package bankActivities;

import java.time.LocalDate;

public class SavingAccount extends Account{

     final double minimum = 10000;
     static double interest;
     
	    
   		public SavingAccount(long accNumber, String accHolder, String dob, double balance, int password,String acc_type,String acc_status,long phone_num, LocalDate acc_creation_timestamp) {
		super(accNumber, accHolder, dob, balance, password, acc_type, acc_status, phone_num,
				acc_creation_timestamp);
		
		}


		@Override
	    public void withdraw(double amount) {
	    	
	        if ((currbalance - amount) >= minimum) {
	        	if(acc_status.equalsIgnoreCase("open"))
	        	{
	        	currbalance=currbalance - amount;
	            System.out.println("Withdraw " + amount + ". New balance: " + currbalance);
	            transactions[tcnt++] = new Transaction(txId() ,LocalDate.now(),"withdraw",amount, currbalance);
	        	}
	        	else {
	        		System.out.println("Account status is : "+acc_status);
	        	}
	        	
	        	} else {
	            System.out.println("Withdrawa denied. Minimum balance of " +minimum
	            		+ " must be maintained.");
	        }
	    }
	    
	
	    
	    public void calculateInterest()
	    {
	    	if(currbalance>=10000)
	    	{
	    		System.out.println("previous balance : "+currbalance);
				interest=(currbalance*0.03); 
				currbalance=currbalance+interest;
	    		System.out.println("interest : "+interest);
	    		System.out.println("Total balance : "+currbalance);
	    	}
	    	else if(currbalance>=50000)
	    	{
	    		System.out.println("previous balance : "+currbalance);
				interest=(currbalance*0.05); 
				currbalance=currbalance+interest;
	    		System.out.println("interest : "+interest);
	    		System.out.println("Total balance : "+currbalance);
	    	}
	    	else if(currbalance>=100000)
	    	{
	    		System.out.println("previous balance : "+currbalance);
				interest=(currbalance*0.09); 
				currbalance=currbalance+interest;
	    		System.out.println("interest : "+interest);
	    		System.out.println("Total balance : "+currbalance);
	    	}
	    	
	    }
	    

}
