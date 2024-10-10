package gui;

import utils.Constance;
import utils.Util;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static utils.Constance.CALCULATOR_BUTTON_LABEL;
import static utils.Constance.CUSTOMER_BUTTON_LABEL;
import static utils.Constance.DRIVER_BUTTON_LABEL;
import static utils.Constance.EXPORTED_BUTTON_LABEL;
import static utils.Constance.IMPORTED_BUTTON_LABEL;
import static utils.Constance.INCOME_EXPENSE_BUTTON_LABEL;
import static utils.Constance.REPORT_BUTTON_LABEL;

public class SideMenuPanel extends JPanel {

    private LogoPanel logo;
    public SideMenuPanel(LogoPanel logo) {
        super();
        this.logo = logo;
        this.setPreferredSize(new Dimension(200, super.getHeight()));
        this.setLayout(new FlowLayout());
        this.setBackground(Constance.sideMenuPanelBackground);

        final JButton report = createButton(REPORT_BUTTON_LABEL, getIcon(Constance.REPORT_ICON_PATH, null));
        final JButton importCommodity = createButton(IMPORTED_BUTTON_LABEL, getIcon(Constance.IMPORT_ICON_PATH, StandardCharsets.UTF_8));
        final JButton exportCommodity = createButton(EXPORTED_BUTTON_LABEL, getIcon(Constance.EXPORT_ICON_PATH, null));
        final JButton incomeAndExpenses = createButton(INCOME_EXPENSE_BUTTON_LABEL, getIcon(Constance.INCOME_EXPENSE_ICON_PATH, null));
        final JButton customer = createButton(CUSTOMER_BUTTON_LABEL, getIcon(Constance.CUSTOMER_ICON_PATH, null));
        final JButton driver = createButton(DRIVER_BUTTON_LABEL, getIcon(Constance.DRIVER_ICON_PATH, null));
        final JButton calculator = createButton(CALCULATOR_BUTTON_LABEL, getIcon(Constance.CALCULATOR_ICON_PATH, null));

        this.add(logo);
        this.add(report);
        this.add(importCommodity);
        this.add(exportCommodity);
        this.add(incomeAndExpenses);
        this.add(customer);
        this.add(driver);
        this.add(calculator);
    }

    private Icon getIcon(String path, Charset charset) {
        charset = charset == null ? StandardCharsets.ISO_8859_1 : charset;
        return Util.getIconFromResource(this.getClass(), new model.Icon(path, charset, 64, 64));
    }

    private JButton createButton(String text, Icon icon) {
        final JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 80));
        Optional.ofNullable(icon).ifPresent(button::setIcon);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        return button;
    }
}
