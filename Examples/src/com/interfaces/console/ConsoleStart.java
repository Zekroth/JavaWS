package com.interfaces.console;

import com.examples.Employee;
import com.sun.jdi.Field;

public class ConsoleStart {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		boolean success = true;
		Employee employee = null;
		try {
			employee = new Employee("Edoardo", "Barchiesi", 21, "Maschio", 1, "E14118", 20);
			
		} catch (Exception e) {
			
			System.out.println("C'è stato un errore: ");
			for (String string : e.getMessage().split(";")) {
				System.out.println(string);
			}
			success = false;
		}
		if(employee.equals(null)) {
			System.out.println("C'è stato un errore con la creazione dell'impiegato");
		}else {
			System.out.println("Impiegato creato");
			for (java.lang.reflect.Field x : employee.getClass().getFields()) {
				System.out.println(x.getName() + " | " + x.get(employee).toString());
			}
		}
	}
}
