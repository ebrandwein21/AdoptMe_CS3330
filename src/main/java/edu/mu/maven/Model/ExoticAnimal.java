package edu.mu.maven.Model;

public class ExoticAnimal {
     protected String uniqueId, animalName, category, subSpecies, exoticId;
     protected int yearsOld;
     boolean adopted = false;

	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld)
     {

		 this.uniqueId = uniqueId;
    	 this.animalName = animalName;
    	 this.category = category;
    	 this.subSpecies = subSpecies;
    	 this.yearsOld = yearsOld;
     }
     
	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
     public String GetUniqueId()
     {
    	   
     	return exoticId;
     }
     
     public void SetUniqueID(String exoticId)
     {
        
     	this.exoticId = exoticId;
     }
     
     public String GetAnimalName()
     {
     	return animalName;
     }
     
     public void SetAnimalName(String animalName)
     {
     	this.animalName = animalName;
     }
     
     public String GetCategory()
     {
     	return category;
     }
     
     public void SetCategory(String category)
     {
     	this.category = category;
     }
     
     public String GetSubSpecies()
     {
     	return subSpecies;
     }
     
     public void SetSubSpecies(String subSpecies)
     {
     	this.subSpecies = subSpecies;
     }
     
     public int GetYearsOld()
     {
     	return yearsOld;
     }
     
     public void SetYearsOld(int yearsOld)
     {
     	this.yearsOld = yearsOld;
     }
}
