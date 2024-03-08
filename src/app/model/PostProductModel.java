package app.model;

import app.config.Config;
import app.entity.Product;
import app.utils.GetTimestamp;
import app.utils.IdGenerator;
import app.utils.NameToHash;
import app.utils.WorkWithCsv;

import java.io.IOException;
import java.util.LinkedHashMap;

public class PostProductModel {
     public boolean createNewProduct(String name, String description, Double price, Integer quantity) {
         boolean isCreated = false;
         WorkWithCsv workWithCsv = new WorkWithCsv();
         try {
             LinkedHashMap<String, Product> products = workWithCsv.getDataCsv();
             if (products.containsKey(String.valueOf(NameToHash.getHash(name)))) {
                 return isCreated;
             }
             boolean neIsSold = quantity.equals(0);
             String newId = IdGenerator.generateId();
             long newTime = GetTimestamp.getTimestamp();
             Product product = new Product(
                     newId,
                     name,
                     quantity,
                     price,
                     Config.CURRENCY,
                     description,
                     neIsSold,
                     newTime,
                     newTime
             );
             products.put(newId, product);
             workWithCsv.writeCsv(products);
             isCreated = true;
         } catch (IOException e) {
             e.printStackTrace();
         }
         return isCreated;
    }
}
