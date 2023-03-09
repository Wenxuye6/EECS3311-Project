package view.keyframe;

import view.baseview.KeyFrame;
import view.panel.manager.ManageCoursePanel;
import view.panel.MainPanel;
import view.panel.manager.MemberPanel;
import view.panel.member.CoachesInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Administrator operation page
 */
public class GymManageMainFrame extends KeyFrame {

    private final CardLayout cardLayout = new CardLayout();

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

        MainPanel main = new MainPanel(username, "admin");
        panel.add(main, "main");
        ManageCoursePanel course = new ManageCoursePanel();
        panel.add(course, "course");
        MemberPanel member = new MemberPanel();
        panel.add(member, "member");
//        InventoryPanel inventory = new InventoryPanel();
//        panel.add(inventory, "inventory");
        CoachesInfoPanel manage = new CoachesInfoPanel();
        panel.add(manage, "manage");

        JButton mainButton = new JButton("mainFrame");
        JButton courseButton = new JButton("manage course");
        JButton memberButton = new JButton("manage member");
//        JButton inventoryButton = new JButton("inventory view");
//        JButton manageButton = new JButton("Modify managers");
//        JButton equipmentButton = new JButton("Equipment info");
        JButton logout = new JButton("Logging Out");
        JButton quit = new JButton("Quit Out");

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "main");
            }
        });
        mainButton.setBounds(50, 70, 150, 30);
        contentPane.add(mainButton);

        courseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "course");
            }
        });
        courseButton.setBounds(50, 120, 150, 30);
        contentPane.add(courseButton);

        memberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "member");
            }
        });
        memberButton.setBounds(50, 170, 150, 30);
        contentPane.add(memberButton);

//        inventoryButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(panel, "inventory");
//            }
//        });
//        inventoryButton.setBounds(50, 220, 150, 30);
//        contentPane.add(inventoryButton);

//        manageButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(panel, "manage");
//            }
//        });
//        manageButton.setBounds(50, 270, 150, 30);
//        contentPane.add(manageButton);

//        equipmentButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(panel, "equipment");
//            }
//        });
//        equipmentButton.setBounds(50, 320, 150, 30);
//        contentPane.add(equipmentButton);

        logout.setBounds(50, 370, 150, 30);
        quit.setBounds(50, 420, 150, 30);
        contentPane.add(logout);
        contentPane.add(quit);
        logout.addActionListener(this::logoutAction);
        quit.addActionListener(this::quitAction);

        setContentPane(contentPane);
    }

    //Log out account
    private void logoutAction(ActionEvent e) {
        int i = JOptionPane.showConfirmDialog(null, "Please confirm");
        if (i == 0) { //Back to the login screen
            dispose();
            new LoginFrame().setVisible(true);
        }
    }

    //Exit procedures
    private void quitAction(ActionEvent e) {
        int i = JOptionPane.showConfirmDialog(null, "Please confirm");
        if (i == 0) {
            System.exit(1);
        }
    }
}
