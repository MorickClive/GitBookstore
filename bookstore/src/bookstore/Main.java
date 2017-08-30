package bookstore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		BookService library	= new BookService();
		
		library.addBook(new Book("Rats", "author", 2.5f));
		library.addBook(new Book("Adventures of Riverside", "T. R. Rogers", 7.5f));	
		
		library.listBooks();
		
		
		library.removeBook(0);
	}

}
