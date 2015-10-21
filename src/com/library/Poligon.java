package com.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Poligon{

	
	public static void main (String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		String s = "";
		for(int i=0; i<10; i++){
			s+="8";
			System.out.println(s);
		}
	}


}
