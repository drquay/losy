package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private SideMenu sideMenu;

    public MainPanel(SideMenu sideMenu) {
        super();
        this.sideMenu = sideMenu;

        this.setLayout(new BorderLayout());
        JButton collapseButton = new JButton("Collapse Menu");
        collapseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sideMenu.setVisible(!sideMenu.isVisible());
                collapseButton.setText(sideMenu.isVisible() ? "Collapse Menu" : "Expand Menu");
            }
        });

        String[] columnNames = {"ID", "Name", "Age"};
        Object[][] data = {
                {"1", "John Doe", "30"},
                {"2", "Jane Smith", "25"},
                {"3", "Mike Johnson", "35"}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Add the collapse button and table to the main panel
        this.add(collapseButton, BorderLayout.NORTH);
        this.add(tableScrollPane, BorderLayout.CENTER);
    }
}
