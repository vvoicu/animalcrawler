package com.tools;

import net.serenitybdd.core.pages.PageObject;

public class AbstractPage extends PageObject{

	
	public void navigateTo(String URL){
		getDriver().get(URL);
	}
}
