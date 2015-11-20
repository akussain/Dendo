package Models;

import java.util.Date;

public class User {
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String phone;
	private String imageUrl;
	private Date birthDate;
	private Date registredDate;
	
	public User() {}
	
	public User(String uName, String fName, String lName, String password, String email, String phone, String imageUrl, Date birthDate) {
		this.userName = uName;
		this.firstName = fName;
		this.lastName = lName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.birthDate = birthDate;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getRegistredDate() {
		return registredDate;
	}

	public void setRegistredDate(Date registredDate) {
		this.registredDate = registredDate;
	}
	
}
