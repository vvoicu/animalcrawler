package com.tools.models;

import com.tools.Constants;
import com.tools.FormatterUtils;

public class OwnerModel {

	public String name;
	public String details;
	public String id;
	
	public OwnerModel(){
		id = "";
		name = "";
		details = "";
	}
	
	public String toStringRow(){
		return  FormatterUtils.cleanString(id + Constants.FILE_SEPARATOR + name + Constants.FILE_SEPARATOR + details + Constants.FILE_SEPARATOR);
	}
	
	public void printOwnerModel(){
		System.out.println("-------");
		System.out.println("id: " + id);
		System.out.println("name: " + name);
		System.out.println("details: " + details);
	}

}
