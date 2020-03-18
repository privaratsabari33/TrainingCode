package com.hcl.util;
	import java.sql.Timestamp;
	import java.time.LocalDateTime;
	import java.time.ZoneId;
	import java.time.format.DateTimeFormatter;

	public class DateTimeUtil {

	    public static Timestamp getTimestamp(String utcDateTime) {
	        LocalDateTime localDateTime = LocalDateTime.parse(utcDateTime, DateTimeFormatter.ISO_DATE_TIME);
	        return Timestamp.from(localDateTime.atZone(ZoneId.of("UTC")).toInstant());
	    }

	    public static String getUTCString(Timestamp dbTimestamp) {
	        return dbTimestamp.toInstant().atZone(ZoneId.of("UTC")).toString();
	    }

	}

