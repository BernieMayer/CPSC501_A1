/*
Bernie Mayer
10124540
T08
User Interface:
-This class where the user starts and will take in the choice of operation
-Displays the menu and will handle the user choice and will allow the user to quit
*/
import java.util.Scanner;
public class UserInterface {
private Manager aManager;
private Scanner in;
	public UserInterface() {
	aManager = new Manager();
	in = new Scanner(System.in);	
	}
	
	public void start() {
	Boolean flag = true;
	String search;
	String input;
	do {
	menu();
	input = in.nextLine();
	
	//If clauses to appropriately respond to user input
	if (input.equals("A")) {
	aManager.add();
	} 
	else if (input.equals("Aa")) {
	aManager.addAlpha();
	}
	else if (input.equals("DE")) {
	Debug.setOn(true);
	System.out.println("Debug Mode is on");
	} else if (input.equals("D")) {
	aManager.display();
	} else if (input.equals("S")) {
		
	System.out.print("Enter the movie you want to search for? ");
	search = in.nextLine();
	if(aManager.search(search) == null) {
	System.out.println("No movie found.");
	
	}else {
	System.out.println(aManager.search(search));
	}
	}
	 else if (input.equals("R")) {
	System.out.print("Enter the movie you want to Remove. ");
	search = in.nextLine();
	aManager.remove(search);
	 }
	 else if (input.equals("DB")) {
	 aManager.displayBackwards();
	 }
	 else if (input.equals("Q"))  {
		System.out.println("The program shall now quit");
		flag = false; 
	 } else {
	 System.out.println("Invalid entry");
	 }
	} while(flag);
	}
	
	/*
	Function that is called to display the menus
	*/
	private void menu() {
	System.out.println("(A)dd a movie to the collection: ");
	System.out.println("Add a movie alphebetically type(Aa): ");
	System.out.println("(D)isplay the collection: ");
	System.out.println("Display the collection backwards: type(DB)");
	System.out.println("(S)earch for a movie: ");
	System.out.println("(R)emove a movie from the list: ");
	System.out.println("(Q)uit the program");
	}
}