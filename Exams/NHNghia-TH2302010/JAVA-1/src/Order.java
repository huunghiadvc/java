import entity.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order extends DeliveryOrder {
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

    public static double cost(){
        double result = 0.1;
        return result;
    }
    public void addProduct(Product product, int quantity){

    }

    @Override
    public String toString(){
        StringBuilder result = null;
        if (this.getAddress() == null){
            result = new StringBuilder("Order List: \n");
        } else {
            result = new StringBuilder("Delivery List: \n");
        }
        for (LineItem item: lineItem) {
            assert false;
            result.append(" | Customer Name: ").append(this.customerName)
                    .append(" | Transaction time: ").append(this.transactionTime)
                    .append(" | Category: ").append(item.getProduct())
                    .append("\n");
        }
        return result.toString();
    }
}
