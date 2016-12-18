# Key Points Java 8 Lambda

Streams follows behaviour parameterization pattern.

1. Stream operations are either intermediate or terminal.  
2. Intermediate operations return a stream so we can chain multiple intermediate operations without  
using semicolons.
3. Terminal operations are either void or return a non-stream result.  
4. A function is non-interfering when it does not modify the underlying data source of the stream,  
e.g. in the above example no lambda expression does modify myList by adding or removing elements  
from the collection.  
5. A function is stateless when the execution of the operation is deterministic, e.g. in the above  
example no lambda expression depends on any mutable variables or states from the outer scope which  
might change during execution.  
6. chain of stream operations is also known as operation pipeline.  
7. Once terminal operation executed, stream is closed, attempting another terminal operation on  
closed stream would cause IllegalStateException  
8. There are two type of iteration, internal and external iteration. Stream uses internal iteration  
9. Collect is an extremely useful terminal operation to transform the elements of the stream into a  
different kind of result, e.g. a List, Set or Map.  
10. Collect accepts a Collector which consists of four different operations: a _supplier_, an  
_accumulator_, a _combiner_ and a _finisher_.  

