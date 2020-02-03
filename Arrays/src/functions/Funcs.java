package functions;

import java.util.List;

public class Funcs {
	
	
	private Number somma(List<Number> list) {
		//Number x = new Number(0); primo errore
		
		Number x = 0;
		
		//for(int val: list.toArray()) { secondo errore (distrazione)
		for(Object val: list.toArray()) {
			
			//x += val terzo errore 
			x = x.doubleValue() + ((Number) val).doubleValue();
			
		}
		//Manca il return, lol quarto errore
		return x;
	}
	
	private Number prodotto(List<Number> list) {
		//Number x = new Number(1);
		
		Number x = 1;
		
		//for(int val: list.toArray())
		
		for(Object val: list.toArray()) {
			x = x.doubleValue() * ((Number) val).doubleValue();
		}
		
		return x;
	}
	
	public Number[] valuta (List <Number> list, boolean mode) {
		
		List<Number> pos = null;//liste non inizializzate
		List<Number> neg = null;
		
		for(Object val : list.toArray()) {
			if(((Number)val).doubleValue() >= 0) {//altro errore per lo stesso problema di prima
				pos.add((Number)val); //errore sintattico
				
			}else {
				neg.add((Number)val);
			}
		}
		
		System.out.println("Il prodotto dei positivi è: "+prodotto(pos));
		System.out.println("La somma dei negativi è: "+somma(pos));
		if(mode) {
			return (Number[]) pos.toArray(); //manca il cast
		}else {
			return (Number[]) neg.toArray();
		}
		

	}
}
