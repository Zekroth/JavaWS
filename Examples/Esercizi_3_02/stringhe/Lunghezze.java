package stringhe;

import java.util.ArrayList;
import java.util.Scanner;

public class Lunghezze {
	
	public static void main(String[] args) {
		
		int len = 0;
		
		Scanner input = new Scanner(System.in);
		int diff = 0;
		String data = "";
		do {
			data = input.nextLine().strip();
			diff = data.length();
			if(!data.isEmpty()&&data.substring(0,1).matches("[A-Z]"))
				len += diff;
		}while(!data.isEmpty());
		
		System.out.println(len);

	}

}
