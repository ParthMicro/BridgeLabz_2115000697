abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public void displayDetails() {
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + price);
    }    

    public abstract double calculateDiscount();
}
class Electronics extends Product {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }
}
class Clothing extends Product {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2;
    }
}
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class ECommercePlatform {
    public static void main(String[] args) {
        Product prod1 = new Electronics(101, "Laptop", 50000);
        Product prod2 = new Clothing(102, "Shirt", 2000);
	Product prod3 = new Groceries(103, "Dry Fruits", 3000);
	
	prod1.displayDetails();
        System.out.println("Discount: " + prod1.calculateDiscount());
	prod2.displayDetails();
        System.out.println("Discount: " + prod2.calculateDiscount());
	prod3.displayDetails();
	System.out.println("Discount: " + prod3.calculateDiscount());
    }
}
