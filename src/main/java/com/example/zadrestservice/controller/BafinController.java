package com.example.zadrestservice.controller;

import com.example.zadrestservice.dto.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-13
 */
@Controller
public class BafinController {

	public List<BafinCompany> getCompanies() {
		List<BafinCompany> list = new ArrayList<>();
		int max = (int) (Math.random()*10);

		for (int i=0; i < max; i++) {
			BafinCompany test = new BafinCompany("Company - " + (i+1), UUID.randomUUID().toString(), UUID.randomUUID().toString());
			list.add(test);
		}

		return list;
	}

}
