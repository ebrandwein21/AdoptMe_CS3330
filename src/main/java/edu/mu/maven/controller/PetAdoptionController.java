package edu.mu.maven.controller;

import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Shelter;
import edu.mu.maven.view.AddPetView;
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
	}
	
	public void initView() {
		view.setVisible(true);
		for(int j = 1; j < petList.size(); j++) {
			view.getTable().setValueAt(petList.get(j-1).GetName(), j, 0);
			}
		int j = 0;
		for(int i = petList.size(); i < (petList.size() + exoticPetList.size()); i++) {
				view.getTable().setValueAt(exoticPetList.get(j).GetAnimalName(), i, 0);
				j++;
			}
		
		}
	
	public void initController() {
		
		
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
		initView();
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
		//method to be called to populate table 
	}

	public void save() { //a file is saving, however, for now it is an empty list 
		PetLoader.savePets(petList);
		ExoticAnimalJson.saveExotic(exoticPetList);
		
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
		
		AddPetView newPet = new AddPetView();
		newPet.getAddPetBtn().addActionListener(e -> {
			int exoticId = 7;
			String name = newPet.getNameField().getText();
			String animal = newPet.getAnimalField().getText();
			String species = newPet.getSpeciesField().getText();
			int age = Integer.parseInt(newPet.getAgeField().getText());
			ExoticAnimal pet = new ExoticAnimal(String.valueOf(exoticId), name, animal, species, age);
			exoticPetList.add(pet);
			view.getTable().setValueAt(pet.GetAnimalName(), (exoticPetList.size() + petList.size()) -1, 0);
		});
		return newPet;

	}

	private void adoptPet() {
		//Changes specific pet's information to "adopted" and removes ability to adopt this animal
	}
	public void initiate() {
		view.setVisible(true);
	}
}