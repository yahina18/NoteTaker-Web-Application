package com.Entites;

import java.util.Date;
import java.util.Random;

import javax.persistence.*;

@Entity
public class NoteTaker {
	
@Id private int id;
private String title;
@Column(length=1500)private String Content;
private Date AddDate;


public NoteTaker(String title, String content, Date addDate) {
	super();
	this.id = new Random().nextInt(10000);
	this.title = title;
	Content = content;
	AddDate = addDate;
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


public String getContent() {
	return Content;
}


public void setContent(String content) {
	Content = content;
}


public Date getAddDate() {
	return AddDate;
}


public void setAddDate(Date addDate) {
	AddDate = addDate;
}


public NoteTaker() {
	super();
	// TODO Auto-generated constructor stub
}

}
