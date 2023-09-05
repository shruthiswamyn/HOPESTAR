package com.HOPESTAR.GenericUtility;

import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.*;

public class JavaUtility {

	/**
	 * This method generate random numbers
	 * @author Shruthi
	 * @return
	 */
	public int randomNumberGeneration()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
	
	/**
	 * This method returns system date
	 * @author Shruthi
	 * @return
	 */
	public String systemDate()
	{
		Date d = new Date();
		String dateInStringFormat = d.toString();
		return dateInStringFormat;
	}
	
	/**
	 * This method returns system date in simple date format
	 * @author Shruthi
	 * @return
	 */
	public String systemDateInFormat()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
		Date d = new Date();
		String finalDate = sdf.format(d);
		return finalDate;
		
	}
}
