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
            String details = "\nid: " + pet.GetID() + "\nname: " + pet.GetName() + "\ntype: " + pet.GetType() + "\nspecies: " + pet.GetSpecies() + "\nAge: " + pet.GetAge() + "\nAdopted: " + pet.GetAdopted(); 
			System.out.println("\nPet info: " + details);
		}
		
	    else if(type.equals("Cat"))
		{
			pet = gson.fromJson(petObject, Cat.class);
			String details = "\nid: " + pet.GetID() + "\nname: " + pet.GetName() + "\ntype: " + pet.GetType() + "\nspecies: " + pet.GetSpecies() + "\nAge: " + pet.GetAge() + "\nAdopted: " + pet.GetAdopted(); 
			System.out.println("\nPet info: " + details);
		}
	    else if(type.equals("Rabbit"))
		{
			pet = gson.fromJson(petObject, Rabbit.class);
			String details = "\nid: " + pet.GetID() + "\nname: " + pet.GetName() + "\ntype: " + pet.GetType() + "\nspecies: " + pet.GetSpecies() + "\nAge: " + pet.GetAge() + "\nAdopted: " + pet.GetAdopted(); 
			System.out.println("\nPet info: " + details);
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
	 return petList;
	   
  }
	   public static void savePets(List<Pet> petList)
		{
	    Gson gson = new Gson();
		
		SimpleDateFormat currentTime = new SimpleDateFormat("yyyyMMdd_HHmmss"); 
		String timeStamp = currentTime.format(new Date());
		String fileName = timeStamp + "_pets.json";	
		String directory = System.getProperty("user.dir");
		String filePath =  directory  + File.separator + "src" + File.separator + "main"
				+ File.separator + "java" + File.separator + "resources" + File.separator +
				fileName;
		
		try(FileWriter timeStampedFile = new FileWriter(filePath))		
		{
			gson.toJson(petList, timeStampedFile);
           System.out.println("Pets saved to " + filePath);
		}catch(IOException e)
		{
           System.err.println("Failed to save pets: " + e.getMessage());
		}
	}
	
	
}
