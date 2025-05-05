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
import edu.mu.maven.Model.ExoticPetAdapter;
import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Rabbit;

import edu.mu.maven.view.GUIView;

import edu.mu.maven.Model.Shelter;
import edu.mu.maven.controller.PetAdoptionController;
import edu.mu.maven.view.GUIView;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.SwingUtilities;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.io.IOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class App {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {
    			GUIView view = new GUIView();
    			PetAdoptionController controller = new PetAdoptionController(new Shelter<>(), new GUIView());
    	     	controller.save();
    	     	controller.view();
    	     	controller.initController();	     	
    	}
    });
  }
    
    /**
     * this method combines the two pet loaders, ExoticAnimaljson and the petloader into one common list
     * It does this by initiating a new pet list and adding all the pets from the load pets method 
     * the list of exotic animals from the exotic animal json file loader are then looped over 
     * the elements of the exotic animal list are then passed through a new instance of the exotic animal adapter and added to the arrayList
     * 
     * @return the new combined list of both pet and exotic pet types, exotic pets are able to be added due to the exotic pet adapter
     */
    public static List<Pet> combineLoaders()
    {
    	List<Pet> combinedPetList = new ArrayList<>();
    	List<Pet> petList = PetLoader.loadPets();
    	combinedPetList.addAll(petList);
    	List<ExoticAnimal> exoticAnimalList = ExoticAnimalJson.loadExoticAnimal();
    		{
    		for(ExoticAnimal exoticPet : exoticAnimalList)
    		{
    		    Pet exoticPetTransfer = new ExoticPetAdapter(exoticPet);
    		    combinedPetList.add(exoticPetTransfer);  
    		}
    	}
    		return combinedPetList;	
    }
    
    /**
     * this method initiates a new file with the current date/month and time of the pets list by writing to a file path in the resource folder
     * @param combineLoaders - the list of pet objects to be saved
     */
    
    public static void savedCombinedLoaders(List<Pet> combineLoaders)
    {
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
   				gson.toJson(combineLoaders, timeStampedFile);
   	            System.out.println("Pets saved to " + filePath);
   			}catch(IOException e)
   			{
   	            System.err.println("Failed to save pets: " + e.getMessage());
   			}
   		}
    } 
}
