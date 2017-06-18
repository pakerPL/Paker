package paker.main.database;

public class Deposit {

	private double price;
	private String since;
	private String until;
	
	public Deposit() {
		// TODO Auto-generated constructor stub
	}
	
	public Deposit(double price, String since, String until) {
	this.price = price;
	this.since = since;
	this.until = until;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getSince() {
		return since;
	}
	
	public String getUntil() {
		return until;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setSince(String since) {
		this.since = since;
	}
	
	public void setUntil(String until) {
		this.until = until;
	}
}
