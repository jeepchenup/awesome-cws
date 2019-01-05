package info.chen.awsome_cws_persist.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleDateFormatTest {

	public static void main(String[] args) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.parse("2017-10-10"));
	}
}
