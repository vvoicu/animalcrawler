package com.tools;

public class FormatterUtils {

	
	public static String cleanString(String string){
		return string.replaceAll("[\\t\\n\\r]"," ");
	}
}
