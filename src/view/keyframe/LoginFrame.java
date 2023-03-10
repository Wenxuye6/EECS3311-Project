package view.keyframe;

import bean.Admin;
import dao.AdminDAO;
import dao.impl.AdminDAOImpl;
import view.baseview.KeyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Administrator login page, this page is for administrator to login 
 */
public class LoginFrame extends KeyFrame {

    private JButton reset;
    private JTextField adminName;
    private JPasswordField password;
    private final AdminDAO adminDAO = new AdminDAOImpl();

    public LoginFrame() {
        super("Gym Management System Login in", 900, 650);
        initFrame();
    }

    private void initFrame() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);

        JLabel label = new JLabel("Login in For Manager");
        label.setFont(new Font("", Font.BOLD, 40));

        JLabel name = new JLabel("Account");
        name.setFont(new Font("", Font.BOLD, 20));
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("", Font.BOLD, 20));

        adminName = new JTextField(12);
        adminName.setFont(new Font("", Font.BOLD, 20));
        adminName.setText("admin");
        password = new JPasswordField(12);
        password.setFont(new Font("", Font.BOLD, 20));
        password.setEchoChar('*');

        JButton login = new JButton("Login");
        reset = new JButton("reset");
        JButton back = new JButton("back");

        label.setBounds(230, 80, 600, 60);

        name.setBounds(200, 230, 100, 30);
        pass.setBounds(200, 330, 100, 30);
        adminName.setBounds(320, 233, 330, 30);
        password.setBounds(320, 333, 330, 30);

        login.setBounds(750, 420, 90, 45);
        reset.setBounds(750, 470, 90, 45);
        back.setBounds(750, 520, 90, 45);

        jpanel.add(name);
        jpanel.add(pass);
        jpanel.add(adminName);
        jpanel.add(password);
        jpanel.add(label);
        jpanel.add(login);
        jpanel.add(reset);
        jpanel.add(back);

        //Button Listener
        login.addActionListener(this::loginAction);
        reset.addActionListener(this::resetAction);
        back.addActionListener(this::backAction);

        setContentPane(jpanel);
    }

    private void loginAction(ActionEvent e) {
        String name = adminName.getText();
        String pass = new String(password.getPassword());
        boolean success = adminDAO.login(new Admin(name, pass));
        if (success) {
            new GymManageMainFrame(name).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "uncorrect password", "error", JOptionPane.ERROR_MESSAGE);
            //Reset text box
            reset.doClick();
        }
    }

    private void resetAction(ActionEvent e) {
        adminName.setText("");
        password.setText("");
    }

    private void backAction(ActionEvent e) {
        new StartFrame().setVisible(true);
        dispose();
    }

}
