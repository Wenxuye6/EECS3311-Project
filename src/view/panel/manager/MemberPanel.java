package view.panel.manager;

import bean.Member;
import dao.MemberDAO;
import dao.ScheduleDAO;
import dao.impl.MemberDAOImpl;
import dao.impl.ScheduleDAOImpl;
import view.minorframe.AddMemberFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * User operating panel
 */
public class MemberPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tdm;
    private JTextField jtf11, jtf12, jtf13, jtf14, jtf15, jtf16, jtf17;
    private JRadioButton jrb1, jrb2;
    private JComboBox<String> jcb;
    private JButton addMember;
    private JButton modify;
    private final MemberDAO memberDAO = new MemberDAOImpl();
    private final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 0, 650);
        g.drawLine(618, 0, 618, 650);
        g.drawLine(0, 320, 100, 320);
        g.drawLine(100, 290, 100, 320);
    }

    public MemberPanel() {
        setLayout(null);
        initPanel();
    }

    private void initPanel() {
        initTable();

        addMember = new JButton("Add Member");
        modify = new JButton("modify");
        JButton delete = new JButton("delete");
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

        addMember.setBounds(50, 530, 120, 30);
        modify.setBounds(250, 530, 120, 30);
        delete.setBounds(450, 530, 120, 30);

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
        add(addMember);
        add(modify);
        add(delete);
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

        addMember.addActionListener(this::addMemberAction);
        modify.addActionListener(this::modifyAction);
        delete.addActionListener(this::deleteAction);
    }

    private void addMemberAction(ActionEvent e) {
        addMember.setEnabled(false);
        modify.setEnabled(false);
        JFrame frame = new AddMemberFrame();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                addMember.setEnabled(true);
                modify.setEnabled(true);
                Object[][] stu = memberDAO.getUserArrayList();
                String[] tableHeader = {"ID", "account", "pass", "realName", "gender", "height", "weight", "BMI", "Fund", "identity"};
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setDataVector(stu, tableHeader);
                table.getColumnModel().getColumn(0).setPreferredWidth(20);
                table.updateUI();
            }
        });
    }

    //Delete button
    private void deleteAction(ActionEvent e) {
        if (table.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "Too many selected!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Get selected row
        int row = table.getSelectedRow();
        if (row == -1) { //No selection
            JOptionPane.showMessageDialog(null, "Not selected!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int isFlag = JOptionPane.showConfirmDialog(null, "Please confirm");
        if (isFlag > 0) {
            return;
        }

        //search coach/member
        String name = (String) table.getValueAt(row, 1);
        if (scheduleDAO.coachExist(name) || scheduleDAO.memberExist(name)) {
            JOptionPane.showMessageDialog(null, "Delete not supported!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        memberDAO.deleteMemberById((int) table.getValueAt(row, 0));
        tdm.removeRow(row);
        resetValue(); //清空文本框
        jtf13.setEnabled(false);
        jtf14.setEnabled(false);
        jtf15.setEnabled(false);
        jtf16.setEnabled(false);
        jtf17.setEnabled(false);
        jcb.setEnabled(false);
        jrb1.setEnabled(false);
        jrb2.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Delete succeeded!");
    }

    //Modify button
    private void modifyAction(ActionEvent e) {
        if (table.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "Too many selected!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Get selected row
        int row = table.getSelectedRow();
        if (row == -1) { //No selection
            JOptionPane.showMessageDialog(null, "Not selected!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = jtf11.getText().trim();
        String account = jtf12.getText().trim();
        String realName = jtf13.getText().trim();
        String height = jtf14.getText().trim();
        String weight = jtf15.getText().trim();
        String BMI = jtf16.getText().trim();
        String Fund = jtf17.getText().trim();
        String identity = (String) jcb.getSelectedItem();
        if ("".equals(account) || "".equals(realName) || "".equals(height) || "".equals(weight) || "".equals(BMI) || "".equals(Fund) || "Please Select……".equals(identity)) {
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

        //search coach/member
        String name = (String) table.getValueAt(row, 1);
        if (scheduleDAO.coachExist(name) || scheduleDAO.memberExist(name)) {
            if(!Objects.equals(identity, table.getValueAt(row, 9))) {
                JOptionPane.showMessageDialog(null, "Modified not supported!", "warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        Member newMember = new Member(Integer.parseInt(id), account, (String) (table.getValueAt(row, 2)), realName, gender,
                Double.parseDouble(height), Double.parseDouble(weight), Double.parseDouble(BMI), Double.parseDouble(Fund), identity);
        memberDAO.change(newMember);

        table.setValueAt(account, row, 1);
        table.setValueAt(realName, row, 3);
        table.setValueAt(gender, row, 4);
        table.setValueAt(height, row, 5);
        table.setValueAt(weight, row, 6);
        table.setValueAt(BMI, row, 7);
        table.setValueAt(Fund, row, 8);
        table.setValueAt(identity, row, 9);
        JOptionPane.showMessageDialog(null, "Modified successfully!");
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
        jtf13.setEnabled(true);
        jtf14.setEnabled(true);
        jtf15.setEnabled(true);
        jtf16.setEnabled(true);
        jtf17.setEnabled(true);
        jcb.setEnabled(true);
        jrb1.setEnabled(true);
        jrb2.setEnabled(true);
    }

    //Initialization Form
    private void initTable() {
        //Create a form
        String[] columnNames = {"ID", "account", "pass", "realName", "gender", "height", "weight", "BMI", "Fund", "identity"};
        Object[][] rowType = memberDAO.getUserArrayList();
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
