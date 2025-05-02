package edu.mu.maven.Model;

public class Cat extends Pet {

	public Cat(int id, String name, String type, String species, int age, boolean adopted) {
		super(id, name, "cat", species, age, adopted);
		
	}
	
	@Override
	public String GetType() {
        return "Cat";  
    }

}
