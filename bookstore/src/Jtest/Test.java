package Jtest;

import static org.junit.Assert.*;

import bookstore.Book;
import bookstore.BookService;

public class Test {
	
	@org.junit.BeforeClass
	public static void bTest(){}
	
	@org.junit.Before
	public void before(){}
	
	@org.junit.Test
	public void test() {
		BookService library	= new BookService();
		
		library.addBook(new Book("Rats", "author", 2.5f));
		library.addBook(new Book("Adventures of Riverside", "T. R. Rogers", 7.5f));	
		
		Book handle = library.getBook(1);
		assertEquals( "Rats" , handle.getTitle());
	}
	
	@org.junit.After
	public void after(){}
	
	@org.junit.AfterClass
	public static void aTest(){}

}
