package com.pages.ramada;

import java.util.ArrayList;
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

public class AnimalDetailsPage extends AbstractPage {

	@FindBy(id = "PartnerSearch")
	private WebElementFacade ownerNameField;

	@FindBy(id = "Partner_details")
	private WebElementFacade ownerDetails;

	@FindBy(id = "editor_field_Name")
	private WebElementFacade nameField;

	@FindBy(css = "#editor_field_Species option[selected='selected']")
	private WebElementFacade speciesField;

	@FindBy(id = "editor_field_Breed_chosen")
	private WebElementFacade breedField;

	@FindBy(id = "editor_field_Color")
	private WebElementFacade colorField;

	@FindBy(css = "#editor_field_Status option[selected='selected']")
	private WebElementFacade statusField;

	@FindBy(css = "#editor_field_Sex option[selected='selected']")
	private WebElementFacade sexField;

	@FindBy(css = "#editor_field_Castrated option[selected='selected']")
	private WebElementFacade castratedField;

	@FindBy(id = "editor_field_BloodType")
	private WebElementFacade bloodTypeField;

	@FindBy(id = "Pet_Born")
	private WebElementFacade bornField;

	@FindBy(css = ".text.numeric.widget.compiled[data-bind*='ageYears']")
	private WebElementFacade ageYearsField;

	@FindBy(css = ".text.numeric.widget.compiled[data-bind*='ageMonths']")
	private WebElementFacade ageMonthsField;

	@FindBy(css = ".text.numeric.widget.compiled[data-bind*='ageDays']")
	private WebElementFacade ageDaysField;

	@FindBy(css = "#Pet\\.ChipNumber")
	private WebElementFacade petChipNumberField;

	@FindBy(id = "Pet_ChipDate_Calendar")
	private WebElementFacade petChipDateField;

	@FindBy(id = "Pet.ChipLocation")
	private WebElementFacade petChipLocationField;

	@FindBy(css = "#Pet\\.PassportNumber")
	private WebElementFacade petPassportNumberField;

	@FindBy(id = "Pet_PassportDate_Calendar")
	private WebElementFacade petPassportDateField;

	@FindBy(css = "#Pet\\.HealthBookNumber")
	private WebElementFacade petHealthBookNumberField;

	@FindBy(id = "Pet_HealthBookDate_Calendar")
	private WebElementFacade petHealthBookDateField;

	@FindBy(css = "#Pet\\.HealthBookNumber")
	private WebElementFacade healthBookNumberField;

	@FindBy(id = "Pet_HealthBookDate_Calendar")
	private WebElementFacade healthBookDateField;

	@FindBy(id = "editor_field_Allergies")
	private WebElementFacade allergiesField;

	@FindBy(id = "editor_field_Observations")
	private WebElementFacade observationsField;

	// Medicine!
	@FindBy(css = "div.OptionHeader a[href*='/Pet/MedicamentsTab/'")
	private WebElementFacade medicineLink;

	@FindBy(css = "div.listerContainer")
	private List<WebElementFacade> administratedMedicinTable;

	private By medicineType = By.className("TD_Type");
	private By medicineProductId = By.className("TD_ProductId");
	private By medicineAdministrationNumber = By.className("TD_Number");
	private By medicineAdministrationDate = By.className("TD_Date");
	private By age = By.className("TD_Age");
	private By medicineWearsOff = By.className("TD_WearsOff");
	private By medicineInvoiced = By.className("TD_Invoiced");
	private By notes = By.className("TD_Note");
	private By createdBy = By.className("TD_CreatedBy");

	public List<MedicineModel> getAnimalAdministratedMedicine(String id) {
		// System.out.println("\n MEDICINE: ");
		// PropertiesUtils.writeToFile(Constants.FILE_NAME, "MEDICAMENTE", "");
		waitFor(medicineLink);
		clickOn(medicineLink);
		waitFor(administratedMedicinTable.get(0));

		List<MedicineModel> returnList = new ArrayList<MedicineModel>();
		// System.out.println("\nMEDICAMENTE ADMINISTRATE: ");
		// PropertiesUtils.writeToFile(Constants.FILE_NAME, "MEDICAMENTE
		// ADMINISTRATE", "");
		List<WebElement> listOfMedicine = administratedMedicinTable.get(0).findElements(By.cssSelector("#ListerData tr"));
		
		if (listOfMedicine.get(0).findElements(By.cssSelector("td")).size() > 1)
			returnList.addAll(getMedicineDetails(id, listOfMedicine));
		// System.out.println("\nMEDICAMENTE NEADMINISTRATE: ");
		// PropertiesUtils.writeToFile(Constants.FILE_NAME, "MEDICAMENTE
		// NEADMINISTRATE", "");
		listOfMedicine = administratedMedicinTable.get(1).findElements(By.cssSelector("#ListerData tr"));
		if (listOfMedicine.get(0).findElements(By.cssSelector("td")).size() > 1)
			returnList.addAll(getMedicineDetails(id, listOfMedicine));
		// PropertiesUtils.writeToFile(Constants.FILE_NAME, "END OF LINE", "");
		// System.out.println("END OF LINE\n\n");

		return returnList;
	}

	public AnimalDetailsModel getAnimalDetails(String id) {
		waitFor(nameField);

		AnimalDetailsModel returnModel = new AnimalDetailsModel();
		returnModel.id = id;
		returnModel.nume = nameField.getAttribute("value");
		returnModel.specie = speciesField.getText();
		returnModel.rasa = breedField.getText();
		returnModel.culoare = colorField.getAttribute("value");
		returnModel.stare = statusField.getText();
		returnModel.sex = sexField.getText();
		returnModel.sterilizat = castratedField.getText();
		returnModel.grupaSanguina = bloodTypeField.getAttribute("value");
		returnModel.nascutLa = bornField.getAttribute("value");
		returnModel.varstaAn = ageYearsField.getAttribute("value");
		returnModel.varstaLuna = ageMonthsField.getAttribute("value");
		returnModel.varstaZi = ageDaysField.getAttribute("value");

		if (isElementVisible(By.id("Pet.ChipNumber"))) {

			returnModel.numarMicrochip = petChipNumberField.getAttribute("value");
			returnModel.dataImplantarii = petChipDateField.getAttribute("value");
			returnModel.loculImplantarii = petChipLocationField.getSelectedValue();
			System.out.println("TextValue: " + petChipLocationField.getSelectedValue());

		}
		if (isElementVisible(By.id("Pet.PassportNumber"))) {

			returnModel.numarPasaport = petPassportNumberField.getAttribute("value");
			returnModel.dataEmiteriiPasaport = petPassportDateField.getAttribute("value");
		}
		if (isElementVisible(By.id("Pet.HealthBookNumber"))) {
			returnModel.carteSanatate = healthBookNumberField.getAttribute("value");
			returnModel.dataEmiteriiCarteSanatate = healthBookDateField.getAttribute("value");
		}
		returnModel.alergii = allergiesField.getAttribute("value");
		returnModel.observatii = observationsField.getAttribute("value");

		return returnModel;
	}

	public List<MedicineModel> getMedicineDetails(String id, List<WebElement> list) {

		List<MedicineModel> resultList = new ArrayList<MedicineModel>();
		for (WebElement element : list) {

			MedicineModel model = new MedicineModel();

			model.id = id;
			model.tip = element.findElement(medicineType).getText();
			model.medicament = element.findElement(medicineProductId).getText();
			model.numarDestinatar = element.findElement(medicineAdministrationNumber).getText();
			model.dataAdministrare = element.findElement(medicineAdministrationDate).getText();
			model.varsta = element.findElement(age).getText();
			model.scadenta = element.findElement(medicineWearsOff).getText();
			model.observatii = element.findElement(notes).getText();
			model.createDe = element.findElement(createdBy).getText();

			resultList.add(model);
		}

		return resultList;
	}

	public OwnerModel getOwnerDetails(String id) {
		OwnerModel resultModel = new OwnerModel();
		resultModel.id = id;
		resultModel.name = ownerNameField.getAttribute("value");
		String details = ownerDetails.getText();
		details = details.replace("\n", "");
		details = details.replace("\\n", "");
		resultModel.details = details;

		return resultModel;
	}

}
