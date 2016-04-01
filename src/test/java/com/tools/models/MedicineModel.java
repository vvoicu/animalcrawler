package com.tools.models;

import com.tools.Constants;
import com.tools.FormatterUtils;

public class MedicineModel {

	public String tip;
	public String medicament;
	public String numarDestinatar;
	public String dataAdministrare;
	public String varsta;
	public String scadenta;
	public String observatii;
	public String createDe;
	public String id;

	public MedicineModel() {
		id = "";
		tip = "";
		medicament = "";
		numarDestinatar = "";
		dataAdministrare = "";
		varsta = "";
		scadenta = "";
		observatii = "";
		createDe = "";
	}

	/**
	 * Used for generating a csv Row
	 * 
	 * @return
	 */
	public String toStringRow() {
		return FormatterUtils.cleanString(
				id + Constants.FILE_SEPARATOR + tip + Constants.FILE_SEPARATOR + medicament + Constants.FILE_SEPARATOR + numarDestinatar + Constants.FILE_SEPARATOR + dataAdministrare + Constants.FILE_SEPARATOR
						+ varsta + Constants.FILE_SEPARATOR + scadenta + Constants.FILE_SEPARATOR + observatii + Constants.FILE_SEPARATOR + createDe + Constants.FILE_SEPARATOR);
	}

	public void printMedicineModel() {
		System.out.println("-----------");
		System.out.println("id: " + id);
		System.out.println("tip: " + tip);
		System.out.println("medicament: " + medicament);
		System.out.println("numarDestinatar: " + numarDestinatar);
		System.out.println("dataAdministrare: " + dataAdministrare);
		System.out.println("varsta: " + varsta);
		System.out.println("scadenta: " + scadenta);
		System.out.println("observatii: " + observatii);
		System.out.println("createDe: " + createDe);
	}

}
