package view.baseview;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Main window, asking if it is closed
 */
public class KeyFrame extends BaseFrame {
    public KeyFrame(String title, int width, int height) {
        super(title, width, height); 

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            //Ask if you want to exit when the window is clicked closed
            @Override
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "Please confirm");
                if (i == 0) {
                    //Select Yes to release the window and exit the program
                    dispose();
                    System.exit(1);
                }
            }
        });
    }
}
