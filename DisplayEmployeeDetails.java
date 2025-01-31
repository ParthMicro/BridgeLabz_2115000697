class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: ₹" + salary);
    }
}

public class DisplayEmployeeDetails {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Parth Goyal", 11111, 50000.00);
        Employee emp2 = new Employee("Abhinav Gupta", 22222, 50000.00);
        Employee emp3 = new Employee("Kshitiz Katiyar", 33333, 50000.00);
        emp1.displayDetails();
	emp2.displayDetails();
	emp3.displayDetails();
    }
}
