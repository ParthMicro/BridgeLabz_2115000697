interface Worker {
    void performDuties();
}
class Person {
    protected String name;
    protected int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }
    public void performDuties() {
        System.out.println(name + " is cooking meals.");
    }
}
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }
    public void performDuties() {
        System.out.println(name + " is serving food to customers.");
    }
}
public class RestaurantManagement{
    public static void main(String[] args) {
        Chef chef = new Chef("Parth", 101);
        Waiter waiter = new Waiter("Abhinav", 102);
        System.out.println("Chef Info:");
        chef.displayInfo();
        chef.performDuties();
        System.out.println("Waiter Info:");
        waiter.displayInfo();
        waiter.performDuties();
    }
}
