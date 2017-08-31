package bookstore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		BookService library	= new BookService();
		
		library.addBook(new Book("Rats", "author", 2.5f));
		library.addBook(new Book("Adventures of Riverside", "T. R. Rogers", 7.5f));	
		library.addBook(new Book("", "", 0f));
		
		Book bk = library.getBook(3);
		
		bk.setTitle("Galaxy away");
		bk.setAuthor("Jeremy Maxwell");
		bk.setCost(12.5f);
		
		library.listBooks();
		library.extractToJSON("C:\\JSONWRITE\\book.json");
		library.readTargJSON("C:\\JSONWRITE\\book.json", 3);
		
		
		library.removeBook(0);
	}

}
