package com.msrm.lambda.parallel;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * Runtime argument used to customize poolSize of threads
 * -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
 * 
 * @author srirammuthaiah
 *
 */
//@formatter:off
public class ParallelStreamApp {

	public static void main(String[] args) {
		// -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println("parallelism : " + commonPool.getParallelism());
		System.out.println("poolSize : " + commonPool.getPoolSize());
		
		// parallel execution of streams
		Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i")
			.parallelStream()
			.filter(s -> {
				System.out.printf("filter  : %s [%s]%n", s, Thread.currentThread().getName());
				return true;
			})
			.map(s -> {
				System.out.printf("map     : %s [%s]%n", s, Thread.currentThread().getName());
				return s.toUpperCase();
			})
			.forEach(s -> {
				System.out.printf("forEach : %s [%s]%n", s, Thread.currentThread().getName());
			});
		
		System.out.println();
		
		// little modification in the above example
		Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i")
		.parallelStream()
		.filter(s -> {
			System.out.printf("filter  : %s [%s]%n", s, Thread.currentThread().getName());
			return true;
		})
		.map(s -> {
			System.out.printf("map     : %s [%s]%n", s, Thread.currentThread().getName());
			return s.toUpperCase();
		})
		.sorted((s1, s2) -> {
			System.out.printf("sorted  : %s <> %s [%s]%n", s1, s2, Thread.currentThread().getName());
			return s1.compareTo(s2);
		})
		.forEach(s -> {
			System.out.printf("forEach : %s [%s]%n", s, Thread.currentThread().getName());
		});

		System.out.println();
		
	}

}
