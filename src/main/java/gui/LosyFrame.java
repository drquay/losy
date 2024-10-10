package gui;

import utils.ConstanceUtil;

import javax.swing.*;
import java.awt.*;

public class LosyFrame extends JFrame {

    public LosyFrame() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle(ConstanceUtil.APPLICATION_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(new SideMenu(new LogoPanel()), BorderLayout.WEST);
        this.add(new MainPanel(), BorderLayout.CENTER);

        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        this.setMaximumSize(screenSize);
        this.setSize(screenSize);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
