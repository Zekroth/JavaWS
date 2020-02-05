package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String operatorName = null;
		do {
			try {
				System.out.println("Ciao, chi sei?");
				operatorName = input.nextLine();
				if(operatorName.isEmpty()) {
					throw new InputMismatchException("Per favore inserisci il tuo nome");
				}else if(operatorName.contains("[123456789*{}\"\'#@§,.;:]")) {
					throw new InputMismatchException("Il nome inserito contiene caratteri non validi");
				}
			}catch(InputMismatchException e) {
				System.out.println("ERR LOG: "+ e.getMessage());
			}
			
			
			
		}while(true);

	}

}
