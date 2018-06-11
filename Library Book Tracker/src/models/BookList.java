package models;

public class BookList {
	private UserBean user;
	private BookBean book;
	private BookCheckoutBean checkedbook;
	
	public BookList() {
		user = new UserBean();
		book = new BookBean();
		checkedbook = new BookCheckoutBean();
	}
	
	public UserBean getUser() {
		return user;
	}
	public BookBean getBook() {
		return book;
	}
	public BookCheckoutBean getCheckedbook() {
		return checkedbook;
	}
	public void setBook(BookBean book) {
		this.book = book;
	}
	public void setCheckedbook(BookCheckoutBean checkedbook) {
		this.checkedbook = checkedbook;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "BookList [user=" + user + ", book=" + book + ", checkedbook=" + checkedbook + "]";
	}
	

}
