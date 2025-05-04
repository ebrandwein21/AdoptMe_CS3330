package edu.mu.maven.Model;

public class ExoticAnimal {
     protected String uniqueId, animalName, category, subSpecies;
     protected int yearsOld, exoticId;
     boolean adopted = false;

	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld)
     {
    	 if(uniqueId != null) {
    		 String newID = uniqueId.replaceAll("[^0-9]", "");
    	 	 this.exoticId = Integer.parseInt(newID); 
    	 }
    	 else {
    		 this.exoticId = Integer.parseInt(uniqueId);
    	 }
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
	
     public int GetUniqueId()
     {
    	   
     	return exoticId;
     }
     
     public void SetUniqueID(int exoticId)
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
