package functions;

import java.util.ArrayList;
import java.util.List;

public class Funcs {
	
	
	private Number somma(List<Number> list) {
		//Number x = new Number(0); primo errore
		
		Number x = 0;
		//System.out.println(list.toArray().length);
		//for(int val: list.toArray()) { secondo errore (distrazione)
		for(Object val: list.toArray()) {
			
			//x += val terzo errore 
			//System.out.println(x);
			
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
	
	public Object[] valuta (List <Number> list, boolean mode) {
		
		List<Number> pos = new ArrayList<Number>();//liste non inizializzate
		List<Number> neg = new ArrayList<Number>();
		
		for(Object val : list.toArray()) {
			if(((Number)val).doubleValue() >= 0) {//altro errore per lo stesso problema di prima
				pos.add((Number)val); //errore sintattico
				
			}else {
				neg.add((Number)val);
			}
		}
		if(!pos.isEmpty())
			System.out.println("Il prodotto dei positivi è: "+prodotto(pos));
		if(!neg.isEmpty())
			System.out.println("La somma dei negativi è: "+somma(neg));
		if(mode) {
			return pos.toArray(); //manca il cast
		}else {
			return neg.toArray();
		}
		

	}
}
