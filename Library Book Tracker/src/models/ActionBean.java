package models;

public class ActionBean {
	private int id;
	private String name;
	private float fineAmt;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getFineAmt() {
		return fineAmt;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFineAmt(float fineAmt) {
		this.fineAmt = fineAmt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActionBean other = (ActionBean) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ActionBean [id=" + id + ", name=" + name + ", fineAmt=" + fineAmt + "]";
	}
	
	
	

}
