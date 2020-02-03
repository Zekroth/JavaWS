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
	static class StringStripper{
		public String str;
		public String vocali = "[aeiouy]";
		public String consonanti = "[bcdfghlmnpqrstvwxz]";
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		//System.out.println(new Data(input.nextLong()));
		
		String str  = input.nextLine();
		System.out.println("Vuoi togliere le vocali o le consonanti?");
		String answer = input.nextLine();
		String[] arr = null;
		if(answer.equalsIgnoreCase("vocali")) {
			arr = str.split((new StringStripper()).vocali);
		}else if(answer.equalsIgnoreCase("consonanti")){
			arr = str.split((new StringStripper()).consonanti);
		}
		str = "";
		for (String stringa : arr) {
			str += stringa;
		}
		System.out.println(str);
	}	
}
