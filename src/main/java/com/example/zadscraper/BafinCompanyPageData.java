package com.example.zadscraper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.*;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-12
 */

// Erstellt das Objekt, in dem die Daten temporär gespeichert werden

public class BafinCompanyPageData {

	private String companyName = null;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat
					(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
	private Date kontoinformationsdiensteDate = null;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat
					(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
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
