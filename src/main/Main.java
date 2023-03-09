package main;

import view.keyframe.GymManageMainFrame;
import view.keyframe.MemberMainFrame;
import view.keyframe.StartFrame;

import java.util.Locale;

/**
 * Main functions
 */
public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        new StartFrame().setVisible(true);
//        new MemberMainFrame("123").setVisible(true);
//        new GymManageMainFrame("admin").setVisible(true);

    }
}
