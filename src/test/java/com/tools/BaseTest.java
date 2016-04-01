package com.tools;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;

public class BaseTest {

	@Managed(uniqueSession = false)
	public WebDriver driver;
	
}
