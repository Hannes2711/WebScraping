package com.example.zadscraper;

import org.apache.commons.lang3.*;

import java.text.*;
import java.util.*;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-12
 */

// Ertstellt aus dem Objekt eine Liste mit dem Namen, dem K-Datum und dem Z-Datum

public class BafinCompanyPageDataToCSVAdapter {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	public static List<String> adaptToLines(List<BafinCompanyPageData> results) {
		List<String> lines = new ArrayList<>();

		lines.add("NAME; KONTOINFORMATIONSDIENSTE; ZAHLUNGSINFORMATIONSDIENSTE;");
		for (BafinCompanyPageData scraper : results) {

			String name = scraper.getCompanyName();

			String ktoDatum = "";
			if (null != scraper.getKontoinformationsdiensteDate()) {
				ktoDatum = sdf.format(scraper.getKontoinformationsdiensteDate());
			}

			String zadDatum = "";
			if (null != scraper.getZahlungsausloesediensteDate()) {
				zadDatum = sdf.format(scraper.getZahlungsausloesediensteDate());
			}

			String line = ("\"" + name + "\"" + "; " + ktoDatum + "; " + zadDatum + ";");

			if (StringUtils.isNotBlank(name)) {
				lines.add(line);

			}
		}
			return lines;
	}

}
