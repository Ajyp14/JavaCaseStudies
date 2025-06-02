package bookManagement2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	static int b_count=0;
	static int s_count=0;
	
	List<Book> books=new ArrayList<Book>();
	List<Student> students=new ArrayList<Student>();
	
	Scanner sc = new Scanner(System.in);
	
	public void openLiabrary()
	{
		while(true) 
		{
			System.out.print("\n1.Add Book \n2.Remove book\n3.Search Book\n4.Shwo Author's Book\n5.Show category Books\n6.Update Book Data\n7.Display Sorted Books\n8.Display all books\n9.See Issued Book\n10.Show Dateline over\n11.Close the App");
			System.out.print("\nPlease Enter the choice : ");
		    int choice=sc.nextInt();
            
			if(choice==1) {
				addBook();
			}
			else if(choice==2) {
				removeBook();
			} else if(choice==3) {
			   s_Book();
			} else if(choice==4) {
				shwoAuthors();
			} else if(choice==5) {
				showCategory();
			} else if(choice==6) {
				update();
			} else if(choice==7) {
				sort();
			} 
			else if(choice==8) {
				displayAll();
			}
			else if(choice==9) {
				showIssuedBooks();
			} else if(choice==10) {
				showOutOfDate();
			} 
			else if(choice==11) {
				System.exit(1);
			}
			else {
				System.out.printf("\ninvalid Input!!!!");
			}

		}

	}
	
	public void addBook()
	{
		try {	
		System.out.print("Enter the book ID : ");
		int id =sc.nextInt();

            if(b_count!=0) {
				for(Book b:books) {
					if(id==b.getB_id()) {
						System.out.print("Book id should be 'UNIQUE' ////\nPlease Enter valid book id : ");
						id=sc.nextInt();
					}
				}
			}
            
			System.out.print("Enter the book name : ");
			String bname=sc.next();

			System.out.print("Enter the Author name: ");
			String aName=sc.next();

			System.out.print("Enter the Category : ");
			String category=sc.next();

			System.out.print("Enter the book prize: ");
			int price=sc.nextInt();
			
			while((price<=0) && (price>=0 && price<=9))  ///updated
			{
				System.out.print("please Enter valid price !!!");
				price=sc.nextInt();
			}


			System.out.print("Enter the book rating (1-10) : ");
			int brating=sc.nextInt();

			while( brating<0 ||  brating>10) {
				System.out.println("Please enter valid rating!!!!  : ");
			    brating=sc.nextInt();
			}

			System.out.print("Enter the '1' if booked is issued , '0' if book is not issued ");
			int isIssued=sc.nextInt();
			while( !(isIssued==0 ||  isIssued==1)) {
				System.out.print("Please enter valid status!!!!  : ");
			    isIssued=sc.nextInt();
			}	


			if(isIssued==1) {

				System.out.print("Enter the book issued day : ");
				int day=sc.nextInt();

				if(day<0 || day>31) {
					System.out.print("Please Enter valid day: ");
					day=sc.nextInt();
				}


				System.out.print("Enter the book issued month : ");
				int month=sc.nextInt();

				if(month<0 || month>12) {
					System.out.print("Please Enter valid Month : ");
					month=sc.nextInt();
				}

				System.out.print("Enter the book issued year : ");
				int year=sc.nextInt();

				System.out.print("Enter the student id of student who take book : ");
				int issuedToSt=sc.nextInt();

				if(!students.isEmpty())
				{
				for(Student s:students) {
					if(issuedToSt==s.getS_id()) {
				
						books.add(new Book(id,bname,aName,category,price,brating,isIssued,LocalDate.of(year,month,day),issuedToSt));
					//	b_count++;

						System.out.println("\nBooked Added successfully \n");
						return;
					}
				}
			}
				
			

		//to add into student database
				
				System.out.println("Entere the student name : ");
				String s_name=sc.next();

				System.out.println("Entere the student phone number : ");
				long w_no=sc.nextLong();

				 students.add(new Student(issuedToSt, s_name, w_no));
				 books.add(new Book(id,bname,aName,category,price,brating,isIssued,LocalDate.of(year,month,day),issuedToSt));

				return;
		}

			
			System.out.println("\nBooked Added successfully \n");	
		}catch (Exception e) {
			sc.nextLine();
			System.out.println("\nPlease enter valid input");
		}

}
	
	public void removeBook() {
		Book b=searchBook();
		
		if(b!=null)
		{
			books.remove(b);
			System.out.println("Book removed successfully");
		}
		
	}
	
public void s_Book() {
		
		System.out.println("\n1.Search Book by Book Name\n2.Search Book by Book id\n3.stop searching ");
		System.out.println("\nPlease Enter the choice : ");
		int choice =sc.nextInt();

		if(choice==1) {
			boolean flag=false;
			System.out.println("\nEnter book name to search : ");
			String bName = sc.next();
			
			for(Book b : books) {
				if(b.getA_name().equalsIgnoreCase(bName)) {
					flag=true;

					display(b);
				}

			}
			if(!flag) {
				System.out.println("\nnot found \n");
			}
			flag=false;

		} else if(choice==2) {

			System.out.println("\nEnter book 'ID' to search : ");
			int bid=sc.nextInt();

			Book b=searchBook();
			
				if(b!=null) 
					display(b);

			}

		else if(choice==3)
			return;
		 else 
			System.out.println("\ninvlaid choice!!! ");
	}
	
	
	public Book searchBook()
	{
		System.out.println("Enter book id : ");
		int bid=sc.nextInt();
		
		for(Book b:books)
		{
			if(bid==b.getB_id())
			{
				return b;
			}
		}
		System.out.println("Book not Found");
		return null;
	}
	
	public void shwoAuthors() {
		boolean flag=false;
	
		System.out.println("\nEnter the Author's Name :");
		String aname=sc.next();

		System.out.println("\nThe Books Written by Mr.%s :  \n"+aname);


		for(Book b :books) 
			if(b.getA_name().equalsIgnoreCase(aname)) {
				display(b);
				flag=true;
			}
				

		if(!flag) {
			System.out.println("\n not found \n");
		}

	}
	
	public void showCategory() {
		
		System.out.println("Available Categorries : ");
		
		for(int i=0;i<books.size();i++)
		{
			System.out.println((i+1)+". "+books.get(i).getCategory());
		}
		System.out.print("Enter your choice : ");
		 int choice = sc.nextInt();
		
		 for(Book b:books)
		 {
			 
		 }
		 
		 
		 
		 
//		Book b=searchBook();
		
//		if(cat.equals("0")) {
//			return;
//		}
//		
//		for(Book b :books)
//		{
//			if(b.getCategory().equalsIgnoreCase(cat))
//			{
//				display(b);
//			}
//		}
//		
	}
	
	
	public void update() {


		while(true) {
			System.out.println("\n1.To change the book price \n2.To change the book rating\n3.To update Issued status \n4.To Update Issued Date\n5.To Update students Id\n6.back ");
			System.out.println("\nEnter the choice :  ");
			int choice =sc.nextInt();
			System.out.println();
			Book b =searchBook();
			
			if(choice==1) {
				//flag=1;
				System.out.print("\n1.Enter the new price of book  : ");
				b.setB_price(sc.nextInt());
				System.out.println(b.getB_id()+" Id Prize changed successfull !!!!\n");
			
				
			} else if(choice==2) {
				System.out.println("\n1.Enter the new rating of book  (1-10): ");
				b.setRating(sc.nextInt());
				
				while(b.getRating()<0 || b.getRating()>10 ) {
					System.out.println("\nPlease enter valid rating (1-10)!!!!\n");
					b.setRating(sc.nextInt());
						}
				
				System.out.println(b.getB_id()+" Id rating changed successfull !!!!\n");
				}
			 else if(choice==3) {
				 System.out.println("\n1.Enter the Issued Status (0-not issued)and(1-issued)  : ");
				b.setIsIssued(sc.nextInt());
				 
					while(b.getIsIssued()< 0 || b.getIsIssued()> 1 ) {
						System.out.println("\nPlease enter valid Issued Status (0-not issued)and(1-issued)!!!! : ");
						b.setIsIssued(sc.nextInt());
						}
					System.out.println(b.getB_id()+" Id ,Issued status changed successfull !!!!\n");

						if(b.getIsIssued()==1) {
							System.out.println("Enter the new  issued day : ");
							int d=sc.nextInt();

							if(d<0 || d>31) {
								System.out.println("Please Enter valid day: ");
								d=sc.nextInt();
							}


							System.out.println("Enter the new  issued month : ");
							int m=sc.nextInt();

							if(m<0 || m>12) {
								System.out.println("Please Enter valid Month : ");
								m=sc.nextInt();
							}

							System.out.println("Enter the new  issued year : ");
							int y=sc.nextInt();
							
							b.setIssuedate(LocalDate.of(y, m, d));

						} else {
							b.setIssuedate(null);
						}
					
			 } else if(choice==4) {


				if(b.getIsIssued()==0) {
					System.out.println(b.getB_id()+" book Id Status is not Issued  (0) ,thats why you cannot allowed to change the date !!!\n");
					break;
				}
				
				if(b.getIsIssued()==1) {
					System.out.println("Enter the new  issued day : ");
					int d=sc.nextInt();

					if(d<0 || d>31) {
						System.out.println("Please Enter valid day: ");
						d=sc.nextInt();
					}


					System.out.println("Enter the new  issued month : ");
					int m=sc.nextInt();

					if(m<0 || m>12) {
						System.out.println("Please Enter valid Month : ");
						m=sc.nextInt();
					}

					System.out.println("Enter the new  issued year : ");
					int y=sc.nextInt();
					
					b.setIssuedate(LocalDate.of(y, m, d)); 

				}
				
				}
			 else if(choice==5) {
		
				 int temp;
				 
					if(b.getIsIssued()==0) {
						System.out.println(b.getB_id()+" book Id Status is not Issued  (0) ,thats why there is no student ID to Update  !!!\n");
						break;
					}
					if(b.getIsIssued()==1) {
						temp=b.getIssuedToSt();
						System.out.print("Enter the new student id : ");
						b.setIssuedToSt(sc.nextInt());
						
						
						boolean f=false;
						for(Student s: students)
						{
						     if(b.getIssuedToSt()==s.getS_id())
						     {
						    	 f=true;
						    
						     }
						     
						}    
						if(!f)
					     {
							System.out.println("Entere the student name : ");
							String s_name=sc.next();

							System.out.println("Entere the student phone number : ");
							long w_no=sc.nextLong();

							 students.add(new Student(b.getIssuedToSt(), s_name, w_no));
					     }
						
						 System.out.println(b.getIssuedToSt()+" Id already exist in database");
						
				}
			 }

			else if(choice==6) {
				break;
			} else
				System.out.print("\nInvalid choice !!!!\n");
		}
	}
	
public void sort() {
		
		List<Book> lb=new ArrayList<Book>();
		
		lb.addAll(books);
		
		while(true) {

			System.out.printf("\n1.Sort books price wise (lowest-highest) \n2.Sort books price wise (highest-lowest) \n3.Sort books  Rating-wise (lowest-hights)"
					+ " \n4.Sort books rating-wise (highest-lowests) \n5.back");
			System.out.printf("\nEnter the choice : ");
			int choice=sc.nextInt();

//			if(choice==1){
//					lb.sort(Comparator.comparingInt(book->book.b_price));
//			}else if(choice==2) {
//				    //lb.sort(Comparator.comparingInt(book->book.b_price).reversed());
//				//Collections.sort(lb.);
//			}else if(choice==3) { 
//				lb.sort(Comparator.comparingInt(book->book.rating));
//			}else if(choice==4) {
//				lb.sort(Comparator.comparingInt(book->book).reversed());
//			}else if(choice==5) {
//				return;
//			}else
//				System.out.println("\nInvalid choice !!!!");
		}
	

	}

public void displayAll() {
	
	System.out.printf("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
	System.out.printf("\n| %-15s| %-20s| %-20s| %-20s| %-15s| %-15s| %-15s| %-15s| %-15s ","book ID","book name","Author name","book Category","book prize","book rating","IsIssued","IssueDate","Student Id");
	System.out.printf("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");

	for(Book b:books) {

		System.out.printf("\n| %-15s| %-20s| %-20s| %-20s| %-15s| %-15s| %-15s| %-15s| %-13s |",b.getB_id(),b.getB_name(),b.getA_name(),b.getCategory(),b.getB_price(),b.getRating(),b.getIsIssued(),b.getIssuedate(),b.getIssuedToSt());
					
	}
	System.out.printf("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
}

public void display(Book b) {


	System.out.printf("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
	System.out.printf("\n| %-15s| %-20s| %-20s| %-20s| %-15s| %-15s| %-15s| %-15s| %-15s ","book ID","book name","Author name","book Category","book prize","book rating","IsIssued","IssueDate","Student Id");
	System.out.printf("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");


	if(b.getIsIssued()==1)
		System.out.printf("\n| %-15s| %-20s| %-20s| %-20s| %-15s| %-15s| %-15s| %-15s| %-13s |",b.getB_id(),b.getB_name(),b.getA_name(),b.getCategory(),b.getB_price(),b.getRating(),b.getIsIssued(),b.getIssuedate(),b.getIssuedToSt());
	 else 
		System.out.printf("\n| %-15s| %-20s| %-20s| %-20s| %-15s| %-15s| %-15s|",b.getB_id(),b.getB_name(),b.getA_name(),b.getCategory(),b.getB_price(),b.getRating(),b.getIsIssued());
	
	System.out.printf("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");

}

private void showIssuedBooks() {
	
	for(Book b:books)
	{
		if(b.getIsIssued()==1)
		{
			display(b);
		}
	}
	
}

private void showOutOfDate() {
	

	LocalDate d1=LocalDate.now();
	
	for(Book b: books)
	{
		if(b.getIsIssued()==1)
		{
			long days=ChronoUnit.DAYS.between(b.getIssuedate(), d1);
			
			if(days>30) {
				
				System.out.printf("\nextend days "+days);
				
				int tempStudID=b.getIssuedToSt();
				System.out.printf(" Please submit book  "+b.getB_name());
				
				for(Student s:students)
					if(s.getS_id() == tempStudID)
						System.out.println(" ( message is sent to  : "+s.getW_no()+" , Student id : "+s.getS_id()+" )");
	         }
		}
	}
}

public void booksHardcoded() {
	
	books.add(new Book(101,"Chhaava","Shivaji sawant","Historical",499,9,1,LocalDate.of(2025,01,13),203));
	b_count++;

	

	books.add(new Book(102,"Mrutyunjay","Shivaji sawant","Fiction",299,8,1,LocalDate.of(2025,01,02),201));
	b_count++;
	

	books.add(new Book(103,"Bhagvat Gita","Shivaji sawant","Religious",499,9,0));
	b_count++;

	books.add(new Book(104,"The Exorcist","William Blatty","Horror",600,7,1,LocalDate.of(2023,04,03),202));
	b_count++;
	

	
	books.add(new Book(105,"DesignPattern","Erich Gamma","Technical",249,5,1,LocalDate.of(2024,7,12),204));
	b_count++;
	

	books.add(new Book(106,"GunahonKaDev","D. bharti","Entertainment",199,8,0));
	b_count++;

}

public void studentHardcoded() {
	
	
	students.add(new Student(201,"Ajay Pawar",9910126547L));


	students.add(new Student(202,"nikhil dev",7788554499L));
	

	students.add(new Student(203,"Ankit kondalkar",7788993322L));
	

	students.add(new Student(204,"Vijay Pawar",9988774455L));
	

	students.add(new Student(205,"prasad nal",7788993378L));
	

	students.add(new Student(206,"Kali das",9910126547L));
	
	
	students.add(new Student(207,"Rao patil",8899443377L));
	
}







}
