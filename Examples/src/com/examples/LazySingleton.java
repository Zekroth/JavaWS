package com.examples;

public class LazySingleton {
	
	//FIELDS
	public String nome;
	//STATIC FIELDS
	private static LazySingleton _self;
	public static boolean debug = true;
	//CONSTRUCTORS
	private LazySingleton() {
		
	}
	private LazySingleton(String name) {
		this();
		this.nome = name;
	}
	//STATIC METHODS
	public static LazySingleton getInstance() {
		_self.debug = true;
		if(_self == null) {
			
			_self = new LazySingleton();
		}
		if(debug) {
			System.out.println("Returning instance: "+ _self.nome);
		}
		return _self;
	}
	public static LazySingleton getInstance(String name) {
		
		if(_self == null) {
			_self = new LazySingleton(name);
		}else {
			_self.nome = name;
		}
		if(debug) {
			System.out.println("Returning instance: "+_self.nome);
		}
		return _self;
	}
	
}
