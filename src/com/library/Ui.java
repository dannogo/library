package com.library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ui {

	public static void main (String[] args) {
		try {
			Library lib = new Library("data/db.txt");
			
			mainPrompt(lib);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Файл базы данных не найден");
			e.printStackTrace();
		}
		
	}
	

	// Выводит в консоль список доступных команд, и возвращает введенную пользователем
	public static String getUserCommand(){
		
		String resString="";
		
		// Вывожу в консоль список доступных команд
		System.out.println("ACTION LIST. Input to start:");
		System.out.println("load fish");
		System.out.println("clear db");
		System.out.println("show users");
		System.out.println("show books");
		System.out.println("show all data");
		System.out.println("add user");
		System.out.println("add book");
		System.out.println("borrow book");
		System.out.println("return book");
		
		// Принимаю команду пользователя
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("");
		
		try {
			 resString = reader.readLine();
		} catch (IOException e) {
			System.out.println("Команда от пользователя не получена");
			e.printStackTrace();
		}
		return resString;
		
	}
	
	// Запускает метод, соответствующий команде пользователя. Если команда не правильная перезапрашивает ее 
	public static void mainPrompt(Library lib) throws IOException, FileNotFoundException{
		
		boolean condition = true;
		do {
			
			switch (getUserCommand()) {
			case "show users":
				lib.showUsers();
				break;
			case "show books":
				lib.showBooks();
				break;
			case "show all data":
				lib.showAllData();
				break;
			case "add user":
				lib.addUser();
				break;
			case "add book":
				lib.addBook();
				break;
			case "borrow book":
				lib.borrowBook();
				break;
			case "return book":
				lib.returnBook();
				break;
			case "write file":
				lib.writeFile();
				break;
			case "load fish":
				lib.loadFish();
				break;
			case "clear db":
				lib.clearDatabase();
				break;
			default: 
				System.out.println("Wrong command");
				System.out.println("Try again!");
				System.out.println("");
			}
			
		} while (condition);
		
		
		
	}
	
	
}

/*
 * В консоли работает библиотекарь
 * 
 * Books
 * 		id
 * 		title
 * 		author
 * 		pubYear
 * 		borrower
 * 		
 * Users
 * 		id
 * 		type (student, professor)
 * 		borrowedBooks
 * 		name
 * 		studentNumber or faculty
 * 		
 * 		Писать функции так, чтобы они не были привязаны к этому интерфейсу
 * 		При удобном случае показывать список книг и юзеров
 * 		
 * */
