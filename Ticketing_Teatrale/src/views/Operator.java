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
				continue;
			}
			
			do {
				try {
					System.out.println("Cosa vuoi fare?");
					System.out.println("1\t per creare biglietto\n2\t per creare spettacolo");
					
					switch(input.nextInt()) {
					case 1:
						System.out.println("Per quale spettacolo vuoi creare il biglietto?");
						try {
							
						}catch(InputMismatchException e) {
							
						}
						break;
					case 2:
						break;
					}
				}catch(InputMismatchException e) {
					System.out.println("Inserisci un valore tra 1 e 2, senza altri caratteri");
					continue;
				}
				
			}while(true);
			
			
			
		}while(true);

	}

}
