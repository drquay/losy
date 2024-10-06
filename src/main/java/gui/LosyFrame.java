package gui;

import utils.ConstanceUtil;

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

        setTitle(ConstanceUtil.APPLICATION_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
