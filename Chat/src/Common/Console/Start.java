package Common.Console;

import java.util.Scanner;

public class Start {
	public static boolean isHost = false;
	public static void main(String[] args) {
		System.out.println("Would you like to host the conversation?");
		Scanner scanner = new Scanner(System.in);
		
		String answer= null;
		while(answer == null) {
			answer = scanner.nextLine();
		}
		if(answer.toCharArray()[0] == 'Y'||answer.toCharArray()[0] == 'y') {
			isHost = true;
		}
	}

}
