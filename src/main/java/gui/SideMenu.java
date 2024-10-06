package gui;

import javax.swing.*;
import java.awt.*;

public class SideMenu extends JPanel {

    private JButton importCommodity;
    private JButton exportCommodity;
    private JButton incomeAndExpenses;

    public SideMenu() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Color.LIGHT_GRAY);

        importCommodity = new JButton("NHẬP HÀNG");
        exportCommodity = new JButton("XUẤT HÀNG");
        incomeAndExpenses = new JButton("THU + CHI");

        this.add(importCommodity);
        this.add(exportCommodity);
        this.add(incomeAndExpenses);
    }
}
