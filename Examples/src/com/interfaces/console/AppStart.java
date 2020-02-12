package com.interfaces.console;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.examples.*;

public class AppStart {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Dimmi quanto inchiostro mettere nella penna");
		Penna p = new Penna(input.nextInt());
		System.out.println("Dimmi cosa vuoi scrivere con la penna");
		try {
			p.draw(input.next());
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}catch(NotEnoughInkException e) {
			System.out.println("\nNella penna non c'era inchiostro sufficiente per scrivere");//AGGIUNTO \n
		}
		input.nextLine();
		
		System.out.println("Dimmi quanto inchiostro mettere nel pennarello");
		Pennarello po = new Pennarello(input.nextInt());
		System.out.println("Dimmi cosa vuoi scrivere con il pennarello");
		try {
			po.draw(input.next());
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}catch(NotEnoughInkException e) {
			System.out.println("\nNel pennarello non c'era inchiostro sufficiente per scrivere");//AGGIUNTO \n
		}
		input.nextLine();
		
		System.out.println("Dimmi quanto inchiostro mettere nella stilo");
		Stilo s = new Stilo(input.nextInt());
		input.nextLine();System.out.println("Dimmi cosa vuoi scrivere con la stilo");
		try {
			s.draw(input.next());
		}catch(InputMismatchException e) {
			if(e.getMessage().equals(null)) {
				e.printStackTrace();
			}else {
				System.out.println("\nHai chiesto alla stilo di stampare dei caratteri non consentiti: "+e.getMessage());//AGGIUNTO \n
			}
		}catch(NotEnoughInkException e) {
			System.out.println("\nNella stilo non c'era inchiostro sufficiente per scrivere");//AGGIUNTO \n
		}
		input.nextLine();
		
		System.out.println("Tutte le stampe sono andate a buon fine");
		
	}

}
