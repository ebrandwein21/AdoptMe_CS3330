package edu.mu.maven.Model;

import java.util.Comparator;

public class PetComparitors {

	public static Comparator<Pet> sortByAge(){
		
		return Comparator.comparingInt(Pet::getAge);
	}
}
