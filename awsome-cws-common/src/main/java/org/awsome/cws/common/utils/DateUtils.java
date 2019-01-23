package org.awsome.cws.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.awsome.cws.common.constants.DateConstants;

public class DateUtils {

	public static final ThreadLocal<SimpleDateFormat> formart = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			String pattern = DateConstants.YYYY_MM_DD_PATTERN;
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
