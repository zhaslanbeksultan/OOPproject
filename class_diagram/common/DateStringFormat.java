package common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The DateStringFormat class provides utility methods for formatting Date objects to strings with specific formats.
 */
public class DateStringFormat {

    /**
     * Converts a Date object to a string using the format "yyyy-MM-dd HH:mm:ss".
     *
     * @param date The Date object to be converted.
     * @return A string representation of the date in the specified format.
     */
    public static String convert(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * Extracts the year from a Date object and represents it as a string.
     *
     * @param date The Date object from which to extract the year.
     * @return A string representing the year extracted from the date.
     */
    public static String year(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        return dateFormat.format(date);
    }
}
