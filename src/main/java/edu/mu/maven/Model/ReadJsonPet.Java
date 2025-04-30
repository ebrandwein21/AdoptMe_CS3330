package edu.mu.maven.Model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonPet
{
	JSONParser parser = new JSONParser()
	String directory = System.getProperty("user.dir");
	String filePath =  directory  + File.separator + "AdoptMeGroup23" + File.separator + "src" + File.separator + "main"
			+ File.separator + "java" + File.separator +
			+ "resources" + File.seperator + "pets.json" ;
	JSONArray petArray = (JSONArray) parser.parse(new FileReader(filePath))
}