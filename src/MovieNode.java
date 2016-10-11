/*
Bernie Mayer
10124540
T08
Movie Node:
Class that is in charge of storing the current node and pointing to the next node
-Stores Movie data, nextNode and is a component of the linked list
*/
public class MovieNode {
	//attributes
private Movie data;
private MovieNode next;
	//Constructor
	public MovieNode(Movie aMovie,MovieNode aNext) {
		data = aMovie;
		next = aNext;
	}
	
	/*
	Function that will change the Movie data
	*/
	public void setData(Movie newData) { data = newData;}
	/*
	returns the movie data
	*/
	public Movie getData() { return data;}
	/*
	returns the next node in the linked list.
	*/
	public MovieNode getNext() {
		return next;
		}
	/*
	Sets the next node in the next list
	*/
	public void setNext(MovieNode aNext) {
		next = aNext;
	}
	
	public String toString() {
	String temp;
	temp = data.toString();
	return temp;
	}
}