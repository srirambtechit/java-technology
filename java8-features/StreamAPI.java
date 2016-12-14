import java.util.stream.*;
import java.util.*;

public class StreamAPI {
	public static void main(String []args) {
		Stream<Integer> ints = Stream.of(1, 3, 4, 2, 8, 9, 5);
		ints.forEach(System.out::println);

		Stream<Integer> ints2 = Stream.of(new Integer[] {1, 2, 3});
		ints2.forEach(System.out::println);

		IntStream ints3 = Arrays.stream(new int[] {11, 22, 33});
		ints3.forEach(System.out::println);

		LongStream longs = Arrays.stream(new long[] {10, 20, 30});
		longs.forEach(System.out::println);


		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(9);
		list.add(10);

		int total = list.stream()
			.filter(i -> i > 4)
			.mapToInt(i -> i)
			.sum();
		System.out.println("Total : " + total);
	}
}
