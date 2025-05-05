package edu.mu.maven.Model;
/**
 * extends pet class to represent a specific type of pet, which happens to be rabbit
 */
public class Rabbit extends Pet {
	/**
	  * the attributes of the cat class, sets the pet as type rabbit 
	  * @param id - the specific id of the rabbit
	  * @param name - the specific name of the rabbit
	  * @param species - the specific species of the rabbit
	  * @param age - the specific age of the rabbit
	  * @param adopted - if the rabbit has been adopted or not 
	  */
	public Rabbit(int id, String name, String type, String species, int age, boolean adopted) {
		super(id, name, "rabbit", species, age, adopted);
		// TODO Auto-generated constructor stub
	}
	/**
	 * overrides the base class and returns the type rabbit 
	 */
	@Override
	public String GetType() {
        return "Rabbit";  
    }
}
