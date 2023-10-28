public class DeliveryOrder extends Order {
    private String address;

    public DeliveryOrder() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        StringBuilder result = null;
        result = new StringBuilder("\nDELIVERY LIST: \n");
        result.append("Customer: ").append(super.getCustomerName());
        for (LineItem item: lineItem) {
            assert false;
            result.append("\n\n\t| Product name: ").append(item.getProduct().getName())
                    .append("\n\t| Transaction time: ").append(super.getTransactionTime())
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
