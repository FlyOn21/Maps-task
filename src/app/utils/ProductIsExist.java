package app.utils;
import app.entity.Product;

import java.io.IOException;
import java.util.LinkedHashMap;

public class ProductIsExist {
    private static final WorkWithCsv workWithCsv = new WorkWithCsv();
    public static boolean isExist(String productName) {
        boolean flag = false;
        try{
            LinkedHashMap<String, Product> products = workWithCsv.getDataCsv();
            String hash = String.valueOf(NameToHash.getHash(productName));
            if (products.containsKey(hash)) {
                flag = true;
                return flag;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       return flag;
    }
}
