package com.examples;

public class Employee {
	public String nome;
	public String cognome;
	public int anni;
	public String sesso;
	public int stipendio;
	public String matricola;
	public int gglavorati;
	
	private String errors = "";
	private boolean isValid = true;
	
	/**
	 * @param nome
	 * @param cognome
	 * @param anni
	 * @param sesso
	 * @param stipendio
	 * @param matricola
	 * @param gglavorati 
	 * @throws Exception 
	 */
	public Employee(String nome, String cognome, int anni, String sesso, int stipendio, String matricola, int gglavorati) throws Exception {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.anni = anni;
		this.sesso = sesso;
		this.stipendio = stipendio;
		this.matricola = matricola;
		this.gglavorati = gglavorati;
		
		if(!Validate()) {
			throw new Exception(errors);
		}
		
	}
	public boolean Validate() {
		if(anni > 100) {
			errors += "L'età non può essere superiore a 100 anni;";
		}
		if(anni < 18) {
			errors += "L'età non può essere inferiore a 18 anni;";
		}
		//Aggiungere controlli vari
		if(errors != "") {
			isValid = false;
		}
		return isValid;
	}
	
	
}
