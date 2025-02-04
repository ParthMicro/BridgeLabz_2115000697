public class Employee {
    static String companyName = "Capgemini";
    static int totalEmployees = 0;
    final int id;
    String name;
    String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees at " + companyName + ": " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Employee Name: " + name);
            System.out.println("Employee ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Parth", 101, "Software Engineer");
        Employee emp2 = new Employee("Abhinav", 102, "Software Engineer");
	Employee emp3 = new Employee("Kshitiz", 103, "Software Engineer");

        Employee.displayTotalEmployees();
        
        emp1.displayDetails();
        emp2.displayDetails();
	emp3.displayDetails();
    }
}
