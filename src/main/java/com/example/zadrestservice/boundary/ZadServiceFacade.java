package com.example.zadrestservice.boundary;

import com.example.zadrestservice.controller.*;
import com.example.zadscraper.BafinCompanyPageData;
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
  public List<BafinCompanyPageData> getCompanies(@RequestParam(value = "withdate", defaultValue = "false") String withdate) {

    System.out.println("withdate = " + withdate);
    boolean withDateB = Boolean.parseBoolean(withdate);

    return controller.getCompanies(withDateB);
  }

}