package bankActivities;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.Formatter;

public class Bank {
   
   static Account accounts[];
   static int accountCount;
   static double opening_balance; //openingBalance
   static double closing_balance;
   
   Scanner sc=new Scanner(System.in);
  
  public Bank() {
      Bank.accounts = new Account[50];
  }
  
  public void openBank() {
	calculateOpeningbalance();
	  while(true)
	  {
	  System.out.printf("\n1.Over the counter Activity\n2.Acount Lifecycle\n3.Show all acounts\n4.End of the day report for daily transaction\n5.exit");
	  System.out.print("\nEnter the choice : ");
	  int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:  counterActivity();
					break;
		case 2:  acLifecycle();
					break;
		case 3: displayAccounts();
		 		break;
		case 4: dailyReport();
				break;
		default:System.out.println("Invalid choice");
		}
	}
  }
  
  public void counterActivity() {
      while (true) {
          System.out.println("\nCounter Activities:");
          System.out.println("1. Create Account");
          System.out.println("2. Display Accounts");
          System.out.println("3. Update Account");
          System.out.println("4. Delete Account");
          System.out.println("5. Get Account Information");
          System.out.println("6.withdraw Amount");
          System.out.println("7.deposite Amount");
          System.out.println("8.Check Account Balance");
          System.out.println("9.Transaction Details");
          System.out.println("10.interest calculation");
          System.out.println("11. back");
          System.out.print("Enter your choice: ");
          int choice = sc.nextInt();
          //scanner.nextLine();
          
          switch (choice) {
              case 1:
                  create_Account();
                  break;
              case 2:
                  displayAccounts();
                  break;
              case 3:
              	 updateAccount();
                  break;
              case 4:
              	 deleteAccount();
                  break;
              case 5:
            	   getAccInfo();
            	   break;
              case 6:
            	  	withdraw();
            	  	break;
              case 7:
          	  		diposite();
          	  		break;
              case 8:
          	  		cheakBalance();
          	  		break;
              case 9:
          	  		transactionDetails();
          	  		break;
              case 10:
            	  	calculateInterest();
          	  	    break;
              case 11:
                  System.out.println("Exiting counter activities...");
                  return;
              default:
                  System.out.println("Invalid choice. Please try again.");
          }
          
      }
}
  


public void calculateOpeningbalance()
  {

	  
	  for(int i=0;i<accountCount;i++)
	  {
		  opening_balance=opening_balance+accounts[i].currbalance;
	  }
	  
  }
  public void calculateClosingbalance()
  {
	  closing_balance=0;
	  for(int i=0;i<accountCount;i++)
	  {
		  closing_balance= closing_balance+accounts[i].currbalance;
	  }
	  
  }
  public int  account_search()
	{
		System.out.print("Enter the account number : ");
		long acc_num=sc.nextLong();
		for(int i=0;i<accountCount;i++)
		{
			if(accounts[i].accNumber==acc_num)
			{
				boolean check =passwordChecker(i);
				if(check)
					return i;
				else
					System.out.println("Wrong password !!!");
			}
		}
		
		return-1;
	}
	public void acLifecycle() {
    
		int index=account_search();
		 
	     if (index>=0)
	     {
//	    	 System.out.println("Account num : "+accounts[index].accNumber);
//	    	 System.out.println("Account Holdaer name : "+accounts[index].accHolderName);
//	    	 System.out.println("Account creation Date : "+accounts[index].accCreatDate);
//	    	 System.out.println("Account current balance : "+accounts[index].currbalance);
	    	 display_formatt();
	    	 accounts[index].displayAccountDetails();

	    	 
	    	 accounts[index].transaction_details(accounts[index].transactions,accounts[index].tcnt,index);
	    	 	    	 
	     }
	     else
	    	 System.out.println("Account not found ");
	  
		
		
}
 public void calculateInterest() {
	
	 
	 int index=account_search();
	 
	 if(index>=0)
	 {
		 accounts[index].calculateInterest(); 
	 }
	 
	 else 
		System.out.println("Account not found");
	
 }

 public void dailyReport()
{
	 	int accTypeCntToday[]=new int[4]; // Indexing =  0:Saving,1:Salary,2:Current,3:Loan
	   int accTypeCntOverall[]=new int[4];
	   int deleteAccTypeCntToday[]=new int[4];
	   int deleteaccTypeCntOverall[]=new int[4];
	  
	    int dipo_cnt=0;
		int with_cnt=0;
		double diposite=0;
		double withdraw=0;
	   
		System.out.println("Daily info");
		
		
			calculateClosingbalance();
			
			System.out.println("Openeing balance : "+opening_balance);
			System.out.println("closing balance : "+closing_balance);
			
			
			for(int i=0;i<accountCount;i++)
			{
				
				if(accounts[i].accCreatDate.equals(LocalDate.now()))
					{
						if(accounts[i].acc_type.equals("savings"))
						{
							accTypeCntToday[0]++;
						}	
						else if(accounts[i].acc_type.equals("salary"))
						{
							accTypeCntToday[1]++;
						}
						else if(accounts[i].acc_type.equals("current")) {
							accTypeCntToday[2]++;
						}
						else if(accounts[i].acc_type.equals("loan")) {
							accTypeCntToday[3]++;
						}
					}
				
				
					if(accounts[i].acc_type.equals("savings"))
					{
						accTypeCntOverall[0]++;
					}	
					else if(accounts[i].acc_type.equals("salary"))
					{
						accTypeCntOverall[1]++;
					}
					else if(accounts[i].acc_type.equals("current")) {
						accTypeCntOverall[2]++;
					}
					else if(accounts[i].acc_type.equals("loan")) {
						accTypeCntOverall[3]++;
					}
					

					for(int j=0;j<accounts[i].tcnt;j++)
					{
					  if(accounts[i].transactions[j].lastTxDate.equals(LocalDate.now()))
					  {

						  if(accounts[i].transactions[j].type.equals("Diposit") || accounts[i].transactions[j].type.equals("repay"))
						  {
						      diposite=diposite+accounts[i].transactions[j].amount;
						     dipo_cnt++;
						  }
						  else if(accounts[i].transactions[j].type.equals("withdraw"))
						  {
							  withdraw=withdraw + accounts[i].transactions[j].amount;
								 with_cnt++; 
						  }
					  }
					}
					
					
				}
			

			
			
			System.out.println("\ntotal accounts created today :");
			System.out.println("Total Saving Accounts Open today : "+accTypeCntToday[0]);
			System.out.println("Total Salary Accounts Open today : "+accTypeCntToday[1]);
			System.out.println("Total current Accounts Open today : "+accTypeCntToday[2]);
			System.out.println("Total Loan Accounts Open today : "+accTypeCntToday[3]);
			
			System.out.println("\ntotal accounts Deleted today :");
			System.out.println("Total Saving Accounts deleted today : "+deleteAccTypeCntToday[0]);
			System.out.println("Total Salary Accounts deleted today : "+deleteAccTypeCntToday[1]);
			System.out.println("Total current Accounts deleted today : "+deleteAccTypeCntToday[2]);
			System.out.println("Total Loan Accounts deleted today : "+deleteAccTypeCntToday[3]);
			
			
			System.out.println("\nTotal amount deposite in bank Today: "+diposite);
			System.out.println("Total amount deposite transaction in bank : "+dipo_cnt);
			
			System.out.println("\nTotal amount Withdraw in bank Today: "+withdraw);
			System.out.println("Total amount withdraw transaction in bank : "+with_cnt);
			
		
}
 
 public void create_Account()
	{
		
	   long acc_num = 0;
	   String acc_name="";
	   String dob="";
	   int acc_password=0;
	   String acc_status="";
	   long mob_num=0;
		String acc_type="";
		double amount=0;
		
		  double interestRate=0;
			double totalinterest;
			int repayMonths = 0;
			double totalrepay=0;
			double m_Installment=0;
		
		
		while(true)
		{
			    System.out.println("Select Account Type:");
		        System.out.println("1. Savings Account");
		        System.out.println("2. Salary Account");
		        System.out.println("3. Current Account");
		        System.out.println("4. Loan Account");
		        System.out.print("Enter your choice: ");
		        int choice = sc.nextInt();
		     
		        if(choice==1)
		        {
		        	acc_type="saving";
		        while(true)
		        {
		        	System.out.println("Enter amount to deposite : ");
		        	amount=sc.nextDouble();
		        	if(amount>5000)
		        		break;
		        	System.out.println("please deposite atleast 5000");
		        }
		        break;
		        }
		        
		        else if(choice==2)
		        {
		        	acc_type="salary";
		        	
		        	 while(true)
				        {
				        	System.out.println("Enter amount to deposite : ");
				        	amount=sc.nextDouble();
				        	if(amount>=5000)
				        		break;
				        	System.out.println("please deposite atleast 5000");
				        }
				        break;
		        }
		        else if(choice==3)
		        {
		        	acc_type="current";
		        	System.out.println("Enter amount to deposite : ");
		        	amount=sc.nextDouble();
		        	break;
				        
		        }
		        else if(choice==4)
		        {
		        	acc_type="loan";
		        	break;
		        }
		        else
		        	System.out.println("please select valid Account type !!");
		        
		}
		
		
		
		if(acc_type.equals("loan")) {
			
			 System.out.print("Enter Salary : ");
				double salary=sc.nextDouble();
			System.out.println("Enter loan amount : ");
			 amount=sc.nextDouble();
			
			
			if((salary<=30000 &&salary>=20000) && amount<=salary*6)
				{
				 	interestRate=0.11;
					//loan=salary*6;
					totalinterest=amount*interestRate;
					repayMonths=12;
					totalrepay=amount + totalinterest;
					m_Installment=totalrepay/repayMonths;
					System.out.println("You are elibigle for loan !!!");
				}
				else if ((salary<=50000 && salary>30000) && amount<=salary*10) {
					interestRate=0.14;
					//loan=salary*10;
					repayMonths=24;
					totalinterest=amount*interestRate;
					totalrepay=amount + totalinterest;
					m_Installment=totalrepay/repayMonths;
					System.out.println("You are elibigle for loan !!!");
				}
				else if ((salary>50000 && salary>=100000)&& amount<=salary*20) {
					interestRate=0.16;
					//loan=salary*20;
					repayMonths=48;
					totalinterest=amount*interestRate;
					totalrepay=amount + totalinterest;
					m_Installment=totalrepay/repayMonths;

					System.out.println("You are elibigle for loan !!!");
				}
				else //if(l_amount>2000000 || salary<20000){
				{	
					
					System.out.println("You are not elibigle for loan !!!");
					return;
				}
				System.out.println();
				System.out.println("Loan Details : ");
				//System.out.println("Maximum loan : "+loan);
				System.out.println("Customer loan : "+amount);
				System.out.println("interest rate : "+interestRate);
				System.out.println("payable interest : "+totalinterest+" per year ");
				System.out.println("Repay months : "+repayMonths);
				System.out.println("Repaid amount : "+totalrepay);
				System.out.println("Monthly installment : "+m_Installment);
				System.out.println();
				System.out.println("Do you want to get loan (yes/no)");
				String res=sc.next();
				
				if (res.equals("no")) {
					System.out.println("Loan account creation cancell");
					return;
				}
		}
		 acc_num=generateAccountNumber();
		System.out.println("Account number is : "+acc_num);
		
		sc.nextLine();
		System.out.print("Enter account holder name : ");
		acc_name=sc.nextLine();
		
		System.out.print("Enter date of birth : ");
		dob=sc.nextLine();
		
		acc_password=genarate_password();
		
		acc_status="open";
		
		
		mob_num=mobile_validation();
		
		LocalDate acc_create_timeStamp=LocalDate.now();
		//String acc_delete_timeStamp="Active Account";
		
		if(acc_type=="saving")
			accounts[accountCount]=new SavingAccount(acc_num,acc_name,dob,amount,acc_password,acc_type,acc_status,mob_num,acc_create_timeStamp);
		else if(acc_type=="salary") 
			accounts[accountCount]=new SalaryAccount(acc_num,acc_name,dob,amount,acc_password,acc_type,acc_status,mob_num,acc_create_timeStamp);
		else if(acc_type=="saving") 
			accounts[accountCount]=new CurrentAccount(acc_num,acc_name,dob,amount,acc_password,acc_type,acc_status,mob_num,acc_create_timeStamp);
		else if(acc_type=="loan")
			accounts[accountCount]=new LoanAccount(acc_num,acc_name,dob,amount,acc_password,acc_type,acc_status,mob_num,acc_create_timeStamp,repayMonths,totalrepay,interestRate);
		
		
		
//		System.out.println("account created successfully");
		}


  


public void displayAccounts() {
	
	display_formatt();
	
	for(int i=0;i<accountCount;i++)
	{
		accounts[i].displayAccountDetails();
	}
	System.out.println();

}

	public void updateAccount() {
		
		int index=account_search();
		
	if(index>=0) 
	 {
		 
			sc.nextLine();
		  while(true)
		   {
			 System.out.println("select option to update details : ");
			 System.out.println("1)name");
			 System.out.println("2)Account type");
			 System.out.println("3)Date OF Birth");
			 System.out.println("4)Change Password");
			 System.out.println("5)Mobile Number");
			 System.out.println("6)Account Status");
			 System.out.println("7)Back");
			 System.out.print("\nEnter your choice : ");
			 int choice=sc.nextInt();
			 sc.nextLine();
						 
			 if(choice==1)
			 {
				 System.out.println("Enter name to update :");
				 accounts[index].accHolderName=sc.nextLine();
			 }
			 else if(choice==2)
			 {
				 while(true)
				 {
					 System.out.println("Select account type");
					 System.out.println("1)Salary");
					 System.out.println("2)Saving");
					 System.out.println("3)Current");
					 System.out.println("4)Loan");
					 System.out.println("5)back");
					 System.out.print("\nEnter your choice : ");
					 int ch=sc.nextInt();
					 
					 if(ch==1) {
						 accounts[index].acc_type="salary"; 
						 break;
					 }
					 else if(ch==2) {
						accounts[index].acc_type="saving"; 
						 break;
					 }
					 else if(ch==3) {
						accounts[index].acc_type="current"; 
						 break;
					 }
					 else if(ch==4) {
						accounts[index].acc_type="loan"; 
						 break;
					 }
					 else if(ch==5)
							break;
					 else
						 System.out.println("Invalid choice");
				 }
			 }
			 else if(choice==3)
			 {
				 System.out.println("Enter the new birthDate");
				 accounts[index].dob=sc.nextLine();
			 }
			 else if(choice==4)
			 {
				 	accounts[index].password=genarate_password();
			 }
			 else if(choice==5)
			 {
				accounts[index].phone_num= mobile_validation();
				 
			 }
			 else if(choice==6) {
				 
				 System.out.println("1)open\n2)closed\n3)frezze\n4)back");
				 System.out.println("Select account status to change : ");
				 int ct=sc.nextInt();
				 if(ct==1)
				   accounts[index].acc_status="open";
				 else if(ct==2)
				   accounts[index].acc_status="closed";
				 else if(ct==3)
				   accounts[index].acc_status="frezzed";
				 else
					 return;
				 
			 }
			 else if(choice==7)
			 {
				 return;
			 }
			 else
				 System.out.println("Invalid choice ");
			 
			 //sc.nextLine();
			 System.out.println("Update done!!!!!");
		 }
		 
    }
	else
		System.out.println("Account not found ");
	}
	

	public void deleteAccount() {
        int index=account_search();
        int deleteAccTypeCntToday[]=new int[4];
   //   static int deleteaccTypeCntOverall[]=new int[4];
        long temp;
        
		if(index>=0) {
			if(accounts[index].acc_type.equals("savings"))
				deleteAccTypeCntToday[0]++;
			else if(accounts[index].acc_type.equals("salary"))
				deleteAccTypeCntToday[1]++;
			else if(accounts[index].acc_type.equals("current"))
				deleteAccTypeCntToday[2]++;
			else if(accounts[index].acc_type.equals("loan"))
				deleteAccTypeCntToday[3]++;
			temp=accounts[index].accNumber;
			for(int j=index;j<accountCount-1;j++) {
				
				accounts[j]=accounts[j+1];
			
		}
			accounts[accountCount-1]=null;
			accountCount--;
			
			;
			System.out.println("Account "+temp+" delete successfully");
		    //break;
		}
		else
		{
			System.out.println("Account not found ");
		}

	}
	
	public void getAccInfo() {
	
		int index=account_search();
		 
		 if(index>=0)
		 {
			 display_formatt();
			 accounts[index].displayAccountDetails(); 
		 }
		 
		 else 
			System.out.println("Account not found");


}
	
	 	 
	 
	public void diposite()
	 {
		int index=account_search();
		
		if(index>=0)
		{
		//	if(!accounts[index].acc_type.equals("loan
			{
	        System.out.print("Enter Amount to deposite : ");
	        int amount = sc.nextInt();
	        
	        
	        accounts[index].deposit(amount);
	        closing_balance=closing_balance+amount;
			}
//			else
//			{
//				System.out.print("Enter amount to repay : ");
//				int repay_amount=sc.nextInt();
//				
//				accounts[index]
//				
//			}
	        
        }
		else
		{
			System.out.println("Account not found");
		}
	        
	 }
	
	public void withdraw()
	{
		
		int index=account_search();
				
		if(index>=0)
		{
		
	        System.out.print("Enter Amount to withdraw : ");
	        int amount = sc.nextInt();
	        
	        
	        accounts[index].withdraw(amount);
	        closing_balance=closing_balance-amount;
        }
		else
		{
			System.out.println("Account not found");
		}
		 
	
	}
	
	public static long generateAccountNumber()
	{
		Random random=new Random();
		
		return random.nextLong(1000000000L,10000000000L);
	}
	
	public static int generateOtp()
	{
		Random random=new Random();
		
		return random.nextInt(1000,10000);
	}
	
	private void cheakBalance() {
		int index=account_search();
		
		if (index>=0) {
			
			System.out.println("Current balance : "+accounts[index].currbalance);
			
		}
		else
			System.out.println("Account not found");
		
	}
	
	private void transactionDetails() {
       int index=account_search();
		
		if (index>=0) {
			
			  accounts[index].transaction_details(accounts[index].transactions,accounts[index].tcnt,index);
			
		}
		else
			System.out.println("Account not found");
		
		
	}

	public void addAccount(SavingAccount savingAccount) {
		
		System.out.println("count before "+accountCount);
		accounts[accountCount]=savingAccount;
		System.out.println("count after "+accountCount);
	}
	
	
	public int genarate_password()
	{

		
		while(true) {
		
		System.out.print("Entere the password : ");
		int pass=sc.nextInt();
		int tempPass=pass;
		int cnt=0;
		
		while(tempPass!=0)
		{
			tempPass=tempPass/10;
			cnt++;
		}
		
		if(cnt==4)
			return pass;
		else
			System.out.println("please enter 4 digit passWord");
	}
}
	
	public boolean passwordChecker(int i)
	{
		int cnt=3;
		
		while(cnt!=0)
		{
			System.out.print("Enter password : ");
			int pass=sc.nextInt();
			
			if(pass==accounts[i].password)
			{
				return true;
			}
			else
			{
				System.out.println("Wrong password : "+cnt--+" Attempts left");
			}
		}
		System.err.println("0 attempts left ,Please try after some time !!!");
		return false;
	}

	public long mobile_validation()
	{
		while(true)
		{
			System.out.print("Enter mobile number :");
			long mob_num=sc.nextLong();
			
			int cnt=0,otp=0,user_otp=-1;
			boolean flag=false;
			
			long temp=mob_num;
			while(temp!=0)
			{
				temp=temp/10;
				cnt++;
			}
			if(cnt!=10)
			{
				System.out.println("Mobile number is not valid ");
				
			}
			else
			{
				otp=generateOtp();
				System.out.println("Otp : "+otp);
				System.err.print("Please enter otp : ");
				user_otp=sc.nextInt();
				flag=true;
			}
			
			if(flag)
			{
				if(otp==user_otp)
				{
					System.out.println("Mobile number is succesfully verified");
					return mob_num;
				}
				else
					System.out.println("invalid otp ");
			}
		}
	}

public void display_formatt()
{
	System.out.println("\n|----------------------------------------------------------------------------------------------------------------------------------------|");
	System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15s| %-15s| %-15s| %-15s","Account Num","AcHolderName","DOB","Balance","ACC_open_Date","Status","Type","Contact");
	System.out.print("\n|----------------------------------------------------------------------------------------------------------------------------------------|");

}


}
