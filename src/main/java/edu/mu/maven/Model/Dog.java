package edu.mu.maven.Model;

public class Dog extends Pet {

	public Dog(int id, String name, String type, String species, int age, boolean adopted) {

		super(id, name, "dog", species, age, adopted);

	}
	
	@Override
	public String GetType() {
        return "Dog";  
    }
}
