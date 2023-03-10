package view.panel.member;

import bean.Member;
import dao.MemberDAO;
import dao.impl.MemberDAOImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PersonalInformation extends JPanel {

    private JTextField jtf11, jtf12, jtf13, jtf14, jtf15, jtf16, jtf17;
    private JRadioButton jrb1, jrb2;
    private JComboBox<String> jcb;
    private JButton modify;
    private final MemberDAO memberDAO = new MemberDAOImpl();

    public PersonalInformation(String account) {
        setLayout(null);
        initPanel(account);
    }

    private void initPanel(String account) {
        modify = new JButton("modify");
        //Membership Information
        //Information column
        Label jl10 = new Label("Info Bar");
        jl10.setFont(new Font("", Font.BOLD, 15));

        Label jl11 = new Label("account::");
        Label jl12 = new Label("password:");
        Label jl13 = new Label("realName:");
        Label jl14 = new Label("gender:");
        Label jl15 = new Label("height:");
        Label jl16 = new Label("weight:");
        Label jl17 = new Label("BMI:");
        Label jl18 = new Label("Fund:");
        Label jl19 = new Label("identity:");
        jtf11 = new JTextField(); //account
        jtf12 = new JTextField(); //password
        jtf13 = new JTextField(); //realName
        jtf14 = new JTextField(); //height
        jtf15 = new JTextField(); //weight
        jtf16 = new JTextField(); //BMI
        jtf17 = new JTextField(); //Fund
        jrb1 = new JRadioButton("male");
        jrb2 = new JRadioButton("female");
        ButtonGroup bg = new ButtonGroup(); //gender
        bg.add(jrb1);
        bg.add(jrb2);
        jcb = new JComboBox<>(); //identity

        jtf11.setEnabled(false);

        modify.setBounds(450, 380, 120, 30);

        jl10.setBounds(20, 90, 80, 30);
        jl11.setBounds(20, 130, 40, 30);
        jl12.setBounds(180, 130, 60, 30);
        jl13.setBounds(400, 130, 60, 30);
        jl14.setBounds(20, 200, 60, 30);
        jl15.setBounds(260, 200, 60, 30);
        jl16.setBounds(430, 200, 60, 30);
        jl17.setBounds(20, 270, 40, 30);
        jl18.setBounds(200, 270, 50, 30);
        jl19.setBounds(380, 270, 60, 30);
        jtf11.setBounds(60, 132, 60, 30);
        jtf12.setBounds(250, 132, 100, 30);
        jtf13.setBounds(480, 132, 100, 30);
        jtf14.setBounds(320, 202, 90, 30);
        jtf15.setBounds(490, 202, 90, 30);
        jtf16.setBounds(70, 272, 90, 30);
        jtf17.setBounds(250, 272, 90, 30);
        jrb1.setBounds(80, 202, 70, 30);
        jrb2.setBounds(150, 202, 80, 30);
        jcb.setBounds(440, 272, 140, 30);

        fillJcb();
        initInfo(account);

        add(modify);
        add(jl10);
        add(jl11);
        add(jl12);
        add(jl13);
        add(jl14);
        add(jl15);
        add(jl16);
        add(jl17);
        add(jl18);
        add(jl19);
        add(jtf11);
        add(jtf12);
        add(jtf13);
        add(jtf14);
        add(jtf15);
        add(jtf16);
        add(jtf17);
        add(jcb);
        add(jrb1);
        add(jrb2);

        modify.addActionListener(this::modifyAction);
    }


    //Modify button
    private void modifyAction(ActionEvent e) {
        String account = jtf11.getText().trim();
        Member member = memberDAO.getMemberByAccount(account);
        String password = jtf12.getText().trim();
        String realName = jtf13.getText().trim();
        String height = jtf14.getText().trim();
        String weight = jtf15.getText().trim();
        String BMI = jtf16.getText().trim();
        String Fund = jtf17.getText().trim();
        String identity = (String) jcb.getSelectedItem();
        if ("".equals(password) || "".equals(realName) || "".equals(height) || "".equals(weight) || "".equals(BMI) || "".equals(Fund) || "Please Select……".equals(identity)) {
            JOptionPane.showMessageDialog(null, "Not filled in correctly!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String gender;
        if (jrb1.isSelected()) {
            gender = "male";
        } else if (jrb2.isSelected()) {
            gender = "female";
        } else {
            gender = "unknown";
        }

        int isFlag = JOptionPane.showConfirmDialog(null, "Please confirm");
        if (isFlag > 0) {
            return;
        }

        Member newMember = new Member(member.getMemberId(), account, password, realName, gender, Double.parseDouble(height),
                Double.parseDouble(weight), Double.parseDouble(BMI), Double.parseDouble(Fund), identity);
        memberDAO.change(newMember);
        JOptionPane.showMessageDialog(null, "Modified successfully!");
    }

    private void initInfo(String account) {
        Member member = memberDAO.getMemberByAccount(account);
        jtf11.setText(account);
        jtf12.setText(member.getPassword());
        jtf13.setText(member.getRealName());
        jtf14.setText(String.valueOf(member.getHeight()));
        jtf15.setText(String.valueOf(member.getWeight()));
        jtf16.setText(String.valueOf(member.getBMI()));
        jtf17.setText(String.valueOf(member.getFund()));
        String gender = member.getGender();
        if ("male".equals(gender)) {
            jrb1.setSelected(true);
        } else if ("female".equals(gender)) {
            jrb2.setSelected(true);
        }
        String identity = member.getIdentity();
        jcb.setSelectedItem(identity);
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
