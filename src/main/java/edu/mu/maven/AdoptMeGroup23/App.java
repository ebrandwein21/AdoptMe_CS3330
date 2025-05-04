package edu.mu.maven.AdoptMeGroup23;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import edu.mu.maven.Model.Cat;
import edu.mu.maven.Model.Dog;
import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Rabbit;

import edu.mu.maven.view.GUIView;

import edu.mu.maven.Model.Shelter;
import edu.mu.maven.controller.PetAdoptionController;
import edu.mu.maven.view.GUIView;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import java.lang.reflect.Type;
import java.io.IOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class App {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {
    			GUIView view = new GUIView();
    			PetAdoptionController controller = new PetAdoptionController(new Shelter<>(), new GUIView());
    	     	controller.save();
    	     	controller.view();
    	     	controller.initController();

    	     	
    	     	
    	}
    });
    }
}
