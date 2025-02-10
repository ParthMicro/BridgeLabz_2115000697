import java.util.*;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Not Set";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; 
    }

    @Override
    public String getCurrentLocation() {
        return "Car Location: " + location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Not Set";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; 
    }

    @Override
    public String getCurrentLocation() {
        return "Bike Location: " + location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Not Set";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20; 
    }

    @Override
    public String getCurrentLocation() {
        return "Auto Location: " + location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        Car car1 = new Car("Car123", "Amit", 15);
        Bike bike1 = new Bike("Bike123", "Ravi", 5);
        Auto auto1 = new Auto("Auto123", "Pooja", 10);

        car1.updateLocation("Mathura");
        bike1.updateLocation("Station");
        auto1.updateLocation("Market");

        rides.add(car1);
        rides.add(bike1);
        rides.add(auto1);

        double distance = 10;
        for (Vehicle ride : rides) {
            System.out.println(ride.getVehicleDetails());
            System.out.println("Fare for " + distance + " km: " + ride.calculateFare(distance));

            if (ride instanceof GPS) {
                GPS gps = (GPS) ride;
                System.out.println(gps.getCurrentLocation());
            }
            System.out.println();
        }
    }
}
