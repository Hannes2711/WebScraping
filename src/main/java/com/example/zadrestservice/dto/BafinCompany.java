package com.example.zadrestservice.dto;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-13
 */
public class BafinCompany {

	private String name;
	private String ktoDatum;
	private String zadDatum;

	public BafinCompany(String name, String ktoDatum, String zadDatum) {
		this.name = name;
		this.ktoDatum = ktoDatum;
		this.zadDatum = zadDatum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKtoDatum() {
		return ktoDatum;
	}

	public void setKtoDatum(String ktoDatum) {
		this.ktoDatum = ktoDatum;
	}

	public String getZadDatum() {
		return zadDatum;
	}

	public void setZadDatum(String zadDatum) {
		this.zadDatum = zadDatum;
	}
}
