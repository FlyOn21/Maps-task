package app.model;

import app.entity.Product;
import app.utils.NameToHash;
import app.utils.WorkWithCsv;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.function.Consumer;
public class PutProductModel {
    private final WorkWithCsv workWithCsv = new WorkWithCsv();

    public boolean updateProductDescription(String name, String description) {
        return updateProductAttribute(String.valueOf(NameToHash.getHash(name)), product -> product.setDescription(description));
    }

    public boolean updateProductPrice(String name, Double price) {
        return updateProductAttribute(String.valueOf(NameToHash.getHash(name)), product -> product.setPrice(price));
    }

    public boolean updateProductQuantity(String name, Integer quantity) {
        return updateProductAttribute(String.valueOf(NameToHash.getHash(name)), product -> product.setQuantity(quantity));
    }

    private boolean updateProductAttribute(String id, Consumer<Product> updateFunction) {
        boolean isUpdated = false;
        try {
            LinkedHashMap<String, Product> products = workWithCsv.getDataCsv();
            Product product = products.get(id);
            if (product != null) {
                updateFunction.accept(product);
                workWithCsv.writeCsv(products);
                isUpdated = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
}