package view.keyframe;

import bean.Member;
import dao.MemberDAO;
import dao.impl.MemberDAOImpl;
import view.baseview.KeyFrame;
import view.minorframe.RegisterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * User login page，this frame extends from KeyFrame and user should be able to use this page to login
 */
public class UserLoginFrame extends KeyFrame {

    private JButton reset;
    private JTextField adminName;
    private JPasswordField password;
    private final MemberDAO memberDAO = new MemberDAOImpl();

    public UserLoginFrame() {
        super("Login in System", 900, 650);
        initFrame();
    }

    //fields for input when user it logging in
    private void initFrame() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);

        JLabel label = new JLabel("Login in For Member");
        label.setFont(new Font("", Font.BOLD, 40));

        JLabel name = new JLabel("Account");
        name.setFont(new Font("", Font.BOLD, 20));
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("", Font.BOLD, 20));

        adminName = new JTextField(12);
        adminName.setFont(new Font("", Font.BOLD, 20));
        password = new JPasswordField(12);
        password.setFont(new Font("", Font.BOLD, 20));
        password.setEchoChar('*');

        JButton login = new JButton("Login");
        reset = new JButton("reset");
        JButton register = new JButton("register");
        JButton back = new JButton("back");

        label.setBounds(230, 80, 600, 60);

        name.setBounds(200, 230, 100, 30);
        pass.setBounds(200, 330, 100, 30);
        adminName.setBounds(320, 233, 330, 30);
        password.setBounds(320, 333, 330, 30);

        login.setBounds(750, 370, 90, 45);
        reset.setBounds(750, 420, 90, 45);
        register.setBounds(750, 470, 90, 45);
        back.setBounds(750, 520, 90, 45);

        jpanel.add(name);
        jpanel.add(pass);
        jpanel.add(adminName);
        jpanel.add(password);
        jpanel.add(label);
        jpanel.add(login);
        jpanel.add(reset);
        jpanel.add(register);
        jpanel.add(back);

        login.addActionListener(this::loginAction);
        reset.addActionListener(this::resetAction);
        register.addActionListener(this::registerAction);
        back.addActionListener(this::backAction);

        setContentPane(jpanel);
    }

    //after log in
    private void loginAction(ActionEvent e) {
        String name = adminName.getText();
        String pass = new String(password.getPassword());
        boolean success = memberDAO.login(new Member(name, pass));
        if (success) {
            new MemberMainFrame(name).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "uncorrect password", "WRONG", JOptionPane.ERROR_MESSAGE);
            reset.doClick();
        }
    }

    //re log in
    private void resetAction(ActionEvent e) {
        adminName.setText("");
        password.setText("");
    }

    //register a account
    private void registerAction(ActionEvent e) {
        setEnabled(false); //Login window cannot be selected
        JFrame This = this;
        JFrame frame = new RegisterFrame(); //Go to the registration window
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) { //Close the registration window at the end of registration
                This.setEnabled(true);
                requestFocus(); //Activate login window
            }
        });
    }

    //go back to main log in page
    private void backAction(ActionEvent e) {
        new StartFrame().setVisible(true);
        dispose();
    }
}
