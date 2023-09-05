package com.HOPESTAR.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;


public class FileUtility {

	/**
	 * This method reads data from property file
	 * @author Shruthi
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstantsUtility.propertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
