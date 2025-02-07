class Course {
    String courseName;
    int duration;
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public void displayDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%");
    }
}
public class EducationalCourse {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse("Java Programming", 8, "Udemy", true, 199.99, 20);
        course.displayDetails();
    }
}
