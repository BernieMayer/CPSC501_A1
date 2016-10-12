import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MovieTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	
	@Test 
	public void testMovieToString() {
		Movie aMovie = new Movie("test", new String[]{"1", "2", "3"}, "horror", 3);
		System.out.print(aMovie);
		
		String expected = new String("Movie name: test\nCast \n1\n2\n3\nGenre: horror\nRating: 3");
		//String expected = new String("Movie name: test\nCast\n1\n2\n3\nGenre: horror\nRating: 3");
		Assert.assertTrue(aMovie.toString().equals(expected));
	}
}
