package org.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_details")
public class BookDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="book_name",nullable = false)
	private String name;
	
	@Column(name="author_name",nullable = false)
	private String author_name;
	
	@Column(name="author_email",nullable = false)
	private String author_email;
	
	@Column(name="published_date",nullable=false)
	private Date published_date;
	
	@Column(name="book_genre",nullable = false)
	private String genre;
	
	public BookDetails() {
		super();
	}


	public BookDetails(String name, String author_name,String author_email, Date published_date, String genre) {
		super();
		this.name = name;
		this.author_name = author_name;
		this.author_email=author_email;
		this.published_date = published_date;
		this.genre = genre;
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


	public String getAuthor_name() {
		return author_name;
	}


	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}


	public Date getPublished_date() {
		return published_date;
	}


	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getId() {
		return id;
	}
	
	


	public String getAuthor_email() {
		return author_email;
	}


	public void setAuthor_email(String author_email) {
		this.author_email = author_email;
	}


	@Override
	public String toString() {
		return "BookDetails [id=" + id + ", name=" + name + ", author_name=" + author_name + ", author_email="
				+ author_email + ", published_date=" + published_date + ", genre=" + genre + "]";
	}


	
	
	
	
	

}
