package core;

import models.*;

public class TheaterManager {
	
	private static Theater theater;//da modificare se teatri multipli
	
	public static Theater getTheater() {
		return theater;
	}
	
	protected static Theater initTheater(String operatorName) {
		theater = new Theater(operatorName);
		return theater;
	}
	
	
}
