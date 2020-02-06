package console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Models.Corso;
import Models.Professore;
import Models.Studente;

public class AppStart {

	private static List<Studente> studentList = new ArrayList<Studente>();
	private static List<Professore> professorList = new ArrayList<Professore>();
	private static List<Corso> courseList = new ArrayList<Corso>();
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.println("Ciao");
		do {
			System.out.println("Dimmi cosa vuoi fare: "
					+ "\n1 per inserire uno studente"
					+ "\n2 per inserire un corso"
					+ "\n3 per inserire un professore"
					+ "\n4 per assegnare un professore ad un corso"
					+ "\n5 per iscrivere uno studente ad un corso"
					+ "\n6 per uscire");
			try {
				switch(input.nextInt()) {
				
				case 1:{
					System.out.println("Dimmi il nome dello studente");
					String nomeStudente = input.nextLine();
					System.out.println("Dimmi il cognome dello studente");
					String cognomeStudente = input.nextLine();
					System.out.println("Dimmi la matricola dello studente");
					String matricola = input.nextLine();
					studentList.add(new Studente(nomeStudente, cognomeStudente, matricola));
					break;
				}
				case 2:{
					System.out.println("Dimmi il titolo del corso");
					String titolo = input.nextLine();
					System.out.println("Dimmi il codice del corso");
					String codice = input.nextLine();
					courseList.add(new Corso(titolo, codice));
					break;
				}
				case 3:{
					System.out.println("Dimmi il nome del professore");
					String nomeProfessore = input.nextLine();
					System.out.println("Dimmi il cognome del professore");
					String cognomeProfessore = input.nextLine();
					professorList.add(new Professore(nomeProfessore ,cognomeProfessore));
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
									ricercaProfessore = lookForProf(input.nextLine(), ricercaProfessore);
									if(ricercaProfessore.isEmpty()) {
										System.out.println("la ricerca non ha prodotto risultati");
										continue;
									}else if(ricercaProfessore.size() == 1) {
										//PROFESSORE TROVATO
										System.out.println("A che corso vuoi assegnare "+ricercaProfessore.get(0).getNome()+"?");
										List<Corso> ricercaCorso = courseList;
										do {
											for(Corso c : ricercaCorso) {
												System.out.println(c.getCodice()+ "\t" + c.getTitolo());
											}
											System.out.println("Inserisci la query");
											ricercaCorso = lookForCourse(input.nextLine(), ricercaCorso);
											if(ricercaCorso.isEmpty()) {
												System.out.println("la ricerca non ha prodotto risultati");
												continue;
											}else if(ricercaCorso.size() == 1) {
												//CORSO TROVATO
												professorList.remove(ricercaProfessore.get(0));
												ricercaProfessore.get(0).assegnaCorso(ricercaCorso.get(0));
												professorList.add(ricercaProfessore.get(0));
												correct = true;
												break;
											}else {
												continue;
											}
										}while(true);
										
									}else {
										continue;
									}
								}while(true);
								
							}
							case 1: {
								break;
							}
							}
						}else {
							String data = input.nextLine();
							if(data.matches("[A-Za-z][_][A-Za-z]")) {
								Professore p = new Professore(data.split("_")[0],data.split("_")[1]);
								if(professorList.contains(p)) {
									System.out.println("Inserisci il codice del corso");
									data = input.nextLine();
									List<Corso> cList = lookForCourse(data,courseList);
									if(cList.size()==1) {
										courseList.remove(cList.get(0));
										p.assegnaCorso(cList.get(0));
										courseList.add(cList.get(0));
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
					
					break;
				}
				case 5:{
					break;
				}
				case 6:{
					System.exit(0);
					break;
				}
				}
			}catch(InputMismatchException e) {
				System.out.println("ERR LOG:" + e.getMessage());
				continue;
			}
			break;
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
		
		for(Corso c : list) {
			if(c.getTitolo().concat(c.getCodice()).contains(query)) {
				list2.add(c);
			}
		}
		
		return list2;
	}
}
