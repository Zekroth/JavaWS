package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Corso implements Comparable<Corso>{
	
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
	
	public void getStampaIscritti() {
		String stampa = "";
		
		for(Studente s : iscrizioni) {
			stampa += (s + "\n");
		}
	}
	
	public void getStampaProfessori() {
		
	}
	public String toString() {
		return "Corso :\t" + this.codice + "\ttitolo= \"" + this.titolo + "\"\t";
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

	@Override
	public int compareTo(Corso o) {
		return this.codice.compareTo(o.codice);
	}
	

}
