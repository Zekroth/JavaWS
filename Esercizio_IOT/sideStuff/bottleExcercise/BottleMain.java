package bottleExcercise;
import java.util.*;

public class BottleMain {
	
	public static void main(String[] args) {
		boolean notOver = true;
		Scanner console = null;
		ArrayList<Bottle> distributore = new ArrayList<Bottle>();
		
		for(int i = 0; i < 3; i++) {
			distributore.add(new Bottle((int) Math.random()*100,"Acqua"));
		}
		for(int i = 0; i < 1; i++) {
			distributore.add(new Bottle((int) Math.random()*100,"CocaCola"));
		}
		for(int i = 0; i < 1; i++) {
			distributore.add(new Bottle((int) Math.random()*100,"Fanta"));
		}
		do {
			
			
			System.out.println("Scegli una bottiglia");
			
			for(int i = 0; i< distributore.size(); i++) {
				System.out.println(i + ") "+distributore.get(i).contenuto +": "+distributore.get(i).quantita);
			}
			
			console = new Scanner(System.in);
			
			int choice = console.nextInt();
			console.nextLine();
			System.out.println(choice + ") "+distributore.get(choice).contenuto +": "+distributore.get(choice).quantita);
			
			System.out.println("Cosa vuoi fare ora?\n\t1)aggiungi quantità\n\t2)sottrai quantità\n\t3)Inserisci un altro liquido (solo se contenitore vuoto)");
		
			switch(choice = console.nextInt()) {
				case 1:
					console.nextLine();
					System.out.println("quanto vuoi aggiungere?");
					distributore.set(choice, distributore.get(choice).Metti(console.nextInt()));
					console.nextLine();
					break;
				case 2:
					console.nextLine();
					System.out.println("quanto vuoi togliere?");
					distributore.set(choice, distributore.get(choice).Togli(console.nextInt()));
					console.nextLine();
					break;
				case 3:
					console.nextLine();
					System.out.println("Cosa vuoi aggiungere?");
					String nomeBevanda = console.nextLine();
					
					System.out.println("quanto vuoi aggiungere?");
					int q = console.nextInt();
					console.nextLine();
					try {
						distributore.set(choice, distributore.get(choice).Metti(console.nextInt(),nomeBevanda));
						console.nextLine();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					console.nextLine();
					System.out.println("Exiting");
					notOver = !notOver;
					break;
			}
		}while(notOver);
		console.close();
	}
	
}
