# Java Extension Mechanism
* It is concept since Java 1.3
* Pluging functionality to existing application without restarting application
* `java.util.ServiceLoader` is class used to achieve this

## Example
word processing software was developed in Java.
Dictionary functionality has to be added to it.
Using Extension mechnanism, we can develop as below

### Generic step
* Create Service Provider Interface
* Create ServiceLoader implementation
* Implement SPI for specific requirement
* Use Ex-Mech API in specific application

### Dictionary project steps
#### Create service provider interface
* create an interface `dictionary.spi.Dictionary`
* SPI should have only one method (here `getDefinition(String)`)

#### Create ServiceLoader implementation
* create a class `dictionary.DictionaryService`
* Using `java.util.ServiceLoader`, register `dictionary.spi.Dictionary` to DictionaryService class in Singleton pattern
* Only one instance has to be created throughout application so, Singleton patter used
* Generate jar file at `lib/dictionary-spi-1.0.jar`

#### Implement SPI for GenericDictionary
* create a class `dictionary.spi.impl.GenericDictionary` by implementing `dictionary.spi.Dictionary` and implement `getDefinition(String)` method.
* Generate jar file at `lib/gen-dict-1.0.jar`

#### Implement SPI for ExtendedDictionary
* create a class `dictionary.spi.impl.ExtendedDictionary` by implementing `dictionary.spi.Dictionary` and implement `getDefinition(String)` method.
* Generate jar file at `lib/ext-dict-1.0.jar`

#### Use Ex-Mech API in specific application
* Create word processor application

### Run application
* Run dictionary application
  ```$ java -cp dict-client/bin word.processor.DictionaryDemo
  Exception in thread "main" java.lang.NoClassDefFoundError: dictionary/DictionaryService
  	at word.processor.DictionaryDemo.main(DictionaryDemo.java:8)
	Caused by: java.lang.ClassNotFoundException: dictionary.DictionaryService
		at java.net.URLClassLoader.findClass(Unknown Source)
		at java.lang.ClassLoader.loadClass(Unknown Source)
		at sun.misc.Launcher$AppClassLoader.loadClass(Unknown Source)
		at java.lang.ClassLoader.loadClass(Unknown Source)
		... 1 more
  ```
  Note: Unable to load class since SPI should be loaded explicitly

* Run application with spi jar @ classpath
```$ java -cp dict-client/bin:lib/dictionary-spi-1.0.jar word.processor.DictionaryDemo
null
null
```
Note: Still values are not displayed, since provider implementation not yet loaded into JVM classloader

* Run application with extended dictionary impl
```$ java -cp dict-client/bin:lib/dictionary-spi-1.0.jar:lib/ext/ext-dictionary-1.0.jar word.processor.DictionaryDemo
class name: dictionary.spi.impl.ExtendedDictionary
def : null
null
class name: dictionary.spi.impl.ExtendedDictionary
def : Extensible Markup Language
Extensible Markup Language
```
* Run application with generic dictionary impl
```$ java -cp dict-client/bin:lib/dictionary-spi-1.0.jar:lib/gen/gen-dictionary-1.0.jar word.processor.DictionaryDemo
class name: dictionary.spi.impl.GenericDictionary
def : It is a object contains information about anything
It is a object contains information about anything
class name: dictionary.spi.impl.GenericDictionary
def : null
null
```









