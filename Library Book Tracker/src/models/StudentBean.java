package models;

import java.util.ArrayList;
import java.util.List;

public class StudentBean extends UserBean {
	
	public StudentBean(String firstName, String lastName, String gender, String mail, String password, String phone,
			UserType type) {
		super(firstName, lastName, gender, mail, password, phone, type);
		// TODO Auto-generated constructor stub
	}
	private UserBean parent;
	private UserBean advisor;
	private List<CourseBean> courses = new ArrayList<>();
	
	public UserBean getParent() {
		return parent;
	}
	public void setParent(UserBean parent) {
		this.parent = parent;
	}
	public UserBean getAdvisor() {
		return advisor;
	}
	public void setAdvisor(UserBean advisor) {
		this.advisor = advisor;
	}
	public List<CourseBean> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseBean> courses) {
		this.courses = courses;
	}
	
}
