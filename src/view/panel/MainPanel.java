package view.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Welcome Panel
 */
public class MainPanel extends JPanel {

    public MainPanel(String username, String identity) {
        setLayout(null);
        Label label = new Label("Welcome ' " + username + " ' to use GymManage System");
        Label label1 = new Label("Your identity is ' " + identity + " '");

        label.setFont(new Font("", Font.BOLD, 20));
        label1.setFont(new Font("", Font.BOLD, 20));
        label.setBounds(100, 50, 650, 40);
        label1.setBounds(100, 100, 650, 40);
        add(label);
        add(label1);
    }
}
