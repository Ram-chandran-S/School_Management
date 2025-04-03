package DTO;

public class Student {
	private int id;
	private String name;
	private int chemistry;
	private int physics;
	private int maths;
	
	public Student(int id, String name, int chemistry, int physics, int maths) {
		super();
		this.id = id;
		this.name = name;
		this.chemistry = chemistry;
		this.physics = physics;
		this.maths = maths;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}

}
