import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty() || username.length() < 5) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Invalid password");
        }
    }
}

public class UserRegistrationTest {
    UserRegistration userRegistration = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("validUser", "user@example.com", "password123"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("usr", "user@example.com", "password123"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "invalidemail", "password123"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "user@example.com", "pass"));
    }
}
