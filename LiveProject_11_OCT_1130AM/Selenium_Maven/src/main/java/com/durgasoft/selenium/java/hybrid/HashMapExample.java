package com.durgasoft.selenium.java.hybrid;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<Integer, String>map=new LinkedHashMap<Integer, String>();
		map.put(101, "Mahesh");
		map.put(100, "Durga");
		map.put(120, "Sunny");
		System.out.println(map);
		Collection<String> v = map.values();
		System.out.println(v);
		Set<Integer> k = map.keySet();
		System.out.println(k);
		Set<Entry<Integer, String>> entry = map.entrySet();
		System.out.println(entry);
		

	}

}
