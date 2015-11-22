package Models;

import java.util.Date;

public class Comment {
	private int id;
	private String text;
	private Date createdDate;
	
	public Comment() {}
	
	public Comment(String text) {
		this.setText(text);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
