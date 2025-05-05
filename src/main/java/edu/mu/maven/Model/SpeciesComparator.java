package edu.mu.maven.Model;

import java.util.Comparator;
/**
 * sorts pets based on species in alphabetical order
 * pet 1 (first pet compared) and pet 2 (second pet compared)
 * returns a negative interger, zero or positive integer depending who is first alphabetically
 */
public class SpeciesComparator implements Comparator<Pet>
{
	public int compare(Pet pet1, Pet pet2)
	{
		return pet1.GetSpecies().compareTo(pet2.GetSpecies());
	}
}