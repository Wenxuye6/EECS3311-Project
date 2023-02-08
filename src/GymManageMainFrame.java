import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class GymManageMainFrame extends JFrame {
	JLabel labeltile;
	JLabel info;
	JPanel jpanel;
	JPanel jp1;
	JPanel User,jp2,jp3;
	JButton admin,user;

	JButton lend;
	DefaultTableModel tableModel;
	
    
	public GymManageMainFrame(){
		
		this.setLayout(new BorderLayout());
		this.setBounds(400, 200, 900, 650);
		this.setTitle("GymManageSystem");

        	labeltile = new JLabel("GymManageSystem",SwingConstants.CENTER);
		labeltile.setFont(new Font("",Font.BOLD,40));		 
		
		jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		jp1 = new JPanel();
		jp2 = new JPanel();		

		user = new JButton("Sing in as User");
		admin = new JButton("Sing in as Manage");

		jp3 = new JPanel();
		jp2.setLayout(new BorderLayout());
		jp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp3.add(user);
		jp3.add(admin);
		jp2.add(jp3,BorderLayout.SOUTH);
		
		jpanel.add(jp1,BorderLayout.NORTH);
		jpanel.add(jp2);
		
		
		this.add(labeltile,BorderLayout.NORTH);
		this.add(jpanel);
		
		MyEvent();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void MyEvent(){
		
		admin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new LoginFrame();
			}
			
		});
		
		user.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new UserLoginFrame();
			}
			
		});
	}
	
	public static void main(String[] args){
		new GymManageMainFrame();
	}
}
