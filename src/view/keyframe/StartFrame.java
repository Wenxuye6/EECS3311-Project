package view.keyframe;

import view.baseview.KeyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//mainpage
/**
 *This class shows main page，this frame extends from KeyFrame.
 */
public class StartFrame extends KeyFrame {

    public StartFrame() {
        super("GymManageSystem", 900, 650);
        initFrame();
    }

    private void initFrame() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);

        JLabel labelTitle = new JLabel("GymManageSystem");
        labelTitle.setFont(new Font("", Font.BOLD, 40));
        JLabel info = new JLabel("This is a simple version, ONLY for Iteration 2");
        info.setFont(new Font("", Font.PLAIN, 15));

        //software should have two different portals of log in
        JButton user = new JButton("Log in as User");
        JButton admin = new JButton("Log in as Manage");

        //set positions of bars
        labelTitle.setBounds(250, 50, 600, 60);
        info.setBounds(300, 120, 500, 30);
        user.setBounds(500, 520, 150, 30);
        admin.setBounds(660, 520, 150, 30);

        jpanel.add(labelTitle);
        jpanel.add(info);
        jpanel.add(user);
        jpanel.add(admin);


        user.addActionListener(this::userAction);
        admin.addActionListener(this::adminAction);

        setContentPane(jpanel);
    }

    //log in as user
    private void userAction(ActionEvent e) {
        new UserLoginFrame().setVisible(true);
        dispose();
    }

    //log in as admin
    private void adminAction(ActionEvent e) {
        new LoginFrame().setVisible(true);
        dispose();
    }
}
