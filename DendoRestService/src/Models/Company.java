package Models;

import java.util.Date;

public class Company {
	private int id;
	private String name;
	private String desc;
	private Date registredDate;
	
	public Company() {}
	
	public Company(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Date getRegistredDate() {
		return registredDate;
	}
	
	public void setRegistredDate(Date registredDate) {
		this.registredDate = registredDate;
	}
	
	
}
