package org.awsome.cws.common.util;

public class CommonUtils {

	public static boolean isEmpty(String key) {
		if(null == key || key.equals("null") || key.equals(""))
			return true;
		return false;
	}
}
