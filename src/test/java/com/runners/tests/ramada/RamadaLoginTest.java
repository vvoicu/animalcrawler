package com.runners.tests.ramada;

import org.junit.Test;

import com.steps.ramada.HomePageSteps;
import com.tools.BaseTest;
import com.tools.Constants;

public class RamadaLoginTest extends BaseTest{

	
	private HomePageSteps homePageSteps;
	
	
	@Test
	public void loginToRamadaTest(){
		homePageSteps.navigateTo(Constants.BASE_URL);
	}
}
