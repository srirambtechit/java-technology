package dictionary.spi.impl;

import java.util.HashMap;

import dictionary.spi.Dictionary;

public class ExtendedDictionary implements Dictionary {

	private HashMap<String, String> dict;

	public ExtendedDictionary() {
		dict = new HashMap<>();
		dict.put("xml", "Extensible Markup Language");
		dict.put("rest", "Representational State Transfer");
	}

	@Override
	public String getDefinition(String word) {
		return dict.get(word);
	}

}
