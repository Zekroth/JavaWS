package console;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import functions.*;
public class Test {
	private static Funcs funcs = new Funcs();
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		List<Number> list = null;
		do {
			try {
				list.add(input.nextDouble());
				

			}
			catch(InputMismatchException e) {
				if(input.next().equalsIgnoreCase("stop")) {
					System.out.println("Starting the evaluation");
					break;
				}else {
					e.printStackTrace();
				}
			}
			
		}while(true);
		
		do {
			try {
				boolean argument = false;
				
			}
			catch(InputMismatchException e) {
				
			}
		}while(true);
	}

}
