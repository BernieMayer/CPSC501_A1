/*
Bernie Mayer
10124540
T08
Driver:
Main starting point.
-Initializes the user interface and prints the opening message.
*/
public class Driver {
	//UserInterface aUserInterface
	public static void main(String[] args) {
	Manager manager = new Manager();
	System.out.println("This program is designed to give users a way to make a list of movies");
	manager.start();
	}
}