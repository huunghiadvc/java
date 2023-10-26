import entity.Product;

public class LineItem {
    Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public static double cost(double price, int quantity){
        return price * quantity;
    }

    @Override
    public String toString(){
        return  " | Product: " + product.getName() + " | Quantity: " + product.getQuantity() +
                " | Cost: " + cost(product.getPrice(), product.getQuantity()) + "\n";
    }
}
