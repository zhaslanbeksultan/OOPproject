package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * The commonBuffer class provides a utility method for reading user input from the console.
 * It encapsulates the handling of input stream operations to simplify input reading in other parts of the application.
 */
public class commonBuffer {

    /**
     * Default constructor for the commonBuffer class.
     * Initializes a new instance of the commonBuffer class.
     */
    public commonBuffer() {}

    /**
     * Reads a line of text from the console input.
     *
     * @return A string containing the user input.
     * @throws IOException If an I/O error occurs while reading the input.
     */
    public static String readInput() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
