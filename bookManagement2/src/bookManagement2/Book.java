package bookManagement2;

import java.time.LocalDate;

public class Book {
	private int b_id;
	private String b_name;
	private String a_name;
	private String category;
	private int b_price;
	private int rating;
	private int isIssued;
	private LocalDate issuedate;
	private int issuedToSt;
		
	public  Book()
	{
		
	}
	public Book(int b_id, String b_name, String a_name, String category, int b_price, int rating, int isIssued,
			LocalDate issuedate, int issuedToSt) {
		
		this.b_id = b_id;
		this.b_name = b_name;
		this.a_name = a_name;
		this.category = category;
		this.b_price = b_price;
		this.rating = rating;
		this.isIssued = isIssued;
		this.issuedate=issuedate;
		this.issuedToSt = issuedToSt;
	}
	public Book(int b_id, String b_name, String a_name, String category, int b_price, int rating, int isIssued) {

		this.b_id = b_id;
		this.b_name = b_name;
		this.a_name = a_name;
		this.category = category;
		this.b_price = b_price;
		this.rating = rating;
		this.isIssued = isIssued;
	}
	
	public String toString() {
		
		
		if(isIssued==1) {
			System.out.printf("\n| %-15s| %-20s| %-20s| %-20s| %-15s| %-15s| %-15s| %-15s| %-13s |",b_id,b_name,a_name,category,b_price,rating,isIssued,issuedate,issuedToSt);
			System.out.printf("\n---------------------------------------------------------------------------------------------------------------------------------------\n");
		
			return "";
			
		} else {
			System.out.printf("| %-15d| %-20s| %-20s| %-20s| %-15d| %-15d| %15d ",b_id,b_name,a_name,category,b_price,rating,isIssued);
			System.out.printf("\n---------------------------------------------------------------------------------------------------------------------------------------\n");
			return "";
		}
	}

	
	

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getB_price() {
		return b_price;
	}

	public void setB_price(int b_price) {
		this.b_price = b_price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getIsIssued() {
		return isIssued;
	}

	public void setIsIssued(int isIssued) {
		this.isIssued = isIssued;
	}

	public LocalDate getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(LocalDate issuedate) {
		this.issuedate = issuedate;
	}

	public int getIssuedToSt() {
		return issuedToSt;
	}

	public void setIssuedToSt(int issuedToSt) {
		this.issuedToSt = issuedToSt;
	}

}
