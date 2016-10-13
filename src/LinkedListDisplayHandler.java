
public class LinkedListDisplayHandler {
	
	public static String generateLinkedListAsString(MovieNode headOfLinkedList)
	{
		String displayString = new String();
		int index = 1;
		MovieNode tempNode = headOfLinkedList;
		//System.out.println("Now Displaying the movie Collection"); Lines that println are replace with the String + "\n"
		displayString = displayString + "Now Displaying the movie Collection" + "\n";
		if (tempNode == null) {
			displayString = displayString + "List is null" + "\n";
		}
		while (tempNode != null) {
			displayString = displayString + tempNode + "\n";
			displayString = displayString + "******************************" + "\n";
			tempNode = tempNode.getNext();
		 }	
		return displayString;
	}
	
	
	public static String generateStringOfLinkedListBackwards(MovieNode headOfLinkedList)
	{
		String displayString = new String();
		if (headOfLinkedList == null) {
			displayString = displayString + "Null list, enter a movie(s) to display" + "\n";
		} else if (headOfLinkedList.getNext() == null) {
			displayString = displayString + headOfLinkedList + "\n";//head will be printed last
		}else {
			
			displayString = displayString + generateRecursiveStringOfLinkedList(headOfLinkedList) + "\n";
		}
		return displayString;
		
		
	}
	
	private static String generateRecursiveStringOfLinkedList(MovieNode tempNode)
	{
		String displayString = new String();
		MovieNode nextNode = tempNode.getNext();
		
		//Goes to the end clause
		if (nextNode == null) {
			return tempNode.toString();
		}
		
		//Recursive call
		displayString = displayString + generateRecursiveStringOfLinkedList(nextNode) + "\n";
		displayString = displayString + "******************************" + "\n";
		return displayString + tempNode.toString();
		
		
	}

}
