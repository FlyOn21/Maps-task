package app.entity;

import app.utils.GetTimestamp;

public class Product {
    private final String id;
    private final String productName;
    private Integer quantity;
    private Double price;
    private final String currency;
    private String description;
    private boolean isSold;
    private final long createTimestamp;
    private long lastUpdateTimeStamp;

    // Constructor
    public Product(String id, String productName, Integer quantity, Double price, String currency, String description, boolean isSold, long createTimestamp, long lastUpdateTimeStamp) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
        this.description = description;
        this.isSold = isSold;
        this.createTimestamp = createTimestamp;
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSold() {
        return isSold;
    }

    public long getCreateTimestamp() {
        return createTimestamp;
    }

    public long getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        this.isSold = quantity == 0;
        this.lastUpdateTimeStamp = GetTimestamp.getTimestamp();
    }

    public void setPrice(Double price) {
        this.price = price;
        this.lastUpdateTimeStamp = GetTimestamp.getTimestamp();
    }

    public void setDescription(String description) {
        this.description = description;
        this.lastUpdateTimeStamp = GetTimestamp.getTimestamp();
    }
}
