package edu.mu.maven.Model;

import java.util.Comparator;

public class IDComparator implements Comparator<Pet>
{
	/**
	 * a comparator that sorts pets based on their respective id
	 * @param pet 1 (the first pet being compared) and pet 2 (the second pet being compared)
	 * @return returns a negative interger, zero or positive integer depending who has the higher ID number
	 */
		public int compare(Pet pet1, Pet pet2)
		{
			return Integer.compare(pet1.GetAge(), pet2.GetAge());

		}
}
