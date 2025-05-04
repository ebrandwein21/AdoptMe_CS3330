package edu.mu.maven.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddPetView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JLabel nameLabel;
	private JLabel animalLabel;
	private JTextField animalField;
	private JLabel speciesLabel;
	private JTextField speciesField;
	private JLabel ageLabel;
	private JTextField ageField;
	private JButton addPetBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPetView frame = new AddPetView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddPetView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Header = new JLabel("Hi! Tell me about the animal you'd like to add");
		Header.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Header.setBounds(21, 0, 665, 98);
		contentPane.add(Header);
		
		nameField = new JTextField();
		nameField.setBounds(296, 93, 268, 34);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		nameLabel = new JLabel("What's their name?");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(31, 95, 204, 20);
		contentPane.add(nameLabel);
		
		animalLabel = new JLabel("What type of animal is it?");
		animalLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		animalLabel.setBounds(31, 179, 255, 32);
		contentPane.add(animalLabel);
		
		animalField = new JTextField();
		animalField.setBounds(296, 177, 268, 34);
		contentPane.add(animalField);
		animalField.setColumns(10);
		
		speciesLabel = new JLabel("What species is it?");
		speciesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		speciesLabel.setBounds(31, 275, 255, 32);
		contentPane.add(speciesLabel);
		
		speciesField = new JTextField();
		speciesField.setColumns(10);
		speciesField.setBounds(296, 273, 268, 34);
		contentPane.add(speciesField);
		
		ageLabel = new JLabel("How old are they?");
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ageLabel.setBounds(31, 378, 255, 32);
		contentPane.add(ageLabel);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(296, 376, 268, 34);
		contentPane.add(ageField);
		
		addPetBtn = new JButton("Add Pet");
		addPetBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addPetBtn.setBounds(423, 420, 153, 33);
		contentPane.add(addPetBtn);
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getAnimalField() {
		return animalField;
	}

	public void setAnimalField(JTextField animalField) {
		this.animalField = animalField;
	}

	public JTextField getSpeciesField() {
		return speciesField;
	}

	public void setSpeciesField(JTextField speciesField) {
		this.speciesField = speciesField;
	}

	public JTextField getAgeField() {
		return ageField;
	}

	public void setAgeField(JTextField ageField) {
		this.ageField = ageField;
	}

	public JButton getAddPetBtn() {
		return addPetBtn;
	}

	public void setAddPetBtn(JButton addPetBtn) {
		this.addPetBtn = addPetBtn;
	}
	
	
}
