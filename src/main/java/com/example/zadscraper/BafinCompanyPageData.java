package com.example.zadscraper;

import java.util.*;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-12
 */

// Erstellt das Objekt, in dem die Daten temporär gespeichert werden

public class BafinCompanyPageData {

	private String companyName = null;
	private Date kontoinformationsdiensteDate = null;
	private Date zahlungsausloesediensteDate = null;

	public BafinCompanyPageData(String companyName, Date kontoinformationsdiensteDate, Date zahlungsauslösediensteDate) {
		this.companyName = companyName;
		this.kontoinformationsdiensteDate = kontoinformationsdiensteDate;
		this.zahlungsausloesediensteDate = zahlungsauslösediensteDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Date getKontoinformationsdiensteDate() {
		return kontoinformationsdiensteDate;
	}

	public Date getZahlungsausloesediensteDate() {
		return zahlungsausloesediensteDate;
	}
}
