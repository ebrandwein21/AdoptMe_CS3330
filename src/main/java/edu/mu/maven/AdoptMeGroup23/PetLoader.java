package edu.mu.maven.AdoptMeGroup23;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import edu.mu.maven.Model.Cat;
import edu.mu.maven.Model.Dog;
import edu.mu.maven.Model.ExoticAnimal;
import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Rabbit;
import edu.mu.maven.view.GUIView;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.io.IOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PetLoader
{
	/**
	 * loads a list of pets from the pets.json file located in the resources folder of our program, parses and deserializes a group of pet objects
	 * loops through a pet field in pet array and assigns the fromJson object based on the pet type, an illegal arg exception is thrown if the type is unknown
	 * the pets are then added to a petlist and a file not found exception is called if the file is not valid
	 * @return the list of pets the object is stored in
	 */
	   public static List<Pet> loadPets()
	   {
	    Gson gson = new Gson();
        List<Pet> petList = new ArrayList<>();
      
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
		}
		
	    else if(type.equals("Cat"))
		{
			pet = gson.fromJson(petObject, Cat.class);
		}
	    else if(type.equals("Rabbit"))
		{
			pet = gson.fromJson(petObject, Rabbit.class);			
		}else 
		{
			throw new IllegalArgumentException("Unknown pet type: " + type);	
	    }
	   
		petList.add(pet);
		}	
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}   
	 return petList;
  }
}
