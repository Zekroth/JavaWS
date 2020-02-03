package calcolo_date;

import java.util.Scanner;

public class CalcoloDate {
	
	static class Data{
		public long giorno;
		public long ora;
		public long minuto;
		public long secondo;
		
		public Data(long secondo) {
			this.giorno = giorni(secondo)[0];
			this.ora = ore(giorni(secondo)[1])[0];
			this.minuto = minuti( ore(giorni(secondo)[1])[1])[0];
			this.secondo = minuti(ore(giorni(secondo)[1])[1])[1];
		}
		public long[] giorni(long secondi) {
			return new long[] {secondi/86400, secondi%86400};
		}
		
		public long[] ore(long secondi) {
			return new long[] {secondi/3600, secondi%3600};
		}
		
		public long[] minuti(long secondi) {
			return new long[] {secondi/60, secondi%60};
		}
		
		public String toString() {
			
			return "gg:\t"+ this.giorno + "\nhh:\t" + this.ora + "\nmm:\t" + this.minuto + "\nss:\t" + this.secondo;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		System.out.println(new Data(input.nextLong()));
	}	
}
