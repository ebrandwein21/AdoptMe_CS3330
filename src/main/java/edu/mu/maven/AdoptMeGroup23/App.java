package edu.mu.maven.AdoptMeGroup23;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.*;
import edu.mu.maven.Model.Pet;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
    
    List<Pet> pet = new ArrayList<>();
    Gson gson = new Gson();
      
	try {
		String directory = System.getProperty("user.dir");
		String filePath =  directory  + File.separator + "src" + File.separator + "main"
				+ File.separator + "java" + File.separator + "resources" + File.separator
				+ "pets.json";
	   BufferedReader br = new BufferedReader(new FileReader(filePath));
	   JsonArray jsonArray = gson.fromJson(br, JsonArray.class);
	   JsonObject js = jsonArray.getAsJsonObject();
	   int id = js.get("id").getAsInt();
	   String name = js.get("name").getAsString();
	   String type = js.get("type").getAsString();
	   String species = js.get("species").getAsString();
	   int age = js.get("age").getAsInt();
	   boolean adopted = js.get("adopted").getAsBoolean();
	   System.out.println("id: " + id);
	   
	   
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
