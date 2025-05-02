package edu.mu.maven.AdoptMeGroup23;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.mu.maven.Model.Pet;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.io.IOException;


public class App {
    public static void main(String[] args) {
    
    List<Pet> pet = new ArrayList<>();
    GsonBuilder gsonBuilder = new GsonBuilder();
    		gsonBuilder.registerTypeAdapter(Pet.class, new PetInstanceCreator());
    		.create();
      
	try {
		String directory = System.getProperty("user.dir");
		String filePath =  directory  + File.separator + "src" + File.separator + "main"
				+ File.separator + "java" + File.separator + "resources" + File.separator
				+ "pets.json";
	   BufferedReader br = new BufferedReader(new FileReader(filePath));
	   Type type = new TypeToken<ArrayList<Pet>>() {}.getType(); //it could be the gettype
	   pet = gson.fromJson(br, type);
	   System.out.println(pet);
	   System.out.println(pet.get(0).GetName());
	   br.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    }
}

//the value fields should be passed as strings and then cast back 
//try the adapter

