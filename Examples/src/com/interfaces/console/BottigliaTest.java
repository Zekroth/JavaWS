package com.interfaces.console;

import com.examples.Bottiglia;

public class BottigliaTest {
	public static void main(String[] args) {
		Bottiglia bottiglia = new Bottiglia();
		bottiglia.riempi(5d,"CocaCola");
		System.out.println("La bottiglia contiene: "+bottiglia.quantita + " di "+ bottiglia.contenuto);
	}
}
