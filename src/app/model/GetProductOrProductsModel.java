package app.model;

import app.entity.Product;
import app.utils.NameToHash;
import app.utils.WorkWithCsv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GetProductOrProductsModel {
    private final WorkWithCsv workWithCsv = new WorkWithCsv();

    public List<Product> getAllProducts() {
        return new ArrayList<>(getProductsMap().values());
    }

    public List<Product> getOneProduct(String name) {
        List<Product> result = new ArrayList<>();
        String id  = String.valueOf(NameToHash.getHash(name));
        Product product = getProductsMap().get(id);
        result.add(product);
        return result;
    }

    private LinkedHashMap<String, Product> getProductsMap() {
        try {
            return workWithCsv.getDataCsv();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
