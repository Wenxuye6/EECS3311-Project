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
 * Administrator operation page, this class extends from KeyFrame and should be able to allow administrator to do some operations 
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

        CoachesInfoPanel manage = new CoachesInfoPanel();
        panel.add(manage, "manage");

        JButton mainButton = new JButton("mainFrame");
        JButton courseButton = new JButton("manage course");
        JButton memberButton = new JButton("manage member");

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
