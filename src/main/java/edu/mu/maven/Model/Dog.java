package edu.mu.maven.Model;
/**
 * extends pet class to represent a specific type of pet, which happens to be dog
 */
public class Dog extends Pet {
	/**
	  * the attributes of the cat class, sets the pet as type dog 
	  * @param id - the specific id of the dog
	  * @param name - the specific name of the dog
	  * @param species - the specific species of the dog
	  * @param age - the specific age of the dog
	  * @param adopted - if the dog has been adopted or not 
	  */
	public Dog(int id, String name, String type, String species, int age, boolean adopted) {

		super(id, name, "dog", species, age, adopted);
	}
	/**
	 * overrides the base class and returns the type dog 
	 */
	@Override
	public String GetType() {
        return "Dog";  
    }
}
