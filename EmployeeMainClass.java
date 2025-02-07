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
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;
        
    Developer(String name, int id, double salary, String programmingLanguage) {
	super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String internshipDuration;

    Intern(String name, int id, double salary, String internshipDuration) {
        super(name, id, salary);
        this.internshipDuration = internshipDuration;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + internshipDuration);
    }
}

public class EmployeeMainClass {
    public static void main(String[] args) {
        Employee manager = new Manager("Parth", 101, 80000, 5);
        Employee developer = new Developer("Shanya", 102, 60000, "Java");
        Employee intern = new Intern("Priyanshi", 103, 30000, "6 months");

        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}
