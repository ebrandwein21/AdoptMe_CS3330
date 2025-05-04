package edu.mu.maven.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class DetailsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel nameLabel, typeLabel, speciesLabel, ageLabel, adoptedLabel, idLabel, petName, petType,
	petSpecies, petAge, petAdopted, petId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsView frame = new DetailsView();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public DetailsView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nameLabel.setBounds(10, 34, 189, 36);
		contentPane.add(nameLabel);
		
		typeLabel = new JLabel("Type:");
		typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		typeLabel.setBounds(10, 98, 189, 36);
		contentPane.add(typeLabel);
		
		speciesLabel = new JLabel("Species:");
		speciesLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		speciesLabel.setBounds(10, 170, 189, 36);
		contentPane.add(speciesLabel);
		
		ageLabel = new JLabel("Age:");
		ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ageLabel.setBounds(10, 242, 189, 36);
		contentPane.add(ageLabel);
		
		adoptedLabel = new JLabel("Adopted?");
		adoptedLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		adoptedLabel.setBounds(10, 318, 189, 36);
		contentPane.add(adoptedLabel);
		
		idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		idLabel.setBounds(10, 396, 189, 36);
		contentPane.add(idLabel);
		
		petName = new JLabel("");
		petName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		petName.setBounds(209, 34, 167, 31);
		contentPane.add(petName);
		
		petType = new JLabel("");
		petType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		petType.setBounds(209, 103, 167, 31);
		contentPane.add(petType);
		
		petSpecies = new JLabel("");
		petSpecies.setFont(new Font("Tahoma", Font.PLAIN, 15));
		petSpecies.setBounds(209, 170, 167, 31);
		contentPane.add(petSpecies);
		
		petAge = new JLabel("");
		petAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		petAge.setBounds(209, 247, 167, 31);
		contentPane.add(petAge);
		
		petAdopted = new JLabel("");
		petAdopted.setFont(new Font("Tahoma", Font.PLAIN, 15));
		petAdopted.setBounds(209, 323, 167, 31);
		contentPane.add(petAdopted);
		
		petId = new JLabel("");
		petId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		petId.setBounds(209, 401, 167, 31);
		contentPane.add(petId);
		
		
	}
	public JLabel getPetName() {
		return petName;
	}

	public void setPetName(JLabel petName) {
		this.petName = petName;
	}

	public JLabel getPetType() {
		return petType;
	}

	public void setPetType(JLabel petType) {
		this.petType = petType;
	}

	public JLabel getPetSpecies() {
		return petSpecies;
	}

	public void setPetSpecies(JLabel petSpecies) {
		this.petSpecies = petSpecies;
	}

	public JLabel getPetAge() {
		return petAge;
	}

	public void setPetAge(JLabel petAge) {
		this.petAge = petAge;
	}

	public JLabel getPetAdopted() {
		return petAdopted;
	}

	public void setPetAdopted(JLabel petAdopted) {
		this.petAdopted = petAdopted;
	}

	public JLabel getPetId() {
		return petId;
	}

	public void setPetId(JLabel petId) {
		this.petId = petId;
	}
	
}
