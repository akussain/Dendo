package Models;

import java.util.Date;

public class Discount {
	private int id;
	private String title;
	private String desc;
	private Date createdDate;
	private String imageUrl;
	private double oldPrice;
	private double newPrice;
	private String sourcePortal;
	private int isActive;
	private Date startedDate;
	private Date endedDate;
	
	public Discount() {}
	
	public Discount(String title, String desc, String imageUrl, double oldPrice, double newPrice, String sourcePortal, int isActive, Date startedDate, Date endedDate) {
		this.setTitle(title);
		this.setDesc(desc);
		this.setImageUrl(imageUrl);
		this.setOldPrice(oldPrice);
		this.setNewPrice(newPrice);
		this.setSourcePortal(sourcePortal);
		this.setIsActive(isActive);
		this.setStartedDate(startedDate);
		this.setEndedDate(endedDate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public String getSourcePortal() {
		return sourcePortal;
	}

	public void setSourcePortal(String sourcePortal) {
		this.sourcePortal = sourcePortal;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Date getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}

	public Date getEndedDate() {
		return endedDate;
	}

	public void setEndedDate(Date endedDate) {
		this.endedDate = endedDate;
	}
	
	
}
