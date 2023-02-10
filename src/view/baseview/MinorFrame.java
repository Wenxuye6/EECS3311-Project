package view.baseview;

/**
 * Function window that closes to release resources but does not exit the program
 */
public class MinorFrame extends BaseFrame {
    public MinorFrame(String title, int width, int height) {
        super(title, width, height); 
        //close to release this window without exiting the program
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
