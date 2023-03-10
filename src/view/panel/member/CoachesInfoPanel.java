package view.panel.member;

import dao.MemberDAO;
import dao.impl.MemberDAOImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/**
  * Welcome to CoachesInfoPanel class, this class extends from Jpael and should be able to show all informations about coaches 
  */

public class CoachesInfoPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tdm;
    private JTextField jtf11, jtf12, jtf13, jtf14, jtf15, jtf16, jtf17;
    private JRadioButton jrb1, jrb2;
    private JComboBox<String> jcb;
    private final MemberDAO memberDAO = new MemberDAOImpl();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 0, 650);
        g.drawLine(618, 0, 618, 650);
        g.drawLine(0, 320, 100, 320);
        g.drawLine(100, 290, 100, 320);
    }

    public CoachesInfoPanel() {
        setLayout(null);
        initPanel();
    }

    private void initPanel() {
        initTable();

        //Membership Information
        JScrollPane jsp = new JScrollPane(table);
        //Information column
        Label jl10 = new Label("Info Bar");
        jl10.setFont(new Font("", Font.BOLD, 15));

        Label jl11 = new Label("ID:");
        Label jl12 = new Label("account:");
        Label jl13 = new Label("realName:");
        Label jl14 = new Label("gender:");
        Label jl15 = new Label("height:");
        Label jl16 = new Label("weight:");
        Label jl17 = new Label("BMI:");
        Label jl18 = new Label("Fund:");
        Label jl19 = new Label("identity:");
        jtf11 = new JTextField(); //ID
        jtf12 = new JTextField(); //account
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
        jtf12.setEnabled(false);
        jtf13.setEnabled(false);
        jtf14.setEnabled(false);
        jtf15.setEnabled(false);
        jtf16.setEnabled(false);
        jtf17.setEnabled(false);
        jcb.setEnabled(false);
        jrb1.setEnabled(false);
        jrb2.setEnabled(false);

        jsp.setBounds(0, 0, 620, 290);

        jl10.setBounds(20, 290, 80, 30);
        jl11.setBounds(20, 330, 40, 30);
        jl12.setBounds(180, 330, 60, 30);
        jl13.setBounds(400, 330, 60, 30);
        jl14.setBounds(20, 400, 60, 30);
        jl15.setBounds(260, 400, 60, 30);
        jl16.setBounds(430, 400, 60, 30);
        jl17.setBounds(20, 470, 40, 30);
        jl18.setBounds(200, 470, 50, 30);
        jl19.setBounds(380, 470, 60, 30);
        jtf11.setBounds(60, 332, 60, 30);
        jtf12.setBounds(250, 332, 100, 30);
        jtf13.setBounds(480, 332, 100, 30);
        jtf14.setBounds(320, 402, 90, 30);
        jtf15.setBounds(490, 402, 90, 30);
        jtf16.setBounds(70, 472, 90, 30);
        jtf17.setBounds(250, 472, 90, 30);
        jrb1.setBounds(80, 402, 70, 30);
        jrb2.setBounds(150, 402, 80, 30);
        jcb.setBounds(440, 472, 140, 30);

        fillJcb();

        add(jsp);
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

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                MousePressed();
            }
        });
    }

    //Listening for mouse click events
    private void MousePressed() {
        int row = table.getSelectedRow();
//        System.out.println(row);
        jtf11.setText(String.valueOf(table.getValueAt(row, 0)));
        jtf12.setText(String.valueOf(table.getValueAt(row, 1)));
        jtf13.setText(String.valueOf(table.getValueAt(row, 3)));
        jtf14.setText(String.valueOf(table.getValueAt(row, 5)));
        jtf15.setText(String.valueOf(table.getValueAt(row, 6)));
        jtf16.setText(String.valueOf(table.getValueAt(row, 7)));
        jtf17.setText(String.valueOf(table.getValueAt(row, 8)));
        String gender = String.valueOf(table.getValueAt(row, 4));
        if ("male".equals(gender)) {
            jrb1.setSelected(true);
        } else if ("female".equals(gender)) {
            jrb2.setSelected(true);
        }
        String identity = String.valueOf(table.getValueAt(row, 9));
        jcb.setSelectedItem(identity);
    }

    //Initialization Form
    private void initTable() {
        //Create a form
        String[] columnNames = {"ID", "account", "pass", "realName", "gender", "height", "weight", "BMI", "Fund", "identity"};
        Object[][] rowType = memberDAO.getCoachArrayList();
        tdm = new DefaultTableModel(rowType, columnNames);
        table = new JTable(tdm) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //Not editable, but optional
            }
        };
        //
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, dtcr);

        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(5).setPreferredWidth(70);
        table.getColumnModel().getColumn(6).setPreferredWidth(70);
        table.getColumnModel().getColumn(7).setPreferredWidth(70);
        table.getColumnModel().getColumn(8).setPreferredWidth(70);
        table.getColumnModel().getColumn(9).setPreferredWidth(70);

        table.getTableHeader().setReorderingAllowed(false); //Cannot change the position of a column
    }

    private void resetValue() {
        jtf11.setText("");
        jtf12.setText("");
        jtf13.setText("");
        jtf14.setText("");
        jtf15.setText("");
        jtf16.setText("");
        jtf17.setText("");
        jrb1.setSelected(false);
        jrb2.setSelected(false);
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
