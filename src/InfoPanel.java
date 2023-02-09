import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	JLabel jlabel;

	
	public InfoPanel(){
		this.jlabel = new JLabel("Welcome to use GymManage System");

		this.add(jlabel);
	}
}
