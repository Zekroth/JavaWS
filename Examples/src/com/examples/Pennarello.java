package com.examples;

public class Pennarello extends StrumentoDaScrittura {

	public Pennarello(int qInchiostro) {
		super(qInchiostro);//ERRORE 3 dir� solo un politico ok boomer
		this.qInchiostro = qInchiostro;
		this.consumo = 2;
		this.writableRegex = "";
	}

}
