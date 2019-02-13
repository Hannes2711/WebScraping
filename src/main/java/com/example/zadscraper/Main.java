package com.example.zadscraper;

import org.apache.commons.lang3.*;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-11
 */
public class Main {

	public static void main(String[] args) throws IOException {
		new Main();
	}

	public Main() throws IOException {

		List<BafinCompanyPageData> results = new ArrayList<BafinCompanyPageData>();
		BafinCompanyPageScraper companyPageScraper = new BafinCompanyPageScraper();

		BafinCompaniesScraper bps = new BafinCompaniesScraper();
		List<String> allCompanyUrls = bps.getAllCompanyUrls();

		System.out.println("allCompanyUrls.size() = <" + allCompanyUrls.size() + ">");
		for (String companyUrl : allCompanyUrls) {
			System.out.println("companyUrl = <" + companyUrl + ">");
			results.add(companyPageScraper.scrapeCompanyPage(companyUrl));
		}

		List<String> lines = BafinCompanyPageDataToCSVAdapter.adaptToLines(results);

		CSVWriter csvWriter = new CSVWriter();
		csvWriter.writeFile("output.csv", lines);
	}

}
