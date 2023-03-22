package pkg_main;

import java.util.Scanner;

import pkgPerson.Student;
import pkgPerson.StudentManager;
import pkg_book.BookManager;
import pkg_exception.StudentNotFoundException;
import transaction.BookTransactionManager;

public class Main {

	public static void main(String[] args) throws StudentNotFoundException {
		int choice;
		
		Scanner sc= new Scanner(System.in);
		
		BookManager bm = new BookManager();
		StudentManager sm = new StudentManager();
		BookTransactionManager btm = new BookTransactionManager();
		
		do {
			System.out.println("Enter 1 if Student\nEnter 2 if Libraeian\nEnter 3 You want to Exit");
			choice = sc.nextInt();
			
			if (choice == 1)  //if user is student
			{
				System.out.println("Enter your Roll Number");
				int rollNo = sc.nextInt();
				try {
					Student s = sm.get(rollNo);
					if ( s==null)
						throw new StudentNotFoundException();
	                    int stud_choice;
	                    do {
	                    	System.out.println("Enter 1 to View AllBooks\nEnter 2 to Search Book by ISBN\nEnter 3 to List Books by Subject\nEnter 4 to Issue a Book\nEnter 5 to Return a Book\nEnter 99 to Exit");
	                    	stud_choice = sc.nextInt();
	                    	switch(stud_choice) {
	                    	case 1:
	                    	   System.out.println("view all Selected");
	                    	case 2:
		                    	   System.out.println("Search by ISBN Selected");
	                    	case 3:
		                    	   System.out.println("Search by Subject");
	                    	case 4:
		                    	   System.out.println("Issual of Book");
	                    	case 5:
		                    	   System.out.println("Return of Book");
	                    	case 99:
		                    	   System.out.println("Thank you for using Library");
		                    	   break;
	                    	default:
		                    	   System.out.println("Invalid Choice");
		                    	
		                    	
		                    	   
	                    	}
	                    }	while(stud_choice != 99);
	                    
				}
				catch( StudentNotFoundException snfe) {
					System.out.println(snfe);
				}
			}
			else if(choice == 2) //user is librarian
			{
				int lib_choice;
				do {
				
				System.out.println("Enter 11 to view all Students\nEnter 12 to print a Student by Roll Number\nEnter 13 to a Register a Student\nEnter 14 to Update a Student\nEnter 15 to Delete a Student ");
				System.out.println("Enter 21 to view all Books\nEnter 22 to print a Book by ISBN\nEnter 23 to Add a Book\nEnter 24 to Update a Book\nEnter 25 to Delete a Book ");
				System.out.println("Enter 31 to view all Transactions");
				System.out.println("Enter 99 to Exit");
				lib_choice = sc.nextInt();
				switch(lib_choice) {
				case 11: // view all all student
					System.out.println("All the Student Records");
					sm.viewAllStudent();
					break;
				case 12: // search a student 
					System.out.println("Enter RollNumber to Fetch Student");
					int get_rollNo = sc.nextInt();
					Student student = sm.get(get_rollNo);
					if (student == null) {
						System.out.println("No Record Matches this RollNumber");
					}
		 
						System.out.println(student);
					break;
				case 13:
					System.out.println("Enter Students Detail to Add");
					String name;
					String emailId;
					String phoneNumber;
					String address;
					String dob;
					int rollNo;
					int std;
					String division;
					
                    sc.nextLine();	
					System.out.println("Name");
					name = sc.nextLine();
					

					System.out.println("EmailId");
					emailId = sc.nextLine();

					System.out.println("Phone Number");
					phoneNumber = sc.nextLine();

					System.out.println("Address");
					address = sc.nextLine();

					System.out.println("Date of Birth");
					dob = sc.nextLine();

					System.out.println("Roll Number as Integer");
					rollNo = sc.nextInt();

					System.out.println("Standard as Integer");
					std = sc.nextInt();
					
					sc.nextLine();

					System.out.println("Division");
					division = sc.nextLine();
					
					 student = new Student(name, emailId,  address,  phoneNumber, 
				          dob, rollNo,std, division);
			         sm.addStudent(student); 
			         System.out.println("Student is Added");
			         break;
			         
				case 14:  //update a student
					System.out.println("Enter The Roll Number to Modify the Records");
					int modify_rollNo;
					modify_rollNo = sc.nextInt();
					student = sm.get(modify_rollNo);
					try {
					if ( student == null)
					   throw new StudentNotFoundException();
						
					   sc.nextLine();	
						System.out.println("Name");
						name = sc.nextLine();
						

						System.out.println("EmailId");
						emailId = sc.nextLine();

						System.out.println("Phone Number");
						phoneNumber = sc.nextLine();

						System.out.println("Address");
						address = sc.nextLine();

						System.out.println("Date of Birth");
						dob = sc.nextLine();

						System.out.println("Standard as Integer");
						std = sc.nextInt();
						
						sc.nextLine();

						System.out.println("Division");
						division = sc.nextLine();
						
						sm.updateStudent(modify_rollNo, name, emailId, address, phoneNumber, dob, division);
						System.out.println("Student record is update");
					}
					catch(StudentNotFoundException snfe) {
						System.out.println(snfe);
					}
						break;
						
				case 15: //to delete a student	
					System.out.println("Enter The Roll Number to Modify the Records");
					int delete_rollNo;
					delete_rollNo = sc.nextInt();
					if (sm.deleteStudent(delete_rollNo))
						System.out.println("Student record is delete");
					else
						System.out.println("No Record with Given Roll Number Exists");
					break;
				case 99:
					System.out.println("Thank you for using Library");
					break;
					default:
						System.out.println("Invalid Choice");
					
				}
			}while(lib_choice !=99);
				
			}
			
		}while(choice !=3);
		sm.writeToFile();
	}

}
