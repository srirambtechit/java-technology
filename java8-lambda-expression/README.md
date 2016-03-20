<h1>Java 8 Programming</h1>

<h3>Introduction</h3>
<pre>
  - Java 8 has lot of improvements with respect to API, new concepts
  - Lambda programming
  - Method Reference
  - Stream API
  - Enhanced Interface
  - New Date and Time AIP
  - CompletableFuture - it is class to compose multiple asynchronous task
  - Optional - inspired by functional programming languages
  			 - it was introduced to allow better modeling in codebase
  			   when a value may be present or absent.
  			 - it protects from NullPointerException
</pre>

<h3>Lambda Expression</h3>
<pre>
 - Syntax: () -> {}
   example: (File f) -> f.getName().endsWith(".xml");
 - Returns FunctionalInterface as object
 
 - <b>FunctionalInterface</b>: in jdk8, it is new feature proposed by JRS. It is 
   an interface which would have only one abstract method.
   
 - <b>Anonymous</b>: A lambda expression is anonymous because it does not have an
   explicit name as a method normally would. It’s sort of like an anonymous class
   in that it does not have a declared name.
   
 - <b>Function</b>: A lambda is like a method in that it has a list of parameters, a
   body, a return type, and a possible list of exceptions that can be thrown. However, 
   unlike a method, it’s not declared as part of a particular class.
   
 - <b>Passed around</b>: A lambda expression can be passed as an argument to a
   method, stored in a variable, and also returned as a result.      
   
</pre>

<h3>Method Reference</h3>
<pre>
 - supports to form a better lambda expression
 - To reuse existing method definition
 - Method reference straight a way uses Class's implementation since lambda 
   need to have implementation details of functional interface
 - Four kinds of method reference
 
     - A method reference to a static method
       example: 
       <b>Function<String, Integer> converter = Integer::parseInt;
       Integer number = converter.apply("10");</b>
       
     - A method reference to an instance method
       example:
       <b>Function<Invoice, Integer> invoiceToId = Invoice::getId;</b>
       
     - A method reference to an instance method of an existing object
       example 1:
       <b> Consumer&lt;Object&gt; print = System.out::println;</b>
       
       example 2: to call private helper method inside a class
       <b>
       File[] hidden = mainDirectory.listFiles(this::isXML);
       
       private boolean isXML(File f) {
          return f.getName.endsWith(".xml");
       }
       </b>
       
     - A constructor reference
       example:
       <b>Supplier&lt;List&lt;String&gt;&gt; listOfString = List::new;</b>
</pre>

<h3>Stream API</h3>
<pre>
 - <b>Sequence of elements</b>: A stream provides an interface to a sequenced set
  of values of a specific element type. However, streams don’t actually store 
  elements; they’re computed on demand.
  
 - <b>Source</b>: Streams consume from a data-providing source such as collections,
   arrays, or I/O resources.
   
 - <b>Aggregate operations</b>: Streams support database-like operations and common 
   operations from functional programming languages, such as filter, map, reduce, 
   findFirst, allMatch, sorted, and so on.
   
 - stream operations have two additional fundamental characteristics 
   that differentiate them from collections:
      - <b>Pipelining</b>: Many stream operations return a stream themselves. This
       allows operations to be chained to form a larger pipeline. This style enables
       certain optimizations such as laziness, short-circuiting, and loop fusion.
      - <b>Internal iteration</b>:  In contrast to collections, which are iterated
        explicitly (external iteration), stream operations do the iteration behind 
        the scenes for you.
</pre>

<h3>Enhanced Interface</h3>
<pre>
 - <b>default methods</b> can have implementation inside interface
 - inherit default methods from multiple different interfaces. Note that Java 8 
   has explicit rules to prevent inheritance issues common in C++
 - interfaces can now also have <b>static methods</b>
 example:
 <b>
      default void sort(Comparator<? super E> c) {
         Collections.sort(this, c);
      }
      
     public static <T> Stream<T> of(T... values) {
        return Arrays.stream(values);
     }
 </b>
</pre>

<h3>New Date and Time API</h3>
<pre>
 - <b>Domain-driven design</b>: it precisely models various notions of date and
   time by introducing new classes to represent them
 - few of them are ZonedDateTime, Period
 - It is immutable so thread safe
 - example: create a new LocalDateTime object and add 2 hours and 30 minutes
 <b>
    LocatedDateTime coffeeBreak = LocalDateTime.now()
                                               .plusHours(2)
                                               .plusMinutes(30);
</b>
</pre>


<h3>CompletableFuture</h3>
<pre>
 - asynchronous programming with a new class, <b>CompletableFuture</b>
 - improved on <b>Future</b> class in jdk7
 - can declaratively process and compose multiple asynchronous tasks
 - example: a price finder service along with an exchange rate calculator. 
   Once the results from the two services are available, you can combine their 
   results to calculate and print the price in GBP
   
<b>
 findBestPrice("iPhone6")
  .thenCombine(lookupExchangeRate(Currency.GBP), this::exchange)
  .thenAccept(localAmount -> System.out.printf("It will cost you %f GBP\n", localAmount));
           
  private CompletableFuture<Price> findBestPrice(String productName) {
    return CompletableFuture.supplyAsync(() -> 
           priceFinder.findBestPrice(productName));
  }
    
  private CompletableFuture<Double> lookupExchangeRate(CurrencylocalCurrency) {
    return CompletableFuture.supplyAsync(() -> 
           exchangeService.lookupExchangeRate(Currency.USD, localCurrency));
  }
</b>
</pre>


<h3>Optional</h3>
<pre>
 - It is a new class introduced in jdk8
 - better modeling in for code when a value may be present or absent
 - Protects from NullPointerException
 - example: 
 
   <b>getEventWithId(10).getLocation().getCity();</b>
   
  at any time, above code may throw NPE, so need to refactor code as follows
  earlier to jdk8
  
  <b>
  public String getCityForEvent(int id) {
     Event event = getEventWithId(id);
     if(event != null) {
       Location location = event.getLocation();
       if(location != null) {
          return location.getCity();
       }
     }
     return "TBC";
  }
  </b>
   
   
   refactored as per jdk8 style
   
   <b>
  public String getCityForEvent(int id) {
     return Optional.ofNullable(getEventWithId(id))
             .flatMap(this::getLocation)
             .map(this::getCity)
             .orElse("TBC");
  }
   </b>
   
   
</pre>


















