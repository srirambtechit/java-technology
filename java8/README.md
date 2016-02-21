<h1>Java 8 Programming</h1>

<h3>Introduction</h3>
<pre>
  - Java 8 has lot of improvements with respect to API, new concepts
  - Lambda programming
  - Stream API
  - Enhanced Interface
  - New Date and Time AIP
  - CompletableFuture - it is class to compose multiple asynchronous task
  - Optional - inspired by functional programming languages
  			 - it was introduced to allow better modeling in codebase
  			   when a value may be present or absent.
  			 - it protects from NullPointerException
</pre>

<h3>Lambda expression</h3>
<pre>
 - Syntax: () -> {}
   example: (File f) -> f.getName().endsWith(".xml");
 - Returns FunctionalInterface as object
 - <b>FunctionalInterface</b>: in jdk8, it is new feature proposed by JRS. It is 
   an interface which would have only one abstract method.
</pre>