import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserLoginFrame extends JFrame{
	JLabel label;
	JLabel name;
	JLabel pass;
	JLabel identify;
	JButton login;
	JButton register;
	JButton modify;
	JTextField adminName;
	JPasswordField password;
	JPanel panel;
	JPanel jp1;
	JPanel jp2;
	JPanel[] panelLeft;
	JPanel[] panelRight;
	
  
  public UserLoginFrame(){
    	this.setBounds(400, 200, 900, 650);
	this.setTitle("Login in System");
	this.setLayout(new BorderLayout());
		
	label = new JLabel("Login in",SwingConstants.CENTER);
	label.setFont(new Font("",Font.BOLD,30));
		
	name = new JLabel("ACCOUNT");
	pass = new JLabel("PASSWORD");
		
	adminName = new JTextField(12);
	adminName.setHorizontalAlignment(SwingConstants.CENTER);
	password = new JPasswordField(12);
	password.setHorizontalAlignment(SwingConstants.CENTER);
	password.setEchoChar('*');
		
	panel = new JPanel();
	jp1 = new JPanel();
	jp2 = new JPanel();
	panel.setLayout(new BorderLayout());
		
	jp1.add(adminName);
	jp1.add(name);
	jp1.add(password);
	jp1.add(pass);
		
	panel.add(jp1);
		
	register = new JButton("Create new account");
	login = new JButton("Login in");
	modify = new JButton("Change Password");
	jp2.add(register);
	jp2.add(login);
	jp2.add(modify);
	panel.add(jp2,BorderLayout.SOUTH);
		
	this.add(label,BorderLayout.NORTH);
	this.add(panel);
		
	MyEvent();
		
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
