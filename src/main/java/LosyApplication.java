import gui.LosyFrame;
import utils.ConstanceUtil;
import utils.OtherUtil;

import javax.swing.plaf.FontUIResource;

public class LosyApplication {

    public static void main(String[] args) {
        OtherUtil.setUIFont(new FontUIResource(ConstanceUtil.systemFont));
        java.awt.EventQueue.invokeLater(() -> new LosyFrame().setVisible(true));
    }
}
