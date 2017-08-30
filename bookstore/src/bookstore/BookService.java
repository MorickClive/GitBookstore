package bookstore;

import java.util.HashMap;

public class BookService {

	private static int totalBooks = 0;
	
	HashMap<Integer,Book> bookList;
	
	public BookService(){
		bookList = new HashMap<>();
		System.out.println("Book service created!!!");
	}
	
	public void addBook(Book bk){
		totalBooks++;
		
		bookList.put(totalBooks, bk);
		
		System.out.println("You have added: " + bk.getTitle());
	}
	
	public void removeBook(int ID){
		if(ID == 0){ID = 1;} // we start at 1, but support programmers.
		Book handle = bookList.get(ID);
		
		if( handle != null){	
			// remove book and inform.
			bookList.remove(ID);
			System.out.println("You have removed book: " + handle.getTitle());
		}
		else{
			System.out.println("Cannot find book under ID: " + ID + ", unable to delete.");
			
		}

	}
}
