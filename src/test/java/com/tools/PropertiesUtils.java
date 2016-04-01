package com.tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtils {

	private static Properties prop = new Properties();

	public static void writeToFile(String fileName, String key, String value) {

		OutputStream output = null;

		try {

			output = new FileOutputStream(Constants.PROPERTY_FILE_PATH + fileName + ".properties");
			prop.setProperty(key, value);
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	public static String readFromFile(String fileName, String key) {
		String result = "";

		try {
			FileInputStream file = new FileInputStream(Constants.PROPERTY_FILE_PATH + fileName + ".properties");
			prop.load(file);
			result = prop.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
