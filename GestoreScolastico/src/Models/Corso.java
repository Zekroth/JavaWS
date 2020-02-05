package Models;

import java.util.List;

public class Corso {
	
	private String titolo;
	private String codice;
	protected List<Studente> iscrizioni;
	protected List<Professore> professori;
	
	public Corso(String titolo , String codice) {
		this.titolo = titolo;	
		this.codice = codice;
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

		
	}
	

	

}
