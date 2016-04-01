package com.tools;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps{

	private static final long serialVersionUID = 7893187272866052276L;

	private AbstractPage abstractPage;
	
	@Step
	public void navigateTo(String URL){
		abstractPage.navigateTo(URL);
		getDriver().manage().window().maximize();
	}
}
