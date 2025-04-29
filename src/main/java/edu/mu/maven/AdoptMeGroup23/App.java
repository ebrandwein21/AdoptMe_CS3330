package edu.mu.maven.AdoptMeGroup23;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
        System.out.println("Hello World!");
        
        String directory = System.getProperty("user.dir");
		String filePath =  directory  + File.separator + "AdoptMe_CS3330" + File.separator + "src" + File.separator + "main"
				+ File.separator + "java" + File.separator + "resources" + File.separator
				+ "pets.json";
        Gson gson = new Gson();
        
        try {
			FileReader fr = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

       
    }
}
