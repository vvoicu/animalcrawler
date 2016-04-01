package com.pages.ramada;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;
import com.tools.Constants;
import com.tools.FileUtils;
import com.tools.PropertiesUtils;
import com.tools.models.AnimalDetailsModel;
import com.tools.models.MedicineModel;
import com.tools.models.OwnerModel;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AnimalListPage extends AbstractPage {

	private AnimalDetailsPage animalDetailsPage;

	@FindBy(css = "tbody#ListerData")
	private WebElementFacade animalsTable;

	// @FindBy(css = "div.header a.listerPageNext:not([disabled])")
	@FindBy(css = "div.listerNavigation a.listerPageNext:not([disabled])")
	private WebElement nextButton;

	public void getAnimalDetails() {

		do {
			waitForPageToLoad();
			String currentHref = getDriver().getCurrentUrl();
			PropertiesUtils.writeToFile("TestRunner", "href", currentHref);
			List<WebElement> listOfAnimals = animalsTable.findElements(By.cssSelector("tr.listerRowActioned"));


			for (int i = 0; i < listOfAnimals.size(); i++) {
				listOfAnimals = animalsTable.findElements(By.cssSelector("tr.listerRowActioned"));
				String idItemProp = listOfAnimals.get(i).getAttribute("data-id");

				System.out.println("---- ITEM ID: " + idItemProp);
				listOfAnimals.get(i).click();
				OwnerModel ownerModel = animalDetailsPage.getOwnerDetails(idItemProp);
				AnimalDetailsModel animalDetailsModel = animalDetailsPage.getAnimalDetails(idItemProp);
				List<MedicineModel> medicineModelList = animalDetailsPage.getAnimalAdministratedMedicine(idItemProp);
				navigateTo(currentHref);

				FileUtils.writeToCsvFile("OwnerList", ownerModel.toStringRow());
				FileUtils.writeToCsvFile("AnimalDetailsModel", animalDetailsModel.toStringRow());
				FileUtils.writeMedicineModelToCsvFile("MedicineModelList", medicineModelList);
			}



		} while (isNextButton());

	}

	public void elementjQueryClick(String element) {
		evaluateJavascript("var dd =jQuery(' " + element + " ').eq(0);dd.click(); ");
	}

	public boolean isNextButton() {
		boolean isPresent = false;
		element(nextButton).waitUntilVisible();
		System.out.println("href: " + getDriver().getCurrentUrl());
		System.out.println("dis: " + nextButton.getAttribute("disabled"));

		if (nextButton.isEnabled()) {
			nextButton.click();
			isPresent = true;
		}
		waitABit(Constants.WAIT_TIME_LONG);
		waitForPageToLoad();
		return isPresent;
	}
}
