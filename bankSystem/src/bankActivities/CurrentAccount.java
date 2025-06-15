package bankActivities;

import java.time.LocalDate;

public class CurrentAccount extends Account {

	double overdraft;
	
	public CurrentAccount(long accNumber, String accHolder, String dob, double balance, int password, String acc_type,
			String acc_status, long phone_num, LocalDate acc_creation_timestamp) {
		super(accNumber, accHolder, dob, balance, password, acc_type, acc_status, phone_num,
				acc_creation_timestamp);
		
		this.overdraft=20000;
	}

	public void withdraw(double amount)
	{
		if((currbalance-amount)>=(-overdraft))
		{
			currbalance=currbalance-amount;
			System.out.println("withdraw done ..");
			System.out.println("Current balance : "+currbalance);
			transactions[tcnt++] = new Transaction(txId() ,LocalDate.now(),"withdraw",amount, currbalance);
		}
		else {
			System.err.println("Overdraft is reached ,maximum availaible withdraw money is : "+(currbalance+overdraft));
		}
		
	}
	
	public void diposite(double amount)
	{
		if(amount>0)
		{
			currbalance=currbalance+amount;
			System.out.println("diposite done..");
			System.out.println("Current balance : "+currbalance);
			
			transactions[tcnt++] = new Transaction(txId() ,LocalDate.now(),"Diposit",amount, currbalance);
		}
		else {
			System.out.println("invalid amount ");
		}
	}



	@Override
	public void calculateInterest() {
		System.out.println("No interest for Current  Account");
		
	}

}
