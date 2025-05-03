package edu.mu.maven.Model;


public class ExoticPetAdapter extends Pet{
		
	
	private ExoticAnimal exoticPet = null;
	
	
	public ExoticPetAdapter(ExoticAnimal exoticPet)
	{
		super(exoticPet.GetUniqueId(), exoticPet.GetAnimalName(), exoticPet.GetCategory(), exoticPet.GetSubSpecies(), exoticPet.GetYearsOld(), false);
		this.exoticPet = exoticPet;
		
	}
}