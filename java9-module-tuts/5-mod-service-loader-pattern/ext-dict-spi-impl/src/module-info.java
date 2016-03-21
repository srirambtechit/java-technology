module ext.dictionary.provider {
	requires dictionary.spi;
	provides dictionary.spi.Dictionary with dictionary.spi.impl.ExtendedDictionary;
}
