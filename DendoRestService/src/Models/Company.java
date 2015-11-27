package Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Entity
@Table(name = "companies")
public class Company {
	private int id;
	private String name;
	private String desc;
	private Date registredDate;
	private String logo_url;
	private Category companyCategory;
	
	public Company() {}
	
	public Company(String name, String desc, String logo_url, Category companyCategory) {
		this.name = name;
		this.desc = desc;
		this.setLogo_url(logo_url);
		this.setCompanyCategory(companyCategory);
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
	
	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "description", nullable = false, length = 50)
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Column(name = "date_registred", nullable = false)
	public Date getRegistredDate() {
		return registredDate;
	}
	
	public void setRegistredDate(Date registredDate) {
		this.registredDate = registredDate;
	}
	
	@Column(name = "logo_url", nullable = false, length = 100)
	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	public Category getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(Category companyCategory) {
		this.companyCategory = companyCategory;
	}
	
	
}
