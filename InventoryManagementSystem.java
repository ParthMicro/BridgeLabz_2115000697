class ItemNode { 
    int itemId, quantity; 
    String itemName; 
    double price; 
    ItemNode next; 

    public ItemNode(int itemId, String itemName, int quantity, double price) { 
        this.itemId = itemId; 
        this.itemName = itemName; 
        this.quantity = quantity; 
        this.price = price; 
        this.next = null; 
    } 
} 

class InventoryManagementLinkedList { 
    private ItemNode head; 

    public InventoryManagementLinkedList() { 
        this.head = null; 
    } 

    public void addItem(int itemId, String itemName, int quantity, double price, Integer position) { 
        ItemNode newItem = new ItemNode(itemId, itemName, quantity, price); 
        if (position == null || position == 0) { 
            newItem.next = head; 
            head = newItem; 
            return; 
        } 

        ItemNode temp = head; 
        int count = 0; 
        while (temp != null && count < position - 1) { 
            temp = temp.next; 
            count++; 
        } 
        if (temp != null) {
            newItem.next = temp.next; 
            temp.next = newItem; 
        }
    } 

    public void removeItem(int itemId) { 
        if (head == null) return; 

        if (head.itemId == itemId) { 
            head = head.next; 
            return; 
        } 

        ItemNode temp = head, prev = null; 
        while (temp != null && temp.itemId != itemId) { 
            prev = temp; 
            temp = temp.next; 
        } 

        if (temp != null) { 
            prev.next = temp.next; 
        }
    } 

    public void updateQuantity(int itemId, int newQuantity) { 
        ItemNode temp = head; 
        while (temp != null) { 
            if (temp.itemId == itemId) { 
                temp.quantity = newQuantity; 
                return; 
            } 
            temp = temp.next; 
        } 
    } 

    public void searchItemById(int itemId) { 
        ItemNode temp = head; 
        while (temp != null) { 
            if (temp.itemId == itemId) { 
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + ")"); 
                return; 
            } 
            temp = temp.next; 
        } 
        System.out.println("Item not found."); 
    } 

    public void searchItemByName(String itemName) { 
        ItemNode temp = head; 
        while (temp != null) { 
            if (temp.itemName.equalsIgnoreCase(itemName)) { 
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + ")"); 
                return; 
            } 
            temp = temp.next; 
        } 
        System.out.println("Item not found."); 
    } 

    public double calculateTotalValue() { 
        double totalValue = 0; 
        ItemNode temp = head; 
        while (temp != null) { 
            totalValue += temp.quantity * temp.price; 
            temp = temp.next; 
        } 
        return totalValue; 
    } 

    public void displayItems() { 
        ItemNode temp = head; 
        while (temp != null) { 
            System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price); 
            temp = temp.next; 
        } 
    } 
}

public class InventoryManagementSystem { 
    public static void main(String[] args) { 
        InventoryManagementLinkedList inventory = new InventoryManagementLinkedList(); 
        inventory.addItem(1, "Laptop", 5, 50000.0, 0); 
        inventory.addItem(2, "Mouse", 10, 500.0, 1);   
        inventory.addItem(3, "Keyboard", 7, 1500.0, 1);  
        
        System.out.println("Initial Inventory:");
        inventory.displayItems(); 
        System.out.println("Total Inventory Value: " + inventory.calculateTotalValue()); 
        
        inventory.removeItem(2); 
        inventory.updateQuantity(1, 3); 
        
        System.out.println("\nUpdated Inventory:");
        inventory.displayItems(); 
    } 
} 
