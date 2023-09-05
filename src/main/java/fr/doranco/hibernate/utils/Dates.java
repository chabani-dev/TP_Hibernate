package fr.doranco.hibernate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public  abstract class Dates {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static final java.util.Date convertStringToDate(String dateStr) throws ParseException {
		if (dateStr == null || dateStr.trim().isEmpty()) {
			throw new IllegalArgumentException("La date ne doit pas être NULL ou vide !");
		}
		return formatter.parse(dateStr);
	}

	public static final String convertDateToString(java.util.Date date) {
		if (date == null) {
			throw new NullPointerException("La date ne doit pas être NULL !");
		}
		return formatter.format(date);
	}
	
	public static final java.sql.Date convertDateUtilToDateSql(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
	
	public static final java.util.Date convertDateSqlToDateUtil(java.sql.Date date) {
		return new java.util.Date(date.getTime());
	}

	public static Object convertDateToString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
