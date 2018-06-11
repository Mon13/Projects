package models;

import java.util.Date;

public class BookCheckoutBean {
	
	BookBean book;
	StudentBean student;
	ActionBean action;
	private int id;
	private Date checkoutDate;
	private Date dueDate;
	private Date returnDate;
	
	public BookBean getBook() {
		return book;
	}
	public StudentBean getStudent() {
		return student;
	}
	public int getId() {
		return id;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setBook(BookBean book) {
		this.book = book;
	}
	public void setStudent(StudentBean student) {
		this.student = student;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public ActionBean getAction() {
		return action;
	}
	
	public void setAction(ActionBean action) {
		this.action = action;
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
		BookCheckoutBean other = (BookCheckoutBean) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookCheckoutBean [book=" + book + ", student=" + student + ", id=" + id + ", checkoutDate="
				+ checkoutDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + "]";
	}
	
	
	
	

	
	
	
	

}
