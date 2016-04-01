package com.tools.models;

import com.tools.Constants;
import com.tools.FormatterUtils;

import freemarker.template.utility.StringUtil;

public class AnimalDetailsModel {

	public String nume;
	public String specie;
	public String rasa;
	public String culoare;
	public String stare;
	public String sex;
	public String sterilizat;
	public String grupaSanguina;
	public String nascutLa;
	public String varstaAn;
	public String varstaLuna;
	public String varstaZi;

	public String numarMicrochip;
	public String dataImplantarii;
	public String loculImplantarii;

	public String numarPasaport;
	public String dataEmiteriiPasaport;

	public String carteSanatate;
	public String dataEmiteriiCarteSanatate;

	public String alergii;
	public String observatii;
	public String id;

	public AnimalDetailsModel() {
		id ="";
		nume = "";
		specie = "";
		rasa = "";
		culoare = "";
		stare = "";
		sex = "";
		sterilizat = "";
		grupaSanguina = "";
		nascutLa = "";
		varstaAn = "";
		varstaLuna = "";
		varstaZi = "";

		numarMicrochip = "";
		dataImplantarii = "";
		loculImplantarii = "";

		numarPasaport = "";
		dataEmiteriiPasaport = "";

		carteSanatate = "";
		dataEmiteriiCarteSanatate = "";

		alergii = "";
		observatii = "";
	}

	public String toStringRow() {
		return FormatterUtils.cleanString(id + Constants.FILE_SEPARATOR + nume + Constants.FILE_SEPARATOR + specie + Constants.FILE_SEPARATOR + rasa + Constants.FILE_SEPARATOR + culoare + Constants.FILE_SEPARATOR + stare
				+ Constants.FILE_SEPARATOR + sex + Constants.FILE_SEPARATOR + sterilizat + Constants.FILE_SEPARATOR + grupaSanguina + Constants.FILE_SEPARATOR + nascutLa
				+ Constants.FILE_SEPARATOR + varstaAn + Constants.FILE_SEPARATOR + varstaLuna + Constants.FILE_SEPARATOR + varstaZi + Constants.FILE_SEPARATOR + numarMicrochip
				+ Constants.FILE_SEPARATOR + dataImplantarii + Constants.FILE_SEPARATOR + loculImplantarii + Constants.FILE_SEPARATOR + numarPasaport + Constants.FILE_SEPARATOR
				+ dataEmiteriiPasaport + Constants.FILE_SEPARATOR + carteSanatate + Constants.FILE_SEPARATOR + dataEmiteriiCarteSanatate + Constants.FILE_SEPARATOR + alergii
				+ Constants.FILE_SEPARATOR + observatii + Constants.FILE_SEPARATOR);
	}

	public void printAnimalDetailsModel() {
		System.out.println("id: " + id);
		System.out.println("nume: " + nume);
		System.out.println("specie: " + specie);
		System.out.println("rasa: " + rasa);
		System.out.println("culoare: " + culoare);
		System.out.println("stare: " + stare);
		System.out.println("sex: " + sex);
		System.out.println("sterilizat: " + sterilizat);
		System.out.println("grupaSanguina: " + grupaSanguina);
		System.out.println("nascutLa: " + nascutLa);
		System.out.println("varstaAn: " + varstaAn);
		System.out.println("varstaLuna: " + varstaLuna);
		System.out.println("varstaZi: " + varstaZi);

		System.out.println(numarMicrochip);
		System.out.println(dataImplantarii);
		System.out.println(loculImplantarii);

		System.out.println(numarPasaport);
		System.out.println(dataEmiteriiPasaport);

		System.out.println(carteSanatate);
		System.out.println(dataEmiteriiCarteSanatate);

		System.out.println(alergii);
		System.out.println(observatii);

	}

}
