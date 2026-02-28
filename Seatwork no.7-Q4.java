class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

public class Main {
    static void checkPassword(String password) throws PasswordException {
        if (password.length() < 8) {
            throw new PasswordException("Incorrect Password Please try again.");
        } else {
            System.out.println("Password accepted");
        }
    }

    public static void main(String[] args) {
        try {
            checkPassword("Celest_321");
        } catch (PasswordException e) {
            System.out.println("User-Defined Exception: " + e.getMessage());
        }
    }
}
