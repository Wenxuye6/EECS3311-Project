import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginFrame extends JFrame{
	JLabel label,name,pass;
	JButton login;
	JTextField adminName;
	JPasswordField password;
	JPanel panel,jp1,jp2;
	
	public LoginFrame(){
		this.setBounds(400, 200, 900, 650);
		this.setTitle("Gym Management System Login in");
		this.setLayout(new BorderLayout());
		
		label = new JLabel("Login in",SwingConstants.CENTER);
		label.setFont(new Font("",Font.BOLD,30));
		
		name = new JLabel("Account");
		pass = new JLabel("Password");
		
		adminName = new JTextField(12);
		adminName.setText("admin");
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
		
		login = new JButton("Login");
		jp2.add(login);
		panel.add(jp2,BorderLayout.SOUTH);
		
		this.add(label,BorderLayout.NORTH);
		this.add(panel);
		
		MyEvent();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void MyEvent(){
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String word = "123456";	
				String str = new String(password.getPassword());
				String str1 = "correct password";
				
				if(str.equals(word)){
					new GymManageMainFrame();
				}else{
					String str2 = "uncorrect password";
					JOptionPane.showMessageDialog(null, str2);
					
				}

				LoginFrame.this.dispose();
			}

		});
	}
	
	public static void main(String[] args){
		new LoginFrame();
	}
}
