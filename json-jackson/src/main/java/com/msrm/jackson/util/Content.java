package com.msrm.jackson.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Content {

	public static byte[] fileBytes(String file) {
		Path path = Paths.get(file, "");
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String fileStrings(String file) {
		StringBuffer buf = new StringBuffer();
		try {
			Path path = Paths.get(file);
			List<String> lines = Files.readAllLines(path);
			for (String string : lines) {
				buf.append(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}

}
