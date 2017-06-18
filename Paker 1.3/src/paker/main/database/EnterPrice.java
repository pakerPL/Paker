package paker.main.database;

public class EnterPrice {

	private long id;
	private double price;
	private String name;
	private boolean inUse;
	
	public EnterPrice() {
		// TODO Auto-generated constructor stub
	}
	
	public EnterPrice(double price, String name, boolean inUse) {
		this.price = price;
		this.name = name;
		this.inUse = inUse;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean isInUse() {
		return inUse;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}
