package com.interfaces.console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatTeest {

	public static void main(String[] args) {
		String sf1 = String .format("hi ", args[0]);
		
		Pattern pattern = Pattern.compile("[A-Za-z]");
		Matcher m = pattern.matcher(sf1);
		
		System.out.println(sf1);
		System.out.println(args[0]);
	}

}
