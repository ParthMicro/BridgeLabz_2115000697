import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: 10% off";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_EXTRA_CHARGE = 20.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + NON_VEG_EXTRA_CHARGE) * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5% off";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 350, 1));
        order.add(new VegItem("Veg Burger", 120, 3));

        double totalOrderPrice = 0;
        double totalDiscount = 0;

        for (FoodItem item : order) {
            System.out.println(item.getItemDetails());
            double totalPrice = item.calculateTotalPrice();
            System.out.println("Total Price: " + totalPrice);

            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                double discount = discountableItem.applyDiscount();
                System.out.println(discountableItem.getDiscountDetails());
                System.out.println("Discount Applied: " + discount);
                totalDiscount += discount;
            }
            totalOrderPrice += totalPrice;
            System.out.println();
        }

        System.out.println("Grand Total: " + (totalOrderPrice - totalDiscount));
    }
}
