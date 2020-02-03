package console;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import functions.*;
public class Test {
	private static Funcs funcs = new Funcs();
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		List<Number> list = new ArrayList<Number>();
		do {
			try {
				System.out.println("Please give me a number or stop");
				Double nextValue = input.nextDouble();
				System.out.println(nextValue);
				list.add((Number) nextValue);
			}
			catch(InputMismatchException e) {
				if(input.next().equalsIgnoreCase("stop")) {
					System.out.println("Starting the evaluation");
					break;
				}else {
					System.out.println("Please tell me either a number or to stop");
				}
			}
			
		}while(true);
		
		boolean argument = false;
		
		do {
			try {
				
				System.out.println("Vuoi i numeri positivi o negativi");
				String data = input.next();
				if(data.equalsIgnoreCase("positivi")) {
					argument = true;
					break;
				}else if(data.equalsIgnoreCase("negativi")) {
					break;
				}else {
					throw new InputMismatchException("Per favore scrivi true o false");
				}
			}
			catch(InputMismatchException e) {
				
			}
		}while(true);
		

		Object[] arr = funcs.valuta(list,argument);
		Number[] numbs = new Number[arr.length];
		for (int i = 0; i < arr.length; i++) {
			numbs[i] = (Number) arr[i];
			System.out.println(numbs[i]);
		}
		
	}

}
