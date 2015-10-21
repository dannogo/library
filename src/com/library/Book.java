package com.library;

import java.io.Serializable;

public class Book implements Serializable{
	public String title;
	private String author;
	private int pubyear;
	private String borrower = "nobody";
//	private 
	
	Book(String title, String author, int pubyear){
		this.title = title;
		this.author = author;
		this.pubyear = pubyear;
	}
	
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	public int getPubYear(){
		return pubyear;
	}
	public String getBorrower(){
		return borrower;
	}
	
	public void setBorrower(String borrower){
		this.borrower = borrower;
	}
	
	public void addBookPrompt(){
		
	}
}
