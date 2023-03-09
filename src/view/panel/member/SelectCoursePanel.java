package view.panel.member;

import bean.Schedule;
import dao.CourseDAO;
import dao.ScheduleDAO;
import dao.impl.CourseDAOImpl;
import dao.impl.ScheduleDAOImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Course operating panel
 */
public class SelectCoursePanel extends JPanel {

    private JTable table;
    private DefaultTableModel tdm;
    private JTextField jtf1, jtf2, jtf3;
    private JTextArea jta;
    private final CourseDAO courseDAO = new CourseDAOImpl();
    private final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 0, 650);
        g.drawLine(618, 0, 618, 650);
        g.drawLine(0, 320, 100, 320);
        g.drawLine(100, 290, 100, 320);
    }

    public SelectCoursePanel(String account) {
        setLayout(null);
        initPanel(account);
    }

    private void initPanel(String account) {
        initTable();

        JButton select = new JButton("Select Course");
        //Course Information
        //Information column
        Label jl10 = new Label("Info Bar");
        jl10.setFont(new Font("", Font.BOLD, 15));

        JScrollPane jsp = new JScrollPane(table);
        JScrollPane jsp0 = new JScrollPane();

        Label jl11 = new Label("ID:");
        Label jl12 = new Label("courseName:");
        Label jl13 = new Label("price:");
        Label jl14 = new Label("benefit:");
        jtf1 = new JTextField(); //ID
        jtf2 = new JTextField(); //courseName
        jtf3 = new JTextField(); //price
        jta = new JTextArea(); //benefit

        jtf1.setEnabled(false);
        jtf2.setEnabled(false);
        jtf3.setEnabled(false);
        jta.setEnabled(false);

        jsp.setBounds(0, 0, 620, 290);

        select.setBounds(450, 530, 120, 30);

        jl10.setBounds(20, 290, 80, 30);
        jl11.setBounds(20, 330, 40, 30);
        jl12.setBounds(170, 330, 80, 30);
        jl13.setBounds(420, 330, 60, 30);
        jl14.setBounds(20, 380, 60, 30);
        jtf1.setBounds(60, 332, 60, 30);
        jtf2.setBounds(270, 332, 100, 30);
        jtf3.setBounds(480, 332, 100, 30);
        jsp0.setBounds(20, 410, 560, 100);

        jsp0.setViewportView(jta);

        add(jsp);
        add(select);
        add(jl10);
        add(jl11);
        add(jl12);
        add(jl13);
        add(jl14);
        add(jtf1);
        add(jtf2);
        add(jtf3);
        add(jsp0);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MouseReleased();
            }
        });

        select.addActionListener(e -> selectAction(account));
    }

    private void selectAction(String account) {
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

        boolean success = scheduleDAO.addSchedule(new Schedule(0, account, String.valueOf(table.getValueAt(row, 1)), ""));

        if (success) {
            JOptionPane.showMessageDialog(null, "Selection succeeded!");
        } else {
            JOptionPane.showMessageDialog(null, "Selection failed!", "warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Listening for mouse click events
    private void MouseReleased() {
        int row = table.getSelectedRow();
        jtf1.setText(String.valueOf(table.getValueAt(row, 0)));
        jtf2.setText(String.valueOf(table.getValueAt(row, 1)));
        jtf3.setText(String.valueOf(table.getValueAt(row, 2)));
        jta.setText(String.valueOf(table.getValueAt(row, 3)));
    }

    //Initialization Form
    private void initTable() {
        //Create a form
        String[] columnNames = {"ID", "courseName", "price", "benefit"};
        Object[][] rowType = courseDAO.getCourseArrayList();
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
}
