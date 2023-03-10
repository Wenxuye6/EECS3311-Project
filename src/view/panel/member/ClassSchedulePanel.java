package view.panel.member;

import bean.Schedule;
import dao.MemberDAO;
import dao.ScheduleDAO;
import dao.impl.MemberDAOImpl;
import dao.impl.ScheduleDAOImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClassSchedulePanel extends JPanel {

    private JTable table;
    private DefaultTableModel tdm;
    private JTextField jtf1, jtf2, jtf3;
    private JComboBox<String> jcb;
    private final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
    private final MemberDAO memberDAO = new MemberDAOImpl();
    private JButton modify, renovate, delete;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 0, 650);
        g.drawLine(618, 0, 618, 650);
        g.drawLine(0, 320, 100, 320);
        g.drawLine(100, 290, 100, 320);
    }

    public ClassSchedulePanel() {
        setLayout(null);
        initPanel();
    }

    private void initPanel() {
        initTable();

        jcb = new JComboBox<>();
        modify = new JButton("modify");
        renovate = new JButton("renovate");
        delete = new JButton("delete");
        //Course Information
        //Information column
        Label jl10 = new Label("Info Bar");
        jl10.setFont(new Font("", Font.BOLD, 15));

        JScrollPane jsp = new JScrollPane(table);

        Label jl11 = new Label("ID:");
        Label jl12 = new Label("memberName:");
        Label jl13 = new Label("courseName:");
        Label jl14 = new Label("coachName:");
        jtf1 = new JTextField(); //ID
        jtf2 = new JTextField(); //courseName
        jtf3 = new JTextField(); //price

        jtf1.setEnabled(false);
        jtf2.setEnabled(false);
        jtf3.setEnabled(false);
        jcb.setEnabled(false);

        jsp.setBounds(0, 0, 620, 290);
        jcb.setBounds(420, 432, 140, 30);

        modify.setBounds(30, 510, 120, 30);
        renovate.setBounds(230, 510, 120, 30);
        delete.setBounds(430, 510, 120, 30);

        jl10.setBounds(20, 290, 80, 30);
        jl11.setBounds(20, 330, 100, 30);
        jl12.setBounds(290, 330, 100, 30);
        jl13.setBounds(20, 430, 100, 30);
        jl14.setBounds(290, 430, 100, 30);
        jtf1.setBounds(120, 332, 60, 30);
        jtf2.setBounds(420, 332, 100, 30);
        jtf3.setBounds(120, 432, 100, 30);

        fillJcb();

        add(jcb);
        add(jsp);
        add(modify);
        add(renovate);
        add(delete);
        add(jl10);
        add(jl11);
        add(jl12);
        add(jl13);
        add(jl14);
        add(jtf1);
        add(jtf2);
        add(jtf3);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                MouseReleased();
            }
        });

        modify.addActionListener(this::modifyAction);
        renovate.addActionListener(this::renovateAction);
        delete.addActionListener(this::deleteAction);
    }

    //renovate
    private void renovateAction(ActionEvent e) {
        Object[][] stu = scheduleDAO.getScheduleArrayList();
        String[] tableHeader = {"ID", "memberName", "courseName", "coachName"};
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(stu, tableHeader);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.updateUI();
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

        scheduleDAO.deleteScheduleById((int) table.getValueAt(row, 0));
        tdm.removeRow(row);
        resetValue(); //Clear text box
        jcb.setEnabled(false);
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
        String id = jtf1.getText().trim();
        String memberName = jtf2.getText().trim();
        String courseName = jtf3.getText().trim();
        String coachName = (String) jcb.getSelectedItem();
        if ("".equals(memberName) || "".equals(courseName)) {
            JOptionPane.showMessageDialog(null, "Not filled in correctly!", "warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if ("Please Select……".equals(coachName)) {
            coachName = "";
        }

        int isFlag = JOptionPane.showConfirmDialog(null, "Please confirm");
        if (isFlag > 0) {
            return;
        }

        Schedule newSchedule = new Schedule(Integer.parseInt(id), memberName, courseName, coachName);
        scheduleDAO.changeSchedule(newSchedule);

        table.setValueAt(memberName, row, 1);
        table.setValueAt(courseName, row, 2);
        table.setValueAt(coachName, row, 3);
        JOptionPane.showMessageDialog(null, "Modified successfully!");
    }

    //Listening for mouse click events
    private void MouseReleased() {
        int row = table.getSelectedRow();
        jtf1.setText(String.valueOf(table.getValueAt(row, 0)));
        jtf2.setText(String.valueOf(table.getValueAt(row, 1)));
        jtf3.setText(String.valueOf(table.getValueAt(row, 2)));
        String coachName = String.valueOf(table.getValueAt(row, 3));
        if ("".equals(coachName)) {
            jcb.setSelectedIndex(0);
        } else {
            jcb.setSelectedItem(coachName);
        }
        jcb.setEnabled(true);
    }

    //Initialization Form
    private void initTable() {
        //Create a form
        String[] columnNames = {"ID", "memberName", "courseName", "coachName"};
        Object[][] rowType = scheduleDAO.getScheduleArrayList();
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

        table.getTableHeader().setReorderingAllowed(false); //Cannot change the position of a column
    }

    private void fillJcb() {
        jcb.addItem("Please Select……");
        Object[][] coaches = memberDAO.getCoachArrayList();
        for (Object[] coach : coaches) {
            jcb.addItem((String) coach[1]);
        }
    }

    private void resetValue() {
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
    }
}
