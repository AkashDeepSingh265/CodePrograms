package DateAndCalnedar;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestLocale {

	public static void printLocale(){
		Locale loc = new Locale("pt","BR");
		Calendar c = Calendar.getInstance();
		c.set(2015,0,15);
		Date d = c.getTime();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,loc);
		System.out.println(df.format(d));
	}
	public static void main(String[] args){
		TestLocale.printLocale();
	}
}
