package com.msrm.jdk8.feature;

import java.util.HashMap;
import java.util.Map;

public class ImprovedMapApp {

	public static void main(String[] args) {
		Map<String, String> oldMap = new HashMap<>();
		oldMap.put("1", "one");
		oldMap.put("2", "two");
		oldMap.put("3", "three");
		for (int i = 0; i < 10; i++) {
			if (!oldMap.containsKey(String.valueOf(i)))
				oldMap.put(String.valueOf(i), "val" + i);
		}
		System.out.println(oldMap);

		System.out.println();

		// 1. no need of checking key presents
		Map<String, String> newMap = new HashMap<>();
		newMap.put("1", "one");
		newMap.put("2", "two");
		newMap.put("3", "three");
		for (int i = 0; i < 10; i++) {
			newMap.putIfAbsent(String.valueOf(i), "val" + i);
		}
		System.out.println(newMap);

		System.out.println();

		// 2. compute logic on map based on presents of value
		newMap.computeIfPresent("1", (k, v) -> v.concat(k));

		// 3. compute logic on map if value not there
		newMap.computeIfAbsent("10", v -> "ten");

		// 4. always get value though value not there in map
		// key "11" not in map
		String foundValue = newMap.getOrDefault("11", "negative");
		String defaultValue = newMap.getOrDefault("10", "negative");
		System.out.println(foundValue);
		System.out.println(defaultValue);
		
		System.out.println();
		
		// 5. merging values in map
		newMap.merge("10", "_value", String::concat); // ten_value

		// 4. printing map is so easy in lambda style
		newMap.forEach((k, v) -> System.out.println(k + "=" + v));

	}

}
