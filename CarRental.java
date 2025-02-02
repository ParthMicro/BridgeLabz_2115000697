public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate = 250.0;

    public CarRental() {
        this.customerName = "";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }
}
