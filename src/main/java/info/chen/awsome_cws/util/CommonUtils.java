package info.chen.awsome_cws.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CommonUtils {

	public static Date getDate(int year, int month, int dayOfMoth) {
		Calendar calendar = new GregorianCalendar(year, month, dayOfMoth);
		return calendar.getTime();
	}
}
