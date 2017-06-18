package paker.main.database;

public class Type {

	private long id;
	private String name;
	private Group group;
	private int visitLimit;
	private int validity;
	private boolean inUse;
	
	public Type() {
		// TODO Auto-generated constructor stub
	}
	
	public Type(String name, Group group, int visitLimit, int validity, boolean inUse) {
		this.name = name;
		this.group = group;
		this.visitLimit = visitLimit;
		this.validity = validity;
		this.inUse = inUse;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValidity() {
		return validity;
	}
	
	public int getVisitLimit() {
		return visitLimit;
	}
	
	public boolean isInUse() {
		return inUse;
	}
	
	public void setGroup(Group group) {
		this.group = group;
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
	
	public void setValidity(int validity) {
		this.validity = validity;
	}
	
	public void setVisitLimit(int visitLimit) {
		this.visitLimit = visitLimit;
	}
	
}
