package edu.mu.maven.Model;
/**
 * extends pet class to represent a specific type of pet, which happens to be cat
 */
public class Cat extends Pet 
 /**
  * the attributes of the cat class, sets the pet as type cat 
  * @param id - the specific id of the cat
  * @param name - the specific name of the cat
  * @param species - the specific species of the cat
  * @param age - the specific age of the cat
  * @param adopted - if the cat has been adopted or not 
  */
    {
	public Cat(int id, String name, String type, String species, int age, boolean adopted) {
		super(id, name, "cat", species, age, adopted);	
	}
	/**
	 * overrides the base class and returns the type cat 
	 */
	@Override
	public String GetType() 
	{
        return "Cat";  
    }
}
