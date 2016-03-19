# Overview
* jLink is binary comes along with Java 9
* It provisions to bundle all binaries, modules, jars
* It exports as jimage

# Example
* Create a base module image
  $ `jlink --modulepath /opt/jdk9/jmods/ --addmods java.base --output myimage --exclude-files *.diz`

* Create compact3 module image; Java has different profile meaning that diffent number of modules comprises 
  as a bundle. compact3 is one among in the list
  $ `jlink --modulepath /opt/jigsaw-jdk-9/jmods/ --addmods java.compact3 --output myimage --exclude-files *.diz`
  # checking available modules in this profile
  $ `myimage/bin/java -listmods`
  # list out module details
  $`myimage/bin/java -listmods:java.compact3`
