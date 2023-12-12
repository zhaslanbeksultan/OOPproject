package common;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class commonBuffer{
	public commonBuffer() {}
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