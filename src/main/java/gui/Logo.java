package gui;

import model.Icon;
import utils.Constance;
import utils.Util;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class Logo extends JPanel {

    private JLabel logo;
    public Logo() {
        super();

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Constance.sideMenuPanelBackground);

        final javax.swing.Icon logoIcon = Util.getIconFromResource(this.getClass(), new Icon(Constance.LOGO_PATH, StandardCharsets.ISO_8859_1, 150, 150));
        Optional.ofNullable(logoIcon).ifPresent(ic -> logo = new JLabel(logoIcon));

        this.add(logo);
    }
}
