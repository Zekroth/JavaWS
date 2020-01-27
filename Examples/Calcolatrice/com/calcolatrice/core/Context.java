package com.calcolatrice.core;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Context {
	
	public static final Pattern numbers = Pattern.compile("/([0-9])/");

	public String Source;
	public List<Op> OperationList;
	public Number ExpressionValue;
	
	private boolean debug = true;
	
	public Context(String source) {
		Source = source;
		int index = 0;
		char current = source.charAt(index);
		ExpressionValue.Assign(0d);
		
		while (index != source.length()) {
			switch (current) {
			case '(':
				OperationList.add(new Context(source.substring(index, source.indexOf(')'))).ExpressionValue);
				break;
			}
			
			if(((new String())+current).matches("/([0-9])/")){
				Matcher pattern = numbers.matcher(source.substring(index));
				int numberEndIndex = pattern.end(0) + index;
				OperationList.add(new Number(Integer.parseInt(source.substring(index, numberEndIndex))));
				
				
			}
		}

	}
	
	private Double numberParser(String s) throws IllegalArgumentException{
		
		Matcher pattern = numbers.matcher(s);
		
		return null;
	}

}
