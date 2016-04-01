package com.tools;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

import com.tools.models.AnimalDetailsModel;
import com.tools.models.MedicineModel;
import com.tools.models.OwnerModel;

public class FileUtils {

	public static void writeToCsvFile(String fileName, List<String> stringList) {

		try (FileWriter writer = new FileWriter(Constants.PROPERTY_FILE_PATH + fileName + ".csv",true);) {
			String stringConcat = "";

			for (String string : stringList) {
				stringConcat += string + "\n";
			}

			writer.write(stringConcat);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToCsvFile(String fileName, String string) {

		try (FileWriter writer = new FileWriter(Constants.PROPERTY_FILE_PATH + fileName + ".csv",true);) {
//			try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Constants.PROPERTY_FILE_PATH + fileName + ".csv"), "utf-8"))) {
			writer.write(string + "\n");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeMedicineModelToCsvFile(String fileName, List<MedicineModel> medicineModelList) {
		try (FileWriter writer = new FileWriter(Constants.PROPERTY_FILE_PATH + fileName + ".csv",true);) {

			String stringConcat = "";

			for (MedicineModel itemNow : medicineModelList) {
				stringConcat += itemNow.toStringRow() + "\n";
			}

				writer.write(stringConcat);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeAnimalDetailsModelToCsvFile(String fileName, List<AnimalDetailsModel> animalDetailsList) {
		try (FileWriter writer = new FileWriter(Constants.PROPERTY_FILE_PATH + fileName + ".csv",true);) {

			String stringConcat = "";

			for (AnimalDetailsModel itemNow : animalDetailsList) {
				stringConcat += itemNow.toStringRow() + "\n";
			}

				writer.write(stringConcat);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void writeOwnerModelToCsvFile(String fileName, List<OwnerModel> ownerModelList) {
		try (FileWriter writer = new FileWriter(Constants.PROPERTY_FILE_PATH + fileName + ".csv",true);) {

			String stringConcat = "";

			for (OwnerModel itemNow : ownerModelList) {
				stringConcat += itemNow.toStringRow() + "\n";
			}

				writer.write(stringConcat);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
