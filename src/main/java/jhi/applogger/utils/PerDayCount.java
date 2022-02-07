package jhi.applogger.utils;

import java.sql.*;

public class PerDayCount
{
	private Timestamp date;
	private Integer   count;

	public PerDayCount()
	{
	}

	public Timestamp getDate()
	{
		return date;
	}

	public PerDayCount setDate(Timestamp date)
	{
		this.date = date;
		return this;
	}

	public Integer getCount()
	{
		return count;
	}

	public PerDayCount setCount(Integer count)
	{
		this.count = count;
		return this;
	}
}
