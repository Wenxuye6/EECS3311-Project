package view.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Welcome Panel
 */
public class MainPanel extends JPanel {

    public MainPanel(String username) {
        setLayout(null);
        Label label = new Label("Welcome "+ username +" to use GymManage System");

        label.setFont(new Font("", Font.BOLD, 20));
        label.setBounds(100,50,650,40);
        add(label);
    }
}
