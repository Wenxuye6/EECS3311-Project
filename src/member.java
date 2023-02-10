import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class member extends JFrame {

	private JPanel contentPane;
	private JTextField namefield;
	private JTextField genderfield;
	private JTextField Agefield;
	private JTextField bodyIfield;
	private JTextField weightfield;
	private JTextField heightfield;
	private JTextField pricefield;
	private JTextField fundfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member frame = new member();
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
	public member() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Membership");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel namelabel = new JLabel("Name");
		namelabel.setBounds(17, 6, 78, 23);
		contentPane.add(namelabel);
		
		namefield = new JTextField();
		namefield.setBounds(112, 4, 130, 26);
		contentPane.add(namefield);
		namefield.setColumns(10);
		
		JLabel genderlabel = new JLabel("Gender");
		genderlabel.setBounds(17, 48, 61, 16);
		contentPane.add(genderlabel);
		
		genderfield = new JTextField();
		genderfield.setBounds(112, 42, 130, 26);
		contentPane.add(genderfield);
		genderfield.setColumns(10);
		
		JLabel Agelabel = new JLabel("Age");
		Agelabel.setBounds(17, 84, 61, 16);
		contentPane.add(Agelabel);
		
		Agefield = new JTextField();
		Agefield.setBounds(112, 80, 130, 26);
		contentPane.add(Agefield);
		Agefield.setColumns(10);
		
		JLabel bodyindex = new JLabel("Bodyindex");
		bodyindex.setBounds(17, 122, 61, 16);
		contentPane.add(bodyindex);
		
		bodyIfield = new JTextField();
		bodyIfield.setBounds(112, 117, 130, 26);
		contentPane.add(bodyIfield);
		bodyIfield.setColumns(10);
		
		JLabel weightlabel = new JLabel("weight");
		weightlabel.setBounds(17, 156, 61, 16);
		contentPane.add(weightlabel);
		
		weightfield = new JTextField();
		weightfield.setBounds(112, 151, 130, 26);
		contentPane.add(weightfield);
		weightfield.setColumns(10);
		
		JLabel heightlabel = new JLabel("height");
		heightlabel.setBounds(17, 185, 61, 16);
		contentPane.add(heightlabel);
		
		heightfield = new JTextField();
		heightfield.setBounds(112, 180, 130, 26);
		contentPane.add(heightfield);
		heightfield.setColumns(10);
		
		JLabel pricelabel = new JLabel("Price");
		pricelabel.setBounds(17, 226, 61, 16);
		contentPane.add(pricelabel);
		
		pricefield = new JTextField();
		pricefield.setBounds(112, 221, 130, 26);
		contentPane.add(pricefield);
		pricefield.setColumns(10);
		
		JLabel fundlabel = new JLabel("fund");
		fundlabel.setBounds(17, 254, 61, 16);
		contentPane.add(fundlabel);

		fundfield = new JTextField();
		fundfield.setBounds(112, 249, 130, 26);
		contentPane.add(fundfield);
		fundfield.setColumns(10);
		
		JButton addmemberButton = new JButton("Add Member");
		addmemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymProject", "root", "");
					Statement stmt = con.createStatement();
					//Now we will specify Query
					String sql = "INSERT INTO Memebership (Name, Gender, Age, Bodyindex, Weight, Height, Price, Fund) VALUES (" +namefield.getText()+ "," 
							+ genderfield.getText() +"," + Agefield.getText() + "," + bodyIfield.getText() + ", " 
							+ weightfield.getText() + "," + heightfield.getText() + ", " + pricefield.getText() + ", " + fundfield.getText() + ")";
					
					ResultSet rs = stmt.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "New Gym member added");
				}catch (Exception e) {
					System.out.print(e);
				}
			}
		});
		addmemberButton.setBounds(56, 294, 117, 23);
		contentPane.add(addmemberButton);
	}
}
