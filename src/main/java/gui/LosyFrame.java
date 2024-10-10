package gui;

import gui.imported.ImportPanel;
import utils.Constance;

import javax.swing.*;
import java.awt.*;

public class LosyFrame extends JFrame {

    public LosyFrame() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle(Constance.APPLICATION_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(new SideMenuPanel(new LogoPanel()), BorderLayout.WEST);
        this.add(new ImportPanel(), BorderLayout.CENTER);

        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        this.setMaximumSize(screenSize);
        this.setSize(screenSize);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
