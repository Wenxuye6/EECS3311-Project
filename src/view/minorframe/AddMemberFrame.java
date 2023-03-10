package view.minorframe;

import bean.Member;
import dao.MemberDAO;
import dao.impl.MemberDAOImpl;
import view.baseview.MinorFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * add new member interface, this class extends from MinorFrame and should be able to add new member to the system
 */

public class AddMemberFrame extends MinorFrame {

    private JTextField jtf11, jtf12, jtf13, jtf14, jtf15, jtf16, jtf17, pass2;
    private JRadioButton jrb1, jrb2;
    private JComboBox<String> jcb;
    private final MemberDAO memberDAO = new MemberDAOImpl();

    public AddMemberFrame() {
        super("Add New Member", 840, 300);
        initFrame();
    }

    private void initFrame() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JButton addMember = new JButton("add member");
        JButton reset = new JButton("reset");

        Label jl11 = new Label("ID:");
        Label jl12 = new Label("account:");
        Label jl13 = new Label("realName:");
        Label jl14 = new Label("gender:");
        Label jl15 = new Label("height:");
        Label jl16 = new Label("weight:");
        Label jl17 = new Label("BMI:");
        Label jl18 = new Label("Fund:");
        Label jl19 = new Label("identity:");
        Label pass1 = new Label("pass:");
        jtf11 = new JTextField(); //ID
        jtf11.setEnabled(false);
        jtf12 = new JTextField(); //account
        jtf13 = new JTextField(); //realName
        jtf14 = new JTextField(); //height
        jtf15 = new JTextField(); //weight
        jtf16 = new JTextField(); //BMI
        jtf17 = new JTextField(); //Fund
        pass2 = new JTextField(); //pass
        jrb1 = new JRadioButton("male");
        jrb2 = new JRadioButton("female");
        ButtonGroup bg = new ButtonGroup(); //gender
        bg.add(jrb1);
        bg.add(jrb2);
        jcb = new JComboBox<>(); //identity
        jl11.setBounds(20, 30, 40, 30);
        jl12.setBounds(180, 30, 60, 30);
        jl13.setBounds(400, 30, 60, 30);
        jl14.setBounds(20, 100, 60, 30);
        jl15.setBounds(260, 100, 60, 30);
        jl16.setBounds(430, 100, 60, 30);
        jl17.setBounds(20, 170, 40, 30);
        jl18.setBounds(200, 170, 50, 30);
        jl19.setBounds(380, 170, 60, 30);
        jtf11.setBounds(60, 32, 60, 30);
        jtf12.setBounds(250, 32, 100, 30);
        jtf13.setBounds(480, 32, 100, 30);
        jtf14.setBounds(320, 102, 90, 30);
        jtf15.setBounds(490, 102, 90, 30);
        jtf16.setBounds(70, 172, 90, 30);
        jtf17.setBounds(250, 172, 90, 30);
        pass1.setBounds(630, 30, 40, 30);
        pass2.setBounds(690, 32, 90, 30);
        jrb1.setBounds(80, 102, 70, 30);
        jrb2.setBounds(150, 102, 80, 30);
        jcb.setBounds(440, 172, 140, 30);
        reset.setBounds(650, 102, 120, 40);
        addMember.setBounds(650, 172, 120, 40);

        fillJcb();

        jPanel.add(jl11);
        jPanel.add(jl12);
        jPanel.add(jl13);
        jPanel.add(jl14);
        jPanel.add(jl15);
        jPanel.add(jl16);
        jPanel.add(jl17);
        jPanel.add(jl18);
        jPanel.add(jl19);
        jPanel.add(jtf11);
        jPanel.add(jtf12);
        jPanel.add(jtf13);
        jPanel.add(jtf14);
        jPanel.add(jtf15);
        jPanel.add(jtf16);
        jPanel.add(jtf17);
        jPanel.add(pass1);
        jPanel.add(pass2);
        jPanel.add(jcb);
        jPanel.add(jrb1);
        jPanel.add(jrb2);
        jPanel.add(addMember);
        jPanel.add(reset);

        addMember.addActionListener(this::addMemberAction);
        reset.addActionListener(this::resetAction);

        setContentPane(jPanel);
    }

    private void addMemberAction(ActionEvent e) {
        String account = jtf12.getText().trim();
        String realName = jtf13.getText().trim();
        String height = jtf14.getText().trim();
        String weight = jtf15.getText().trim();
        String BMI = jtf16.getText().trim();
        String Fund = jtf17.getText().trim();
        String pass = pass2.getText().trim();
        String identity = (String) jcb.getSelectedItem();
        String gender = "";
        if(jrb1.isSelected()) {
            gender = "male";
        } else if(jrb2.isSelected()) {
            gender = "female";
        }
        if ("".equals(account) || "".equals(realName) || "".equals(pass) ||"".equals(height) || "".equals(weight) || "".equals(BMI) || "".equals(Fund) ||"".equals(gender) || "Please Select……".equals(identity)) {
            JOptionPane.showMessageDialog(null, "Not filled in correctly!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int isFlag = JOptionPane.showConfirmDialog(null, "Please confirm");
        if (isFlag > 0) {
            return;
        }

        Member member = new Member(0, account, pass, realName, gender, Double.parseDouble(height), Double.parseDouble(weight), Double.parseDouble(BMI), Double.parseDouble(Fund), identity);
        boolean success = memberDAO.addMember(member);
        if(success) {
            JOptionPane.showMessageDialog(null, "Successfully added!");
        } else {
            JOptionPane.showMessageDialog(null, "account exists!", "warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetAction(ActionEvent e) {
        jrb1.setSelected(false);
        jrb2.setSelected(false);
        pass2.setText("");
        jtf11.setText("");
        jtf12.setText("");
        jtf13.setText("");
        jtf14.setText("");
        jtf15.setText("");
        jtf16.setText("");
        jtf17.setText("");
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
