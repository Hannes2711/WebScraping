package com.example.zadrestservice.controller;
import com.example.zadscraper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.example.zadscraper.BafinData;

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

	public List<BafinCompanyPageData> getCompanies(boolean withDate) {
		List<BafinCompanyPageData> liste = new ArrayList<>();

		try {liste =  bafinData.start(); }
		catch(IOException e){
			System.out.print("Fehler: "+e.getMessage());
		}

		// filtering
		liste = BafinCompanyPageDataToCSVAdapter2.filter(BafinData.start().results);

		System.out.println("Company list contains <"+ liste.size()+"> elements.");

		return liste;

		}
}