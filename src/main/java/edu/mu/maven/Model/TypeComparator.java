package edu.mu.maven.Model;

import java.util.Comparator;

public class TypeComparator implements Comparator<Pet>
{
	/**
	 * sorts pets based on type in alphabetical order
	 * pet 1 (first pet compared) and pet 2 (second pet compared)
	 * returns a negative interger, zero or positive integer depending who is first alphabetically so they can be compared 
	 */
	public int compare(Pet pet1, Pet pet2)
	{
		return pet1.GetType().compareTo(pet2.GetType());
	}
}