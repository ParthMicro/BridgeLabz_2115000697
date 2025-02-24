import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String[] value();
}

class AccessControl {
    @RoleAllowed({"ADMIN"})
    public void adminTask() {
        System.out.println("Admin task executed.");
    }

    @RoleAllowed({"USER", "ADMIN"})
    public void userTask() {
        System.out.println("User task executed.");
    }

    public void generalTask() {
        System.out.println("General task executed.");
    }
}

public class RoleAllowedAnnotation {
    public static void main(String[] args) throws Exception {
        AccessControl accessControl = new AccessControl();
        String currentUserRole = "USER";  

        Method[] methods = accessControl.getClass().getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (isRoleAllowed(currentUserRole, roleAllowed.value())) {
                    method.invoke(accessControl);
                } else {
                    System.out.println("Access Denied for method: " + method.getName());
                }
            } else if (method.getDeclaringClass() == AccessControl.class) { 
                method.invoke(accessControl);
            }
        }
    }

    private static boolean isRoleAllowed(String userRole, String[] allowedRoles) {
        for (String role : allowedRoles) {
            if (role.equalsIgnoreCase(userRole)) {
                return true;
            }
        }
        return false;
    }
}
