package edu.mu.maven.controller;

import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Shelter;
import edu.mu.maven.view.GUIView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.mu.maven.Model.AgeComparator;
import edu.mu.maven.Model.SpeciesComparator;

public class PetAdoptionController{
	
	private List<Pet> petList = new ArrayList<>();
	private Shelter<Pet> model;
	private GUIView view;
	
	public PetAdoptionController(Shelter<Pet> m, GUIView v){
		model = m;
		view = v;
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

	private Object view() {
		// TODO Auto-generated method stub
		//Open a window with the selected pet's information
		return null;
	}

	private Object save() {
		// TODO Auto-generated method stub
		//Update pets.json / exotic_animals.json to reflect GUI list
		return null;
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