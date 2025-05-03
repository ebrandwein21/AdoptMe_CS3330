package edu.mu.maven.Model;

public class Rabbit extends Pet {

	public Rabbit(int id, String name, String type, String species, int age, boolean adopted) {
		super(id, name, "rabbit", species, age, adopted);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String GetType() {
        return "Rabbit";  
    }

}
