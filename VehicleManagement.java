interface Refuelable {
    void refuel();
}
class Vehicle {
    protected int maxSpeed;
    protected String model;
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    public void charge() {
        System.out.println(model + " is charging.");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    public void refuel() {
        System.out.println(model + " is refueling.");
    }
}
public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle electricCar = new ElectricVehicle("Tesla Model S", 250);
        PetrolVehicle petrolCar = new PetrolVehicle("Ford Mustang", 220);
        System.out.println("Electric Vehicle Info:");
        electricCar.displayInfo();
        electricCar.charge();
        System.out.println("Petrol Vehicle Info:");
        petrolCar.displayInfo();
        petrolCar.refuel();
    }
}
