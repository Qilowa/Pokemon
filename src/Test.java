import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dut.fr.pokemon.Category;

public class Test {

	public static void main(String[] args) {
		System.out.println("Test");
		System.out.println("Test1");
		//test
            	 try (BufferedReader bufferedreader = new BufferedReader(new FileReader("RessourcesPok�mon-20191205/test.txt"))) {
            	      String strCurrentLine;
            	      while ((strCurrentLine = bufferedreader.readLine()) != null) {
            	    	  String[] splited = strCurrentLine.split("/");
            	          for (String part : splited) {
            	              System.out.println(part);
            	          }
            	      }
            	    } catch (IOException ioe) {
            	      ioe.printStackTrace();
            	    }
            	  }

	}
