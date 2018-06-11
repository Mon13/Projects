package controllers;

import java.awt.Checkbox;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.BookBean;
import models.BookCheckoutBean;
import models.BookList;
import models.CourseBean;
import models.StudentBean;
import models.TeacherBean;
import models.UserBean;
import models.UserBean.UserType;

public class UserDAO {
	


//	public UserBean insertUser(UserBean user) {
//		if (user.getType().equals(UserType.STUDENT)) {
//			StudentBean student = (StudentBean) user;
//			UserBean parent = student.getParent();
//			
//			int pid = insertUserToDB(parent);
//			parent.setId(pid);
//
//			int sid = insertUserToDB(student);
//			student.setId(sid);
//
//			insertStudentParentMapping(sid, pid);
//			insertStudentAdvisorMapping(student.getAdvisor().getId(),sid );
//			insertStudentCourseMapping(student);
//		} else {
//			int id = insertUserToDB(user);
//			user.setId(id);
//		}
//		return user;
//	}
	
	//delete user 
	public void deleteuser(UserBean user) {
		
		try{
			Connection connectionObject = DBConnectionObject();
			String deleteUserQuery = "delete from user where id = ?;";
			PreparedStatement pst = connectionObject.prepareStatement(deleteUserQuery);
			pst.setInt(1, user.getId());
			pst.executeUpdate();

		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public void insertCourse(CourseBean course) {
		int typeId = 0;
		//insert into course table
		try{
			Connection connectionObject = DBConnectionObject();
			String insertIntoCourseQuery = "insert into course(code,name) values (?,?);";
			PreparedStatement pst = connectionObject.prepareStatement(insertIntoCourseQuery);
			pst.setString(1,course.getCode());
			pst.setString(2,course.getName());
			pst.execute();
			
			String getIdQuery = "select id from course where code=? and name=?;";
			pst = connectionObject.prepareStatement(getIdQuery);
			pst.setString(1, course.getCode());
			pst.setString(2, course.getName());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				typeId= rs.getInt("id");
			}
			System.out.println(typeId);
			course.setId(typeId);
		}catch(Exception e){
			
		}	
	}
	
	//delete a course
	public void deletecourse(String courseName) {
		
		try{
			Connection connectionObject = DBConnectionObject();
			String deletecourseQuery = "delete from course where name = ?;";
			PreparedStatement pst = connectionObject.prepareStatement(deletecourseQuery);
			pst.setString(1, courseName);
			pst.executeUpdate();

		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public void insertTeacherCourseMapping(String email,String courseName) throws Exception {
//		if(!user.getType().equals(UserType.TEACHER)) {
//			throw new Exception("Not Authorized");
//		}
//		TeacherBean teacher = new;
//		for (CourseBean course : teacher.getCourses()) {
//			//insert
			int facultyId = getUserId(email);
			int courseId = getCourseId(courseName);
			//insert into teacher course mapping table

			try{
				Connection connectionObject = DBConnectionObject();
				String insertIntoTeacherCourseMappingQuery = "insert into user_course_mapping(faculty_id,course_id) values (?,?);";
				PreparedStatement pst = connectionObject.prepareStatement(insertIntoTeacherCourseMappingQuery);
				pst.setInt(1,facultyId);
				pst.setInt(2,courseId);
				pst.execute();
				
			}catch(Exception e){
				
			}
		
	}
	
	public int insertStudentCourseMapping(String email,String courseName) {
		int flag=0;
		int studentId = getUserId(email);
		int courseId = getCourseId(courseName);
		System.out.println(getCourseCountofStudent(studentId));
		
		if(getCourseCountofStudent(studentId)<3){
			System.out.println("hello");
//			StudentBean student = (StudentBean) user;
//			for (CourseBean course : student.getCourses()) {
				//insert
//				int studentId = student.getId();
//				int courseId = course.getId();
//				//insert into teacher course mapping table
				try{
					Connection connectionObject = DBConnectionObject();
					String insertIntoStudentCourseMappingQuery = "insert into student_course_mapping(student_id,course_id) values (?,?);";
					PreparedStatement pst = connectionObject.prepareStatement(insertIntoStudentCourseMappingQuery);
					pst.setInt(1,studentId);
					pst.setInt(2,courseId);
					pst.execute();
				}catch(Exception e){
					
				}
			return flag;}
		else{
			System.out.println("Course registration limit reached");
			flag =1;
			return flag;
		}

	}

	public int insertUserToDB(UserBean user) {
		int typeId = 0;
		// insert user prepared stmt
		try{
			System.out.println("reached2");
			System.out.println(user);
			Connection connectionObject = DBConnectionObject();
			String insertIntoUserQuery = "insert into user(first_name,last_name,gender,email,password,phone,type_id) values "
					+ "(?,?,?,?,?,?,?);";
			PreparedStatement pst = connectionObject.prepareStatement(insertIntoUserQuery);
			pst.setString(1,user.getFirstName());
			pst.setString(2,user.getLastName());
			pst.setString(3, user.getGender());
			pst.setString(4, user.getMail());
			pst.setString(5, user.getPassword());
			pst.setString(6, user.getPhone());
			pst.setInt(7, getTypeId(user.getType()));
			pst.execute();
			
			//set the generated user id to the user object
			String getIdQuery = "select id from user where first_name = ? and last_name=?;";
			pst = connectionObject.prepareStatement(getIdQuery);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastName());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				typeId= rs.getInt("id");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return typeId;
	}

	public void insertStudentParentMapping(int sid,int pid) {
		// insert query
		try{
			Connection connectionObject = DBConnectionObject();
			String insertIntoStudentParentMappingQuery = "insert into guardian(student_id,parent_id) values (?,?);";
			PreparedStatement pst = connectionObject.prepareStatement(insertIntoStudentParentMappingQuery);
			pst.setInt(1,sid);
			pst.setInt(2,pid);
			pst.execute();
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public void insertStudentAdvisorMapping(int sid,int aid) {
		// insert query
		try{
			Connection connectionObject = DBConnectionObject();
			String insertIntoAdvisorStudentMappingQuery = "insert into advisor_student_mapping(faculty_id,student_id) values (?,?);";
			PreparedStatement pst = connectionObject.prepareStatement(insertIntoAdvisorStudentMappingQuery);
			pst.setInt(1,aid);
			pst.setInt(2,sid);
			pst.execute();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//queries related to book
	public void insertBook(BookBean book) {
	
		// insert book into book table
		try{
			Connection connectionObject = DBConnectionObject();
			String insertIntoBookQuery = "insert into book(book_college_code,isbn,title,author,total_available) "
					+ "values (?,?,?,?,?);";
			PreparedStatement pst = connectionObject.prepareStatement(insertIntoBookQuery);
			pst.setString(1, book.getSchoolGeneratedId());
			pst.setString(2, book.getIsbn());
			pst.setString(3, book.getBookTitle());
			pst.setString(4, book.getBookAuthor());
			pst.setInt(5, book.getNoOfCopies());
			pst.execute();
			
			String getIdQuery = "select id from book where book_college_code = ?;";
			pst = connectionObject.prepareStatement(getIdQuery);
			pst.setString(1, book.getSchoolGeneratedId());
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				book.setId(rs.getInt("id"));
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//delete a book
	public void deletetBook(String bookName) {
		
		// insert book into book table
		try{
			Connection connectionObject = DBConnectionObject();
			String deleteBookQuery = "delete from book where name = ?;";
			PreparedStatement pst = connectionObject.prepareStatement(deleteBookQuery);
			pst.setString(1, bookName);
			pst.executeUpdate();

		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void insertIntoBookCheckout(int student_id,int book_id,java.sql.Date dueDate,java.sql.Date checkoutDate) {
		System.out.println(getBookCheckoutCountOfStudent(student_id));
		if (getBookCheckoutCountOfStudent(student_id) <3){
			
			try{
				BookCheckoutBean obj = new BookCheckoutBean();
				// insert book into book table
				Connection connectionObject = DBConnectionObject();
				String insertIntoBookCheckoutQuery = "insert into checkout(book_id,checkout_date,return_date,due_date,user_id,action_id) "
						+ "values (?,?,?,?,?,?);";
				PreparedStatement pst = connectionObject.prepareStatement(insertIntoBookCheckoutQuery, 
						Statement.RETURN_GENERATED_KEYS);
				pst.setInt(1, book_id);
				pst.setDate(2,(java.sql.Date) checkoutDate);
				pst.setNull(3,java.sql.Types.DATE);
				pst.setDate(4,(java.sql.Date) dueDate);
				pst.setInt(5, student_id);
				pst.setNull(6,java.sql.Types.INTEGER);
				pst.execute();
				
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()) {
					obj.setId(rs.getInt(1));
				}
				
				decreaseBookCount(book_id);
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
		else{
			System.out.println("No of book Limit Reached");
		}
		
	

	}
	
	enum ActionType {
		NOFINE, FINE
	}
	
	public void bookReturn(String userName,String bookName, java.sql.Date returnDate){
		int actionId = 0;
		try{System.out.println("hiiiiiiiiiii");
			Connection connectionObject = DBConnectionObject();
			ActionType action;
			if(returnDate.after(getDueDate(userName, bookName))) {
				
				action = ActionType.FINE;
				System.out.println(action);
			} else {
				action = ActionType.NOFINE;
				System.out.println(action);
			}
			String query = "select id from action where name = ?";
			PreparedStatement  pst = connectionObject.prepareStatement(query);
			pst.setString(1, action.name());
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				//obj.getAction().setId(rs.getInt("id"));
				actionId = rs.getInt("id");
			}
			System.out.println(actionId);
			String updateBookCheckoutQuery = "update checkout set return_date = ?,action_id = ? where book_id = ? and user_id =?;";
			pst = connectionObject.prepareStatement(updateBookCheckoutQuery);
			pst.setDate(1,returnDate);
			pst.setInt(2, actionId);
			pst.setInt(3, getBookId(bookName));
			pst.setInt(4, getIdByUserName(userName));
			pst.executeUpdate();
			
			increaseBookCount(getBookId(bookName));
			
		}catch(Exception e){
			System.out.println(e);
		}

		
	}
	
	//get the list of books
	public List<BookBean> getListOfBooks(){
		List<BookBean> books = new ArrayList<>();
		try{
			Connection connectionObject = DBConnectionObject();
			String query = "select * from book";
			PreparedStatement  pst = connectionObject.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				BookBean book =  new BookBean(rs.getString("book_college_code"), rs.getString("isbn"), rs.getString("title"), 
						rs.getString("author"), rs.getInt("total_available"));
				books.add(book);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return books;

	}
	
	//get list of students fined
	public List<BookList> getStudentsFined(){
		BookList book = new BookList();
		UserBean user = new UserBean();
		BookCheckoutBean ck = new BookCheckoutBean();
		BookBean b = new BookBean();
		List<BookList> books = new ArrayList<>();
		
		
		try{
			Connection connectionObject = DBConnectionObject();
			String query = "select u.first_name,b.title,c.due_date,c.checkout_date from user u "
					+ "inner join checkout c on u.id = c.user_id "
					+ "inner join book b on  c.book_id = b.id where c.return_date is  null;";
			PreparedStatement  pst = connectionObject.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				book.getUser().setFirstName(rs.getString("u.first_name"));
				book.getBook().setBookTitle(rs.getString("b.title"));
				book.getCheckedbook().setDueDate(rs.getDate("c.due_date"));
				book.getCheckedbook().setCheckoutDate(rs.getDate("c.checkout_date"));
				books.add(book);
			}
		}catch(Exception e){
			e.printStackTrace();
//			System.out.println(e);
		}
		return books;
	}
	
	//username listing for advisor and students
	public List<String> getUserNames(String email){
		List <String> userNames= new ArrayList<>();
		try{

			Connection connectionObject = DBConnectionObject();			
			PreparedStatement ps = connectionObject.prepareStatement("select first_name from user u inner join advisor_student_mapping a"
					+ " on a.student_id = u.id  where faculty_id = ?;");
			ps.setInt(1, getUserId(email));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userNames.add(rs.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return userNames;	
	}
	
	public List<String> getAdvisorNames(String email){
		List <String> userNames= new ArrayList<>();
		try{

			Connection connectionObject = DBConnectionObject();			
			PreparedStatement ps = connectionObject.prepareStatement("select first_name from user u inner join advisor_student_mapping a"
					+ " on a.faculty_id = u.id  where student_id = ?;");
			ps.setInt(1, getUserId(email));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userNames.add(rs.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return userNames;	
	}
	
	//coursename listing for the advisor
	public List<String> getCourseNames(String email){
		List <String> courseNames= new ArrayList<>();
		try{

			Connection connectionObject = DBConnectionObject();			
			PreparedStatement ps = connectionObject.prepareStatement("select name from course c inner join user_course_mapping u"
					+ " on u.course_id = c.id  where faculty_id = ?;");
			ps.setInt(1, getUserId(email));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				courseNames.add(rs.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return courseNames;	
	}
	
	//course listing for student
	public List<String> getStudentCourseList(String email){
		List <String> courseNames= new ArrayList<>();
		try{

			Connection connectionObject = DBConnectionObject();			
			PreparedStatement ps = connectionObject.prepareStatement("select c.name from course c inner join student_course_mapping u"
					+ " on u.course_id = c.id  where student_id = ?;");
			ps.setInt(1, getUserId(email));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				courseNames.add(rs.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return courseNames;	
	}
	
	//check credentials
	public int checkCredentials(String email,String password){
		int typeId = 0;
		try{
			
			Connection connectionObject = DBConnectionObject();			
			PreparedStatement ps = connectionObject.prepareStatement("select type_id from user where email=? and password=?;");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				typeId = rs.getInt(1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return typeId;	
	}
	
	public int getIdByUserName(String name){


		int userId=0;
		try{
		Connection connectionObject = DBConnectionObject();
		String getTypeIdQuery = "select id from user where first_name = ?;";
		PreparedStatement pst = connectionObject.prepareStatement(getTypeIdQuery);
		pst.setString(1,name);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
		userId= rs.getInt("id");
		}


		}catch(Exception e){

		}
		
		return userId;
		}
	
	//available count of a book
	private int getBookCount(int id){
		int count = 0;
		try{
			Connection connectionObject = DBConnectionObject();
			String query = "select total_available from book where id = ?";
			PreparedStatement  pst = connectionObject.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				count = rs.getInt("total_available");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return count;

	}
	
	private void decreaseBookCount(int id){
		try{
			Connection connectionObject = DBConnectionObject();
			String query = "update book set total_available= ? where id = ?";
			PreparedStatement  pst = connectionObject.prepareStatement(query);
			pst.setInt(1, (getBookCount(id)-1));
			pst.setInt(2, id);
			pst.executeUpdate();
	}catch(Exception e){
		System.out.println(e);
	}
		
	}
	
	private void increaseBookCount(int id){
		try{
			Connection connectionObject = DBConnectionObject();
			String query = "update book set total_available = ? where id = ?";
			PreparedStatement  pst = connectionObject.prepareStatement(query);
			pst.setInt(1, (getBookCount(id)+1));
			pst.setInt(2, id);
			pst.executeUpdate();
	}catch(Exception e){
		System.out.println(e);
	}
		
	}
	
	private int getBookCheckoutCountOfStudent(int id){
		int count = 0;
		try{
			Connection connectionObject = DBConnectionObject();
			String query = "select count(book_id) from checkout where user_id = ?;";
			PreparedStatement  pst = connectionObject.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
	}catch(Exception e){
		System.out.println(e);
	}
		return count;
	}
	
	private int getCourseCountofStudent(int id){
		int count = 0;
		try{
			Connection connectionObject = DBConnectionObject();
			String query = "select count(course_id) from student_course_mapping  where student_id = ?;";
			PreparedStatement  pst = connectionObject.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
	}catch(Exception e){
		System.out.println(e);
	}
		return count;
	}
	
	
	private Connection DBConnectionObject(){
		// creates a database connection object
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/librarymangement","root","root"); 
			connection = con;
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println(connection);
		return connection;
		
	}
	private int getTypeId(UserType type){
		String usertype = type.toString();
		System.out.println(usertype);
		int typeId=0;
		try{
			Connection connectionObject = DBConnectionObject();
			String getTypeIdQuery = "select id from user_type where name = ?;";
			PreparedStatement pst = connectionObject.prepareStatement(getTypeIdQuery);
			pst.setString(1,usertype);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				typeId= rs.getInt("id");
			}
			
			
		}catch(Exception e){
			
		}
		System.out.println(typeId);
		return typeId;
	}
	
	public int getUserId(String email){
		
		int userId=0;
		try{
			Connection connectionObject = DBConnectionObject();
			String getTypeIdQuery = "select id from user where email = ?;";
			PreparedStatement pst = connectionObject.prepareStatement(getTypeIdQuery);
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				userId= rs.getInt("id");
			}
			
			
		}catch(Exception e){
			
		}
		//System.out.println(typeId);
		return userId;
	}
	
	public int getBookId(String bookName){
		
		int bookId=0;
		try{
			Connection connectionObject = DBConnectionObject();
			String getTypeIdQuery = "select id from book where title = ?;";
			PreparedStatement pst = connectionObject.prepareStatement(getTypeIdQuery);
			pst.setString(1, bookName);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				bookId= rs.getInt("id");
			}
			
			
		}catch(Exception e){
			
		}
		//System.out.println(typeId);
		return bookId;
	}
	
	private int getCourseId(String courseName){
		
		int courseId=0;
		try{
			Connection connectionObject = DBConnectionObject();
			String getTypeIdQuery = "select id from course where name = ?;";
			PreparedStatement pst = connectionObject.prepareStatement(getTypeIdQuery);
			pst.setString(1, courseName);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				courseId= rs.getInt("id");
			}
			
			
		}catch(Exception e){
			
		}
		//System.out.println(typeId);
		return courseId;
	}
	
	private Date getDueDate(String userName, String bookName ){
		Date date = new Date();
		try{
			Connection connectionObject = DBConnectionObject();
			String getTypeIdQuery = "select due_date from checkout where book_id = ? and user_id=?;";
			PreparedStatement pst = connectionObject.prepareStatement(getTypeIdQuery);
			pst.setInt(1, getBookId(bookName));
			pst.setInt(2, getIdByUserName(userName));
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				date= rs.getDate("due_date");
			}
			
			
		}catch(Exception e){
			
		}
		//System.out.println(typeId);
		return date;
		
	}
	public List getUserList(){

		List <String>userList = new ArrayList<>();


		try{

		Connection connectionObject = DBConnectionObject();

		String getTypeIdQuery = "select * from user;";

		PreparedStatement pst = connectionObject.prepareStatement(getTypeIdQuery);

		ResultSet rs=pst.executeQuery();

		while(rs.next()){

//		output= rs.getString("email");

		userList.add(rs.getString("email"));

		}

		}catch(Exception e){

		}

		//System.out.println(typeId);

		return userList;

		}
	

}
