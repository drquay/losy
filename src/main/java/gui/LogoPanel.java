package gui;

import model.Icon;
import utils.ConstanceUtil;
import utils.OtherUtil;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class LogoPanel extends JPanel {

    private JLabel logo;
    public LogoPanel() {
        super();

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(ConstanceUtil.panel);

        final javax.swing.Icon logoIcon = OtherUtil.getIconFromResource(this.getClass(), new Icon(ConstanceUtil.LOGO_PATH, StandardCharsets.ISO_8859_1, 150, 150));
        Optional.ofNullable(logoIcon).ifPresent(ic -> logo = new JLabel(logoIcon));

        this.add(logo);
    }
}
