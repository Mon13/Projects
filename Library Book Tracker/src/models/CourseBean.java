package models;

import java.util.List;

public class CourseBean {
	private int id;
	private String code;
	private String name;
	
	public CourseBean(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public CourseBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
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
		CourseBean other = (CourseBean) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CourseBean [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

	


}
