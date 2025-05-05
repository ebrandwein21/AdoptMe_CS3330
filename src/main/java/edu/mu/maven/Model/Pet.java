package edu.mu.maven.Model;

/*
 * abstract base class that defines pets to be adopted, defines properties that the pets have in the json file 
 */
public abstract class Pet implements Comparable<Pet> {
   protected int age, id;
   protected String name, type, species;
   protected boolean adopted;
    
   /**
    * creates a new pet instance
    * @param id id of pet
    * @param name name of pet
    * @param type type of pet
    * @param species the species of the pet
    * @param age age of pet
    * @param adopted if the pet is adopted or not 
    */
    public Pet(int id, String name, String type, String species, int age, boolean adopted)
    {
    	this.id = id;
    	this.name = name;
    	this.type = type;
    	this.species = species;
    	this.age = age;
    	this.adopted = adopted;
    }
    /**
     *
     * @return the specific id of the pet 
     */
    public int GetID()
    {
    	return id;
    }
    /**
    *
    * @param the specific id of the pet to be set
    */
    public void SetID(int id)
    {
    	this.id = id;
    }
    /**
    *
    * @return the specific name of the pet 
    */
    public String GetName()
    {
    	return name;
    }
    /**
    *
    * @param the specific name of the pet to be set
    */
    public void SetName(String name)
    {
    	this.name = name;
    }
    /**
    *
    * @return the specific type of the pet 
    */
    public String GetType()
    {
    	return type;
    }
    /**
    *
    * @param the specific type of the pet to be set
    */
    public void SetType(String type)
    {
    	this.type = type;
    }
    /**
    *
    * @return the specific species of the pet 
    */
    public String GetSpecies()
    {
    	return species;
    }
    /**
    *
    * @param the specific species of the pet to be set
    */
    public void SetSpecies(String species)
    {
    	this.species = species;
    }
    /**
    *
    * @return the specific age of the pet 
    */
    public int GetAge()
    {
    	return age;
    }
    /**
    *
    * @param the specific age of the pet to be set
    */
    public void SetAge(int age)
    {
    	this.age = age;
    }
    /**
    *
    * @return the specific instance of if the pet has been adopted or not
    */
    public boolean GetAdopted()
    {
    	return adopted;
    }
    /**
    *
    * @param the specific instance of if the the pet ha been adopted or not of the pet to be set
    */
    public void SetAdopted(boolean adopted)
    {
    	this.adopted = adopted;
    }
    /**
    * compares the pets alphabetically by name
    * @param pet the current instance of pet is to be compared
    * an interger, either negative, zero or positive depending on  the two pets being compared 
    */
    public int compareTo(Pet pet)
    {
    	return this.name.compareTo(pet.GetName());
    	
    }
}
