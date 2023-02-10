package view.baseview;

import javax.swing.*;

/**
 * Defining a base window frame
 */
public class BaseFrame extends JFrame {
    public BaseFrame(String title,int width,int height){
        setTitle(title); 
        setSize(width,height); 
//        setIconImage(ImageData.bi); 
        setResizable(false); 
        setLocationRelativeTo(null); 
    }
}
