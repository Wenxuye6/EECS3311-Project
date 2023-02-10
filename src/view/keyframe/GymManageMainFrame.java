package view.keyframe;

import view.baseview.KeyFrame;
import view.panel.CoursePanel;
import view.panel.InventoryPanel;
import view.panel.MainPanel;
import view.panel.MemberPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Administrator operation page
 */
public class GymManageMainFrame extends KeyFrame {

    String username = "";
    CardLayout cardLayout = new CardLayout();

    public GymManageMainFrame(String username) {
        super("GymManageSystem", 900, 650);
        initFrame(username);
    }

    private void initFrame(String username) {
        JPanel contentPane = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(240, 0, 240, 650);
            }
        };
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(250, 0, 650, 650);
        contentPane.add(panel);
        panel.setLayout(cardLayout);

        MainPanel main = new MainPanel(username);
        panel.add(main, "main");
        CoursePanel course = new CoursePanel();
        panel.add(course, "course");
        MemberPanel member = new MemberPanel();
        panel.add(member, "member");
        InventoryPanel inventory = new InventoryPanel();
        panel.add(inventory, "inventory");

        JButton mainButton = new JButton("mainFrame");
        JButton courseButton = new JButton("course info");
        JButton memberButton = new JButton("manage member");
        JButton inventoryButton = new JButton("inventory view");
        JButton logout = new JButton("Logging Out");

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "main");
            }
        });
        mainButton.setBounds(50,70,150,30);
        contentPane.add(mainButton);

        courseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "course");
            }
        });
        courseButton.setBounds(50,120,150,30);
        contentPane.add(courseButton);

        memberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "member");
            }
        });
        memberButton.setBounds(50,170,150,30);
        contentPane.add(memberButton);

        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "inventory");
            }
        });
        inventoryButton.setBounds(50,220,150,30);
        contentPane.add(inventoryButton);

        logout.setBounds(50,270,150,30);
        contentPane.add(logout);
        logout.addActionListener(this::logoutAction);

        setContentPane(contentPane);

    }

    //Log out  account
    private void logoutAction(ActionEvent e) {
        int i = quitAction(e);
        if (i == 0) { //Back to the login screen
            new LoginFrame().setVisible(true);
        }
    }

    //Exit procedures
    private int quitAction(ActionEvent e) {
        int i = JOptionPane.showConfirmDialog(null, "Please confirm");
        if (i == 0) {
            dispose();
        }
        return i;
    }
}
