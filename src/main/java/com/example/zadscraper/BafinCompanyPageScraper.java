package com.example.zadscraper;

import org.apache.commons.lang3.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-11
 */
public class BafinCompanyPageScraper {

	private static String KONTOINFORMATIONSDIENSTE = "Kontoinformationsdienste";
	private static String ZAHLUNGSAUSLOESEDIENSTE = "Zahlungsauslösedienste";
	private static int ERLAUBNIS_TYPE_COLUMN = 0;
	private static int ERLAUBNIS_DATE_COLUMN = 1;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	public BafinCompanyPageData scrapeCompanyPage(String url) throws IOException {

		Document document = Jsoup.connect(url).get();

		String companyName = extractCompanyName(document);
		Date ktoDate = null;
		Date zadDate = null;

		Element table = getErlaubnisTable(document);
		if (table != null) {
			Elements rows = getRows(table);
			ktoDate = extractDateColumn(rows, KONTOINFORMATIONSDIENSTE);
			zadDate = extractDateColumn(rows, ZAHLUNGSAUSLOESEDIENSTE);
		}

		return new BafinCompanyPageData(companyName, ktoDate, zadDate);
	}

	private String extractCompanyName(Document document) {
		Elements content = document.select("#content");
		Elements paragraph = content.select("p");

		if (paragraph.size() > 0) {
			Node node = paragraph.first().childNode(0);

			String name = StringUtils.trim(node.toString());
			System.out.println("name = <" + name + ">");

			if (StringUtils.isNotBlank(name)) {
				return name;
			}
		}

		return null;
	}

	private Date extractDateColumn(Elements rows, String checkValue) {
		for (Element row : rows) {
			Elements columns = getColumns(row);
			if (columns.size() > 1) {
				String type = getErlaubnisTypeValue(columns);
				if (StringUtils.containsIgnoreCase(type, checkValue)) {
					System.out.println("Found column <" + checkValue + ">, extracting date.");
					return extractDate(columns);
				}
			}
		}
		return null;
	}

	private String getColumnValue(Elements columns, int col) {
		TextNode node = (TextNode) columns.get(col).childNode(0);
		return node.text();
	}

	private String getErlaubnisTypeValue(Elements columns) {
		String value = getColumnValue(columns, ERLAUBNIS_TYPE_COLUMN);
		System.out.println("Erlaubnis type from column <" + ERLAUBNIS_TYPE_COLUMN + ">: <" + value + ">.");
		return value;
	}

	private Date extractDate(Elements columns) {
		String value = getColumnValue(columns, ERLAUBNIS_DATE_COLUMN);
		System.out.println("Erlaubnis date from column <" + ERLAUBNIS_DATE_COLUMN + ">: <" + value + ">.");

		if (StringUtils.isNotBlank(value)) {
			try {
				System.out.println("Extracting date <" + value + ">.");
				return sdf.parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	private Element getErlaubnisTable(Document document) {

		Elements select = document.select("table#erlaubnis");
		System.out.println("Found <" + select.size() + "> table with id 'erlaubnis' on page.");

		if (select.size() > 0) {
			return select.first();
		}
		return null;
	}

	private Elements getRows(Element table) {
		Elements tbody = table.select("tbody");
		Elements rows = tbody.select("tr");
		System.out.println("Found <" + rows.size() + "> rows in table.");
		return rows;
	}

	private Elements getColumns(Element row) {
		Elements columns = row.select("td");
		System.out.println("Found <" + columns.size() + "> columns for row.");
		return columns;
	}
}
