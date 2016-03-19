package dictionary.spi.impl;

import java.util.HashMap;

import dictionary.spi.Dictionary;

public class GenericDictionary implements Dictionary {

	private HashMap<String, String> dict;

	public GenericDictionary() {
		dict = new HashMap<>();
		dict.put("book", "It is a object contains information about anything");
		dict.put("author", "the one who holds wrights for something");
	}

	@Override
	public String getDefinition(String word) {
		return dict.get(word);
	}

}
