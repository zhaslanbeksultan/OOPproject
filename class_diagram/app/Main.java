package app;

import java.io.IOException;
import common.*;
import users.Admin;

/**
 * The main class responsible for launching the application.
 * It contains the main method to start the application and provides initializations and configurations.
 */
public class Main {   
   
    /**
     * The main entry point for the application.
     * It initializes the login system and displays the main menu.
     * Users can choose to log in or exit the application.
     *
     * @param args Command line arguments (not used).
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {

//      Uncomment the following lines to create and add an admin to the system.
//		Admin admin = new Admin();
//		admin.setUsername("steve_jobs");
//		admin.setPassword("pass");
//		Data.getInstance().addAdmin(admin);
//		Data.getInstance().addUser("steve_jobs", admin);

        // Initialize the login system
        Login login = new Login();
        
        // Main application loop
        while(true) {
            // Display the login menu
            login.menu();
            
            // Prompt the user to choose an option
            System.out.println("Enter '0' to close the app. '1' - to Login");
            String input = commonBuffer.readInput();
            
            // Exit the loop if the user chooses to close the app
            if(input.equals("0")) break;
        }
        
        // Save data before closing the application
        Data.write();
    }
}
