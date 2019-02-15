package com.example.zadrestservice.controller;
import com.example.zadscraper.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.example.zadscraper.BafinData;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-13
 */
@Controller
public class BafinController {

	@Autowired
	private BafinData bafinData;

  private List<BafinCompanyPageData> liste = new ArrayList<>();
  private int counter = 100;

  @PostConstruct
  public void init() {
    getCachedResults();
  }

	public List<BafinCompanyPageData> getCompanies(boolean withDate, String nameFilter) {

    List<BafinCompanyPageData> liste = getCachedResults();

    // filtering for name
		if (StringUtils.isNotBlank(nameFilter)) {
      liste = BafinCompanyNameFilter.filter(liste, nameFilter);
    }

		// filtering for date
		if (withDate == true) {
      liste = BafinCompanyPageDataToCSVAdapter2.filter(liste);
      System.out.println("Company list contains <" + liste.size() + "> elements.");
    }

		return liste;
	}

	private List<BafinCompanyPageData> getCachedResults() {
	  if (counter > 10) {
      counter = 0;
      try {
        liste = bafinData.start();
      } catch (IOException e) {
        System.out.print("Fehler: " + e.getMessage());
      }
    }
	  counter ++;
	  return liste;
  }



}