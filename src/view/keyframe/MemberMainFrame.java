package view.keyframe;

import dao.MemberDAO;
import dao.impl.MemberDAOImpl;
import view.baseview.KeyFrame;
import view.panel.MainPanel;
import view.panel.member.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Member operation page, this frame extends from the KeyFrame and should be able to choose operation as member 
 */
public class MemberMainFrame extends KeyFrame {

    private final CardLayout cardLayout = new CardLayout();

    public MemberMainFrame(String username) {
        super("Member Main Frame", 900, 650);
        MemberDAO dao = new MemberDAOImpl();
        String identity = dao.getIdentityByAccount(username);
        initFrame(username, identity);
    }

    private void initFrame(String username, String identity) {
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

        MainPanel main = new MainPanel(username, identity);
        panel.add(main, "main");
        PersonalInformation info = new PersonalInformation(username);
        panel.add(info, "info");
        JButton mainButton = new JButton("mainFrame");
        JButton infoButton = new JButton("personal info");

        if("membership".equals(identity)) {
            SelectCoursePanel course = new SelectCoursePanel(username);
            panel.add(course, "course");
            CoachesInfoPanel coaches = new CoachesInfoPanel();
            panel.add(coaches, "coaches");
            ClassSchedulePanel schedule = new ClassSchedulePanel();
            panel.add(schedule, "schedule");
            JButton selectButton = new JButton("select course");
            JButton coachesButton = new JButton("coaches info");
            JButton scheduleButton = new JButton("class schedule");

            selectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(panel, "course");
                }
            });
            selectButton.setBounds(50, 170, 150, 30);
            contentPane.add(selectButton);

            coachesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(panel, "coaches");
                }
            });
            coachesButton.setBounds(50, 220, 150, 30);
            contentPane.add(coachesButton);

            scheduleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(panel, "schedule");
                }
            });
            scheduleButton.setBounds(50, 270, 150, 30);
            contentPane.add(scheduleButton);
        } else {
            WorkPanel work = new WorkPanel(username);
            panel.add(work, "work");

            JButton workButton = new JButton("work info");

            workButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(panel, "work");
                }
            });
            workButton.setBounds(50, 170, 150, 30);
            contentPane.add(workButton);
        }

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

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "info");
            }
        });
        infoButton.setBounds(50, 120, 150, 30);
        contentPane.add(infoButton);

        logout.setBounds(50, 320, 150, 30);
        quit.setBounds(50, 370, 150, 30);
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
            new UserLoginFrame().setVisible(true);
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
