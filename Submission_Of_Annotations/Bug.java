import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Fix null pointer issue")
    @BugReport(description = "Improve performance")
    public void buggyMethod() {
        System.out.println("Buggy method executed");
    }
}

public class Bug {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("buggyMethod");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}
