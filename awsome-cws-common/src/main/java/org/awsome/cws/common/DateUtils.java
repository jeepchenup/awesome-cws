package org.awsome.cws.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final ThreadLocal<SimpleDateFormat> formart = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			String pattern = "yyyy-MM-dd";
			return new SimpleDateFormat(pattern);
		}
	};
	
	public static Date getDate(String date) {
		try {
			return formart.get().parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
