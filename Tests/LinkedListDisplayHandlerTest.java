import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListDisplayHandlerTest {

	@Test
	public void testDisplayingLinkedListWithSingleItem()
	{
		Movie expectedMovie1 = new Movie("Movie1", new String[] { "Ironman"}, "horror", 3);
		MovieNode list = new MovieNode(expectedMovie1, null);
		String returnString = LinkedListDisplayHandler.generateLinkedListAsString(list);
		
		//Show that the list is displaying some important components
		assertTrue(returnString.contains("Movie1"));
		assertTrue(returnString.contains("Ironman"));
		assertTrue(returnString.contains("horror"));
		
		int numberOfLines = returnString.split("\n").length;
		
		assertTrue(numberOfLines > 1);
	}
	
	@Test
	public void testDisplayingLinkedListWithSeveralItems()
	{
		Manager m = new Manager();
		Movie expectedMovie1 = new Movie("Movie1", new String[] { "Ironman"}, "horror", 3);
		Movie expectedMovie2 = new Movie("Movie2", new String[] { "Daniel Radcliffe"}, "horror", 4);
		Movie expectedMovie3 = new Movie("Movie3", new String[] { "Emma Watson", "Bob Smith"}, "",  2);
		
		//add the movies to the Manager
		m.addMovie(expectedMovie1);
		m.addMovie(expectedMovie2);
		m.addMovie(expectedMovie3);
		
		
		MovieNode list = m.getHead();
		

		String displayText = LinkedListDisplayHandler.generateLinkedListAsString(list);
		assertTrue(displayText.contains(expectedMovie1.toString()));
		assertTrue(displayText.contains(expectedMovie2.toString()));
		assertTrue(displayText.contains(expectedMovie3.toString()));
	}
	
	@Test
	public void testDisplayingLinkedListBackwards()
	{
		Manager m = new Manager();
		Movie expectedMovie1 = new Movie("Movie1", new String[] { "Ironman"}, "horror", 3);
		Movie expectedMovie2 = new Movie("Movie2", new String[] { "Daniel Radcliffe"}, "horror", 4);
		Movie expectedMovie3 = new Movie("Movie3", new String[] { "Emma Watson", "Bob Smith"}, "",  2);
		
		//add the movies to the Manager
		m.addMovie(expectedMovie1);
		m.addMovie(expectedMovie2);
		m.addMovie(expectedMovie3);
		
		
		MovieNode list = m.getHead();
		
		String displayText = LinkedListDisplayHandler.generateStringOfLinkedListBackwards(list);
		
		//System.out.println(displayText);
		String[] componenetsOfDisplayText = displayText.split("\\*+");
		assertTrue(componenetsOfDisplayText[0].contains(expectedMovie3.toString()));
		assertTrue(componenetsOfDisplayText[1].contains(expectedMovie2.toString()));
		assertTrue(componenetsOfDisplayText[2].contains(expectedMovie1.toString()));
	}
	
	@Test
	public void testDisplayLinkedListBackwardsWithEmptyList()
	{
		Manager m = new Manager();
		
		assertTrue(m.getHead() == null);
		String displayText = LinkedListDisplayHandler.generateStringOfLinkedListBackwards(m.getHead());
		
		
		assertTrue(displayText.contains("Null list, enter a movie(s) to display"));
	}
	
	
	@Test
	public void testDisplayLinkedListWithEmptyList()
	{
		Manager m = new Manager();
		
		assertTrue(m.getHead() == null);
		String displayText = LinkedListDisplayHandler.generateLinkedListAsString(m.getHead());
		
		assertTrue(displayText.contains("List is null"));
	}

}
