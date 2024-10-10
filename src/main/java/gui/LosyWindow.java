package gui;

import gui.imported.ImportWindow;
import gui.imported.ImportedTable;
import utils.Constance;

import javax.swing.*;
import java.awt.*;

public class LosyWindow extends JFrame {

    public LosyWindow() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle(Constance.APPLICATION_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(new SideMenu(new Logo()), BorderLayout.WEST);
        this.add(new ImportWindow(), BorderLayout.CENTER);

        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        this.setMaximumSize(screenSize);
        this.setSize(screenSize);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
