package com.runners.tests.ramada;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.steps.ramada.HomePageSteps;
import com.tools.BaseTest;
import com.tools.Constants;
import com.tools.PropertiesUtils;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.PropertiesUtil;


@RunWith(SerenityRunner.class)
public class RamadaLoginTest extends BaseTest {

    @Steps
    private HomePageSteps homePageSteps;

    private String href;
    @Before
    public void dataSetup(){
    	href = PropertiesUtils.readFromFile("TestRunner", "href");
    }
    

    @Test
    public void loginToRamadaTest() {
    	
    	
        homePageSteps.navigateTo(Constants.BASE_URL);
        homePageSteps.login();
        if(href.contains("p=")){
        	homePageSteps.navigateTo(href);
        }else{
            homePageSteps.navigateTo(Constants.BASE_URL + "Pets");
        }
        homePageSteps.getAnimalDetails();
    }
}
