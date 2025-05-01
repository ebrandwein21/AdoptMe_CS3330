package edu.mu.maven.Model;

public abstract class Pet {
   protected int age, id;
   protected String name, type, species;
   protected boolean adopted;
    
   
    public Pet(int id, String name, String type, String species, int age, boolean adopted)
    {
    	this.id = id;
    	this.name = name;
    	this.type = type;
    	this.species = species;
    	this.age = age;
    	this.adopted = adopted;
    }
    
    public int GetID()
    {
    	return id;
    }
    
    public void SetID(int id)
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
   
}
