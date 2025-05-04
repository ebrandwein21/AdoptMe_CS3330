package edu.mu.maven.Model;

import java.util.Comparator;

public class SpeciesComparator implements Comparator<Pet>
{
	public int compare(Pet pet1, Pet pet2)
	{
		return pet1.GetSpecies().compareTo(pet2.GetSpecies());
	}
}