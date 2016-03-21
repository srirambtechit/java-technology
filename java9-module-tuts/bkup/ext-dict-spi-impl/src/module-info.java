module ext.dictionary.provider {
	requires dictionary.spi;
	provides dictionary.spi.Dictionary with dictinoary.spi.impl.ExtendedDictionary;
}
