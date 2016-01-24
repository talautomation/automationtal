package appModule;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDateTimeStamp {
	public static String getCurrentTimeStamp() {

		SimpleDateFormat formater = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
		Calendar calendar = Calendar.getInstance();
		String timeformat = formater.format(calendar.getTime());
		return timeformat;

		// This returns some thing like Fail_Z_debug_TC_2016-01-22
		// 14:06:48.912.png - which will fail while storing the file in the
		// destination path.
		// java.util.Date date = new java.util.Date();
		// return new Timestamp(date.getTime()).toString();

	}

}
