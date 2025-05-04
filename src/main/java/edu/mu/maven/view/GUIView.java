package edu.mu.maven.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.mu.maven.Model.Pet;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class GUIView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnSave;
	private JButton btnAdopt;
	private JButton btnRemove;
	private JButton btnView;
	private JButton btnAdd;
	private JComboBox sortBox;
	private JLabel title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIView frame = new GUIView();
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
	public GUIView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable(10,1);
		table.setBounds(185, 120, 345, 552);
		contentPane.add(table);
		table.setValueAt("Name:", 0, 0);

		btnAdopt = new JButton("Adopt");
		btnAdopt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdopt.setBounds(540, 150, 142, 55);
		contentPane.add(btnAdopt);

		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRemove.setBounds(540, 250, 142, 55);
		contentPane.add(btnRemove);

		btnView = new JButton("View Details");
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnView.setBounds(540, 350, 142, 55);
		contentPane.add(btnView);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSave.setBounds(540, 450, 142, 55);
		contentPane.add(btnSave);

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(540, 550, 142, 55);
		contentPane.add(btnAdd);

		sortBox = new JComboBox();
		sortBox.setBounds(78, 147, 97, 21);
		contentPane.add(sortBox);
		sortBox.addItem("Name");
		sortBox.addItem("Age");
		sortBox.addItem("Species");
		
		JLabel sortBoxLabel = new JLabel("Sort by:");
		sortBoxLabel.setBounds(23, 151, 45, 13);
		contentPane.add(sortBoxLabel);
		
		title = new JLabel("Pets!");
		title.setFont(new Font("Tahoma", Font.PLAIN, 50));
		title.setBounds(271, 10, 210, 129);
		contentPane.add(title);
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnAdopt() {
		return btnAdopt;
	}

	public void setBtnAdopt(JButton btnAdopt) {
		this.btnAdopt = btnAdopt;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public void setBtnRemove(JButton btnRemove) {
		this.btnRemove = btnRemove;
	}

	public JButton getBtnView() {
		return btnView;
	}

	public void setBtnView(JButton btnView) {
		this.btnView = btnView;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JComboBox getSortBox() {
		return sortBox;
	}

	public void setSortBox(JComboBox sortBox) {
		this.sortBox = sortBox;
	}
	
	
}
