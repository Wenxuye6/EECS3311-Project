package view.panel.member;

import dao.WorkDAO;
import dao.impl.WorkDAOImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WorkPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tdm;
    private JTextField jtf1, jtf2, jtf3;
    private JComboBox<String> jcb;
    private JButton renovate;
    private final WorkDAO workDAO = new WorkDAOImpl();


    public WorkPanel(String account) {
        setLayout(null);
        initPanel(account);
    }

    private void initPanel(String account) {
        initTable(account);

        jcb = new JComboBox<>();
        renovate = new JButton("renovate");
        //Course Information
        //Information column
        Label jl10 = new Label("Info Bar");
        jl10.setFont(new Font("", Font.BOLD, 15));

        JScrollPane jsp = new JScrollPane(table);

        Label jl11 = new Label("ID:");
        Label jl12 = new Label("memberName:");
        Label jl13 = new Label("work:");
        Label jl14 = new Label("identity:");
        jtf1 = new JTextField(); //ID
        jtf2 = new JTextField(); //courseName
        jtf3 = new JTextField(); //price

        jtf1.setEnabled(false);
        jtf2.setEnabled(false);
        jtf3.setEnabled(false);
        jcb.setEnabled(false);

        jsp.setBounds(0, 0, 620, 290);
        jcb.setBounds(420, 432, 140, 30);

        renovate.setBounds(430, 510, 120, 30);

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
        add(renovate);
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
            public void mousePressed(MouseEvent e) {
                MouseReleased();
            }
        });

        renovate.addActionListener(e -> renovateAction(account));
    }

    //renovate
    private void renovateAction(String account) {
        Object[][] stu = workDAO.getWorkArrayListByName(account);
        String[] tableHeader = {"ID", "memberName", "work", "identity"};
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setDataVector(stu, tableHeader);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.updateUI();
    }

    //Listening for mouse click events
    private void MouseReleased() {
        int row = table.getSelectedRow();
        jtf1.setText(String.valueOf(table.getValueAt(row, 0)));
        jtf2.setText(String.valueOf(table.getValueAt(row, 1)));
        jtf3.setText(String.valueOf(table.getValueAt(row, 2)));
        String identity = String.valueOf(table.getValueAt(row, 3));
        if ("".equals(identity)) {
            jcb.setSelectedIndex(0);
        } else {
            jcb.setSelectedItem(identity);
        }
    }

    //Initialization Form
    private void initTable(String account) {
        //Create a form
        String[] columnNames = {"ID", "memberName", "work", "identity"};
        Object[][] rowType = workDAO.getWorkArrayListByName(account);
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

    //Drop down menu
    private void fillJcb() {
        jcb.addItem("Please Select……");
        jcb.addItem("membership");
        jcb.addItem("coach");
        jcb.addItem("front desk");
        jcb.addItem("janitorial");
    }
}
