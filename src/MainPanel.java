
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private JButton memberButton;
	private JButton inventoryButton;
	private JButton Buttonone;
	private JButton Buttontwo;
	private JButton Buttonthree;
	private JButton exitButton;

	public JButton getMemberButton() {
		return memberButton;
	}

	public JButton getInventoryButton() {
		return inventoryButton;
	}
	public JButton getButtontwo() {
		return Buttontwo;
	}
	public JButton getButtonone() {
		return Buttonone;
	}
	public JButton getButtonthree() {
		return Buttonthree;
	}
	public JButton getExitButton() {
		return exitButton;
	}

	public MainPanel(){
		this.memberButton=new JButton("Member Search");
		this.inventoryButton=new JButton("inventory Search");
		this.Buttonone=new JButton("one");
		this.Buttontwo=new JButton("two");
		this.Buttonthree=new JButton("three");
		this.exitButton=new JButton("Logging out");
		
		this.setLayout(new GridLayout(7,1,0,10));
		
		this.add(memberButton);
		this.add(inventoryButton);
		this.add(Buttonone);
		this.add(Buttontwo);
		this.add(Buttonthree);
		this.add(exitButton);

	}
}
