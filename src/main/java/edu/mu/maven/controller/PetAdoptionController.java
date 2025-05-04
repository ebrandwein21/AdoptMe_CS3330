package edu.mu.maven.controller;

import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Shelter;
import edu.mu.maven.view.GUIView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import edu.mu.maven.AdoptMeGroup23.ExoticAnimalJson;
import edu.mu.maven.AdoptMeGroup23.PetLoader;
import edu.mu.maven.Model.AgeComparator;
import edu.mu.maven.Model.ExoticAnimal;
import edu.mu.maven.Model.SpeciesComparator;

public class PetAdoptionController{
	
	private List<Pet> petList = new ArrayList<>();
	private List<ExoticAnimal> exoticPetList = new ArrayList<>();
	private Shelter<Pet> model;
	private GUIView view;
	
	public PetAdoptionController(Shelter<Pet> m, GUIView v){
		model = m;
		view = v;
		this.initController();
	}
	
	private void initController() {
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
		    }
		});
	}
	
	private void speciesSort() {
		Collections.sort(petList, new SpeciesComparator());
		//feels like there is something we have to call to actually initiate view
	}

	private void ageSort() {
		Collections.sort(petList, new AgeComparator());
		//feels like there is something we have to call to actually initiate view
	}

	private void nameSort() {
		Collections.sort(petList); 
		//feels like there is something we have to call to actually initiate view			
	}

	    public void view() {
		petList = PetLoader.loadPets();
		exoticPetList = ExoticAnimalJson.loadExoticAnimal();
		
		
		
	}

	public void save() { //a file is saving, however, for now it is an empty list 
				
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

	private Object removePet() {
		// TODO Auto-generated method stub
		//Remove specific pet from list
		return null;
	}

	private Object addPet() {
		// TODO Auto-generated method stub
		//Add pet to list
		//Prompt user with new window to enter pet's information
		return null;
	}

	private void adoptPet() {
		//Changes specific pet's information to "adopted" and removes ability to adopt this animal
	}
	public void initiate() {
		view.setVisible(true);
	}
}