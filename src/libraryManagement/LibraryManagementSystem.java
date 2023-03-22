package libraryManagement;

import java.util.Scanner;

public class LibraryManagementSystem  {

	
	
		  public static void main(String[] args) {

		        Library library = new Library();

		        Scanner scanner = new Scanner(System.in);
		        int choice = 0;

		        do {
		            System.out.println("Library Management System");
		            System.out.println("-------------------------");
		            System.out.println("1. Add book");
		            System.out.println("2. Remove book");
		            System.out.println("3. Search books by title");
		            System.out.println("4. Search books by author");
		            System.out.println("5. Display all books");
		            System.out.println("0. Exit");
		            System.out.print("Enter your choice: ");

		            try {
		                choice = scanner.nextInt();
		                scanner.nextLine(); // consume the newline character
		            } catch (Exception e) {
		                scanner.nextLine(); // consume the newline character
		                System.out.println("Invalid input! Please enter a number.");
		                continue;
		            }

		            switch (choice) {

		                case 1:
		                    System.out.print("Enter book title: ");
		                    String title = scanner.nextLine();
		                    System.out.print("Enter book author: ");
		                    String author = scanner.nextLine();

		                    Book book = new Book(title, author);
		                    library.addBook(book);
		                    System.out.println("Book added successfully.");
		                    break;
		                case 2:
		                    System.out.print("Enter book title: ");
		                    String title1 = scanner.nextLine();
		                    System.out.print("Enter book author: ");
		                    String author1 = scanner.nextLine();

		                    Book book1 = new Book(title1, author1);
		                    library.removeBook(book1);
		                    System.out.println("Book removed successfully.");
		                    break;
		                case 3:
		                    System.out.print("Enter book title to search: ");
		                    String searchTitle = scanner.nextLine();
		                    Book[] titleResults = library.searchBooksByTitle(searchTitle);
		                    if (titleResults.length == 0) {
		                        System.out.println("No books found with title \"" + searchTitle + "\"");
		                    } else {
		                        System.out.println("Books with title \"" + searchTitle + "\":");
		                        for (int i = 0; i < titleResults.length; i++) {
		                            System.out.println(titleResults[i].getTitle() + " by " + titleResults[i].getAuthor() );
		                        }
		                    }
		                    break;
		                case 4:
		                    System.out.print("Enter book author to search: ");
		                    String searchAuthor = scanner.nextLine();
		                    Book[] authorResults = library.searchBooksByAuthor(searchAuthor);
		                    if (authorResults.length == 0) {
		                        System.out.println("No books found by author \"" + searchAuthor + "\"");
		                    } else {
		                        System.out.println("Books by author \"" + searchAuthor + "\":");
		                        for (int i = 0; i < authorResults.length; i++) {
		                            System.out.println(authorResults[i].getTitle() + " by " + authorResults[i].getAuthor() );
		                        }
		                    }
		                    break;

		                case 5:
		                    Book[] books = library.showAllOrder();
		                    if (books.length == 0) {
		                        System.out.println("No books found in the library.");
		                    } else {
		                        System.out.println("List of books in the library:");
		                        for (int i = 0; i < books.length; i++) {
		                            System.out.println((i+1) + ". " + books[i].getTitle() + " by " + books[i].getAuthor() );
		                        }
		                    }
		                    break;


		                case 0:
		                    System.out.println("Exiting the program..."+"\nThank you for using Library Management System.");
		                    break;
		                default:
		                    System.out.println("Invalid choice! Please enter a valid choice.");
		                    break;
		            }

		            System.out.println(); // print a blank line for spacing

		        } while (choice != 0);

		        scanner.close();
		    }
		
	}


