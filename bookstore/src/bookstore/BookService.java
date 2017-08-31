package bookstore;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class BookService {

	private static int totalBooks = 0;
	
	private HashMap<Integer,Book> bookList;
	
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
	
	public void listBooks(){
		
		if(bookList.size() > 0){
			
			System.out.println("Printing all available books:");
			
			for(int x = 1; x <= bookList.size(); x++){
				 System.out.println("\t- ID: " + x + "\t" + bookList.get(x).printMe());
			}
		}
		else{	System.out.println("No books to list.");		}
		
	}

	public Book getBook(int ID){return bookList.get(ID);}
	
	public void extractToJSON(String filelocation){
		try {
			JsonFactory factory = new JsonFactory();
			JsonGenerator jGenerator = factory.createGenerator(new File(
					filelocation),
					JsonEncoding.UTF8);
			Book bkHandle = null;
			
			for(int x = 1; x <= bookList.size(); x++){
				// active book
				bkHandle = bookList.get(x);
				
				// Start writing object
				jGenerator.writeStartObject(); // {	
				
				jGenerator.writeStringField("Title", bkHandle.getTitle()); // "name" : "mkyong"
				jGenerator.writeStringField("Author", bkHandle.getAuthor()); // "name" : "mkyong"
				jGenerator.writeNumberField("Cost", bkHandle.getCost()); // "age" : 29
				
				jGenerator.writeEndObject(); // }
			}

			jGenerator.close();
		} catch (IOException e) {
			System.out.println("WARNING: Failed to write to Json!!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	

	public void readTargJSON(String filelocation, int totalentries){

			try {
				JsonFactory factory = new JsonFactory();
				JsonParser jParser = factory.createJsonParser(new File(filelocation));	
				
				// need to adjust this to read until end of file.
				for(int x = 0; x < totalentries; x++){
					while (jParser.nextToken() != JsonToken.END_OBJECT) {
						String fieldname = jParser.getCurrentName();
						if ("Title".equals(fieldname)) {
						  jParser.nextToken();
						  System.out.println(jParser.getText()); // display mkyong
	
						}
						if ("Author".equals(fieldname)) {
							  jParser.nextToken();
							  System.out.println(jParser.getText()); // display mkyong
	
							}
						if ("Cost".equals(fieldname)) {
							  jParser.nextToken();
							  System.out.println(jParser.getFloatValue()); // display mkyong
	
							}
					}
				}
				jParser.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("WARNING: FAILED TO READ JSON!!!");
			}
	}

	
}
