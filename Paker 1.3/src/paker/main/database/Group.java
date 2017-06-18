package paker.main.database;

public class Group {

	private long id;
	private String name;
	private short r;
	private short g;
	private short b;
	private boolean inUse;
	
	public Group() {
		// TODO Auto-generated constructor stub
	}

	public short getB() {
		return b;
	}

	public short getG() {
		return g;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public short getR() {
		return r;
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setB(short b) {
		this.b = b;
	}


	public void setG(short g) {
		this.g = g;
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

	public void setR(short r) {
		this.r = r;
	}
}
