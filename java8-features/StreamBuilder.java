import java.util.*;
import java.util.stream.*;

public class StreamBuilder {

	public static void main(String []args) {
		// stream by Integer objects
		Stream.of(23, 12, 89, 23, 43, 92, 2, 19, 89, 25, 17, 19)
			  .forEach(i -> System.out.print(i + ", "));

		System.out.println();

		// stream by array of Integer
		Stream.of(new Integer[] { 1, 3, 8, 3, 4, 9, 10, 6, 7, 5 })
			  .forEach(i -> System.out.format("%d, ", i));

		System.out.println();

		// stream by array of primitive ints
		Arrays.stream(new int[] { 3, 4, 8, 1, 2, 9, 5 } )
		      .forEach(i -> System.out.print(i + ", "));

		System.out.println();
	
	}

}
