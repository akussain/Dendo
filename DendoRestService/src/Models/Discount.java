package Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "discounts")
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
	private Company discountCompany;
	
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

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false, length = 20)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", nullable = false, length = 100)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "date_created")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "image_url", nullable = false, length = 100)
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "old_price", nullable = false)
	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	@Column(name = "new_price", nullable = false)
	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	@Column(name = "source_portal", length = 50)
	public String getSourcePortal() {
		return sourcePortal;
	}

	public void setSourcePortal(String sourcePortal) {
		this.sourcePortal = sourcePortal;
	}

	@Column(name = "isActive", nullable = false)
	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Column(name = "date_started")
	public Date getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}

	@Column(name = "date_ended")
	public Date getEndedDate() {
		return endedDate;
	}

	public void setEndedDate(Date endedDate) {
		this.endedDate = endedDate;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "comp_id")
	public Company getDiscountCompany() {
		return discountCompany;
	}

	public void setDiscountCompany(Company discountCompany) {
		this.discountCompany = discountCompany;
	}
	
	
}
