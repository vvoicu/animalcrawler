package com.pages.ramada;

import com.tools.AbstractPage;
import com.tools.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AnimalListPage extends AbstractPage {

    private AnimalDetailsPage animalDetailsPage;

    @FindBy(css = "tbody#ListerData")
    private WebElementFacade animalsTable;


    public void getAnimalDetails() {
        List<WebElement> listOfAnimals = animalsTable.findElements(By.cssSelector("tr.listerRowActioned"));

        for (int i = 0; i < listOfAnimals.size(); i++) {
            listOfAnimals = animalsTable.findElements(By.cssSelector("tr.listerRowActioned"));
            listOfAnimals.get(i).click();
            animalDetailsPage.getOwnerDetails();
            animalDetailsPage.getAnimalDetails();
            animalDetailsPage.getAnimalAdministratedMedicine();
            navigateTo(Constants.BASE_URL + "Pets");

        }
    }
}
