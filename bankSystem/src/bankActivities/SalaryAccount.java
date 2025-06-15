package bankActivities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SalaryAccount extends Account{

	int months;
	double interest;
	final double minimum = 10000;

	public SalaryAccount(long accNumber, String accHolder, String dob, double balance, int password, String acc_type,
			String status, long phone_num, LocalDate acc_creation_timestamp) {
		super(accNumber, accHolder, dob, balance, password, acc_type, status, phone_num,
				acc_creation_timestamp);
	}


	public void exendsMonth()
	{
		LocalDate d1=transactions[tcnt-1].lastTxDate;
		//System.out.println(d1);

		LocalDate d2=LocalDate.now();
		//System.out.println(d1);

		long months1=ChronoUnit.MONTHS.between(transactions[tcnt-1].lastTxDate,LocalDate.now());
		//System.out.println(months1);
		
		if(months1>2)
		{
			acc_status="freezed";
		}
		else
		    acc_status="open";
	}
	
	
	public void deposite(double amount)
	{
		 exendsMonth();
				
		if(acc_status.equals("open"))
		{
//			currbalance=currbalance + amount;
//            System.out.println("Diposit : " + amount + ". New balance: : " + currbalance);
//            
//            transactions[tcnt++] = new Transaction( 1,LocalDate.now(),"Diposit",amount, currbalance);
			super.deposit(amount);
	    	
		}else {
			
			System.out.println("Account is frozen ");
		}
	}
	public void withdraw(double amount)
	{
		exendsMonth();
		
		if(acc_status.equals("open"))
		{
			if ((currbalance - amount) >= minimum) {
	        	currbalance=currbalance - amount;
	            
	        	System.out.println("Withdraw " + amount + ". New balance: " + currbalance);
	             LocalDate d1=LocalDate.now();
	            transactions[tcnt++] = new Transaction( 1,d1,"withdraw",amount, currbalance);
	        } else {
	            System.out.println("Withdraw denied. Minimum balance of " +minimum
	            		+ " must be maintained.");
	        }	    	
		}else {
			System.out.println("Account is frozen ");
		}
		
	}

	@Override
	public void calculateInterest() {
		if(currbalance>=10000 && currbalance<50000)
    	{
			System.out.println("previous balance : "+currbalance);
			interest=(currbalance*0.3); 
			currbalance=currbalance+interest;
    		System.out.println("interest : "+interest);
    		System.out.println("Total balance : "+currbalance);
    	}
    	else if(currbalance>=50000 && currbalance<100000)
    	{
    		System.out.println("previous balance : "+currbalance);
			interest=(currbalance*0.5); 
			currbalance=currbalance+interest;
    		System.out.println("interest : "+interest);
    		System.out.println("Total balance : "+currbalance);
    	}
    	else if(currbalance>=100000 && currbalance<1000000)
    	{
    		System.out.println("previous balance : "+currbalance);
			interest=(currbalance*0.9); 
			currbalance=currbalance+interest;
    		System.out.println("interest : "+interest);
    		System.out.println("Total balance : "+currbalance);
    	}
    	
		
	}
	
	
}
