package edu.mu.maven.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.mu.maven.Model.Cat;
import edu.mu.maven.Model.Dog;
import edu.mu.maven.Model.Pet;
import edu.mu.maven.Model.Rabbit;


import javax.swing.JButton;
import javax.swing.JLabel;

public class AddPetDialog extends JFrame
{
	private JPanel panel;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField typeTextField;
	private JTextField speciesTextField;
	private JTextField ageTextField;
	private JButton submitPetButton;
    private Pet addedPet = null;

	public AddPetDialog()
	{
		setTitle("Submit Pet Information");
		setBounds(100, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		idTextField = new JTextField();
		idTextField.setBounds(229, 93, 96, 20);
		panel.add(idTextField);
		idTextField.setColumns(10);
		
		nameTextField = new JTextField();
		panel.add(nameTextField);
		
		typeTextField = new JTextField();
		panel.add(typeTextField);
		
		speciesTextField = new JTextField();
		panel.add(speciesTextField);
		speciesTextField.setColumns(10);
		
		ageTextField = new JTextField();
		panel.add(ageTextField);
		ageTextField.setColumns(10);
		
		submitPetButton = new JButton("Submit Pet");
		panel.add(submitPetButton);
		
		JLabel lblNewLabel = new JLabel("Pet ID:");
		lblNewLabel.setBounds(161, 93, 70, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pet Name:");
		lblNewLabel_1.setBounds(172, 138, 47, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pet Type:");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Pet Species:");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Pet Age:");
		panel.add(lblNewLabel_1);
	
			submitPetButton.addActionListener(e -> {
	            
	                int id = Integer.parseInt(idTextField.getText());
	                String name = nameTextField.getText();
	                String type = typeTextField.getText();
	                String species = speciesTextField.getText();
	                int age = Integer.parseInt(ageTextField.getText());

	                if(type.equals("Dog"))
	        		{
	                	addedPet = new Dog(id, name, type, species, age, false);
	        		}
	        		
	        	    else if(type.equals("Cat"))
	        		{
	        	    	addedPet = new Cat(id, name, type, species, age, false);
	        		}
	        	    else if(type.equals("Rabbit"))
	        		{
	        	    	addedPet = new Rabbit(id, name, type, species, age, false);
	        		}else 
	        		{
	        			throw new IllegalArgumentException("Unknown pet type: " + type);	
	        	    }
	                
			});
	}
	public Pet getPet() {
        return addedPet;
    }
}
	            
			
	
			
	
		

