package bankActivities;

import java.time.LocalDate;
import java.util.Scanner;

public class LoanAccount extends Account{

	int repayMonths;
	double totalrepay;
	double totalinterest;
	double interestRate;
	double original_loan_amount;
	double m_Installment;;
	double loan;
	
	Scanner sc =new Scanner(System.in);
		

	public LoanAccount(long accNumber, String accHolder, String dob,double balance, int password, String acc_type,
			String acc_status, long phone_num, LocalDate acc_creation_timestamp,int repayMonths,double totalRapay,double interestRate) {
		super(accNumber, accHolder, dob,-balance, password, acc_type, acc_status, phone_num,acc_creation_timestamp);
		
		this.repayMonths=repayMonths;
	    this.totalrepay=totalRapay;
	    this.interestRate=interestRate;
	    this.original_loan_amount=-balance;
	}

	@Override
	public void calculateInterest() {
		if(currbalance<0)
		{
			totalinterest=currbalance*interestRate;
				
				System.out.println("Loan interest "+totalinterest);
				
				System.out.println("previous balance : "+currbalance);
				currbalance=currbalance+(-totalinterest);
	    		//System.out.println("interest : "+totalinterest);
	    		System.out.println("Total balance : "+currbalance);
				
		}
		
	}
	
	public void repay(double amount) {
		
//		if(amount<=0)
//		{
//			System.out.println("invalid repayment amount ");
//			return;
//		}
		
		currbalance=currbalance+amount;
		
		if(currbalance>=0)
		{
			System.err.println("Loan full repaid ...");
			System.out.println("Current balance : "+currbalance);
	        transactions[tcnt++] = new Transaction(txId() ,LocalDate.now(),"Diposit",amount, currbalance);
		}
		else
		{
			System.out.println("repayment done ");
			System.out.println("Remaining loan : "+currbalance);
	        transactions[tcnt++] = new Transaction(txId() ,LocalDate.now(),"repay",amount, currbalance);
		}
		
	}
	
	
//	public void displayAccountDetails() {
//        System.out.println("Account Holder: " + accHolderName);
//	     System.out.println("Account Number: " + accNumber);
//	     System.out.println("Original loan amount :"+original_loan_amount);
//	     System.out.println("Remaining Loan Balance : "+currbalance);
//	     System.out.println("Interest Rate : "+interestRate);
//	     System.out.println("Repayment duration : "+repayMonths);
//	     System.out.println("Account creation Date : "+accCreatDate);
//	     
//	     if(currbalance>=0)
//	    	 System.out.println("Status : Loan Fully repaid ");
//	     else
//	    	 System.out.println("Status : Loan ongoing");
//	     
//	 }

	@Override
	public void withdraw(double amount) {
		
		if(currbalance<0)
		{
			System.out.println("You not clear Loan >>> not able to withdraw amount");
			return;
		}
		else
		{
			if(amount>currbalance)
			{
				System.out.println("Not have that much balance available in your account");
				return;
			}
			else
			{

				currbalance=currbalance - amount;
	            
	        	System.out.println("Withdraw " + amount + ". New balance: " + currbalance);
	            transactions[tcnt++] = new Transaction( 1,LocalDate.now(),"withdraw",amount, currbalance);
				
			}
			
		}
		
	}
	
	public void diposite(double amount)
	{
		repay(amount);
	}
		
	

}
