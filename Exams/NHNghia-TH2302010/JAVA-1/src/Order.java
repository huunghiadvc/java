import entity.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private String customerName;
    private LocalDateTime transactionTime;
    ArrayList<LineItem> lineItem = new ArrayList<>();

    public Order() {
    }

    public ArrayList<LineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(ArrayList<LineItem> lineItem) {
        this.lineItem = lineItem;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public double cost(){
        double result = 0;
        for (LineItem item : lineItem) {
            result += LineItem.cost(item.getProduct().getPrice(), item.getQuantity());
        }
        return result;
    }
    public boolean addProduct(Product product, int quantity){
        if (quantity >= product.getQuantity()){
            return false;
        } else {
            LineItem newLineItem = new LineItem(product, quantity);
            lineItem.add(newLineItem);
            product.setQuantity(product.getQuantity() - quantity);
            return true;
        }
    }

    @Override
    public String toString(){
        StringBuilder result = null;
        result = new StringBuilder("\nORDER LIST: \n");
        result.append("Customer: ").append(customerName);
        for (LineItem item: lineItem) {
            assert false;
            result.append("\n\n\t| Product name: ").append(item.getProduct().getName())
                    .append("\n\t| Transaction time: ").append(transactionTime)
                    .append("\n\t| Category: ").append(item.getProduct().getCategory())
                    .append("\n\t| Price: ").append(item.getProduct().getPrice())
                    .append("\n\t| Quantity: ").append(item.getQuantity())
                    .append("\n\t| Cost: ")
                    .append(LineItem.cost(item.getProduct().getPrice(), item.getQuantity()));
        }
        result.append("\n\n| Total: ").append(cost()).append("\n");
        return result.toString();
    }

}
