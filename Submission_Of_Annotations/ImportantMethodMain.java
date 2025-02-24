import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Task {
    @ImportantMethod(level = "HIGH")
    public void criticalTask() {
        System.out.println("Executing critical task");
    }
    
    @ImportantMethod(level = "MEDIUM")
    public void regularTask() {
        System.out.println("Executing regular task");
    }
}

public class ImportantMethodMain {
    public static void main(String[] args) {
        Method[] methods = Task.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println(method.getName() + " - Level: " + annotation.level());
            }
        }
    }
}
