package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface Persona {
	public String getNome();
	public String getCognome();
	public default String getNomeCognome() {
		return this.getNome() + this.getCognome();
	}
	
	public default List<Persona> lookForPerson(String query, List<? extends Persona> list) {
		List<Persona> list2 = new ArrayList<Persona>();
		for(Persona p : list) {
			if(p.getNomeCognome().contains(query)) {
				list2.add(p);
			}
		}
		return list2;
	}
	public static Comparator<Persona> PersonaComparator = new Comparator<Persona>() {
			
		public int compare(Persona p1, Persona p2) {
			
			String persona1 = p1.getNomeCognome();
			String persona2 = p2.getNomeCognome();
			
			//ascending order
			return persona1.compareTo(persona2);
			
			//descending order
			//return professor1.compareTo(professor2);
		}
	

	};
	public default String defaultToString(String classePersona) {
		return classePersona + ": \tnome=\"" + this.getNome() + "\"\tcognome=\"" + this.getCognome() + "\"";
	}
	public default String defaultToString() {
		return "Persona: \tnome=\"" + this.getNome() + "\"\tcognome=\"" + this.getCognome() + "\"";
	}
}
