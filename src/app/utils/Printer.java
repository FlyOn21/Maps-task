package app.utils;

import app.entity.Product;

import java.util.List;

public class Printer {

    public static void printProducts(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        products.forEach(product -> sb.append("===================")
                .append(" Product Name: ").append(product.getProductName()).append(" ===================").append("\n")
                .append("ID: ").append(product.getId()).append("\n")
                .append("Quantity: ").append(product.getQuantity()).append("\n")
                .append("Price: ").append(product.getPrice()).append("\n")
                .append("Currency: ").append(product.getCurrency()).append("\n")
                .append("Description: ").append(product.getDescription()).append("\n")
                .append("Sold: ").append(product.isSold() ? "Yes" : "No").append("\n")
                .append("Creation Timestamp: ").append(product.getCreateTimestamp()).append("\n")
                .append("Last Update Timestamp: ").append(product.getLastUpdateTimeStamp())
                .append("\n")
                .append("\n"));
        System.out.println(sb);
    }
}
