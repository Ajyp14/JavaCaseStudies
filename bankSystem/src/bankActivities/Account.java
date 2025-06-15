package bankActivities;

import java.util.Formatter;
import java.time.LocalDate;
import java.util.Random;

abstract public class Account {
    long accNumber;
	String accHolderName;
	String dob;
	int password;
	double currbalance;
    int tcnt=0;
    long phone_num;
    
	Transaction transactions[];
	LocalDate accCreatDate;
	int txId=1;
	String acc_status;
	String acc_type;
	
	
	public Account(long accNumber, String accHolder, String dob, double balance,int password,String acc_type,String acc_status,long phone_num,LocalDate acc_creation_timestamp) {
		
		this.accNumber= accNumber;
		this.accHolderName = accHolder;
		this.dob=dob;
		this.currbalance = balance;
		this.password=password;
		this.acc_status=acc_status;
		this.acc_type=acc_type;
		this.phone_num=phone_num;
		
		this.accCreatDate = acc_creation_timestamp;
		transactions=new Transaction[50];
		
		transactions[tcnt++] = new Transaction(txId() ,LocalDate.now(),"Diposit",balance, currbalance);
		//tcnt++;
		
		Bank.accountCount++;
		
		System.out.println("account created successfully");
		
		}

	
	public void deposit(double amount) {
		
		if(amount>0)
    	{
    	currbalance=currbalance + amount;
        System.out.println("Diposit : " + amount + ". New balance: : " + currbalance);
        transactions[tcnt++] = new Transaction(txId() ,LocalDate.now(),"Diposit",amount, currbalance);
    	}
    	else {
			System.out.println("invalid Amount");
		}
    }
	
	
	 abstract public void withdraw(double amount);
    abstract public void calculateInterest();
	
	
public void displayAccountDetails() {
	
	System.out.printf("\n| %-15d| %-15s| %-15s| %-15f| %-15s| %-15s| %-15s| %-15d",accNumber,accHolderName,dob,currbalance,accCreatDate,acc_status,acc_type,phone_num);
	System.out.print("\n|----------------------------------------------------------------------------------------------------------------------------------------|");
	
	 }

public void transaction_details(Transaction[] transactions,int tcnt,int index)
{
	System.out.println("\nTransaction Details : ");
	System.out.println("\n|----------------------------------------------------------------------------------------------|");
	System.out.printf("| %-15s| %-25s| %-15s| %-15s| %-15s|","Transaction Id","Transaction Date","Type","Amount","Balance");
	System.out.print("\n|----------------------------------------------------------------------------------------------|");

	
	for(int i=0;i<tcnt;i++)
	{
		System.out.println(transactions[i].toString());
	}
	
}

public  int txId()
{
	Random random = new Random();
	return random.nextInt(1000,10000);
}
	
    
}
