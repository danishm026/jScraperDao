package com.arc.jScraperDao.fileio;

import java.io.PrintWriter;
import java.util.List;

public class FileIO {
	public static void writeListToFile(List<String> list, PrintWriter writer) {
		for (String line : list) {
            writer.println(line);
        }
	}

	public static void writeToFile(String string, PrintWriter writer) {
			writer.println(string);
	}
}
