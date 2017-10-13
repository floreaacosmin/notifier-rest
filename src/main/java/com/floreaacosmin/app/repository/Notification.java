package com.floreaacosmin.app.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notification {

	@Id
	@GeneratedValue
    private Long id;
    
    private String name;
    private String content;
    private String date;
    private String author;
    private String imageUrl;
    
	public Notification() {
		super();
	}

	public Notification(String name, String content, String date, String author, String imageUrl) {
		super();
		this.name = name;
		this.content = content;
		this.date = date;
		this.author = author;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", name=" + name + ", content=" + content + ", date=" + date + ", author="
				+ author + ", imageUrl=" + imageUrl + "]";
	}
}
