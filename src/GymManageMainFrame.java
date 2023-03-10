
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GymManageMainFrame {
	String username = "";
	CardLayout layout = new CardLayout();
	JFrame bamFrame;
	MainPanel mainPanel = new MainPanel();
	JPanel upPanel = new JPanel();
	JPanel downPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();

    InfoPanel infoPanel = new InfoPanel();

    public GymManageMainFrame(){

		BorderLayout mainLayout = new BorderLayout();
		leftPanel.add(mainPanel);
		leftPanel.setBackground(Color.WHITE);
		rightPanel.setLayout(layout);
		rightPanel.add(infoPanel);

		bamFrame = new JFrame("GymManageSystem");
		bamFrame.getContentPane().setLayout(mainLayout);
		bamFrame.setSize(1050, 600);

		bamFrame.getContentPane().add(leftPanel, BorderLayout.WEST);
		bamFrame.getContentPane().add(rightPanel, BorderLayout.CENTER);
		addListeners();
		bamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bamFrame.setVisible(true);
		bamFrame.setLocationRelativeTo(null);
	}
	private void addListeners() {
		
    }

	public static void main(String[] args) {
		new GymManageMainFrame();
	}
}
