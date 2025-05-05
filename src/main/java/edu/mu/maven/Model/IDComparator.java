package edu.mu.maven.Model;

import java.util.Comparator;

public class IDComparator implements Comparator<Pet>
{
		public int compare(Pet pet1, Pet pet2)
		{
			return Integer.compare(pet1.GetAge(), pet2.GetAge());

		}
}
