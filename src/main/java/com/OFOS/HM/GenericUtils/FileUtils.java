package com.OFOS.HM.GenericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	/**
	 * This method is used to return the data from Property File
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		Properties pLib=new Properties();
		pLib.load(fis);
		String value=pLib.getProperty(key);
		return value;
	}

}
