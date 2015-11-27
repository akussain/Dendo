package Models;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "users")
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
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "username", nullable = false, length = 20)
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "first_name", nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false, length = 50)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "phone", length = 20)
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "date_birth")
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "image_url", length = 100)
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "date_registred")
	public Date getRegistredDate() {
		return registredDate;
	}

	public void setRegistredDate(Date registredDate) {
		this.registredDate = registredDate;
	}
	
}
