import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "Parth")
    public void performTask() { 
        System.out.println("Performing task");
    }
}

public class Task {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("performTask");
        TaskInfo info = method.getAnnotation(TaskInfo.class);
        System.out.println("Priority: " + info.priority() + ", Assigned To: " + info.assignedTo());
    }
}
