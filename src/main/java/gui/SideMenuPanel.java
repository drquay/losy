package gui;

import utils.ConstanceUtil;
import utils.OtherUtil;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class SideMenuPanel extends JPanel {

    private LogoPanel logo;
    public SideMenuPanel(LogoPanel logo) {
        super();
        this.logo = logo;
        this.setPreferredSize(new Dimension(200, super.getHeight()));
        this.setLayout(new FlowLayout());
        this.setBackground(ConstanceUtil.panel);

        final JButton report = createButton("BÁO CÁO", getIcon(ConstanceUtil.REPORT_ICON_PATH, null));
        final JButton importCommodity = createButton("NHẬP HÀNG", getIcon(ConstanceUtil.IMPORT_ICON_PATH, StandardCharsets.UTF_8));
        final JButton exportCommodity = createButton("XUẤT HÀNG", getIcon(ConstanceUtil.EXPORT_ICON_PATH, null));
        final JButton incomeAndExpenses = createButton("THU | CHI", getIcon(ConstanceUtil.INCOME_EXPENSE_ICON_PATH, null));
        final JButton customer = createButton("KHÁCH HÀNG", getIcon(ConstanceUtil.CUSTOMER_ICON_PATH, null));
        final JButton driver = createButton("TÀI XẾ", getIcon(ConstanceUtil.DRIVER_ICON_PATH, null));
        final JButton calculator = createButton("MÁY TÍNH", getIcon(ConstanceUtil.CALCULATOR_ICON_PATH, null));

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
        return OtherUtil.getIconFromResource(this.getClass(), new model.Icon(path, charset, 64, 64));
    }

    private JButton createButton(String text, Icon icon) {
        final JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 80));
        Optional.ofNullable(icon).ifPresent(button::setIcon);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        return button;
    }
}
