package com.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class Library {
	private final int MAX_USER_NUMBER = 30;
	private final int MAX_BOOK_NUMBER = 100;
	private String dataAdress; // DEPRECATED
//	private Path dataPath;
	
	private User[] users = new User[MAX_USER_NUMBER];
	private Book[] books = new Book[MAX_BOOK_NUMBER];
	
	Library(String address) throws IOException, ClassNotFoundException{
		this.dataAdress = address; // DEPRECATED
//		Path path = Paths.get(address).toRealPath(LinkOption.NOFOLLOW_LINKS);
		Path path = Paths.get(address);
//		this.dataPath = path;
		
		File f = new File(address);
		if(f.exists() && !f.isDirectory()){
			
			FileInputStream fis = new FileInputStream(address);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object[][] restoreArr = (Object[][]) ois.readObject();
			
			this.users = (User[]) restoreArr[0];
			this.books = (Book[]) restoreArr[1];
			
		}else{
			System.out.println("Library is empty.");
			System.out.println("");
		}
		
		
		
		/*
		 * 
		 * 
		 * 
		 * Делать бэкап базы
		 * Удалить базу
		 * 
		 * */
		
	}
	
	
	public static void readFile(){
		
	}
	
	public void loadFish(){
		
		books[findOutOrderNumber(books)] = new Book("HTML5","Remy Sharp", 2012);  
		books[findOutOrderNumber(books)] = new Book("PHP","Robin Nixon", 2011); 
		books[findOutOrderNumber(books)] = new Book("Java","Herbert Schildt", 2013); 
		books[findOutOrderNumber(books)] = new Book("SQL","Ben Forta", 2009); 
		books[findOutOrderNumber(books)] = new Book("The Scarlet Letter","Nathaniel Hawthorne", 1984); 
		books[findOutOrderNumber(books)] = new Book("Of Mice and Men","John Steinbeck", 1937); 
		books[findOutOrderNumber(books)] = new Book("Little Women","Louisa May Alcott", 1968); 
		books[findOutOrderNumber(books)] = new Book("The Grapes of Wrath","John Steinbeck", 1977); 
		books[findOutOrderNumber(books)] = new Book("The Sun Also Rises","Ernest Hemingway", 1956); 
		books[findOutOrderNumber(books)] = new Book("The Bell Jar","Sylvia Plath", 1963); 
		books[findOutOrderNumber(books)] = new Book("A Farewell to Arms","Ernest Hemingway", 1989); 
		books[findOutOrderNumber(books)] = new Book("Invisible Man","Ralph Ellison", 1952); 
		books[findOutOrderNumber(books)] = new Book("The Call of the Wild","Jack London", 1973); 
		books[findOutOrderNumber(books)] = new Book("East of Eden","John Steinbeck", 1983); 
		books[findOutOrderNumber(books)] = new Book("Animal Farm","George Orwell", 1975); 
		books[findOutOrderNumber(books)] = new Book("As I Lay Dying","William Faulkner", 1970); 
		
		users[findOutOrderNumber(users)] = new Student("Vasya Pupkin", 445533);
		users[findOutOrderNumber(users)] = new Professor("David Gassner", "Economics");
		users[findOutOrderNumber(users)] = new Professor("Bill Veinman", "Psychology");
		users[findOutOrderNumber(users)] = new Student("Sasha Sidorov", 657234);
		users[findOutOrderNumber(users)] = new Student("Lenia Petrov", 885453);
		users[findOutOrderNumber(users)] = new Student("Petia Petin", 877656);
		users[findOutOrderNumber(users)] = new Student("Kolia Vasiliev", 312332);
		users[findOutOrderNumber(users)] = new Professor("Simon Allardice", "Technology");
		
		try {
			writeFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void writeFile() throws FileNotFoundException, IOException {
		
		Object[][] bothArrays = new Object[2][];
		
		
		bothArrays[0] = users;
		bothArrays[1] = books;
		
		FileOutputStream fos = new FileOutputStream(this.dataAdress); 
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		
		oos.writeObject(bothArrays);
		oos.flush();
		oos.close();
		System.out.println("Saved!");
		System.out.println("");
		// Destroy temporary array
		Arrays.fill(bothArrays, null);
	}
	
	public void clearDatabase(){
		for(int i=0; i< users.length; i++){
			users[i] = null;
		}
		
		for(int i=0; i< users.length; i++){
			books[i] = null;
		}
		
		try {
			writeFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addUser() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("What kind of user do you want to create?");
		System.out.println("professor of student?");
		
		
		int k = 0;
		do {
			String userType = reader.readLine();
			if (userType.equals("professor")) {
				addProfessor();
				k++;
			} else if (userType.equals("student")) {
				addStudent();
				k++;
			} else {
				System.out.println("Wrong command.");
				System.out.println("Try again!");
			}
		} while (k<1);
		
	}
	
	public void addProfessor() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("name:");
		String name = reader.readLine();
		System.out.println("faculty");
		String faculty = reader.readLine();
		users[findOutOrderNumber(users)] = new Professor(name, faculty);
		
		writeFile();
		showUsers();
	}
	
	public void addStudent() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("name:");
		String name = reader.readLine();
		System.out.println("student number:");
		String studentNumber = reader.readLine();
		users[findOutOrderNumber(users)] = new Student(name, Integer.parseInt(studentNumber));
		
		writeFile();
		showUsers();
		
	}
	
	
	public void addBook() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("title:");
		String title = reader.readLine();
		System.out.println("author:");
		String author = reader.readLine();
		System.out.println("publcation year:");
		int pubYear = Integer.parseInt(reader.readLine());
		
		books[findOutOrderNumber(books)] = new Book(title, author, pubYear);
		// отследить что будет если закончилось место в библиотеке
		writeFile();
		showBooks();
	}
	
	// Возвращает индекс первой пустой ячейки массива
	private static int findOutOrderNumber(Object[] obj) {
		int objNum = 0;
		for(objNum=0; objNum < obj.length; objNum++){
//			System.out.println(arrNum+" => "+books[arrNum][0]);
			if(obj[objNum] == null){
//				System.out.println(arrNum);
				break;
			}
		}
		return objNum;
	}
	
	
//	public void addUser(){
//		
//	}
	
	public void borrowBook() throws IOException{
		showAllData();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int cond = 0;
		do {
			cond++;
			System.out.println("Input USER ID and BOOK ID separated by space");
			System.out.println("Example: 4 12");
			String str = reader.readLine();
			String[] tempArr = str.split(" ");
			int userId = Integer.parseInt(tempArr[0]);
			int bookId = Integer.parseInt(tempArr[1]);
			//		users[Integer.parseInt(tempArr[0])].onBorrow();
			// if the max amount of borrowed books was not reached and there is no borrower
			//		if((users[userId].onBorrow()) && !(books[bookId].getBorrower().equals("nobody"))){
			if ((users[userId].getBorrowedBooks() < (users[userId].checkLimit()))
					&& (books[bookId].getBorrower().equals("nobody"))) {
				//set borrower field for the book
				books[bookId].setBorrower(users[userId].getName());

				users[userId].onBorrow();
				
				writeFile();
				showAllData();
				
			} else {
				System.out.println("SORRY, but:");
				System.out.println("This book was already borrowed");
				System.out.println("or");
				System.out.println("Max available amount of borrowed books was reached by this user");
				System.out.println("Try again!");
				System.out.println("");
				cond--;
			}
		} while (cond < 1);
		
		
	}
	
	public void returnBook() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		showAllData();
		
		System.out.println("Input BOOK ID of book, which you want to return");
		int bookId = Integer.parseInt(reader.readLine());
		String borrowerName = books[bookId].getBorrower();
		for (int i = 0; i < findOutOrderNumber(users)-1; i++) {
//			System.out.println(borrowerName);
//			System.out.println(i + ":" + users[i].getName());
			if(users[i].getName().equals(borrowerName)){
				users[i].onReturn();
			}
		}
		books[bookId].setBorrower("nobody");
		System.out.println("Eshe huy");
		
		writeFile();
//		showUsers();
		showAllData();
	}

	// Adds necessary quantity of spaces
	public static void showTableItem(String s, int c){
		System.out.print(s);
			if(s.length()<c){
				for(int k = s.length(); k<c; k++){
					System.out.print(" ");
				}
			}
	}
	
	public void showAllData(){
		showUsers();
		showBooks();
	}
	
	public void showUsers(){
		
		if(users[0] == null)
			System.out.println("There are no customers of Library");
		else{
			System.out.println("Users of the library:");
			
			// Displays header of Professor data table
			System.out.println("-----");
			System.out.println(" Professors:");
			showTableItem("id", 5);
			showTableItem("Name", 30);
			showTableItem("Faculty", 30);
			showTableItem("Borrowed Books", 10);
			
			System.out.println("");
			for (int i = 0; i < users.length; i++) {
				if(users[i] == null)
					break;
				if(users[i].getStudentNumber().equals("-")){
					// Displays Professors data table
					showTableItem(""+i, 5);
					showTableItem(users[i].getName(), 30);
					showTableItem(users[i].getFaculty(), 30);
					showTableItem(""+users[i].getBorrowedBooks(), 10);
					
					System.out.println();
				}
			}
			
			// Displays header of Student data table
			System.out.println("-----");
			System.out.println(" Students:");
			showTableItem("id", 5);
			showTableItem("Name", 30);
			showTableItem("Number", 15);
			showTableItem("Borrowed Books", 10);
			
			System.out.println("");
			for (int i = 0; i < users.length; i++) {
				if(users[i] == null)
					break;
				if(users[i].getFaculty().equals("-")){
					// Displays student data table
					showTableItem(""+i, 5);
					showTableItem(users[i].getName(), 30);
					showTableItem(""+users[i].getStudentNumber(), 15);
					showTableItem(""+users[i].getBorrowedBooks(), 10);
					
					System.out.println();
				}
			}
			
			
			System.out.println("--------------");
		}
		System.out.println("");
		
		
	}
	
	
	
	public void showBooks(){
		
		if(books[0] == null)
			System.out.println("There are no books in Library");
		else{
			
			System.out.println("Books in the library:");
			
			// Вывожу шапку таблицы
			showTableItem("id", 5);
			showTableItem("Title", 30);
			showTableItem("Author", 30);
			showTableItem("Pub Year", 12);
			showTableItem("Borrower", 30);
			System.out.println("");
			
			for (int j = 0; j < books.length; j++) {
				if(books[j] == null)
					break;
				
				showTableItem(""+j, 5);
				showTableItem(books[j].getTitle(), 30);
				showTableItem(books[j].getAuthor(), 30);
				showTableItem(""+books[j].getPubYear(), 12);
				showTableItem(""+books[j].getBorrower(), 30);
						
				System.out.println();
			}
		}
		System.out.println("");
		
	}
	
}
