package edu.mu.maven.Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

public class ReadJsonPetFile
{
	String directory = System.getProperty("user.dir");
	String filePath =  directory  + File.separator + "AdoptMeGroup23" + File.separator + "src" + File.separator + "main"
			+ File.separator + "java" + File.separator + "resources" + File.separator + "pets.json" ;
}