package edu.mu.maven.controller;

import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Rabbit;
import edu.mu.maven.Model.Shelter;
import edu.mu.maven.view.AddPetView;
import edu.mu.maven.view.DetailsView;
import edu.mu.maven.view.GUIView;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.mu.maven.AdoptMeGroup23.App;
import edu.mu.maven.AdoptMeGroup23.ExoticAnimalJson;
import edu.mu.maven.AdoptMeGroup23.PetLoader;
import edu.mu.maven.Model.AgeComparator;
import edu.mu.maven.Model.Cat;
import edu.mu.maven.Model.Dog;
import edu.mu.maven.Model.ExoticAnimal;
import edu.mu.maven.Model.ExoticPetAdapter;
import edu.mu.maven.Model.SpeciesComparator;
import edu.mu.maven.Model.IDComparator;
import edu.mu.maven.Model.TypeComparator;



public class PetAdoptionController{
	 
 	private List<Pet> combinedPetList = new ArrayList<>();
 	private List<Pet> petList = new ArrayList<>();
 	private List<ExoticAnimal> exoticPetList = new ArrayList<>();
 	private Shelter<Pet> model;
 	private DefaultTableModel table;
 	private GUIView view;
 	List<Pet> allPets = new ArrayList<>();
    List<Pet> sortedPetList = new ArrayList<>();
 
     /**
      * initializes a new controller to manage the program
      * @param the shelter model that contains the pets
      * @param the view that displays the pets
      */
 	public PetAdoptionController(Shelter<Pet> m, GUIView v){
 		model = m;
 		view = v;
 	}
 	/**
 	 * initView initializes the view GUI component so all pets are visible
 	 * sets pet names in the table 
 	 */
 	public void initView() {
 		view.setVisible(true);
 		for(int j = 1; j < petList.size(); j++) {
 			view.getTable().setValueAt(petList.get(j).GetName(), j, 0);
 			}
 		int j = 0;
 		for(int i = petList.size(); i < (petList.size() + exoticPetList.size()); i++) {
 				view.getTable().setValueAt(exoticPetList.get(j).GetAnimalName(), i, 0);
 				j++;
 			}
 		}
 	/**
 	 * initController initializes the controller and adds Action Listeners to each button,
 	 * allowing them to connect to their corresponding method. It also calls initView.
 	 */
 	public void initController() {
 
 		petList = PetLoader.loadPets();
 		exoticPetList = ExoticAnimalJson.loadExoticAnimal();
 		combinedPetList = App.combineLoaders();
 		view.getBtnAdopt().addActionListener(e -> adoptPet());
 		view.getBtnAdd().addActionListener(e -> addPet());
 		view.getBtnRemove().addActionListener(e -> removePet());
 		view.getBtnSave().addActionListener(e -> save());
 		view.getBtnView().addActionListener(e -> view());
 
 		view.getSortBox().addActionListener(e -> {
 		    String selected = (String) view.getSortBox().getSelectedItem();
 		    switch (selected) {
 		        case "Name":
 		            nameSort();
 		            break;
 		        case "Age":
 		            ageSort();
 		            break;
 		        case "Species":
 		            speciesSort();
 		            break;
 		        case "ID":
 		            idSort();
 		            break;
 		        case "Type":
 		            typeSort();
 		            break;
 		    }
 		});
 		initView();
 	}
 
 	/**
 	 * sorts pet lists by species and then updates the GUI table 
 	 */
 	private void speciesSort() {
 		Collections.sort(combinedPetList, new SpeciesComparator());
 		updateGuiTableForSorting();
 	}
 	/**
 	 * sorts pet lists by age and then updates the GUI table 
 	 */
 	private void ageSort() {
 		Collections.sort(combinedPetList, new AgeComparator());
 		updateGuiTableForSorting();
 	}
 	/**
 	 * sorts pet lists by name and then updates the GUI table 
 	 */
 	private void nameSort() {
 		Collections.sort(combinedPetList); 
 		updateGuiTableForSorting();
 	}
    /**
     * sorts pet list by id and then updates the GUI table
     */
 	private void idSort()
 	{
 		Collections.sort(combinedPetList, new IDComparator());
 		updateGuiTableForSorting();
 	}
 	/**
     * sorts pet list by type and then updates the GUI table
     */
 	private void typeSort()
 	{
 		Collections.sort(combinedPetList, new TypeComparator());
 		updateGuiTableForSorting();
 	}
 
 	/**
 	 * view opens a new window with the details of the selected pet in the table, including type, name, species, age and adoption
 	 */
     public void view() {
 		
 		sortedPetList = readSortingJson();
 
 		if(view.getTable().getSelectedRow() != -1) {
 			System.out.println(exoticPetList.size());
 			int index = view.getTable().getSelectedRow();
 			DetailsView details = new DetailsView();
 
 				details.getPetName().setText(combinedPetList.get(index).GetName());
 				details.getPetType().setText(combinedPetList.get(index).GetType());
 				details.getPetSpecies().setText(combinedPetList.get(index).GetSpecies());
 				details.getPetAge().setText(String.valueOf(combinedPetList.get(index).GetAge()));
 				details.getPetAdopted().setText(String.valueOf(combinedPetList.get(index).GetAdopted()));
 				details.getPetId().setText(String.valueOf(combinedPetList.get(index).GetID()));
 				
 			details.setVisible(true);  
 		}
 	}
 
     /**
      * saves a pet data to the file
      */
 	public void save() { 
 		App.savedCombinedLoaders(combinedPetList);
 	}
 	/**
 	 * removePet removes the pet the user has selected from the pet table and the pet list
 	 */
 	private void removePet() {
 		//Remove specific pet from list
 		int selectedToRemove = view.getTable().getSelectedRow();
 		if(view.getTable().getSelectedRow() != -1) {
 			view.getTableModel().removeRow(selectedToRemove);
 			combinedPetList.remove(selectedToRemove);
 			updateGuiTableForSorting();	
 		}
 	}
 	/**
 	 * addPet takes the information the user inputs into the text fields and adds a new pet with this information and a new pet to the pet list, pet data is then displayed to the table.
 	 */
 	private void addPet() {
 
 		AddPetView newPet = new AddPetView();
 		newPet.getAddPetBtn().addActionListener(e -> {
 			int id = combinedPetList.get((petList.size() - 1)).GetID() + 1;
 			String name = newPet.getNameField().getText();
 			String animal = newPet.getAnimalField().getText();
 			String species = newPet.getSpeciesField().getText();
 			String ageInput = newPet.getAgeField().getText();
 			Integer age = -1;
 			try {
 				age = Integer.parseInt(ageInput);
 			} catch (NumberFormatException e1) {
 
 				System.err.println("Input an integer");
 			}
 			ExoticAnimal pet = new ExoticAnimal(String.valueOf(id), name, animal, species, age);
 			Pet exoticPetTransfer = new ExoticPetAdapter(pet);
 			combinedPetList.add(exoticPetTransfer);
 			DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
 			model.addRow(new Object[]{
 				pet.GetAnimalName()
 			});
 			updateGuiTableForSorting();
 			System.out.println(exoticPetList.size());
 			});
 	}
 /**
  * updates the table to reflect the changes of the pet list after sorting, removing and adding and then clears/repopulates the list with the pet list
  */
 	public void updateGuiTableForSorting()
 	{
 		table = view.getTableModel();
 		table.setRowCount(0);
 
 		for(Pet pet : combinedPetList)
 		{
 			table.addRow(new Object[]{pet.GetName()});
 		}
 
        Gson gson = new Gson();
 
 		String fileName = "sortingTest.json";
 		String directory = System.getProperty("user.dir");
 		String filePath =  directory  + File.separator + "src" + File.separator + "main"
 				+ File.separator + "java" + File.separator + "resources" + File.separator +
 				fileName;
 
 		try(FileWriter sortingWriter = new FileWriter(filePath))		
 		{
 		    gson.toJson(combinedPetList, sortingWriter);
            System.out.println("Pets saved to " + filePath);
 		}catch(IOException e)
 		{
            System.err.println("Failed to save pets: " + e.getMessage());  
 		}
 		combinedPetList = readSortingJson();
 	
 	}	
 	/**
 	 * reads sorted file/list created in updateguitable, this determines the pet type and converts each entry to an object in a new list that is then  used to display changes in the table
 	 * wraps exotic animals using the adapter
 	 * @return a new list of pets called sortedpetlists that the is displayed in the new json file
 	 */
 	public List<Pet> readSortingJson()
 	{
 		sortedPetList.clear();
 		Gson gson = new Gson();
 		String fileName = "sortingTest.json";
 		String directory = System.getProperty("user.dir");
 		String filePath =  directory  + File.separator + "src" + File.separator + "main"
 				+ File.separator + "java" + File.separator + "resources" + File.separator +
 				fileName;
 		 try  {
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
	 		        
	 			    if(type.equals("Dog"))
	 				{
	 			    	sortedPetList.add(gson.fromJson(petObject, Dog.class));
	 				}
	 			    else if(type.equals("Cat"))
	 				{
	 			    	sortedPetList.add(gson.fromJson(petObject, Cat.class));
	 				}
	 			    else if(type.equals("Rabbit"))
	 				{
	 			    	sortedPetList.add(gson.fromJson(petObject, Rabbit.class));	
	 				}else if(type.equals("Bird"))
	 				{
	 					 String exoticId = petObject.get("id").getAsString();
	                     String exoticName = petObject.get("name").getAsString();
	                     String exoticSpecies = petObject.get("species").getAsString();
	                     String exoticCategory = petObject.get("type").getAsString();
	                     int exoticAge = petObject.get("age").getAsInt();
	                     
	                     ExoticAnimal exotic = new ExoticAnimal(exoticId, exoticName, exoticSpecies, exoticCategory, exoticAge);
	                     exotic.setAdopted(petObject.get("adopted").getAsBoolean());
	                     sortedPetList.add(new ExoticPetAdapter(exotic));
 			    }
 				else if(type.equals("Reptile"))
 			    {
 				   String exoticId = petObject.get("id").getAsString();
 		           String exoticName = petObject.get("name").getAsString();
 		           String exoticSpecies = petObject.get("species").getAsString();
 		           String exoticCategory = petObject.get("type").getAsString();
 		           int exoticAge = petObject.get("age").getAsInt();
 		                    
 		           ExoticAnimal exotic = new ExoticAnimal(exoticId, exoticName, exoticSpecies, exoticCategory, exoticAge);
 		           exotic.setAdopted(petObject.get("adopted").getAsBoolean());
 		           sortedPetList.add(new ExoticPetAdapter(exotic));	    
 				}
 				else if(type.equals("Iguana"))
 			    {
 				   String exoticId = petObject.get("id").getAsString();
 		           String exoticName = petObject.get("name").getAsString();
 		           String exoticSpecies = petObject.get("species").getAsString();
 		           String exoticCategory = petObject.get("type").getAsString();
 		           int exoticAge = petObject.get("age").getAsInt();
 		                    
 		           ExoticAnimal exotic = new ExoticAnimal(exoticId, exoticName, exoticSpecies, exoticCategory, exoticAge);
 		           exotic.setAdopted(petObject.get("adopted").getAsBoolean());
 		           sortedPetList.add(new ExoticPetAdapter(exotic));	    
 				}
 				else if(type.equals("Python"))
 			    {
 				   String exoticId = petObject.get("id").getAsString();
 		           String exoticName = petObject.get("name").getAsString();
 		           String exoticSpecies = petObject.get("species").getAsString();
 		           String exoticCategory = petObject.get("type").getAsString();
 		           int exoticAge = petObject.get("age").getAsInt();
 		                    
 		           ExoticAnimal exotic = new ExoticAnimal(exoticId, exoticName, exoticSpecies, exoticCategory, exoticAge);
 		           exotic.setAdopted(petObject.get("adopted").getAsBoolean());
 		           sortedPetList.add(new ExoticPetAdapter(exotic));    
 				}
 				else if(type.equals("Toucan"))
 			    {
 				   String exoticId = petObject.get("id").getAsString();
 		           String exoticName = petObject.get("name").getAsString();
 		           String exoticSpecies = petObject.get("species").getAsString();
 		           String exoticCategory = petObject.get("type").getAsString();
 		           int exoticAge = petObject.get("age").getAsInt();
 		                    
 		           ExoticAnimal exotic = new ExoticAnimal(exoticId, exoticName, exoticSpecies, exoticCategory, exoticAge);
 		           exotic.setAdopted(petObject.get("adopted").getAsBoolean());
 		           sortedPetList.add(new ExoticPetAdapter(exotic));    
 				}
 				else
 				{
 					throw new IllegalArgumentException("Unknown pet type: " + type);	
 				}
 			}
 				System.out.println("Successfully loaded pets from sortingTest.json");
 				}catch (IOException e) {
         System.out.println("Failed to read pets: " + e.getMessage());
         return null;
         }
 		 return sortedPetList;
 	   }
 /**
  * if the selected pet is not adopted, the status is updated, if the pet has been adopted, an error code is displayed to the view
  */
 	private void adoptPet() {
 		int index = view.getTable().getSelectedRow();
 		if(index != -1) {
 			if(combinedPetList.get(index).GetAdopted() != true) {
 				combinedPetList.get(index).SetAdopted(true);
 				updateGuiTableForSorting();	
 			}
 			else {
 				view.getCannotAdopt().setText("Sorry this pet has already been adopted");
 			}
 		}
 	}
}