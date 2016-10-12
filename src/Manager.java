/*
Bernie Mayer
10124540
T08

Manager Class:
-The purpose of this class is to handle the operations of the list\
-Can add to the end, add alphebitically, display forward, display backward, search for a item and display it
remove a selected item and check genre/rating for validity
*/
import java.util.Scanner;
public class Manager {
private MovieNode head;
private Scanner in;
private final int MATCH = 0;
/*
	Constructor for the Manager
	*/
	public Manager() {
	in = new Scanner(System.in);
	head = null;
	}
	
	
	/*
	Function that is called to display the main  menu
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
	
	public void start() {
	Boolean flag = true;
	String search;
	String input;
	do {
		menu();
		input = in.nextLine();
	
	//If clauses to appropriately respond to user input
	if (input.equals("A")) {
		add();
	} 
	else if (input.equals("Aa")) {
		addAlpha();
	}
	else if (input.equals("DE")) {
		Debug.setOn(true);
		System.out.println("Debug Mode is on");
	} else if (input.equals("D")) {
		display();
	} else if (input.equals("S")) {
		
		System.out.print("Enter the movie you want to search for? ");
		search = in.nextLine();
	if (search(search) == null) {
		System.out.println("No movie found.");
	
	}else {
		System.out.println(search(search));
	}
	}
	 else if (input.equals("R")) {
		 System.out.print("Enter the movie you want to Remove. ");
	     search = in.nextLine();
		 remove(search);
	 }
	 else if (input.equals("DB")) {
		 displayBackwards();
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
	Add a element to the end of the linked list
	*/
	public Movie makeMovie() {
		//Code to make and check the movie object items
	System.out.print("Enter the name of the movie: ");
	String name = in.nextLine();
	System.out.print("Enter the number of Cast Members: ");
	int index = Integer.parseInt(in.nextLine());
	String[] cast = new String[index];
	
	//Occupies the array with cast members
	for (int i = 0; i<=(index-1); i++) {
	System.out.print("Enter a Cast member: ");
	cast[i] = in.nextLine();
	}
	
	System.out.print("Enter the Genre(or just enter to add no genre): ");
	String genre = in.nextLine();
	genre = checkGenre(genre);
	
	System.out.print("Enter the rating(Must be between 1 and 5, negative and 0 will rate it as zero): ");
	int rating = Integer.parseInt(in.nextLine());
	rating = checkRating(rating);
	
	Movie newMovie = new Movie(name,cast,genre,rating); //Makes movie object
	return newMovie;
		}
		/*
		This function will add a node to the end of the linked list.
		it also makes the node object.
		*/
	public void add() {
		//Uses makeMovie() function to make the movie
	Movie newMovie = makeMovie();
	MovieNode newNode = new MovieNode(newMovie,null);//Makes the node
	
	//Case one: This case is used when the item added is the first item
	if (head == null) {
		head = newNode;
	} else {
		//Makes the new node be put at the end of the list
		MovieNode current = head;
		MovieNode previous = null;
		while (current != null) {
			//Goes through the list till it finds the end
			previous = current;
			current = current.getNext();	
		}
		previous.setNext(newNode);//places node at the end
	}
	}

	/*
	Function is designed to display the linked list in order
	*/
	public void display() {
		
	int index = 1;
	MovieNode tempNode = head;
	System.out.println("Now Displaying the movie Collection");
	//System.out.println(head);
	if (tempNode == null) {
	System.out.println("List is null");
	//temp = temp.getNext();
	//count +=1;
	}
	while (tempNode != null) {
	System.out.println(tempNode);
	System.out.println("******************************");
	tempNode = tempNode.getNext();
	index +=1;
	if (index == 4) {
	String trash = in.nextLine();
	index = 1;
		}
	}
	}
	/*
	Function used to search the linked list for the desired item. Also will inform the user if such item does not
	exist.
	*/
	public MovieNode search(String search) {
		//Declarations
	MovieNode tempNode = head;
	Boolean flag = true;
	
	//Checks if the list is null
	if (tempNode == null) {
		System.out.println("List is null");
	}
	
	
	//Looks through the list
	while (tempNode != null && flag) {
	Movie tempData = tempNode.getData();
	if (search.compareToIgnoreCase(tempData.getName()) == MATCH) {
	return tempNode;
	} else {
	tempNode = tempNode.getNext();
	}
	
	}
	//System.out.println("Search item was not found");
	return null;
	}
	//Functions that will check the rating
	public int checkRating(int rating) {
		boolean flag = true;
		do {
			//Illegal rating clause
		if (rating > 5) {
		 System.out.println("Invalid number must be between 1 to 5");	
		 
		 //Valid Rating clause
		} else if (rating>= 1 && rating <= 5) {
			flag = false;
			return rating;	
			
			
			//No rating clause
		} else if (rating <= 0) {
			System.out.println("No rating option selected");		
			flag = false;
		return 0;
		}
	} while(flag);
	return rating;
	}
	
	public void remove(String search) {
	MovieNode current = head;
	Movie data = current.getData(); //gets the data
	MovieNode previous = null;

	MovieNode searchNode = search(search);//uses search to find the removing node]
	
	//clause that will remove the item if it is the first item
	if (search.compareToIgnoreCase(data.getName()) == MATCH) {
	head = head.getNext();
	} else if (searchNode == null) {
	System.out.println("Item does not exist in the list");
	}
	while(current != null) {
	previous = current;
	current = current.getNext();
	
	//if the object that is in current is the same as searchNode then current will be removed
	if (current == searchNode) {
	previous.setNext(current.getNext());
	System.out.println(search + " was found and was removed");
	current =null;
	}
	}
	}
	
	
	/* 
	Method is used to add elements into the list alphabetically
	*/
	public void addAlpha() {
		
		//Makes the data
	Movie newMovie = makeMovie();
	MovieNode newNode = new MovieNode(newMovie,null);
	
	
	Boolean flag = true;
	
	//Case for list is empty
	if (head == null) {
	head = newNode;
	}
	else {
		//Declarations
	MovieNode currentNode = head;
	MovieNode previousNode = null;
	String newName = newNode.getData().getName();
	String existName= head.getData().getName();
	int count = 1;
	
	
	while(currentNode != null && flag) {
		
		
		//case that the new movieNode added needs to be inserted as the head
		if (existName.compareToIgnoreCase(newName) >= 0 && count== 1) {
		MovieNode tempHead = head;
		head = newNode;
		head.setNext(tempHead);
		flag = false;
		} 
		
		//case that the new movieNode added needs to be placed between two nodes
		else if (existName.compareToIgnoreCase(newName) >= 0) {
		previousNode.setNext(newNode);
		newNode.setNext(currentNode);
		flag = false;
		}
		

	previousNode = currentNode;
	currentNode = currentNode.getNext();
	
	//Code to prevent null pointer exceptions
	if (currentNode != null) {
	existName = currentNode.getData().getName();
	}
	count += 1;
	}
	//Sets the new node to end of the list
	if (flag) {
	previousNode.setNext(newNode);
	}
	}

	}
	
	
	/*
	Function that will check if the rating is valid or skip
	*/

	
	public String checkGenre(String genre) {
	Boolean flag = true;
	do {
		
	/*
	Compare the genre to the genres allowed.
	Allowed genres: action, drama, science fiction, comedy, horror, martial arts or 'other
	*/
		
	if (genre.compareToIgnoreCase("") == MATCH) {
			return "No Genre";
	}
	
	if (!validGenre(genre) ) {
	System.out.print("Invalid entry for genre, Enter a new value.");
	genre = in.nextLine();
	}
	} while(flag);
	return genre;
	}
	
	private boolean validGenre(String genre)
	{
		if (genre.compareToIgnoreCase("action") == MATCH) {
			return true;
			} else if (genre.compareToIgnoreCase("drama") == MATCH) {
			return true;
			} else if (genre.compareToIgnoreCase("science fiction") == MATCH) {
			return true;
			} else if (genre.compareToIgnoreCase("comedy") == MATCH) {
			return true;
			} else if (genre.compareToIgnoreCase("horror") == MATCH){
			return true;
			} else if (genre.compareToIgnoreCase("martial arts")==MATCH || genre.compareToIgnoreCase("Other")==MATCH) {
				return true;	
			}
		else {
			return false;
		}
	}
	
	
	
	/*
	Displays the linked list backwards by calling a function
	*/
	
	public void displayBackwards() {
	if (head.getNext() == null) {
	System.out.println("Null list, enter a movie(s) to display");
	} else if (head.getNext() == null) {
	System.out.println(head);//head will be printed last
	}else {
	displayBackWards(head);
	System.out.println(head);
	}
	}
	/*
	Uses recursion to display the list back wards
	*/
	private MovieNode displayBackWards(MovieNode tempNode) {
		
		MovieNode nextNode = tempNode.getNext();
		//Goes to the end clause
		if (nextNode == null) {
			return tempNode;
		}
		//Recursive call
		System.out.println(displayBackWards(nextNode));
		System.out.println("******************************");
		return tempNode; //Returns the current memory space tempNode
	}


}