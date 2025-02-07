class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public void displayRole() {
        System.out.println("Role: Teacher");
    }
    public void displaySubject() {
        System.out.println("Subject: " + subject);
    }
}
class Student extends Person {
    private String grade;
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    public void displayRole() {
        System.out.println("Role: Student");
    }
    public void displayGrade() {
        System.out.println("Grade: " + grade);
    }
}
class Staff extends Person {
    private String department;
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    public void displayRole() {
        System.out.println("Role: Staff");
    }
    public void displayDepartment() {
        System.out.println("Department: " + department);
    }
}
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Parth", 30, "Science");
        Student student = new Student("Shanya", 16, "10th Grade");
        Staff staff = new Staff("Priyanshi", 40, "Administration");
        System.out.println("Teacher Info:");
        teacher.displayInfo();
        teacher.displayRole();
        teacher.displaySubject();
        System.out.println("Student Info:");
        student.displayInfo();
        student.displayRole();
        student.displayGrade();
        System.out.println("Staff Info:");
        staff.displayInfo();
        staff.displayRole();
        staff.displayDepartment();
    }
}
