package app.utils;

import app.entity.Product;

import java.io.*;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.*;
import java.nio.file.Paths;
import app.config.Config;
import java.util.AbstractMap.SimpleEntry;

public class WorkWithCsv {
    String header;
    public LinkedHashMap<String, Product> getDataCsv() throws IOException {
        LinkedHashMap<String, Product> productsData = new LinkedHashMap<>();
        SimpleEntry<String, List<List<String>>> result = readCsv();
        header = result.getKey();
        List<List<String>> records = result.getValue();
        if (records.isEmpty()) {
            return productsData;
        }
        for (List<String> record : records) {
                productsData.put(
                        String.valueOf(NameToHash.getHash(record.get(1))),
                        new Product(
                                record.get(0),
                                record.get(1),
                                Integer.parseInt(record.get(2)),
                                Double.parseDouble(record.get(3)),
                                record.get(4),
                                record.get(5),
                                Boolean.parseBoolean(record.get(6)),
                                Long.parseLong(record.get(7)),
                                Long.parseLong(record.get(8))
                        )
                );
        }
        return productsData;
    }

    private SimpleEntry<String, List<List<String>>> readCsv() throws IOException {
        String path = Config.ABS_PRODUCTS_FILE_PATH;
        List<List<String>> records = new ArrayList<>();
        String headerLine;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            headerLine = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(Config.CSV_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        return new SimpleEntry<>(headerLine, records);
    }

    public void writeCsv(LinkedHashMap<String, Product> products) throws IOException {
        Path pathToFile = Paths.get(Config.ABS_PRODUCTS_FILE_PATH);

        try (FileWriter writer = new FileWriter(pathToFile.toAbsolutePath().toString())) {
            writer.write(header);
            writer.write("\n");
            for (Map.Entry<String, Product> entry : products.entrySet()) {
                Product product = entry.getValue();
                writer.write(toCsvLine(product));
                writer.write("\n");
            }
        }
    }

    private static String toCsvLine(Product product) {
        StringJoiner csvLine = new StringJoiner(",");
        csvLine.add(product.getId())
                .add(product.getProductName())
                .add(product.getQuantity().toString())
                .add(product.getPrice().toString())
                .add(product.getCurrency())
                .add(product.getDescription())
                .add(String.valueOf(product.isSold()))
                .add(String.valueOf(product.getCreateTimestamp()))
                .add(String.valueOf(product.getLastUpdateTimeStamp()));

        return csvLine.toString();
    }
}
