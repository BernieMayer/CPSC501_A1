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
	}
}
