package com.OFOS.HM.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	
	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
	
	public String systemDate()
	{
		Date date=new Date();
		String systemDate=date.toString();
		return systemDate;
	}
	
	public String systemDateInFormat()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH-mm-SS");
		Date date=new Date();
		String systemDateInFormat = dateFormat.format(date);
		return systemDateInFormat;
	}

}
