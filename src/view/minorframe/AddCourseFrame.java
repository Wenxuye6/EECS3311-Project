package view.minorframe;

import bean.Course;
import dao.CourseDAO;
import dao.impl.CourseDAOImpl;
import util.CheckDigitUtil;
import view.baseview.MinorFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddCourseFrame extends MinorFrame {

    private final CourseDAO courseDAO = new CourseDAOImpl();
    private JTextField jtf1, jtf2, jtf3;
    private JTextArea jta;

    public AddCourseFrame() {
        super("Add New Course", 600, 300);
        initFrame();
    }

    //fields to input when adding a course
    private void initFrame() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JButton addCourse = new JButton("add course");
        JButton reset = new JButton("reset");

        Label jl11 = new Label("ID:");
        Label jl12 = new Label("courseName:");
        Label jl13 = new Label("price:");
        Label jl14 = new Label("benefit:");
        jtf1 = new JTextField(); //ID
        jtf2 = new JTextField(); //courseName
        jtf3 = new JTextField(); //price
        jta = new JTextArea(); //benefit
        JScrollPane jsp0 = new JScrollPane();

        jl11.setBounds(20, 30, 90, 30);
        jl12.setBounds(20, 100, 90, 30);
        jl13.setBounds(20, 170, 90, 30);
        jl14.setBounds(270, 30, 80, 30);
        jtf1.setBounds(120, 30, 120, 30);
        jtf1.setEnabled(false);
        jtf2.setBounds(120, 100, 120, 30);
        jtf3.setBounds(120, 170, 120, 30);
        jsp0.setBounds(350, 30, 200, 100);
        addCourse.setBounds(270, 160, 120, 40);
        reset.setBounds(430, 160, 120, 40);

        jsp0.setViewportView(jta);
        jPanel.add(addCourse);
        jPanel.add(reset);
        jPanel.add(jl11);
        jPanel.add(jl12);
        jPanel.add(jl13);
        jPanel.add(jl14);
        jPanel.add(jtf1);
        jPanel.add(jtf2);
        jPanel.add(jtf3);
        jPanel.add(jsp0);

        addCourse.addActionListener(this::addCourseAction);
        reset.addActionListener(this::resetAction);

        setContentPane(jPanel);
    }

    //add course button
    private void addCourseAction(ActionEvent e) {
        String courseName = jtf2.getText().trim();
        String price = jtf3.getText().trim();
        String benefit = jta.getText().trim();
        if ("".equals(courseName) || "".equals(price)) {
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

        Course course = new Course(0, courseName, Double.parseDouble(price), benefit);
        boolean success = courseDAO.addCourse(course);
        if(success) {
            JOptionPane.showMessageDialog(null, "success!");
        } else {
            JOptionPane.showMessageDialog(null, "course exists!", "warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    //reset button
    private void resetAction(ActionEvent e) {
        jtf1.setText("");
        jtf2.setText("");
        jtf3.setText("");
        jta.setText("");
    }
}
