package Models;

import java.util.Comparator;

public class Professore implements Persona{
private String nome;
private String cognome;

	public Professore(String nome, String cognome) {
		setNome(nome);
		setCognome(cognome);
	}

	public String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}

	protected void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void assegnaCorso(Corso c) { //assegna il corso al professore
		c.professori.add(this);	//aggiunge il "valore" attuale del professore al corso 
	}

	
}
