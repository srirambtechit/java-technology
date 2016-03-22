# Compiling and Deploying packages - Module version

1. List of projects
   1. dict-spi
   2. gen-dict-spi-impl
   3. ext-dict-spi-impl
   4. dict-client

2. Each project should have its own dependency details
in module-info.java source file.

3. Project structure
<pre>
   1. dict-spi/
	  └── src
   	      ├── dictionary
   	      │   ├── DictionaryService.java
    	  │   └── spi
      	  │       └── Dictionary.java
      	  └── module-info.java

   2. ext-dict-spi-impl/
      ├── META-INF
      │   └── services
      │       └── dictionary.spi.Dictionary
      └── src
          ├── dictionary
	      │   └── spi
	      │       └── impl
	      │           └── ExtendedDictionary.java
	      └── module-info.java
		  
   3. gen-dict-spi-impl/
      ├── META-INF
      │   └── services
      │       └── dictionary.spi.Dictionary
      └── src
          ├── dictionary
	      │   └── spi
		  │       └── impl
		  │           └── GenericDictionary.java
		  └── module-info.java
   4. dict-client/
      └── src
          ├── module-info.java
	      └── word
	          └── processor
	              └── DictionaryDemo.java

</pre>
4. Compiling source code & Packaging as JARs
   1. dict-spi project
   ```shell
   $ javac -d mods\dictionary.spi $(find dict-spi/src -name "*.java")
   ```

   2. ext-dict-spi-impl project
   ```shell
   $ javac -mp mods -d mods/ext.dictionary.provider $(find ext-dict-spi-impl/src -name "*.java")
   ```

   3. gen-dict-spi-impl project
   ```shell
   $ javac -mp mods -d mods/gen.dictionary.provider $(find gen-dict-spi-impl/src -name "*.java")
   ```

   4. dict-client project
   ```shell
   $ javac -mp mods -d mods/dictionary.client $(find dict-client/src -name "*.java")
   ```

   
   
   
   
   
   
   
   
   
   
   
   
   
