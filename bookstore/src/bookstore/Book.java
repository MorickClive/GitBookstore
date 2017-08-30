package bookstore;

public class Book {

	private float cost;
	private String title, author;
	
	public Book(String title, String author, float cost){

		this.title = title;
		this.author = author;
		this.cost = cost;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String printMe(){
		return "Title: " + title + "\tauthor: " + author + "\tprice: " + cost + ".";
	}

}
