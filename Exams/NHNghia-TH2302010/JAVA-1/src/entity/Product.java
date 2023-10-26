package entity;

public class Product {
    private int ID;
    private String sku;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(int ID, String sku, String name, String category, double price, int quantity) {
        this.ID = ID;
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return  " | SKU: " + sku + " | Name: " + name + " | Category: " + category +
                " | Price: " + price + " | Quantity: " + quantity;
    }
}
