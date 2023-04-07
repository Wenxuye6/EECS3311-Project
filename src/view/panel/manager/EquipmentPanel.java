package view.panel.manager;

import bean.Equipment;
import dao.EquipmentDAO;
import dao.WorkDAO;
import dao.impl.EquipmentDAOImpl;
import dao.impl.WorkDAOImpl;
import util.CheckDigitUtil;
import view.minorframe.AddCourseFrame;
import view.minorframe.AddEquipmentFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EquipmentPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tdm;
    private JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
    private JTextArea jta;
    private final EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
    private JButton addEquipment;
    private JButton modify;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 0, 650);
        g.drawLine(618, 0, 618, 650);
        g.drawLine(0, 320, 100, 320);
        g.drawLine(100, 290, 100, 320);
    }

    public EquipmentPanel() {
        setLayout(null);
        initPanel();
    }

    private void initPanel() {
        initTable();

        addEquipment = new JButton("Add Equipment");
        modify = new JButton("modify");
        JButton delete = new JButton("delete");
        //Equipment Information
        //Information column
        Label jl10 = new Label("Info Bar");
        jl10.setFont(new Font("", Font.BOLD, 15));

        JScrollPane jsp = new JScrollPane(table);
        JScrollPane jsp0 = new JScrollPane();

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

        jtf1.setEnabled(false);
        jtf2.setEnabled(false);
        jtf3.setEnabled(false);
        jtf4.setEnabled(false);
        jtf5.setEnabled(false);
        jta.setEnabled(false);

        jsp.setBounds(0, 0, 620, 290);

        addEquipment.setBounds(50, 530, 120, 30);
        modify.setBounds(250, 530, 120, 30);
        delete.setBounds(450, 530, 120, 30);

        jl10.setBounds(20, 290, 80, 30);
        jl11.setBounds(20, 330, 40, 30);
        jl12.setBounds(160, 330, 100, 30);
        jl15.setBounds(400, 330, 80, 30);

        jl13.setBounds(20, 380, 80, 30);
        jl14.setBounds(270, 380, 100, 30);
        jl16.setBounds(20, 430, 60, 30);
        jtf1.setBounds(60, 332, 60, 30);
        jtf2.setBounds(270, 332, 100, 30);
        jtf3.setBounds(100, 382, 100, 30);
        jtf4.setBounds(370, 382, 100, 30);
        jtf5.setBounds(480, 332, 100, 30);
        jsp0.setBounds(20, 460, 560, 50);

        jsp0.setViewportView(jta);

        add(jsp);
        add(addEquipment);
        add(modify);
        add(delete);
        add(jl10);
        add(jl11);
        add(jl12);
        add(jl13);
        add(jl14);
        add(jl15);
        add(jl16);
        add(jtf1);
        add(jtf2);
        add(jtf3);
        add(jtf4);
        add(jtf5);
        add(jsp0);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                MouseReleased();
            }
        });
//
        addEquipment.addActionListener(this::addEquipmentAction);
        modify.addActionListener(this::modifyAction);
        delete.addActionListener(this::deleteAction);
    }

    private void addEquipmentAction(ActionEvent e) {
        addEquipment.setEnabled(false);
        modify.setEnabled(false);
        JFrame frame = new AddEquipmentFrame();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                addEquipment.setEnabled(true);
                modify.setEnabled(true);
                Object[][] stu = equipmentDAO.getEquipmentArrayList();
                String[] tableHeader = {"ID", "equipmentName", "currentNum", "damagedNum", "marketPrice", "value"};
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

        equipmentDAO.deleteEquipmentById((int) table.getValueAt(row, 0));
        tdm.removeRow(row);
        resetValue(); //清空文本框
        jtf2.setEnabled(false);
        jtf3.setEnabled(false);
        jtf4.setEnabled(false);
        jtf5.setEnabled(false);
        jta.setEnabled(false);
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

        Equipment newEquipment = new Equipment(Integer.parseInt(id), name, Integer.parseInt(currentNum), Integer.parseInt(damagedNum), Double.parseDouble(price), value);
        equipmentDAO.changeEquipment(newEquipment);

        table.setValueAt(name, row, 1);
        table.setValueAt(price, row, 4);
        table.setValueAt(currentNum, row, 2);
        table.setValueAt(damagedNum, row, 3);
        table.setValueAt(value, row, 5);
        JOptionPane.showMessageDialog(null, "Modified successfully!");
    }

    //Listening for mouse click events
    private void MouseReleased() {
        int row = table.getSelectedRow();
        jtf1.setText(String.valueOf(table.getValueAt(row, 0)));
        jtf2.setText(String.valueOf(table.getValueAt(row, 1)));
        jtf3.setText(String.valueOf(table.getValueAt(row, 2)));
        jtf4.setText(String.valueOf(table.getValueAt(row, 3)));
        jtf5.setText(String.valueOf(table.getValueAt(row, 4)));
        jta.setText(String.valueOf(table.getValueAt(row, 5)));

        jtf2.setEnabled(true);
        jtf3.setEnabled(true);
        jtf4.setEnabled(true);
        jtf5.setEnabled(true);
        jta.setEnabled(true);
    }

    //Initialization Form
    private void initTable() {
        //Create a form
        String[] columnNames = {"ID", "equipmentName", "currentNum", "damagedNum", "marketPrice", "value"};
        Object[][] rowType = equipmentDAO.getEquipmentArrayList();
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

        table.getTableHeader().setReorderingAllowed(false); //Cannot change the position of a column
    }

    private void resetValue() {
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
        jtf4.setText("");
        jtf5.setText("");
        jta.setText("");
    }
}
