class Product {
    private String productName;
    private double price;
    private int quantity;

    
    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    
    public double getTotalAmount() {
        return price * quantity;
    }
}

public class Main {
    public static void main(String[] args) {

        Product p = new Product("Gaming Mouse", 1500.5, 3);

        System.out.println("2nd sem Seat work no. 2\n");
        System.out.println("Product Name: " + p.getProductName());
        System.out.println("Price: " + p.getPrice());
        System.out.println("Quantity: " + p.getQuantity());
        System.out.println("Total Amount: " + p.getTotalAmount());
    }
}
