package com.arc.jScraperDao.fileio;

import java.io.PrintWriter;
import java.util.List;

public class FileIO {
	public static void writeListtoFile(List<String> list, PrintWriter writer) {
		try {
			for (String line : list) {
				writer.println(line);
			}
		} finally {
			writer.close();
		}
	}
}
