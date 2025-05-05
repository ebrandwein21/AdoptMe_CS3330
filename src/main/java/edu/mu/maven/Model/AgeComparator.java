package edu.mu.maven.Model;

import java.util.Comparator;

public class AgeComparator implements Comparator<Pet>
{
	/**
	 * a comparator that sorts pets based on their respective age
	 * @param pet 1 (the first pet being compared) and pet 2 (the second pet being compared)
	 * @return returns a negative interger, zero or positive integer depending who is younger or older
	 */
	public int compare(Pet pet1, Pet pet2)
	{
		return Integer.compare(pet1.GetAge(), pet2.GetAge());
	}
}