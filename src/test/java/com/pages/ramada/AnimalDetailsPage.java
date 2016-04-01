package com.pages.ramada;


import com.tools.AbstractPage;
import com.tools.Constants;
import com.tools.PropertiesUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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


    public void getAnimalAdministratedMedicine() {
//        System.out.println("\n MEDICINE: ");
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "MEDICAMENTE", "");
        waitFor(medicineLink);
        clickOn(medicineLink);
        waitFor(administratedMedicinTable.get(0));
//        System.out.println("\nMEDICAMENTE ADMINISTRATE: ");
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "MEDICAMENTE ADMINISTRATE", "");
        List<WebElement> listOfMedicine = administratedMedicinTable.get(0).findElements(By.cssSelector("#ListerData tr"));
        if (listOfMedicine.size() > 0)
            getMedicineDetails(listOfMedicine);
//        System.out.println("\nMEDICAMENTE NEADMINISTRATE: ");
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "MEDICAMENTE NEADMINISTRATE", "");
        listOfMedicine = administratedMedicinTable.get(1).findElements(By.cssSelector("#ListerData tr"));
        if (listOfMedicine.size() > 0)
            getMedicineDetails(listOfMedicine);
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "END OF LINE", "");
//        System.out.println("END OF LINE\n\n");
    }

    public void getAnimalDetails() {
        waitFor(nameField);
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "DETALII ANIMAL", "");
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Nume", nameField.getAttribute("value"));
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Specie", speciesField.getText());
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Rasa", breedField.getText());
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Culoare", colorField.getAttribute("value"));
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Stare", statusField.getText());
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Sex", sexField.getText());
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Sterilizat", castratedField.getText());
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Grupa Sanguina", bloodTypeField.getAttribute("value"));
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Nascut la", bornField.getAttribute("value"));
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Varsta An", ageYearsField.getAttribute("value"));
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Varsta Luna", ageMonthsField.getAttribute("value"));
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Varsta Zi", ageDaysField.getAttribute("value"));
//        System.out.println(" Name : " + nameField.getAttribute("value"));
//        System.out.println(" Species : " + speciesField.getText());
//        System.out.println(" Breed  : " + breedField.getText());
//        System.out.println(" Color : " + colorField.getAttribute("value"));
//        System.out.println(" State : " + statusField.getText());
//        System.out.println(" Sex : " + sexField.getText());
//        System.out.println(" Sterile : " + castratedField.getText());
//        System.out.println(" BloodType : " + bloodTypeField.getAttribute("value"));
//        System.out.println(" Born : " + bornField.getAttribute("value"));
//        System.out.println(" AgeYears : " + ageYearsField.getAttribute("value"));
//        System.out.println(" AgeMonths : " + ageMonthsField.getAttribute("value"));
//        System.out.println(" AgeDays : " + ageDaysField.getAttribute("value"));
        if (isElementVisible(By.id("Pet.ChipNumber"))) {
            PropertiesUtils.writeToFile(Constants.FILE_NAME, "Numar microcip", petChipNumberField.getAttribute("value"));
            PropertiesUtils.writeToFile(Constants.FILE_NAME, "Data Implantarii", petChipDateField.getAttribute("value"));
            PropertiesUtils.writeToFile(Constants.FILE_NAME, "Locul Implantarii", petChipLocationField.getText());
//            System.out.println(" Chip Number : " + petChipNumberField.getAttribute("value"));
//            System.out.println(" chip date : " + petChipDateField.getAttribute("value"));
//            System.out.println(" chip location : " + petChipLocationField.getText());
        }
        if (isElementVisible(By.id("Pet.PassportNumber"))) {
            PropertiesUtils.writeToFile(Constants.FILE_NAME, "Numar pasaport", petPassportNumberField.getAttribute("value"));
            PropertiesUtils.writeToFile(Constants.FILE_NAME, "Data emiterii", petPassportDateField.getAttribute("value"));
//            System.out.println(" passport number : " + petPassportNumberField.getAttribute("value"));
//            System.out.println(" passport date : " + petPassportDateField.getAttribute("value"));
//
        }
        if (isElementVisible(By.id("Pet.HealthBookNumber"))) {
            PropertiesUtils.writeToFile(Constants.FILE_NAME, "Numar carnet de sanatate", healthBookNumberField.getAttribute("value"));
            PropertiesUtils.writeToFile(Constants.FILE_NAME, "Data emiterii", healthBookDateField.getAttribute("value"));
//            System.out.println(" HealthBookNumber: " + healthBookNumberField.getAttribute("value"));
//            System.out.println(" HealthBookDate: " + healthBookDateField.getAttribute("value"));
        }
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Alergii", allergiesField.getAttribute("value"));
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Observatii", observationsField.getAttribute("value"));
//        System.out.println(" Allergies : " + allergiesField.getAttribute("value"));
//        System.out.println(" Observations : " + observationsField.getAttribute("value") + "\n");
    }


    public void getMedicineDetails(List<WebElement> list) {
        for (WebElement element : list) {
            if (element.findElement(medicineType).isDisplayed()) {
                PropertiesUtils.writeToFile(Constants.FILE_NAME, "Tip", element.findElement(medicineType).getText());
                PropertiesUtils.writeToFile(Constants.FILE_NAME, "Medicament", element.findElement(medicineProductId).getText());
                PropertiesUtils.writeToFile(Constants.FILE_NAME, "Numar administrare", element.findElement(medicineAdministrationNumber).getText());
                PropertiesUtils.writeToFile(Constants.FILE_NAME, "Data administrare", element.findElement(medicineAdministrationDate).getText());
                PropertiesUtils.writeToFile(Constants.FILE_NAME, "Varsta", element.findElement(age).getText());
                PropertiesUtils.writeToFile(Constants.FILE_NAME, "Scandenta", element.findElement(medicineWearsOff).getText());
                PropertiesUtils.writeToFile(Constants.FILE_NAME, "Observatii", element.findElement(notes).getText());
                PropertiesUtils.writeToFile(Constants.FILE_NAME, "Creat de", element.findElement(createdBy).getText() + "\n");
//                System.out.println(" Type : " + element.findElement(medicineType).getText());
//                System.out.println(" ProductId : " + element.findElement(medicineProductId).getText());
//                System.out.println(" AdministrationNumber : " + element.findElement(medicineAdministrationNumber).getText());
//                System.out.println(" AdministrationDate : " + element.findElement(medicineAdministrationDate).getText());
//                System.out.println(" Age : " + element.findElement(age).getText());
//                System.out.println(" medicineWearsOff : " + element.findElement(medicineWearsOff).getText());
//                System.out.println(" notes : " + element.findElement(notes).getText());
//                System.out.println(" createdBy : " + element.findElement(createdBy).getText() + "\n");
            }
        }
    }

    public void getOwnerDetails() {
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Nume Proprietar", ownerNameField.getAttribute("value"));
        PropertiesUtils.writeToFile(Constants.FILE_NAME, "Detalii Proprietar", ownerDetails.getText());
//        System.out.println(" OwnerName : " + ownerNameField.getAttribute("value"));
//        System.out.println(" OwnerDetails : " + ownerDetails.getText());
    }

}
