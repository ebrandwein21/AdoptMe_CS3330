package edu.mu.maven.Model;

public abstract class Pet implements Comparable<Pet> {
   protected int age;
   protected String name, type, species, id;
   protected boolean adopted;
    
   
    public Pet(String id, String name, String type, String species, int age, boolean adopted)
    {
    	this.id = id;
    	this.name = name;
    	this.type = type;
    	this.species = species;
    	this.age = age;
    	this.adopted = adopted;
    }
    
    public String GetID()
    {
    	return id;
    }
    
    public void SetID(String id)
    {
    	this.id = id;
    }
    
    public String GetName()
    {
    	return name;
    }
    
    public void SetName(String name)
    {
    	this.name = name;
    }
    
    public String GetType()
    {
    	return type;
    }
    
    public void SetType(String type)
    {
    	this.type = type;
    }
    
    public String GetSpecies()
    {
    	return species;
    }
    
    public void SetSpecies(String species)
    {
    	this.species = species;
    }
    
    public int GetAge()
    {
    	return age;
    }
    
    public void SetAge(int age)
    {
    	this.age = age;
    }
    
    public boolean GetAdopted()
    {
    	return adopted;
    }
    
    public void SetAdopted(boolean adopted)
    {
    	this.adopted = adopted;
    }
    
    public int compareTo(Pet pet)
    {
    	return this.name.compareTo(pet.GetName());
    	
    }
}
