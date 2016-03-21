package dictionary;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import dictionary.spi.Dictionary;

/**
 * {@link DictionaryService} should be a Singleton Class
 * 
 * @author sriram
 *
 */
public class DictionaryService {

	private static DictionaryService service;

	private ServiceLoader<Dictionary> loader;

	private DictionaryService() {
		loader = ServiceLoader.load(Dictionary.class);
	}

	public static synchronized DictionaryService getInstance() {
		if (service == null) {
			service = new DictionaryService();
		}
		return service;
	}

	public String getDefinition(String word) {
		String def = null;
		try {
			Iterator<Dictionary> itr = loader.iterator();
			if (def == null && itr.hasNext()) {
				Dictionary dict = itr.next();
				System.out.println("class name: " + dict.getClass().getName());
				def = dict.getDefinition(word);
				System.out.println("def : " + def);
			}
		} catch (ServiceConfigurationError e) {
			def = null;
			e.printStackTrace();
		}
		return def;
	}

}
