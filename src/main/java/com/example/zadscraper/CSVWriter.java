package com.example.zadscraper;

import java.io.*;
import java.util.*;

/**
 * @author hek
 * Copyright 2019 by Star Finanz-Software Entwicklungs und Vertriebs GmbH
 * Created on 2019-02-12
 */
public class CSVWriter {

	public void writeFile(String fileName, List<String> lines) {
		try {
			try (PrintWriter out = new PrintWriter(fileName)) {
				for (String line : lines) {
					out.write(line);
					out.write("\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
