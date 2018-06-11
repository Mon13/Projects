package test;

import controllers.UserDAO;
import models.BookBean;
import models.CourseBean;
import models.StudentBean;
import models.TeacherBean;
import models.UserBean;
import models.UserBean.UserType;

public class Test {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
//		
//		TeacherBean teacher1 = new TeacherBean("omar","aldawud","male","omar@gmail.com","abcd1234","3128663103",UserType.TEACHER);
//		System.out.println(teacher1);
//		userDAO.insertUser(teacher1);
//		UserBean teacher2 = new UserBean("atef","badar","male","atef@gmail.com","efgh1234","3128667013",UserType.TEACHER);
//		userDAO.insertUser(teacher2);
//		
//		CourseBean course1 = new CourseBean("CS587","UML");
//		CourseBean course2 = new CourseBean("CS586","SPM");
//		CourseBean course3 = new CourseBean("CS425","DBO");
//		
//		userDAO.insertCourse(course1);
//		userDAO.insertCourse(course2);
//		userDAO.insertCourse(course3);
//		
//		teacher1.getCourses().add(course3);
//		teacher1.getCourses().add(course2);
//		
//		userDAO.insertTeacherCourseMapping(teacher1);
//		System.out.println(teacher1.getCourses());
//		
//		
//		
//		UserBean parent = new UserBean("aldawud","mohammad","male","mohammad@gmail.com","1563248","312896578",UserType.PARENT);
//		StudentBean student = new StudentBean("mouna","giri","female","mouna@gmail.com","23586","312896563",UserType.STUDENT);
//		student.setParent(parent);
//		student.setAdvisor(teacher1);
//		student.getCourses().add(course2);
//		student.getCourses().add(course1);
//		userDAO.insertUser(student);
		
//		BookBean book1 = new BookBean("IITCSDBO","123456","Database","Bhakshi",10);
//		userDAO.insertBook(book1);
//		System.out.println(book1);
		
		int id = userDAO.checkCredentials("omar@gmail.com", "abcd1234");
		System.out.println(id);
	}
}
