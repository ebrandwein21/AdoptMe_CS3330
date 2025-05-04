package edu.mu.maven.AdoptMeGroup23;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import edu.mu.maven.Model.Cat;
import edu.mu.maven.Model.Dog;
import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Rabbit;

import edu.mu.maven.view.GUIView;

import edu.mu.maven.Model.Shelter;
import edu.mu.maven.controller.PetAdoptionController;
import edu.mu.maven.view.GUIView;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import java.lang.reflect.Type;
import java.io.IOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class App {
    public static void main(String[] args) {
    Gson gson = new Gson();
    List<Pet> petList = new ArrayList<>();
	GUIView gui = new GUIView();
	
	try {
		String directory = System.getProperty("user.dir");
		String filePath =  directory  + File.separator + "src" + File.separator + "main"
				+ File.separator + "java" + File.separator + "resources" + File.separator
				+ "pets.json";
		JsonElement fileElement = JsonParser.parseReader(new FileReader(filePath));
	    JsonArray petArray = fileElement.getAsJsonArray();
	    
		for(JsonElement petField : petArray)
		{
			
	    JsonObject petObject = petField.getAsJsonObject();
	    
	    int id = petObject.get("id").getAsInt();
	    String name = petObject.get("name").getAsString();
	    String type = petObject.get("type").getAsString();
	    String species = petObject.get("species").getAsString();
	    int age = petObject.get("age").getAsInt();
	    boolean adopted = petObject.get("adopted").getAsBoolean();
	     
	    Pet pet = null;
	    if(type.equals("Dog"))
		{
            pet = gson.fromJson(petObject, Dog.class);
			System.out.println("Pet added: " + pet.GetName());
		}
		
	    else if(type.equals("Cat"))
		{
			pet = gson.fromJson(petObject, Cat.class);
			System.out.println("Pet added: " + pet.GetName());
		}
	    else if(type.equals("Rabbit"))
		{
			pet = gson.fromJson(petObject, Rabbit.class);
			System.out.println("Pet added: " + pet.GetName());
		}else 
		{
			throw new IllegalArgumentException("Unknown pet type: " + type);	
	    }
		petList.add(pet);
        System.out.println("Added pet: " + pet.GetName());
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {
    			PetAdoptionController controller = new PetAdoptionController(new Shelter<>(), new GUIView());
    	     	controller.initiate();
    	     	controller.save();
    	     	controller.view();
    	}
    });
    }
}
