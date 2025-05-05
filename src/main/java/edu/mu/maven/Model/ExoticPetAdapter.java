package edu.mu.maven.Model;

/**
 * an adapter class that wraps exoticanimal so it can be treated as a pet
 */
public class ExoticPetAdapter extends Pet{
		
	private ExoticAnimal exoticPet = null;
	/**
	 * adapts the exotic pet so it can be adapter into a pet by calling the super() constructor of the pet class
	 * @param exoticPet, an object of ExoticAnimal to be wrapped
	 */
	public ExoticPetAdapter(ExoticAnimal exoticPet)
	{
		super(exoticPet.GetUniqueId(), exoticPet.GetAnimalName(), exoticPet.GetCategory(), exoticPet.GetSubSpecies(), exoticPet.GetYearsOld(), false);
		this.exoticPet = exoticPet;	
	}
 }