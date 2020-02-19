package com.interfaces.console;

import com.examples.Employee;
import com.examples.FunzioniMatematiche;

public class ConsoleStart {

	public static void StartEmployee() throws IllegalArgumentException, IllegalAccessException {
		boolean success = true;
		Employee employee = null;
		try {
			employee = new Employee("Edoardo", "Barchiesi", 17, "Maschio", 1, "E14118", 20);
			
		} catch (Exception e) {
			
			System.out.println("C'è stato un errore: ");
			for (String string : e.getMessage().split(";")) {
				System.out.println(string);
			}
			success = false;
		}
		if(employee == null) {
			System.out.println("L'impiegato non è stato creato");
		}else {
			System.out.println("Impiegato creato");
			for (java.lang.reflect.Field x : employee.getClass().getFields()) {
				System.out.println(x.getName() + " | " + x.get(employee).toString());
			}
		}
	}
	public static void Radice() throws Exception{
		FunzioniMatematiche fm;
		
		try {
			fm = new FunzioniMatematiche();
			System.out.println(fm.sqrt(7));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] Args) {
		try {
			Radice();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
