package com.example.zadscraper;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BafinCompanyNameFilter {

  public static List<BafinCompanyPageData> filter(List<BafinCompanyPageData> lines, String nameFilter) {
    List<BafinCompanyPageData> result = new ArrayList<>();

    for (BafinCompanyPageData data : lines) {
      if (StringUtils.containsIgnoreCase(data.getCompanyName(), nameFilter)) {
        result.add(data);
      }
    }

    return result;
  }
}

