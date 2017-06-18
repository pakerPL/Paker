package paker.main.database;

public class PassPrice {

	private double price;
	private String validity;
	private Type type;
	private String usageData;
	
	public PassPrice() {
		// TODO Auto-generated constructor stub
	}
	
	public PassPrice(double price, String validity, Type type, String usageData) {
		this.price = price;
		this.validity = validity;
		this.type = type;
		this.usageData = usageData;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getUsageData() {
		return usageData;
	}
	
	public String getValidity() {
		return validity;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void setUsageData(String usageData) {
		this.usageData = usageData;
	}
	
	public void setValidity(String validity) {
		this.validity = validity;
	}
}
