package edu.mu.maven.AdoptMeGroup23;
import edu.mu.maven.Model.*;
import java.lang.reflect.Type;
import com.google.gson.InstanceCreator;

public class PetInstanceCreator implements InstanceCreator<Pet>
{
	public Pet createInstance(Type type)
	{
		String petType = "";
	
	if(petType.equals("Dog"))
	{
		return new Dog(0, "", "", "dog", 0, false);
	}
	
	if(petType.equals("Cat"))
	{
		return new Cat(0, "", "", "cat", 0, false);
	}
	if(petType.equals("Rabbit"))
	{
		return new Rabbit(0, "", "", "rabbit", 0, false);
	} else {
        throw new IllegalArgumentException("Unknown pet type: " + petType);
    }
 
	}
	
	
}

