package com.example.zadscraper;

import java.util.ArrayList;
import java.util.List;

public class BafinCompanyPageDataToCSVAdapter2 {

  public static List<BafinCompanyPageData> filter(List<BafinCompanyPageData> lines) {
    List<BafinCompanyPageData> lines2 = new ArrayList<>();

    for (int i = 0; i < lines.size(); i ++) {
      if (lines.get(i).getKontoinformationsdiensteDate() != null || lines.get(i).getZahlungsausloesediensteDate() != null) {
        lines2.add(lines.get(i));
      }
    }

    return lines2;
  }
}

