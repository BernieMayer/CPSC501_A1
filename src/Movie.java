/*
Bernie Mayer
10124540
T08
*/
public class Movie {
	//Attributes
private String name;
private String[] cast;
private String genre;
//private Scanner in;
private int rating;

	/*
	Constructor for movie that sets 
	*/
	public Movie(String aName, String[] aCast, String aGenre, int aRating) {
	name = aName;
	cast = aCast;
	genre = aGenre;
	rating = aRating;
	}
	/*
	get and set methods...
	*/
	public String getName() { return name;}
	public void setName(String aName) { name = aName;}
	
	public String[] getCast() { return cast;}
	public void setCast(String[] aCast) { cast = aCast;}
	
	public String getGenre() { return genre;}
	public void setGenre(String aGenre) { genre = aGenre;}
	

	//Makes a string of the movie object
	public String toString() {
	String temp;
	temp = "Movie name: " + name + "\n" + "Cast \n";
	//int displaynum;
	for (int i=0; i <=(cast.length-1); i++) {
	//displaynum = i+1;
	temp = temp  + (String)cast[i] + "\n";
	}
	temp = temp + "Genre: " + genre + "\n";
	temp = temp + "Rating: " + rating;
	return temp;
	}
}
