package com.steps.ramada;

import com.pages.ramada.AnimalListPage;
import com.pages.ramada.LoginPage;
import com.tools.AbstractSteps;

public class HomePageSteps extends AbstractSteps {

    private static final long serialVersionUID = -1235013482443827013L;
    private LoginPage loginPage;
    private AnimalListPage animalListPage;

    public void login() {
        loginPage.login();
    }

    public void getAnimalDetails() {
        animalListPage.getAnimalDetails();
    }
}
