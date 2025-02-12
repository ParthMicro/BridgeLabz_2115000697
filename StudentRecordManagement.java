class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        StudentNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 1) {
            System.out.println("Position should be >= 1.");
            return;
        }

        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }

        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        StudentNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of range.");
        } else {
            newStudent.next = current.next;
            current.next = newStudent;
        }
    }

    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        } else {
            current.next = current.next.next;
        }
    }

    public StudentNode searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber +
                    ", Name: " + current.name +
                    ", Age: " + current.age +
                    ", Grade: " + current.grade);
            current = current.next;
        }
    }

    public void updateGradeByRollNumber(int rollNumber, String newGrade) {
        StudentNode student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        studentList.addAtEnd(101, "Parth", 20, "A");
        studentList.addAtEnd(102, "Shanya", 22, "B");
        studentList.addAtBeginning(103, "Priyanshi", 21, "A");

        System.out.println("All student records:");
        studentList.displayAll();

        System.out.println("\nSearching for student with Roll Number 101:");
        StudentNode student = studentList.searchByRollNumber(101);
        if (student != null) {
            System.out.println("Found: Roll Number: " + student.rollNumber +
                    ", Name: " + student.name +
                    ", Age: " + student.age +
                    ", Grade: " + student.grade);
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("\nUpdating grade for Roll Number 101:");
        studentList.updateGradeByRollNumber(101, "A+");
        studentList.displayAll();

        System.out.println("\nDeleting student with Roll Number 103:");
        studentList.deleteByRollNumber(103);
        studentList.displayAll();
    }
}
