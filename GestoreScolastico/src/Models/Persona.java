package Models;

import java.util.Comparator;

public interface Persona {
	public String getNome();
	public String getCognome();
	public default String getNomeCognome() {
		return this.getNome() + this.getCognome();
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
}
