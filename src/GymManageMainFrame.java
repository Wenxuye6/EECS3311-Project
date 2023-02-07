import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class GymManageMainFrame {
    String username = "";
	CardLayout layout = new CardLayout();
	JFrame bamFrame;
	MainPanel mainPanel = new MainPanel();
	JPanel upPanel = new JPanel();
	JPanel downPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();

	
    APanel APanel = new APanel();
    BPanel BPanel = new BPanel();
    CPanel CPanel = new CPanel();
    DPanel DPanel = new DPanel();
    EPanel EPanel = new EPanel();
    FPanel FPanel = new FPanel();

	final Object[] columnNames = {"1", "2", "3","4","5","6","7","8","9"}; 
	Object[][] rowData = queryData("");
	DefaultTableModel model = new DefaultTableModel(rowData,columnNames);
	JTable dataTable = new JTable (model);
	

    
	public GymManageMainFrame(){
		dataTable.setPreferredScrollableViewportSize(new Dimension(900, 580));
		dataTable.setRowHeight (30);
		dataTable.setRowHeight (0, 30);
		dataTable.setSelectionBackground (Color.white);
		dataTable.setSelectionForeground (Color.blue);
		//dataTable.setGridColor (Color.black);
		dataTable.selectAll ();
		//dataTable.setRowSelectionInterval (0,2);
		dataTable.clearSelection ();
		dataTable.setDragEnabled (false); 
		dataTable.setShowGrid (false);
		dataTable.setShowHorizontalLines (false);
		dataTable.setShowVerticalLines (true);
		//friends.setValueAt ("tt", 0, 0);
		dataTable.doLayout (); 
		dataTable.setBackground (Color.lightGray); 

        DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        dataTable.setDefaultRenderer(Object.class,r);
		//JScrollPane pane2 = new JScrollPane (example2); 	 
		
		selectCoursePanel.add(new JScrollPane (dataTable), BorderLayout.SOUTH);

		BorderLayout mainLayout = new BorderLayout();

		leftPanel.add(mainPanel);
		leftPanel.setBackground(Color.WHITE);

		rightPanel.setLayout(layout);
		rightPanel.add("A", APanel);// riget side Boxes 1
		rightPanel.add("B", BPanel);// riget side Boxes 2
		rightPanel.add("C", CPanel);// riget side Boxes 3
		rightPanel.add("D", DPanel);// riget side Boxes 4
		rightPanel.add("E", EPanel);// riget side Boxes 5
		rightPanel.add("F", FPanel);// riget side Boxes 6

		bamFrame = new JFrame("GYM Manage System");
		bamFrame.getContentPane().setLayout(mainLayout);
		bamFrame.setSize(1050, 600);

		bamFrame.getContentPane().add(leftPanel, BorderLayout.WEST);
		bamFrame.getContentPane().add(rightPanel, BorderLayout.CENTER);
		addListeners();
		bamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bamFrame.setVisible(true);
	
		bamFrame.setLocationRelativeTo(null);
	}
	
		private void () addListeners(){
		mainPanel.getSelectAPanel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(rightPanel, "A");
			}
		}
							    
		mainPanel.getBPanel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.equals("")) {
					layout.show(rightPanel, "login");
				}else {
					layout.show(rightPanel, "B");
				}
				
		}
			
		mainPanel.getCPanel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.equals("")) {
					layout.show(rightPanel, "login");
				}else {
					layout.show(rightPanel, "C");
				}
				
		}


}
