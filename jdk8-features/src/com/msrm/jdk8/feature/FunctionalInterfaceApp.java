package com.msrm.jdk8.feature;

@FunctionalInterface
interface Converter<R, T> {
	public T convert(R from);
}

public class FunctionalInterfaceApp {

	public static void main(String[] args) {
		Converter<String, Integer> convert = (s) -> Integer.valueOf(s);
		Integer integer = convert.convert("334");
		System.out.println(integer);
	}

}
