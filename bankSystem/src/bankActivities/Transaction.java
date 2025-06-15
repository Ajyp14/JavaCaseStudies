package bankActivities;

import java.time.LocalDate;

public class Transaction {

	int txId;
	LocalDate lastTxDate;
	String type;
	double amount;
	double balance;
	
	public Transaction() {
		
	}
	public Transaction(int txId,LocalDate lastTxDate, String type, double amount , double currbalance) {
		
		this.txId=txId;
		
		this.lastTxDate = lastTxDate;
		this.type = type;
		this.amount = amount;
		this.balance = currbalance;
		
	}
	@Override
	public String toString() {

		System.out.printf("\n| %-15d| %-25s| %-15s| %-15f| %-15f|",txId,lastTxDate,type,amount,balance);
		System.out.print("\n|----------------------------------------------------------------------------------------------|");

		return"";
	}
	
}
