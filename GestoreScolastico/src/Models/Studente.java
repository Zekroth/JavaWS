package Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Studente implements Persona{
	
	//FIELDS
	private String nome;
	private String cognome;
	private String matricola;
	
	//CONSTRUCTORS
	public Studente(String nome2, String cognome2, String matricola2) {
		this.nome = nome2;
		this.cognome = cognome2;
		this.matricola = matricola2;
	}
	public Studente(String nome2, String cognome2) {
		//TODO
	}
	//GETTERS
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getMatricola() {
		return matricola;
	}
	
	//SETTERS
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected void setCognome(String cognome) {
		this.cognome = cognome;
	}
	protected void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	//METHODS
	public void iscrivi(Corso c) {
		c.iscrizioni.add(this);
	}
	
	public void cancella(Corso c) {
		c.iscrizioni.remove(this);
	}
	public String toString() {
		return "Studente\tnome=\"" + this.nome + "\"\tcognome=\"" + this.cognome + "\"\tmatricola=\"" + this.matricola + "\"";
	}
	
	public static List<Studente> lookForStudente(String query, List<Studente> list) {
		
		List<Studente> list2 = new ArrayList<Studente>();
		for(Studente p : list) {
			if(p.getNomeCognome().contains(query)) {
				list2.add(p);
			}
		}
		return list2;
	}
}
