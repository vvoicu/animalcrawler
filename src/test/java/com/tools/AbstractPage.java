package com.tools;

import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.PageObject;

public class AbstractPage extends PageObject{

	/**
	 * Wait for document ready state for {@link Constants}.PAGE_LOAD_MAX_RETRY
	 * time.
	 */
	public void waitForPageToLoad() {
		int retry = 0;
		
		do {
			waitABit(Constants.WAIT_TIME_SMALL);
			retry++;
		} while (retry <= Constants.PAGE_LOAD_MAX_RETRY && evaluateJavascript("return document.readyState").equals("complete") != true);
	}
	
	
	public void navigateTo(String URL){
		getDriver().get(URL);
	}
}
