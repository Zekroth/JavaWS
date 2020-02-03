package stringhe;

import java.util.Scanner;



public class StringStripper {

	public static final String vocali = "[aeiouy]";
	public static final String consonanti = "[bcdfghlmnpqrstvwxz]";
	public static final String def = "the quick brown fox jumps over the lazy dog";
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str  = input.nextLine();
		System.out.println("Vuoi togliere le vocali o le consonanti?");
		String answer = input.nextLine();
		if(answer.isEmpty()) {
			answer = def;
		}
		String[] arr = null;
		if(answer.equalsIgnoreCase("vocali")) {
			arr = str.split(vocali);
		}else if(answer.equalsIgnoreCase("consonanti")){
			arr = str.split(consonanti);
		}
		str = "";
		for (String stringa : arr) {
			str += stringa;
		}
		System.out.println(str);
		
	}

}
