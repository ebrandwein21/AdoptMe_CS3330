package edu.mu.maven.Model;

import java.util.Comparator;

public class SpeciesComparator implements Comparator<Pet>
{
	public int compare(Pet pet1, Pet pet2)
	{
		return Integer.compare(pet1.GetSpecies().getOrder(), pet2.GetSpecies().getOrder());
	}
}