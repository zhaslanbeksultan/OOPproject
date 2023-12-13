package app;
import common.*;
public class Main {
	public static void main(String[] args) {
		Data.getInstance().setLogs("arsen_zhex", "abcde");
		Login l= new Login();
		l.menu();
	}
}
