package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringFormat {
	public static String convert(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
	}
	public static String year(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        return dateFormat.format(date);
	}
}
