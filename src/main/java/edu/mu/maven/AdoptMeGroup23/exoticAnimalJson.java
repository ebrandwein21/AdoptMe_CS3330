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
import edu.mu.maven.Model.ExoticAnimal;
import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Rabbit;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.io.IOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class exoticAnimalJson
{
	
	public static void main(String[] args) {

	List<ExoticAnimal> exoticPetList = new ArrayList<>();
	Gson gson = new Gson();
	
	try
	{
		String directory = System.getProperty("user.dir");
		String filePath =  directory  + File.separator + "src" + File.separator + "main"
				+ File.separator + "java" + File.separator + "resources" + File.separator
				+ "exotic_animals.json";
		JsonElement fileElement = JsonParser.parseReader(new FileReader(filePath));
	    JsonArray exoticPetArray = fileElement.getAsJsonArray();

	    for(JsonElement exoticPetField : exoticPetArray)
		{
	    	JsonObject exoticPetObject = exoticPetField.getAsJsonObject();
	    	
		    String uniqueId = exoticPetObject.get("uniqueId").getAsString();
		    String animalName = exoticPetObject.get("animalName").getAsString();
		    String category = exoticPetObject.get("category").getAsString();
		    String subSpecies = exoticPetObject.get("subSpecies").getAsString();
		    int yearsOld = exoticPetObject.get("yearsOld").getAsInt();
		    
		    ExoticAnimal exoticPet = null;
		    exoticPet = gson.fromJson(exoticPetObject, ExoticAnimal.class);
		    
		    exoticPetList.add(exoticPet);
		    System.out.println("Added exotic pet: " + exoticPet.GetAnimalName());
		} 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	    
	}
			
}