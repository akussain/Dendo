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
@Table(name = "comments")
public class Comment {
	private int id;
	private String text;
	private Date createdDate;
	private Discount commentDiscount;
	private User commentUser;
	
	public Comment() {}
	
	public Comment(String text, Discount commentDiscount, User commentUser) {
		this.text = text;
		this.commentDiscount = commentDiscount;
		this.commentUser = commentUser;
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

	@Column(name = "text", nullable = false, length = 200)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "date_created")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "discount_id")
	public Discount getCommentDiscount() {
		return commentDiscount;
	}

	public void setCommentDiscount(Discount commentDiscount) {
		this.commentDiscount = commentDiscount;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	public User getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}

}
