package edu.mu.maven.Model;

import java.util.ArrayList;
import java.util.List;

public class Shelter<T extends Pet>{
	
	//logic for storing pets
	private List<T> petList = new ArrayList<>();
	
	public void addPet(T pet){
		petList.add(pet);
	}
	
	public List<T> getPets(){
		return petList;
	}
	
	public void deletePet(T pet)
	{
		petList.remove(pet);
	}	
}
