package app.model;

import app.entity.Product;
import app.utils.NameToHash;
import app.utils.WorkWithCsv;

import java.io.IOException;
import java.util.LinkedHashMap;

public class DeleteProductModel {
    public boolean deleteProduct(String name) {
        boolean isDeleted = false;
        try
        {
            WorkWithCsv workWithCsv = new WorkWithCsv();
            LinkedHashMap<String, Product> products = workWithCsv.getDataCsv();
            String hash = String.valueOf(NameToHash.getHash(name));
            if (products.containsKey(hash)) {
                products.remove(hash);
                workWithCsv.writeCsv(products);
                isDeleted = true;
                return isDeleted;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}
