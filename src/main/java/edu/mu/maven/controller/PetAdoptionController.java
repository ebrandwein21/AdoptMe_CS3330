package edu.mu.maven.controller;

import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Shelter;
import edu.mu.maven.view.AddPetView;
import edu.mu.maven.view.DetailsView;
import edu.mu.maven.view.GUIView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

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
	private DefaultTableModel table;
	private GUIView view;
	
	public PetAdoptionController(Shelter<Pet> m, GUIView v){
		model = m;
		view = v;
	}
	
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
		updateGuiTableForSorting();
	}

	private void ageSort() {
		Collections.sort(petList, new AgeComparator());
		updateGuiTableForSorting();
	}

	private void nameSort() {
		Collections.sort(petList); 
		updateGuiTableForSorting();
	}

    public void view() {
		petList = PetLoader.loadPets();
		exoticPetList = ExoticAnimalJson.loadExoticAnimal();
		
		if(view.getTable().getSelectedRow() != -1) {
			int index = view.getTable().getSelectedRow();
			DetailsView details = new DetailsView();
			
			if(index < petList.size()) {
				details.getPetName().setText(petList.get(index).GetName());
				details.getPetType().setText(petList.get(index).GetType());
				details.getPetSpecies().setText(petList.get(index).GetSpecies());
				details.getPetAge().setText(String.valueOf(petList.get(index).GetAge()));
				details.getPetAdopted().setText(String.valueOf(petList.get(index).GetName()));
				details.getPetId().setText(String.valueOf(petList.get(index).GetID()));
			}
			else if(index >= petList.size()) {
				index = index - petList.size();
				details.getPetName().setText(exoticPetList.get(index).GetAnimalName());
				details.getPetType().setText(exoticPetList.get(index).GetCategory());
				details.getPetSpecies().setText(exoticPetList.get(index).GetSubSpecies());
				details.getPetAge().setText(String.valueOf(exoticPetList.get(index).GetYearsOld()));
				details.getPetAdopted().setText(String.valueOf(exoticPetList.get(index).isAdopted()));
				details.getPetId().setText(String.valueOf(exoticPetList.get(index).GetUniqueId()));
			}
			details.setVisible(true);  
		}
		//method to be called to populate table 
	}

	public void save() { //a file is saving, however, for now it is an empty list 
		PetLoader.savePets(petList);
		ExoticAnimalJson.saveExotic(exoticPetList);
		
	}

	private Object removePet() {
		//Remove specific pet from list
		if(view.getTable().getSelectedRow() != -1) {
			view.getTableModel().removeRow(view.getTable().getSelectedRow());
		}
		return null;
	}

	private Object addPet() {
		//Add pet to list
		//Prompt user with new window to enter pet's information
		
		AddPetView newPet = new AddPetView();
		newPet.getAddPetBtn().addActionListener(e -> {
			int exoticId = petList.get((petList.size() - 1)).GetID() + 1;
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
	
	public void updateGuiTableForSorting()
	{
		table = view.getTableModel();
		table.setRowCount(0);
		
		for(Pet pet : petList)
		{
			table.addRow(new Object[]{pet.GetName()});
		}
		
		for(ExoticAnimal exoticPet : exoticPetList)
		{
			table.addRow(new Object[]{exoticPet.GetAnimalName()});
		}
	}
		

	private void adoptPet() {
		//Changes specific pet's information to "adopted" and removes ability to adopt this animal
	}
	public void initiate() {
		view.setVisible(true);
	}
}