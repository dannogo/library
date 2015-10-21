package com.library;

import java.io.Serializable;

public class User implements Serializable{

	protected int borrowedBooks = 0;
	protected String name;
	
	public void onBorrow(){
		this.borrowedBooks++;
	}
	
	
	public int checkLimit(){
		return 2;
	}
	
	public void onReturn(){
		this.borrowedBooks--;
		
	}
	
	public void addUserPrompt(){
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getBorrowedBooks(){
		return this.borrowedBooks;
	}
	
//	public void setBorrowerBooks(){
//		borrowerBooks--;
//	}
	
	public String getStudentNumber(){
		return "-"; 
	}
	
	public String getFaculty(){
		return "Some String";
	}
	
	
}


/*
 * MAX_BORROWED_BOOKS нужно получать из дочерних классов Student и Professor
 * прочитать еще раз про полиморфизм
 * 
 * 
 * 
 * */
