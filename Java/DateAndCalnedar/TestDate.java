package DateAndCalnedar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	public static void formatDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date bday = formatter.parse("15/07/1992");
			System.out.println(bday.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Calendar c = Calendar.getInstance();
		Date d = new Date();
		//System.out.println(d.toString());
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(df.format(d));
		try {
			d=df.parse("Thursday, 15 January, 2015");
			System.out.println(df.format(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
