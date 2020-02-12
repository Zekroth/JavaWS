package com.examples;

import java.util.InputMismatchException;

public abstract class StrumentoDaScrittura {
	public int qInchiostro;
	public String writableRegex;
	public int consumo;
	
	public StrumentoDaScrittura(int qInchiostro) {
		this.qInchiostro = qInchiostro;
		this.consumo = 1;
	}
	public void draw(String s)throws NotEnoughInkException, InputMismatchException{
		for(char c : s.toCharArray()) {
			if(this.qInchiostro >= this.consumo) { //ERRORE 4 MANCA L'=
				char[] arr = {c};
				String sc = new String(arr);//ERRORE 1 MANCA "String" PRIMA DI sc
				if(sc.matches(this.writableRegex)) {
					System.out.print(c);
				}else if(this.writableRegex.equals("")) {
					System.out.print(c);
				}else {
					throw new InputMismatchException(sc);//c è un char
				}
				this.qInchiostro = this.qInchiostro - this.consumo;
			}else {
				throw new NotEnoughInkException(s);
			}
		}
		System.out.println();//ERRORE 2 E' STATO MESSO ERRONEAMENTE NEL FOR
	}
}
