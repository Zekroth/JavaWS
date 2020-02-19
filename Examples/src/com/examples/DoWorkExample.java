package com.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DoWorkExample {
	interface Util {
		void doWork();
	}
	public static void main(String[] arr) {
		Util action = System.out::println;
		System.out.println("cipolle");
		action.doWork();
		System.out.println("End");
		List<String> strings = new ArrayList<String>();
		
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("ciao");
		strings.add("cipolle");
		
		Scanner input = new Scanner(System.in);
		do {
			String expr = input.next();
			input.nextLine();
			if(expr.equalsIgnoreCase("Exit"))
				break;
			List<String> matching = strings.stream().filter(s -> s.matches(expr)).collect(Collectors.toList());
			matching.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}			
			});
			
			matching.forEach(s -> System.out.println(s));
		}while(true);
	
		
		
		
	}
}
