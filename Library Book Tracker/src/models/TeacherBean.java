package models;

import java.util.ArrayList;
import java.util.List;

public class TeacherBean extends UserBean {
	public TeacherBean(String firstName, String lastName, String gender, String mail, String password, String phone,
			UserType type) {
		super(firstName, lastName, gender, mail, password, phone, type);
		// TODO Auto-generated constructor stub
	}

	private List<CourseBean> courses = new ArrayList<>();
	private List<StudentBean> students = new ArrayList<>();

	public List<CourseBean> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseBean> courses) {
		this.courses = courses;
	}

	public List<StudentBean> getStudents() {
		return students;
	}

	public void setStudents(List<StudentBean> students) {
		this.students = students;
	}
	
	
}
