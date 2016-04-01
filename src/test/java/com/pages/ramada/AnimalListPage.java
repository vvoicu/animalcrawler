package com.pages.ramada;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tools.AbstractPage;
import com.tools.Constants;
import com.tools.FileUtils;
import com.tools.models.AnimalDetailsModel;
import com.tools.models.MedicineModel;
import com.tools.models.OwnerModel;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AnimalListPage extends AbstractPage {

    private AnimalDetailsPage animalDetailsPage;

    @FindBy(css = "tbody#ListerData")
    private WebElementFacade animalsTable;
    
    @FindBy(css = "div.header a.listerPageNext")
    private WebElementFacade nextButton;

    public void getAnimalDetails() {
    	
    	do{
        List<WebElement> listOfAnimals = animalsTable.findElements(By.cssSelector("tr.listerRowActioned"));

//        List<AnimalDetailsModel> animalDetailsList = new ArrayList<AnimalDetailsModel>();
//        List<MedicineModel> medicineFullList= new ArrayList<MedicineModel>();
//        List<OwnerModel> ownerModelList = new ArrayList<OwnerModel>();
        
        for (int i = 0; i < listOfAnimals.size(); i++) {
            listOfAnimals = animalsTable.findElements(By.cssSelector("tr.listerRowActioned"));
            String idItemProp= listOfAnimals.get(i).getAttribute("data-id");
            
            System.out.println("---- ITEM ID: " + idItemProp);
            listOfAnimals.get(i).click();
            OwnerModel ownerModel = animalDetailsPage.getOwnerDetails(idItemProp);
            AnimalDetailsModel animalDetailsModel = animalDetailsPage.getAnimalDetails(idItemProp);
            List<MedicineModel> medicineModelList = animalDetailsPage.getAnimalAdministratedMedicine(idItemProp);
            navigateTo(Constants.BASE_URL + "Pets");
//            animalDetailsList.add(animalDetailsModel);
//            ownerModelList.add(ownerModel);
//            medicineFullList.addAll(medicineModelList);
            

            FileUtils.writeToCsvFile("OwnerList", ownerModel.toStringRow());
            FileUtils.writeToCsvFile("AnimalDetailsModel", animalDetailsModel.toStringRow());
            FileUtils.writeMedicineModelToCsvFile("MedicineModelList", medicineModelList);
        }
        
    	}while(isNextButton());

//        FileUtils.writeAnimalDetailsModelToCsvFile("OwnerList", animalDetailsList);
//        FileUtils.writeOwnerModelToCsvFile("AnimalDetailsModel", ownerModelList);
//        FileUtils.writeMedicineModelToCsvFile("MedicineModelList", medicineFullList);
    }


	private boolean isNextButton() {
		boolean isPresent = false;
		element(nextButton).waitUntilVisible();
		if(!nextButton.getAttribute("disabled").contains("disabled")){
			nextButton.click();
			isPresent = true;
		}
		
		return isPresent;
	}
}
