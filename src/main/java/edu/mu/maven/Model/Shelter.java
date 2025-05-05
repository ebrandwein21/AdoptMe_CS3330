package edu.mu.maven.Model;

import java.util.ArrayList;
import java.util.List;

public class Shelter<T extends Pet>{
	
	private List<T> petList = new ArrayList<>();
	
	/**
	 * adds a pet to the shelter, which will be used in our controller
	 * @param pet to be added to shelter
	 */
	public void addPet(T pet)
	{
		petList.add(pet);
	}
	/**
	 * gets the pets from the shelter, which will be used in our controller
	 * return the list of pets in the shelter 
	 */
	public List<T> getPets()
	{
		return petList;
	}
	
	/**
	 * deletes a pet from the shelter, which is to be used in our controller
	 * @param pet to be deleted to the shelter 
	 */
	public void deletePet(T pet)
	{
		petList.remove(pet);
	}	
}
