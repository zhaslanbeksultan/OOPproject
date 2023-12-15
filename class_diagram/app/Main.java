package app;
import java.util.Date;
import common.*;
import users.*;
import enums.*;
public class Main {
	public static void main(String[] args) {
//		Data.getInstance().setLogs("arsen_zhex", "abcde");
//		Login l= new Login();
//		l.menu();
		Date date = new Date();
		User user = new Student("Beksultan", "Zhaslan", date, "22B030355", "b_zhaslan", "qwerty", "b_zhaslan@kbtu.kz"
				, date, "87770820010", "050608552067", Gender.MALE, "Kazakh", "Kazakhstani", 3.3, 2, Faculty.SITE
				, date, null, "IS", null);
		User user1 = new Student("Arsen", "Zhexenbiev", date, "22B030356", "a_zhexenbiev", "qwerty", "a_zhexenbiev@kbtu.kz"
				, date, "87478968855", "050804559632", Gender.MALE, "Kazakh", "Kazakhstani", 3.5, 2, Faculty.SITE
				, date, null, "IS", null);
		user.sendMessage();
		user1.showMessages();
		user.showMessages();
	}
}
