package console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import models.Corso;
import models.Professore;
import models.Studente;

public class AppStart {

	private static List<Studente> studentList = new ArrayList<Studente>();
	private static List<Professore> professorList = new ArrayList<Professore>();
	private static List<Corso> courseList = new ArrayList<Corso>();
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.println("Ciao");
		do {
			System.out.println("\nDimmi cosa vuoi fare: "
					+ "\n1 per inserire uno studente"
					+ "\n2 per inserire un corso"
					+ "\n3 per inserire un professore"
					+ "\n4 per assegnare un professore ad un corso"
					+ "\n5 per iscrivere uno studente ad un corso"
					+ "\n6 per uscire"
					+ "\n7 per stampare la lista degli studenti"
					+ "\n8 per stampare la lista dei corsi"
					+ "\n9 per stampare la lista dei professori"
					+ "\n");
			try {
				switch(input.nextInt()) {
				
				case 1:{
					System.out.println("Dimmi il nome dello studente");
					String nomeStudente = input.next();
					System.out.println(nomeStudente);
					input.nextLine();
					System.out.println("Dimmi il cognome dello studente");
					String cognomeStudente = input.next();
					input.nextLine();
					System.out.println("Dimmi la matricola dello studente");
					String matricola = input.next();
					input.nextLine();
					studentList.add(new Studente(nomeStudente, cognomeStudente, matricola));
					studentList.sort(Studente.PersonaComparator);
					System.out.println("Ho aggiunto "+ nomeStudente);
					continue;
				}
				case 2:{
					input.nextLine();
					System.out.println("Dimmi il titolo del corso");
					String titolo = input.nextLine();
					System.out.println("Dimmi il codice del corso");
					String codice = input.next();
					input.nextLine();
					courseList.add(new Corso(titolo, codice));
					courseList.sort(new Corso.SortByCodice());
					break;
				}
				case 3:{
					input.nextLine();
					System.out.println("Dimmi il nome del professore");
					String nomeProfessore = input.nextLine();
					System.out.println("Dimmi il cognome del professore");
					String cognomeProfessore = input.next();
					professorList.add(new Professore(nomeProfessore ,cognomeProfessore));
					professorList.sort(Professore.PersonaComparator);
					break;
				}
				case 4:{
					System.out.println("Seleziona un professore in formato {nome}_{cognome} oppure inserisci "
							+ "\n 0\tper cercare un professore"
							+ "\n 1\tper uscire");
					boolean correct = false;
					List<Professore> ricercaProfessore = professorList;
					do {
						
						if(input.hasNextInt()) {
							
							switch (input.nextInt()) {
							case 0: {
								do {
									for(Professore p : ricercaProfessore) {
										System.out.println(p.getNome()+ "\t" + p.getCognome());
									}
									System.out.println("Inserisci la query");
									String query = input.next();
									input.nextLine();
									ricercaProfessore = lookForProf(query, ricercaProfessore);
									System.out.println(query);
									if(ricercaProfessore.isEmpty()) {
										System.out.println("la ricerca non ha prodotto risultati");
										ricercaProfessore = professorList;
										continue;
									}else if(ricercaProfessore.size() == 1) {
										//PROFESSORE TROVATO
										System.out.println("------Professore trovato-------");
										System.out.println("A che corso vuoi assegnare "+ricercaProfessore.get(0).getNome()+"?");
										List<Corso> ricercaCorso = courseList;
										do {
											
											
											if(ricercaCorso.isEmpty()) {
												System.out.println("la ricerca non ha prodotto risultati");
												continue;
											}else if(ricercaCorso.size() == 1) {
												//CORSO TROVATO
												System.out.println("--------Corso trovato--------");
												if(ricercaCorso.get(0).isProfInList(ricercaProfessore.get(0))) {
													System.out.println("Il professore è già nel corso");
												}else {
													professorList.remove(ricercaProfessore.get(0));
													ricercaProfessore.get(0).assegnaCorso(ricercaCorso.get(0));
													professorList.add(ricercaProfessore.get(0));
												}
												correct = true;
												break;
											}else {
												for(Corso c : ricercaCorso) {
													System.out.println("Corso:" + c.getCodice()+ "\t" + c.getTitolo());
												}
												System.out.println("Inserisci la query");
												ricercaCorso = lookForCourse(input.next(), ricercaCorso);
												continue;
											}
										}while(true);
										break;
									}else {
										System.out.println("Sono stati trovati risultati multipli");
										continue;
									}
								}while(!correct);
								break;
							}
							case 1: {
								break;
							}
							}
						}else {
							String data = input.nextLine();
							input.next();
							if(data.matches("[A-Za-z][_][A-Za-z]")) {
								Professore p = new Professore(data.split("_")[0],data.split("_")[1]);
								if(professorList.contains(p)) {
									System.out.println("Inserisci il codice del corso");
									data = input.nextLine();
									input.next();
									List<Corso> cList = lookForCourse(data,courseList);
									if(cList.size()==1) {
										courseList.remove(cList.get(0));
										p.assegnaCorso(cList.get(0));
										courseList.add(cList.get(0));
										courseList.sort(new Corso.SortByCodice());
										correct = true;
										
									}else {
										throw new InputMismatchException("Il nome del corso inserito non è presente nel programma");
									}
								}
							}else {
								throw new InputMismatchException("Il nome del professore inserito non è presente nel programma");
							}
							
							
						}
					}while(!correct);
					continue;
				}
				case 5:{
					
					System.out.println("Seleziona uno studente in formato {nome}_{cognome} oppure inserisci "
							+ "\n 0\tper cercare uno studente"
							+ "\n 1\tper uscire");
					boolean correct = false;
					List<Studente> ricercaStudente = studentList;
					do {
						
						if(input.hasNextInt()) {
							
							switch (input.nextInt()) {
							case 0: {
								do {
									for(Studente s : ricercaStudente) {
										System.out.println(s.getNome()+ "\t" + s.getCognome());
									}
									System.out.println("Inserisci la query");
									String query = input.next();
									input.nextLine();
									ricercaStudente = Studente.lookForStudente(query, ricercaStudente);
									System.out.println(query);
									
									if(ricercaStudente.isEmpty()) {
										System.out.println("la ricerca non ha prodotto risultati");
										ricercaStudente = studentList;
										continue;
									}else if(ricercaStudente.size() == 1) {
										//STUDENTE TROVATO
										System.out.println("------Studente trovato-------");
										System.out.println("A che corso vuoi assegnare "+ricercaStudente.get(0).getNome()+"?");
										List<Corso> ricercaCorso = courseList;
										do {
											
											
											if(ricercaCorso.isEmpty()) {
												System.out.println("la ricerca non ha prodotto risultati");
												continue;
											}else if(ricercaCorso.size() == 1) {
												//CORSO TROVATO
												System.out.println("--------Corso trovato--------");
												if(ricercaCorso.get(0).isStudInList(ricercaStudente.get(0))) {
													System.out.println("Lo studente è già nel corso");
												}else {
													studentList.remove(ricercaStudente.get(0));
													ricercaStudente.get(0).iscrivi(ricercaCorso.get(0));
													studentList.add(ricercaStudente.get(0));
												}
												correct = true;
												break;
											}else {
												for(Corso c : ricercaCorso) {
													System.out.println("Corso:" + c.getCodice()+ "\t" + c.getTitolo());
												}
												System.out.println("Inserisci la query");
												ricercaCorso = lookForCourse(input.next(), ricercaCorso);
												continue;
											}
										}while(true);
										break;
									}else {
										System.out.println("Sono stati trovati risultati multipli");
										continue;
									}
								}while(!correct);
								break;
							}
							case 1: {
								break;
							}
							}
						}else {
							String data = input.next();
							input.nextLine();
							System.out.println("Banane");
							if(data.split("_").length == 2) {
								Studente s = new Studente(data.split("_")[0],data.split("_")[1]);
								List<Studente> ricercaStud = Studente.lookForStudente(s, studentList);
								if(ricercaStud.size() == 1) {
									System.out.println("Inserisci il codice del corso");
									data = input.next();
									input.nextLine();
									List<Corso> cList = lookForCourse(data,courseList);
									if(cList.size()==1) {
										courseList.remove(cList.get(0));
										ricercaStud.get(0).iscrivi(cList.get(0));
										courseList.add(cList.get(0));
										courseList.sort(new Corso.SortByCodice());
										correct = true;
										
									}else {
										throw new InputMismatchException("Il nome del corso inserito non è presente nel programma");
									}
								}
							}else {
								throw new InputMismatchException("Il formato della stringa non è corretto");
							}
							
							
						}
					}while(!correct);
					continue;
				}
				
				case 6:{
					System.exit(0);
				}
				case 7:{
					System.out.println("Stampo la lista degli studenti");
					for(Studente s: studentList) 
						System.out.println(s);
					System.out.println("\n\n");
					continue;
				}
				case 8:{
					System.out.println("Stampo la lista dei corsi");
					for(Corso c: courseList) 
						System.out.println(c);
					System.out.println("\n\n");
					continue;
				}
				case 9:{
					System.out.println("Stampo la lista dei professori");
					for(Professore p: professorList) 
						System.out.println(p);
					System.out.println("\n\n");
					continue;
				}
				}
			}catch(InputMismatchException e) {
				System.out.println("ERR LOG:" + e.getMessage());
				continue;
			}
			
		}while(true);

	}
	private static List<Professore> lookForProf(String query, List<Professore> list) {
		List<Professore> list2 = new ArrayList<Professore>();
		for(Professore p : list) {
			if(p.getNome().concat(p.getCognome()).contains(query)) {
				list2.add(p);
			}
		}
		return list2;
	}
	private static List<Corso> lookForCourse(String query, List<Corso> list){
		
		List<Corso> list2 = new ArrayList<Corso>();
		System.out.println("QUERY:\t" + query);
		for(Corso c : list) {
			if(c.getTitolo().concat(c.getCodice()).contains(query)) {
				list2.add(c);
			}
		}
		
		return list2;
	}
}
