package view.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Welcome Panel, this class should be able to show the set of welcome and show the user's identification.
 */
public class MainPanel extends JPanel {

    //main panel where shows identity
    public MainPanel(String account, String identity) {
        setLayout(null);
        Label label = new Label("Welcome ' " + account + " ' to use GymManage System");
        Label label1 = new Label("Your identity is ' " + identity + " '");

        label.setFont(new Font("", Font.BOLD, 20));
        label1.setFont(new Font("", Font.BOLD, 20));
        label.setBounds(100, 50, 650, 40);
        label1.setBounds(100, 100, 650, 40);
        add(label);
        add(label1);
    }
}
