package com.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTImeFromatCheck {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String startDate = "2021-09-15 15:10:45";
		String endDate = "2021-10-22 15:35:00";
		//creates a formatter that parses the date in the given format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date frmdate = sdf.parse(startDate);
		Date enddate = sdf.parse(endDate);
		long frmtimeInMillis = frmdate.getTime();
		System.out.println(frmtimeInMillis);
		long endtimeInMillis = enddate.getTime();
		System.out.println(endtimeInMillis);

	}

}
