package dictionary.spi;

/**
 * {@link Dictionary} is a Service Provider Interface. This interface should
 * have only one method.
 * 
 * @author sriram
 *
 */
public interface Dictionary {

	public String getDefinition(String word);

}
