package com.runners.tests.ramada;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ramada.HomePageSteps;
import com.tools.BaseTest;
import com.tools.Constants;

import net.serenitybdd.junit.runners.SerenityRunner;


@RunWith(SerenityRunner.class)
public class RamadaLoginTest extends BaseTest{

	
	private HomePageSteps homePageSteps;
	
	
	@Test
	public void loginToRamadaTest(){
		homePageSteps.navigateTo(Constants.BASE_URL);
	}
}
