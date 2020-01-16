import java.util.*;

public class Main {
	
	public static List<EComponent> ComponentList;
	
	public static void main(String args[]) {
	
		Scanner console; 
		String input = null;
		do {
			
			console = new Scanner(System.in);
			System.out.println("Benvenuto in: \"LAMPADINA\"");
			System.out.println("Cosa vuoi fare?");
			System.out.println("Digita \"quit\" per uscire");
			/* elenco opzioni */
			
			input = console.nextLine();
			
			switch(input) {
				case "add":
					System.out.println("Adding element");
					AddComponent();
					break;
				case "run":
					System.out.println("Starting simulation");
					Run();
					break;
				default:
					System.out.println("Opzione non trovata");
					case "quit":
						System.out.println("Program closing");
						break;
			}
			
		}while(input != "quit");
		
		console.close();
	}
	
	/**
	 *  METHODS
	 */
	
	public static void Run() {
		ComponentList.forEach(component -> component.Update(0.0d));
	}
	
	public static void AddComponent() {
		
	}
	
	public static void PrintComponentList() {
		
	}
}
