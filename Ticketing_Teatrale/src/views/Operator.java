package views;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import core.TheaterManager;
import models.Show;




public class Operator {
	public static TheaterManager current = null;
	public static void main(String[] args) throws Exception {
		
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
						if(current.getTheater().getPlannedShows().isEmpty()) {
							System.out.println("Non ci sono show in programma");
							continue;
						}
						System.out.println("Per quale spettacolo vuoi creare il biglietto?"
								+ "\nPer cercare lo spettacolo inserisci"
								+ "\n{gg/mm/yyyy dd} con dd numero di giorni di distanza dalla data indicata"
								+ "\n{eur,cents} per ricercare tramite prezzo"
								+ "\n{nome spettacolo} per ricercare tramite nome");
						do {
							try {
								if(input.hasNextInt()) {
									List<Show> shows = current.getTheater().lookForShow(input.nextInt());
									for( int i = 0; i < shows.size(); i++ ) {
										Show s = shows.get(i);
										if(s.date.after(Calendar.getInstance().getTime()))
											System.out.println(i + "|\t" + s.date + ":\t"+ s.name + "\t" + s.price );
									}
									System.out.println("Seleziona uno spettacolo:");
									do {
										try {
											Show selected = shows.get(input.nextInt());
											
											break;
										}catch(InputMismatchException e) {
											System.out.println("Per favore inserisci un valore tra 0 e " + shows.size());
										}
									}while(true);
								}
								
							}catch(InputMismatchException e) {
								System.out.println("ERR LOG: "+ e.getMessage());
							}
							break;//Da rimuovere
						}while(true);
						
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
