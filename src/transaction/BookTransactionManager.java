package transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class BookTransactionManager {
	 ObjectOutputStream oos_book_transaction = null;
	 ObjectInputStream ois_book_transaction  = null;
	 
	 File book_transaction_file = null;
	 
	 ArrayList<BookTransaction> book_transaction_list = null;
	 
	 public BookTransactionManager() {
		 book_transaction_file =new File(" book_transaction.dat");
		 book_transaction_list = new ArrayList<BookTransaction>();
		 
		 if (  book_transaction_file.exists()) {
			 try {
				ois_book_transaction = new ObjectInputStream(new FileInputStream( book_transaction_file));
				 book_transaction_list = (ArrayList<BookTransaction>) ois_book_transaction.readObject();
			 } catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		 }
	 }
public boolean issueBook(int rollNo, int isbn) {
	int total_books_issued = 0;
	
	for(BookTransaction book_transaction:book_transaction_list)
	{
		if((book_transaction.getRollNo() == rollNo) && (book_transaction.getReturnDate() == null));
	       total_books_issued +=1;
	    if (total_books_issued >=3)
	    	return false;
	}
	String issue_date = new SimpleDateFormat("dd-mm-yyyy").format(new Date(isbn));
	BookTransaction book_transaction = new 	BookTransaction(isbn,rollNo,issue_date,null);
	book_transaction_list.add(book_transaction);
	
	return false;
}

public boolean returnBook(int rollNo, int isbn) {
	for(BookTransaction book_transaction:book_transaction_list) {
		if ((book_transaction.getRollNo() == rollNo) && (book_transaction.getIsbn() == isbn)&&(book_transaction.getReturnDate() == null)) {
		String return_date = new SimpleDateFormat("dd-mm-yyyy").format(new Date(isbn));
		 book_transaction.setReturnDate(return_date);
		 return true;
	}
		
}
return false;

}

public void showAll() {
	for (BookTransaction book_transaction:book_transaction_list)
         System.out.println(book_transaction);

}		
}