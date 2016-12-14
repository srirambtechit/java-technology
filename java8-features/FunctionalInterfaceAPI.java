import java.util.function.*;
import java.util.*;

public class FunctionalInterfaceAPI {
	
	public static void main(String []args) {
		// takes String inputs for printing on Console
		Consumer<String> print = System.out::println;

		// checker
		Predicate<Integer> checker = (age) -> age > 30;

		// transform given integer into binary representation (1's 0's)
		Function<Integer, String> numToBinary = Integer::toBinaryString;
		
		// creates new HashSet object
		Supplier<HashSet> supply = HashSet::new;

		// addition operation performer
		BinaryOperator<Integer> add = (a, b) -> a + b;

		// Halved value
		UnaryOperator<Float> byTwo = a -> a / 2;

		print.accept("Is he aged? " + checker.test(24)); 
		print.accept("Binary value " + numToBinary.apply(0x4A));
		print.accept("New HashSet object " + supply.get());
		print.accept("Adder " + add.apply(23, 2));
		print.accept("Halve of 5 is " + byTwo.apply(5f));


	}

}
