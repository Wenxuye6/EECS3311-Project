package view.keyframe;

import view.baseview.KeyFrame;
import view.panel.manager.EquipmentPanel;
import view.panel.manager.ManageCoursePanel;
import view.panel.MainPanel;
import view.panel.manager.MemberPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Administrator operation page, this class extends from KeyFrame and should be able to allow administrator to do some operations
 */
public class GymManageMainFrame extends KeyFrame {

    private final CardLayout cardLayout = new CardLayout();
    private JButton mainButton, courseButton, memberButton, equipmentButton, logout, quit;

    //fields for admin to input
    public GymManageMainFrame(String account) {
        super("GymManageSystem", 900, 650);
        initFrame(account);
    }

    //input account
    private void initFrame(String account) {
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

        MainPanel main = new MainPanel(account, "admin");
        panel.add(main, "main");
        ManageCoursePanel course = new ManageCoursePanel();
        panel.add(course, "course");
        MemberPanel member = new MemberPanel();
        panel.add(member, "member");
        EquipmentPanel equipment = new EquipmentPanel();
        panel.add(equipment, "equipment");

        setButtonList();
        setLayOut(panel);
        contentPane.add(mainButton);
        contentPane.add(courseButton);
        contentPane.add(memberButton);
        contentPane.add(equipmentButton);
        contentPane.add(logout);
        contentPane.add(quit);
        logout.addActionListener(this::logoutAction);
        quit.addActionListener(this::quitAction);

        setContentPane(contentPane);
    }

    private void setButtonList() {
        mainButton = new JButton("mainFrame");
        courseButton = new JButton("manage course");
        memberButton = new JButton("manage member");
        equipmentButton = new JButton("manage equipment");
        logout = new JButton("Logging Out");
        quit = new JButton("Quit Out");
    }

    private void setLayOut(JPanel panel) {
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "main");
            }
        });
        mainButton.setBounds(50, 70, 150, 30);
        courseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "course");
            }
        });
        courseButton.setBounds(50, 120, 150, 30);
        memberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "member");
            }
        });
        memberButton.setBounds(50, 170, 150, 30);
        equipmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "equipment");
            }
        });
        equipmentButton.setBounds(50, 220, 150, 30);
        logout.setBounds(50, 370, 150, 30);
        quit.setBounds(50, 420, 150, 30);
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
