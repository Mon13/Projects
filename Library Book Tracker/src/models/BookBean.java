package models;

/**
 * 
 * @author Somsunder Gowda
 * The BookBean POJO stores the book details
 *
 */

public class BookBean {
	
	private Integer id;
	private String bookCollegeCode;
	private String isbn;
	private String title;
	private String author;
	private Integer totalAvailable;
	//private AvailableStatus status;
	
	
	
	public BookBean(String bookCollegeCode, String isbn, String title, String author, int totalAvailable) {
		super();
		this.bookCollegeCode = bookCollegeCode;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.totalAvailable = totalAvailable;
	}
	
	public BookBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public enum AvailableStatus{
		AVALIABLE,UNAVALIABLE
	}

	public Integer getId() {
		return id;
	}

	public String getSchoolGeneratedId() {
		return bookCollegeCode;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getBookTitle() {
		return title;
	}

	public String getBookAuthor() {
		return author;
	}

	public Integer getNoOfCopies() {
		return totalAvailable;
	}

//	public AvailableStatus getStatus() {
//		return status;
//	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSchoolGeneratedId(String schoolGeneratedId) {
		this.bookCollegeCode = schoolGeneratedId;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setBookTitle(String bookTitle) {
		this.title = bookTitle;
	}

	public void setBookAuthor(String bookAuthor) {
		this.author = bookAuthor;
	}

	public void setNoOfCopies(Integer noOfCopies) {
		this.totalAvailable = noOfCopies;
	}

//	public void setStatus(AvailableStatus status) {
//		this.status = status;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((bookCollegeCode == null) ? 0 : bookCollegeCode.hashCode());
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
		BookBean other = (BookBean) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (bookCollegeCode == null) {
			if (other.bookCollegeCode != null)
				return false;
		} else if (!bookCollegeCode.equals(other.bookCollegeCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookBean [id=" + id + ", schoolGeneratedId=" + bookCollegeCode + ", isbn=" + isbn + ", title="
				+ title + ", author=" + author + ", totalAvailable=" + totalAvailable + "]";
	}
	
	
	
	

}
