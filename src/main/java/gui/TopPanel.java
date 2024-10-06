package gui;

import utils.ConstanceUtil;
import utils.OtherUtil;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    private ImageIcon logo;
    private JLabel logoLabel;

    public TopPanel() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.logo = new ImageIcon(OtherUtil.getFileFromResource(TopPanel.class, ConstanceUtil.LOGO_PATH).toString());
        this.logoLabel = new JLabel(logo);
        this.add(logoLabel);
    }
}
