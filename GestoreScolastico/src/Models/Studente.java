package Models;

import java.util.ArrayList;
import java.util.List;

public class Studente {
	
	//FIELDS
	private String nome;
	private String cognome;
	private String matricola;
	
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
}
