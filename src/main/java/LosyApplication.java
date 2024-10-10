import gui.LosyWindow;
import utils.Constance;
import utils.Util;

import javax.swing.plaf.FontUIResource;

public class LosyApplication {

    public static void main(String[] args) {
        Util.setUIFont(new FontUIResource(Constance.applicationFont));
        java.awt.EventQueue.invokeLater(() -> new LosyWindow().setVisible(true));
    }
}
