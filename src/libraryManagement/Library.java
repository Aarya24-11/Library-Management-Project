package libraryManagement;

import java.util.Arrays;

class Library {

	  private Book[] books;

	    public Library() {
	        this.books = new Book[0];
	    }

	    public void addBook(Book book) {
	        books = Arrays.copyOf(books, books.length + 1);
	        books[books.length - 1] = book;
	    }

	    public void removeBook(Book book) {
	        int index = 0;
	        for (int i = 0; i < books.length; i++) {
	            if (books[i].equals(book)) {
	                index = i;
	                break;
	            }
	        }
	        if (index != -1) {
	            for (int i = index; i < books.length - 1; i++) {
	                books[i] = books[i + 1];
	            }
	            books = Arrays.copyOf(books, books.length - 1);
	        }
	    }

	    public Book[] searchBooksByTitle(String title) {
	        Book[] results = new Book[0];
	        for (int i = 0; i < books.length; i++) {
	            if (books[i].getTitle().equals(title)) {
	                results = Arrays.copyOf(results, results.length + 1);
	                results[results.length - 1] = books[i];
	            }
	        }
	        return results;
	    }

	    public Book[] searchBooksByAuthor(String author) {
	        Book[] results = new Book[0];
	        for (int i = 0; i < books.length; i++) {
	            if (books[i].getAuthor().equals(author)) {
	                results = Arrays.copyOf(results, results.length + 1);
	                results[results.length - 1] = books[i];
	            }
	        }
	        return results;
	    }


	    public Book[] showAllOrder() {
	        for (int i = 0; i < books.length; i++) {
	            System.out.println(books[i].getTitle() + " by " + books[i].getAuthor() );


	        }
	        return books;
	    }
}
