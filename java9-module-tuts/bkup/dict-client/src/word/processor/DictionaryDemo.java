package word.processor;

import dictionary.DictionaryService;

public class DictionaryDemo {

	public static void main(String[] args) {
		DictionaryService service = DictionaryService.getInstance();
		System.out.println(service.getDefinition("book"));
		System.out.println(service.getDefinition("xml"));
	}

}
