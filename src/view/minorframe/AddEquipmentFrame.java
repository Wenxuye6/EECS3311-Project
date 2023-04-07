package view.minorframe;

import bean.Course;
import bean.Equipment;
import dao.EquipmentDAO;
import dao.impl.EquipmentDAOImpl;
import util.CheckDigitUtil;
import view.baseview.MinorFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddEquipmentFrame extends MinorFrame {

    private final EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
    private JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
    private JTextArea jta;

    public AddEquipmentFrame() {
        super("Add New Equipment", 580, 500);
        initFrame();
    }

    private void initFrame() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JButton addEquipment = new JButton("add equipment");
        JButton reset = new JButton("reset");

        Label jl11 = new Label("ID:");
        Label jl12 = new Label("equipmentName:");
        Label jl13 = new Label("currentNum:");
        Label jl14 = new Label("damagedNum:");
        Label jl15 = new Label("marketPrice:");
        Label jl16 = new Label("value:");
        jtf1 = new JTextField(); //ID
        jtf2 = new JTextField(); //equipmentName
        jtf3 = new JTextField(); //currentNum
        jtf4 = new JTextField(); //damagedNum
        jtf5 = new JTextField(); //marketPrice
        jta = new JTextArea(); //value
        JScrollPane jsp0 = new JScrollPane();

        jl11.setBounds(20, 30, 90, 30);
        jl12.setBounds(270, 30, 100, 30);
        jl13.setBounds(20, 90, 90, 30);
        jl14.setBounds(270, 90, 90, 30);
        jl15.setBounds(20, 150, 90, 30);
        jl16.setBounds(20, 210, 90, 30);
        jtf1.setBounds(120, 30, 120, 30);
        jtf1.setEnabled(false);
        jtf2.setBounds(380, 30, 120, 30);
        jtf3.setBounds(120, 90, 120, 30);
        jtf4.setBounds(380, 90, 120, 30);
        jtf5.setBounds(120, 150, 120, 30);
        jsp0.setBounds(20, 240, 480, 100);
        addEquipment.setBounds(250, 360, 120, 40);
        reset.setBounds(410, 360, 120, 40);

        jsp0.setViewportView(jta);
        jPanel.add(addEquipment);
        jPanel.add(reset);
        jPanel.add(jl11);
        jPanel.add(jl12);
        jPanel.add(jl13);
        jPanel.add(jl14);
        jPanel.add(jl15);
        jPanel.add(jl16);
        jPanel.add(jtf1);
        jPanel.add(jtf2);
        jPanel.add(jtf3);
        jPanel.add(jtf4);
        jPanel.add(jtf5);
        jPanel.add(jsp0);

        addEquipment.addActionListener(this::addEquipmentAction);
        reset.addActionListener(this::resetAction);

        setContentPane(jPanel);
    }

    private void addEquipmentAction(ActionEvent e) {
        String name = jtf2.getText().trim();
        String price = jtf5.getText().trim();
        String currentNum = jtf3.getText().trim();
        String damagedNum = jtf4.getText().trim();
        String value = jta.getText().trim();
        if ("".equals(name) || "".equals(price) || "".equals(value) || "".equals(currentNum) || "".equals(damagedNum)) {
            JOptionPane.showMessageDialog(null, "Not filled in correctly!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!CheckDigitUtil.check(price)) { //digit
            JOptionPane.showMessageDialog(null, "Not filled in correctly!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int isFlag = JOptionPane.showConfirmDialog(null, "Please confirm");
        if (isFlag > 0) {
            return;
        }

        Equipment equipment = new Equipment(0, name, Integer.parseInt(currentNum), Integer.parseInt(damagedNum), Double.parseDouble(price), value);
        boolean success = equipmentDAO.addEquipment(equipment);
        if(success) {
            JOptionPane.showMessageDialog(null, "success!");
        } else {
            JOptionPane.showMessageDialog(null, "equipment exists!", "warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    //reset button
    private void resetAction(ActionEvent e) {
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
        jtf4.setText("");
        jtf5.setText("");
        jta.setText("");
    }
}
