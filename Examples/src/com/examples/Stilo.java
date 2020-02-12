package com.examples;

public class Stilo extends StrumentoDaScrittura {

	public Stilo(int qInchiostro) {
		super(qInchiostro);
		this.writableRegex = "[A-Za-z0-9]";
	}

}
