package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Corso{
	
	private String titolo;
	private static String ultimoCodice;
	private String codice;
	protected List<Studente> iscrizioni;
	protected List<Professore> professori;
	
	public Corso(String titolo , String codice) {
		
		this.titolo = titolo;	
		this.codice = codice;
		this.iscrizioni = new ArrayList<Studente>();
		this.professori = new ArrayList<Professore>();
		
	}
	//empty constructor for constructing inner classes
	public Corso() {
		
	}

	public String getTitolo() {
		return titolo;
	}
	
	protected void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getCodice() {
		return codice;
	}
	
	protected void setCodice(String codice) {
		this.codice = codice;
	}
	
	public void stampaIscritti() {

		for(Studente s : iscrizioni) {
			System.out.println(s.getMatricola()+"\t"+s.getNome()+"\t"+s.getCognome());
		}
	}
	
	public void stampaProfessori() {
		for(Studente s : iscrizioni) {
			System.out.println(s.getMatricola()+"\t"+s.getNome()+"\t"+s.getCognome());
		}
	}
	
	public String getStampaIscritti() {
		String stampa = "";
		
		for(Studente s : iscrizioni) {
			stampa += (s + "\n");
		}
		return stampa;
	}
	
	public String getStampaProfessori() {
		String stampa = "";
		
		for(Professore p : professori) {
			stampa += (p + "\n");
		}
		return stampa;
	}
	public String toString() {
		return "Corso :\t\"" + this.codice + "\"\ttitolo= \"" + this.titolo + "\"\t\n" + "---------------------\n" + getStampaIscritti() + "---------------------\n" + getStampaProfessori();
	}
	public boolean sortProfessori() {
		if(this.professori.isEmpty()) {
			return false;
		}
		this.professori.sort(Persona.PersonaComparator);
		return true;
	}
	public boolean sortIscritti() {
		if(this.iscrizioni.isEmpty()) {
			return false;
		}
		this.iscrizioni.sort(Persona.PersonaComparator);
		return true;
	}

	public static class SortByTitolo implements Comparator<Corso>{

		@Override
		public int compare(Corso o1, Corso o2) {
			return o1.titolo.compareTo(o2.titolo);
		}
		
	}
	
	public static class SortByCodice implements Comparator<Corso>{

		@Override
		public int compare(Corso o1, Corso o2) {
			return o1.codice.compareTo(o2.codice);
		}
		public SortByCodice() {
			
		}
		
	}
	
	public static class SortByDimensioneIscrizioni implements Comparator<Corso>{

		@Override
		public int compare(Corso o1, Corso o2) {
			return o2.iscrizioni.size() - o2.iscrizioni.size();
		}
		public int compareDesc(Corso o1, Corso o2) {
			return o1.iscrizioni.size() - o1.iscrizioni.size();
		}
	}
	
	public static class SortByDimensioneProfessori implements Comparator<Corso>{

		@Override
		public int compare(Corso o1, Corso o2) {
			return o2.professori.size() - o2.professori.size();
		}
		public int compareDesc(Corso o1, Corso o2) {
			return o1.professori.size() - o1.professori.size();
		}
		
	}

}
