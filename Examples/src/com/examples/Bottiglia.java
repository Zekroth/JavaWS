package com.examples;

public class Bottiglia {
	public Double quantita = 0d;
	public String contenuto = "";
	
	public Double getQuantita() {
		return this.quantita;
	}
	
	public void setQuantita(Double value) {
		this.quantita = value;
	}
	
	public String getContenuto() {
		return this.contenuto;
	}
	
	public void setContenuto(String value) {
		this.contenuto = value;
	}
	
	public Double bevi(Double x) {
		this.quantita -= x;
		if(this.quantita == 0d) {
			this.contenuto = "";
		}
		return this.quantita;
	}
	
	public Double riempi(Double x, String nomeBev) {
		this.quantita += x;
		this.contenuto += nomeBev;
		
		return this.quantita;
	}
}
