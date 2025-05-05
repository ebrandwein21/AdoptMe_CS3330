package edu.mu.maven.Model;

import java.util.Comparator;

public class TypeComparator implements Comparator<Pet>
{
	public int compare(Pet pet1, Pet pet2)
	{
		return pet1.GetType().compareTo(pet2.GetType());
	}
}