package com.examples;

import java.util.Locale;
import java.util.ResourceBundle;

public class EsempioResourceBundles {
	
	public static void main(String[] args) {
		

		Locale.setDefault(new Locale("en", "US"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println("Locale corrente: " + Locale.getDefault());
		
		ResourceBundle myBundle = ResourceBundle.getBundle("MyLabels");
		
		System.out.println("Say how are you in US ENG: " + myBundle.getString("how_are_you"));
		
		Locale.setDefault(new Locale("it","IT"));
		myBundle = ResourceBundle.getBundle("MyLabels");
		System.out.println("Ora in italiano" + myBundle.getString("how_are_you"));
	}
	
}
