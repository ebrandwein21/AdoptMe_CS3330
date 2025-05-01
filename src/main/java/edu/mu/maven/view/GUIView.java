package edu.mu.maven.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GUIView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane title;
	private JTable table;
	private JButton btnSave;
	private JButton btnAdopt;
	private JButton btnRemove;
	private JButton btnView;
	private JButton btnAdd;
	private JComboBox sortBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIView frame = new GUIView();
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
		setBounds(100, 100, 1008, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		title = new JTextPane();
		title.setEditable(false);
		title.setFont(new Font("Tahoma", Font.PLAIN, 50));
		title.setText("Pets!");
		title.setBounds(465, 10, 132, 76);
		contentPane.add(title);

		table = new JTable();
		table.setBounds(313, 255, 484, 376);
		contentPane.add(table);

		btnAdopt = new JButton("Adopt");
		btnAdopt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdopt.setBounds(245, 151, 142, 55);
		contentPane.add(btnAdopt);

		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRemove.setBounds(439, 151, 142, 55);
		contentPane.add(btnRemove);

		btnView = new JButton("View Details");
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnView.setBounds(642, 151, 142, 55);
		contentPane.add(btnView);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSave.setBounds(823, 151, 142, 55);
		contentPane.add(btnSave);

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(64, 151, 142, 55);
		contentPane.add(btnAdd);

		sortBox = new JComboBox();
		sortBox.setBounds(206, 264, 97, 21);
		contentPane.add(sortBox);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
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
