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

4. How to use javac, java, jar
   ```shell
   $ javac -mp <module_directory> -d <module_directory\module.name> {all source files}
   $ java -mp <module_directory> -m <module_name>\<fully.qualifized.class>
   $ jar --create --file <mod_directory/filename.jar> --main-class=<fully.qualifized.class> --module-version=1.0 -C <mod_parent_directory/module.name> .
   $ java -mp <mod_directory> -m <module_name_who_has_main_class>
   ```

5. Compiling source code & Running byte code
   * dict-spi project
   ```shell
   $ javac -d mods\dictionary.spi $(find dict-spi/src -name "*.java")
   ```

   * ext-dict-spi-impl project
   ```shell
   $ javac -mp mods -d mods/ext.dictionary.provider $(find ext-dict-spi-impl/src -name "*.java")
   ```

   * dict-client project
   ```shell
   $ javac -mp mods -d mods/dictionary.client $(find dict-client/src -name "*.java")
   ```

   * Running application
   ```shell
   $ java -mp mods -m dictionary.client/word.processor.DictionaryDemo
   ```

   __Note:__ Now we have generated extended version of Dictionary Provider for Dictionary SPI, It's
   time to generate Provider for general version of Dictionary
   
   * gen-dict-spi-impl project
   ```shell
   $ javac -mp mods -d mods/gen.dictionary.provider $(find gen-dict-spi-impl/src -name "*.java")
   ```
   * Running application
   ```shell
   $ java -mp mods -m dictionary.client/word.processor.DictionaryDemo
   ```
   **Oops**...
   ```
   Error occurred during initialization of VM
   java.lang.reflect.LayerInstantiationException: Package dictionary.spi.impl in both module ext.dictionary.provider and module gen.dictionary.provider
    	at java.lang.reflect.Layer.fail(java.base@9-ea/Layer.java:439)
    	at java.lang.reflect.Layer.checkBootModulesForDuplicatePkgs(java.base@9-ea/Layer.java:397)
    	at java.lang.reflect.Layer.defineModules(java.base@9-ea/Layer.java:347)
    	at jdk.internal.module.ModuleBootstrap.boot(java.base@9-ea/ModuleBootstrap.java:249)
    	at java.lang.System.initPhase2(java.base@9-ea/System.java:1916)
	
	because, two service provider impl modules were loaded and get conflicts, so better remove any one
	of these modules from the -modulepath during launching JVM to avoid error.
```

6. Packaging as Modular JAR
   * creating JARs
   ```shell
   $ jar --create --file=lib/dictionary-spi.jar --module-version=1.0 -C mods/dictionary.spi/ .
   $ jar --create --file=lib/ext-dictionary.jar --module-version=1.0 -C mods/ext.dictionary.spi/ .
   $ jar --create --file=lib/dictionary-main.jar --module-version=1.0 --main-class=word.processor.DictionaryDemo -C mods/dictionary.client/ .
   ```
   * Running JAR
   ```shell
   $ java -mp lib -m dictionary.client
   ```
   __Note:__ -m specifies module name, which will have Main-Class Attribute entry in its META-INF/MANIFEST.MF.
   
   
   
   
   
   
   
   
   
   
   
