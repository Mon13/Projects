package models;

/**
 * The UserBean POJO to store different user details
 * 
 * @author Somsunder Gowda
 *
 */

public class UserBean {
	UserBean parent;
	UserBean advisor;
	private Integer id;
	private String firstName;
	private String lastName;
	private String gender;
	private String mail;
	private String password;
	private String phone;
	private UserType type;

	

	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBean(String firstName, String lastName, String gender, String mail, String password,
			String phone, UserType type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.type = type;
	}

	public enum UserType {
		STUDENT, TEACHER, PARENT, ADMIN
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public UserType getType() {
		return type;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserBean other = (UserBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBean [parent=" + parent + ", advisor=" + advisor + ", id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", mail=" + mail + ", password=" + password
				+ ", phone=" + phone + ", type=" + type + "]";
	}



}
