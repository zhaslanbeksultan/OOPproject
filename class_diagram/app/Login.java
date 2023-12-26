package app;

import common.*;
import enums.Language;
import users.*;

/**
 * The Login class handles the user authentication process.
 * It prompts users to enter their email and password, verifies the credentials, and provides access to the user's menu.
 */
public class Login {

    /** The current language for the login interface. Default is English. */
    public static Language language = Language.ENGLISH;

    /** The username entered by the user during login. */
    private String username;

    /** The password entered by the user during login. */
    private String password;

    /**
     * Default constructor for the Login class.
     * Initializes a new instance of the Login class.
     */
    public Login(){

    }

    /**
     * Displays the login menu, prompts the user to enter their email, and performs email validation.
     * The process continues until a valid email is entered.
     */
    public void menu() {
        login();
        password();
    }

    /**
     * Prompts the user to enter their email and validates it against the existing user data.
     * If the entered email is not found, the user is prompted again.
     */
    public void login() {
        while(true) {
            System.out.println("Enter your email: ");
            username = commonBuffer.readInput();
            if(!Data.getInstance().getUsers().containsKey(username)) {
                System.out.println("Incorrect input");
            } else {
                break;
            }
        }
    }

    /**
     * Prompts the user to enter their password and validates it against the stored user password.
     * If the entered password is incorrect, the user is prompted again.
     * Upon successful validation, the user's menu is displayed.
     */
    public void password() {
        User user = Data.getInstance().getUsers().get(username);
        while(true) {
            System.out.println("Enter your password: ");
            password = commonBuffer.readInput();
            if (!password.equals(user.getPassword())) {
                System.out.println("Incorrect input");
            } else {
                break;
            }
        }
        user.showMenu();
    }
}
