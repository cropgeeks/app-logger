package jhi.applogger.utils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.*;
import java.util.Date;

public class DateParameter implements Serializable
{
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	private Timestamp date;

	public DateParameter()
	{
	}

	public void setDate(Date date)
	{
		this.date = new Timestamp(date.getTime());
	}

	public Timestamp getDate()
	{
		return date;
	}

	public static synchronized DateParameter valueOf(String input)
	{
		try
		{
			DateParameter result = new DateParameter();
			result.setDate(SDF.parse(input));
			return result;
		}
		catch (ParseException | NullPointerException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
