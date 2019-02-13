package com.example.zadrestservice.boundary;

import com.example.zadrestservice.controller.*;
import com.example.zadrestservice.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-13
 */
@RestController
public class ZadServiceFacade {

	@Autowired
	private BafinController controller;

	@RequestMapping("/zadcompanies")
	public List<BafinCompany> getCompanies() {
		return controller.getCompanies();
	}

	@RequestMapping("/peter")
	public String halloPeter() {
		return "sagt hallo!";
	}

}