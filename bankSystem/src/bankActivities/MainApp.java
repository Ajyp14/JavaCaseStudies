package bankActivities;

import java.time.LocalDate;

public class MainApp {

	public static void main(String[] args) {
		

		Bank b1 = new Bank(); 
		
		Bank.accounts[Bank.accountCount]=new SavingAccount(111,"Prathamesh","20/01/2001",30000,9767,"savings","open",7777777777L,LocalDate.now());
		
		Bank.accounts[Bank.accountCount]=new SalaryAccount(112,"Suchit","02/01/2001",15000,1267,"salary","open",8888888888L,LocalDate.of(2024, 12, 28));
		
		Bank.accounts[Bank.accountCount]=new CurrentAccount(113,"rahul","08/02/2002",20000,8888,"current","open",9999999999L,LocalDate.now());
		
		Bank.accounts[Bank.accountCount]=new SavingAccount(114,"Aniket","20/11/2004",40000,9999,"savings","freeze",6666666666L,LocalDate.of(2025,02,21));
		
		Bank.accounts[Bank.accountCount]=new LoanAccount(115,"Pranav","23/12/2001",12000,7878,"loan","open",5555555555L,LocalDate.of(2024,10,28),12,144000,0.3);
		
//		b1.openBank();
		
//       Bank.accounts[Bank.accountCount]=new SavingAccount(Bank.generateAccountNumber(),"","22/10/2001",50000,3636,"savings","open",1212121212L,0,LocalDate.now());
//		
//		Bank.accounts[Bank.accountCount]=new SalaryAccount(112,"N","05/06/2001",35000,7575,"salary","open",8686868686L,0,LocalDate.of(2025,01,28));
//		
//		Bank.accounts[Bank.accountCount]=new CurrentAccount(113,"rahul","08/02/2002",20000,8888,"current","open",9999999999L,0,LocalDate.now());
//		
//		Bank.accounts[Bank.accountCount]=new SavingAccount(114,"Aniket","20/11/2004",40000,9999,"savings","closed",6666666666L,0,LocalDate.now());
//		
//		Bank.accounts[Bank.accountCount]=new LoanAccount(115,"Pranav","23/12/2001",-200000,7878,"loan","open",55555555555L,0,LocalDate.of(2024,10,28),12,240000,0.10);
//		
		b1.openBank();
				
			
	}

}
