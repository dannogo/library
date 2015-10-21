package com.library;

public class Professor extends User {
	private String faculty;
	private static final int MAX_BORROWED_BOOKS = 5;
	
	Professor(String name, String faculty){
		this.name = name;
		this.faculty = faculty;
	}
	
//	public String getStudentNumber(){
//		return "-";
//	}
	
//	@Override
//	public boolean onBorrow() {
//		if(this.borrowedBooks < MAX_BORROWED_BOOKS){
//			super.onBorrow();
//			return true;
//		}else{
//			System.out.println("Max available amount of borrowed books was already reached by this professor.");
//			return false;
//		}
//	}
	
	public int checkLimit(){
		return MAX_BORROWED_BOOKS;
	}
	
	public String getFaculty(){
		return this.faculty;
	}
	
	
	
}
