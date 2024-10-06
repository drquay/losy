import javax.swing.*;
import java.awt.*;

public class LosyFrame extends JFrame {

    public LosyFrame() {
        initComponents();
    }

    private void initComponents() {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        setMaximumSize(screenSize);
        setSize(screenSize);

        setTitle("Losy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LosyFrame().setVisible(true));
    }
}
