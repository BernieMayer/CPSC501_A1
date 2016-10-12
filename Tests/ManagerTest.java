import static org.junit.Assert.*;

import org.junit.Test;

public class ManagerTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	
	@Test
	public void testCheckRatings()
	{
		Manager m = new Manager();
		assertEquals(m.checkGenre("horror"), "horror");
		assertEquals(m.checkGenre("drama") , "drama");
		assertEquals(m.checkGenre("comedy"),"comedy");
		assertEquals(m.checkGenre(""), "No Genre");
		assertEquals(m.checkGenre("Other"), "Other");
	}
	
	

	@Test
	public void testAddingMovieToLinkedList()
	{
		Manager m = new Manager();
		Movie movie = new Movie("Movie", new String[] { "Ironman"}, "", 3);
		m.addMovie(movie);
		
		MovieNode list = m.getHead();
		
		Movie actual = list.getData();
		
		assertEquals(actual, movie);
		assertEquals(actual.getName(), movie.getName());
		assertEquals(actual.getCast(), movie.getCast());
		
	}
	
	@Test 
	public void testAddingMultipleMovieToLinkedList()
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
		
		Movie actualMovie1 = list.getData();
		Movie actualMovie2 = list.getNext().getData();
		Movie actualMovie3 = list.getNext().getNext().getData();
		
		assertEquals(actualMovie1, expectedMovie1);
		assertEquals(actualMovie1.getName(), expectedMovie1.getName());
		assertEquals(actualMovie1.getCast(), expectedMovie1.getCast());
		
		
		assertEquals(actualMovie2, expectedMovie2);
		assertEquals(actualMovie2.getName(), expectedMovie2.getName());
		assertEquals(actualMovie2.getCast(), expectedMovie2.getCast());
		
		assertEquals(actualMovie3, expectedMovie3);
		assertEquals(actualMovie3.getName(), expectedMovie3.getName());
		assertEquals(actualMovie3.getCast(), expectedMovie3.getCast());
		
		
		
		}
	}

