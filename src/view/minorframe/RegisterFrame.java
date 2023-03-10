package view.minorframe;

import bean.Member;
import dao.MemberDAO;
import dao.impl.MemberDAOImpl;
import view.baseview.MinorFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * User registration interface, this class extends from MinorFrame and user should be able to use this class to rigister for being a member.
 */
public class RegisterFrame extends MinorFrame {

    private JTextField jtf;
    private JPasswordField jpf1, jpf2;
    private JButton jb1, jb3;
    private JComboBox<String> jcb;
    private final MemberDAO memberDAO = new MemberDAOImpl();

    public RegisterFrame() {
        super("member register frame", 500, 435);
        initFrame();
    }

    private void initFrame() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        //fields for input when registeration
        JLabel jl1 = new JLabel("Account");
        JLabel jl2 = new JLabel("Password");
        JLabel jl3 = new JLabel("RePassword");
        JLabel jl4 = new JLabel("identity");
        jl1.setBounds(60, 45, 165, 25);
        jl2.setBounds(60, 100, 165, 25);
        jl3.setBounds(60, 155, 165, 25);
        jl4.setBounds(60, 210, 165, 25);
        jl1.setFont(new Font("", Font.PLAIN, 25));
        jl2.setFont(new Font("", Font.PLAIN, 25));
        jl3.setFont(new Font("", Font.PLAIN, 25));
        jl4.setFont(new Font("", Font.PLAIN, 25));
        jcb = new JComboBox<>();
        jcb.setBounds(225, 213, 140, 30);
        fillJcb();
        jtf = new JTextField();
        jpf1 = new JPasswordField();
        jpf2 = new JPasswordField();
        jtf.setBounds(225, 48, 200, 25);
        jtf.setFont(new Font("", Font.PLAIN, 25));
        jpf1.setBounds(225, 103, 200, 25);
        jpf1.setFont(new Font("", Font.PLAIN, 25));
        jpf1.setEchoChar('\u2605');
        jpf2.setBounds(225, 158, 200, 25);
        jpf2.setFont(new Font("", Font.PLAIN, 25));
        jpf2.setEchoChar('\u2605');

        jb1 = new JButton("register");
        JButton jb2 = new JButton("cancel");
        jb3 = new JButton("reset");
        jb1.setBounds(70, 285, 80, 40);
        jb1.setFont(new Font("", Font.PLAIN, 12));
        jb2.setBounds(200, 285, 80, 40);
        jb2.setFont(new Font("", Font.PLAIN, 12));
        jb3.setBounds(330, 285, 80, 40);
        jb3.setFont(new Font("", Font.PLAIN, 12));

        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == KeyEvent.VK_ENTER) {
                    jpf1.grabFocus();
                }
            }
        });

        jpf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == KeyEvent.VK_ENTER) {
                    jpf2.grabFocus();
                }
            }
        });

        jpf2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == KeyEvent.VK_ENTER) {
                    jb1.doClick();
                }
            }
        });

        jPanel.add(jl1);
        jPanel.add(jl2);
        jPanel.add(jl3);
        jPanel.add(jl4);
        jPanel.add(jtf);
        jPanel.add(jpf1);
        jPanel.add(jpf2);
        jPanel.add(jb1);
        jPanel.add(jb2);
        jPanel.add(jb3);
        jPanel.add(jcb);

        jb1.addActionListener(this::registerAction);
        jb2.addActionListener(this::cancelAction);
        jb3.addActionListener(this::resetAction);

        setContentPane(jPanel);
    }

    //Register button
    private void registerAction(ActionEvent e) {
        String username = jtf.getText().trim();
        String password1 = String.valueOf(jpf1.getPassword()).trim();
        String password2 = String.valueOf(jpf2.getPassword()).trim();
        String identity = (String)jcb.getSelectedItem();
        if ("".equals(username)) {
            JOptionPane.showMessageDialog(null, "uncorrect account!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if ("".equals(password1)) {
            JOptionPane.showMessageDialog(null, "uncorrect password!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if ("".equals(password2)) {
            JOptionPane.showMessageDialog(null, "uncorrect password!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!password1.equals(password2)) {
            JOptionPane.showMessageDialog(null, "uncorrect password!", "warning", JOptionPane.WARNING_MESSAGE);
            jb3.doClick();
            return;
        }

        if ("Please Select……".equals(identity)) {
            JOptionPane.showMessageDialog(null, "uncorrect identity!", "warning", JOptionPane.WARNING_MESSAGE);
            jb3.doClick();
            return;
        }

        Member member = new Member(0, username, password1, "unknown", "unknown", 0.0, 0.0, 0.0, 0.0, identity);

        boolean isSuccess = memberDAO.addMember(member);
        if (isSuccess) {
            JOptionPane.showMessageDialog(null, "success!");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "account exists!", "WRONG", JOptionPane.ERROR_MESSAGE);
            jb3.doClick();
        }
    }

    //Cancel button
    private void cancelAction(ActionEvent e) {
        this.dispose();
    }

    //Reset button
    private void resetAction(ActionEvent e) {
        jtf.setText("");
        jpf1.setText("");
        jpf2.setText("");
        jcb.setSelectedIndex(0);
    }

    //Drop down menu
    private void fillJcb() {
        jcb.addItem("Please Select……");
        jcb.addItem("membership");
        jcb.addItem("coach");
        jcb.addItem("front desk");
        jcb.addItem("janitorial");
    }
}
