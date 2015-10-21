package com.library;

public class Student extends User {
	private String studentNumber;
	private static final int MAX_BORROWED_BOOKS = 2;
	
	Student(String name, int studentNumber){
		this.name = name;
		this.studentNumber = ""+studentNumber;
	}
	
	@Override
	public String getFaculty(){
		return "-";
	}
	
	@Override
	public String getStudentNumber(){
		return this.studentNumber;
	}
	
	public int checkLimit(){
		return MAX_BORROWED_BOOKS;
	}
	
	
//	@Override
//	public boolean onBorrow() {
//		if(this.borrowedBooks < MAX_BORROWED_BOOKS){
//			super.onBorrow();
//			return true;
//		}else{
//			System.out.println("Max available amount of borrowed books was already reached by this student.");
//			System.out.println("");
//			return false;
//		}
//	}	
	
}
