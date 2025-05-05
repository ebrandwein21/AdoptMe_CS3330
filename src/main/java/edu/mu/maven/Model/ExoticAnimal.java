package edu.mu.maven.Model;

public class ExoticAnimal {
	 protected String uniqueId, animalName, category, subSpecies;
     protected int yearsOld, exoticId;
     boolean adopted = false;

     /**
      * a constructor for the exoticanimal class, a group of animals represented in the exotic animal json file, id is converted from string to int 
      * this is so that it can be used in the adapter and match up with the pet super class
      * @param uniqueId the unique id of the exotic animal
      * @param animalName the name of the exotic animal
      * @param category the  type of exotic animal
      * @param subSpecies the species of the exotic animal 
      * @param yearsOld the age of the exotic animal 
      */
	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld)
     {
		if(uniqueId != null) {
    		 String newID = uniqueId.replaceAll("[^0-9]", "");
    	 	 this.exoticId = Integer.parseInt(newID); 
    	 }
    	 else {
    		 this.exoticId = Integer.parseInt(uniqueId);
    	 }
		 this.uniqueId = uniqueId;
    	 this.animalName = animalName;
    	 this.category = category;
    	 this.subSpecies = subSpecies;
    	 this.yearsOld = yearsOld;
     }
     /**
      * creates a boolean of if the exotic animal is adopted, so that it can be wrapped by the pet class
      * @return the adoption status of the exotic animal 
      */
	public boolean isAdopted() {
		return adopted;
	}
	 /**
    *
    * @param the adoption status of the exotic animal to be set
    */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	/**
    *
    * @return the specific id of the pet 
    */
     public int GetUniqueId()
     {
    	   
     	return exoticId;
     }
     /**
     *
     * @param the specific id of the pet to be set
     */
     public void SetUniqueID(int exoticId)
     {
        
     	this.exoticId = exoticId;
     }
     /**
     *
     * @return the specific name of the pet 
     */
     public String GetAnimalName()
     {
     	return animalName;
     }
     /**
     *
     * @param the specific name of the pet to be set
     */
     public void SetAnimalName(String animalName)
     {
     	this.animalName = animalName;
     }
     /**
     *
     * @return the specific type of the pet 
     */
     public String GetCategory()
     {
     	return category;
     }
     /**
     *
     * @param the specific type of the pet to be set
     */
     public void SetCategory(String category)
     {
     	this.category = category;
     }
     /**
     *
     * @return the specific species of the pet 
     */
     public String GetSubSpecies()
     {
     	return subSpecies;
     }
     /**
     *
     * @param the specific species of the pet to be set
     */
     public void SetSubSpecies(String subSpecies)
     {
     	this.subSpecies = subSpecies;
     }
     /**
     *
     * @return the specific age of the pet 
     */
     public int GetYearsOld()
     {
     	return yearsOld;
     }
     /**
     *
     * @param the specific age of the pet to be set
     */
     public void SetYearsOld(int yearsOld)
     {
     	this.yearsOld = yearsOld;
     }
}
