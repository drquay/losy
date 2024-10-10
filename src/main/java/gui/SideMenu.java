package gui;

import utils.ConstanceUtil;
import utils.OtherUtil;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class SideMenu extends JPanel {

    private LogoPanel logo;
    public SideMenu(LogoPanel logo) {
        super();
        this.logo = logo;
        this.setPreferredSize(new Dimension(200, super.getHeight()));
        this.setLayout(new FlowLayout());
        this.setBackground(ConstanceUtil.panel);

        final Icon importIcon = OtherUtil.getIconFromResource(this.getClass(), new model.Icon(ConstanceUtil.IMPORT_ICON_PATH, StandardCharsets.UTF_8, 64, 64));
        final Icon exportIcon = OtherUtil.getIconFromResource(this.getClass(), new model.Icon(ConstanceUtil.EXPORT_ICON_PATH, StandardCharsets.ISO_8859_1, 64, 64));
        final Icon incomeAndExpensesIcon = OtherUtil.getIconFromResource(this.getClass(), new model.Icon(ConstanceUtil.INCOME_EXPENSE_ICON_PATH, StandardCharsets.ISO_8859_1, 64, 64));
        final Icon customerIcon = OtherUtil.getIconFromResource(this.getClass(), new model.Icon(ConstanceUtil.CUSTOMER_ICON_PATH, StandardCharsets.ISO_8859_1, 64, 64));
        final Icon driverIcon = OtherUtil.getIconFromResource(this.getClass(), new model.Icon(ConstanceUtil.DRIVER_ICON_PATH, StandardCharsets.ISO_8859_1, 64, 64));
        final Icon calculatorIcon = OtherUtil.getIconFromResource(this.getClass(), new model.Icon(ConstanceUtil.CALCULATOR_ICON_PATH, StandardCharsets.ISO_8859_1, 64, 64));

        final JButton importCommodity = new JButton("NHẬP HÀNG");
        importCommodity.setPreferredSize(new Dimension(200, 100));
        Optional.ofNullable(importIcon).ifPresent(importCommodity::setIcon);
        importCommodity.setHorizontalAlignment(SwingConstants.LEFT);

        final JButton exportCommodity = new JButton("XUẤT HÀNG");
        exportCommodity.setPreferredSize(new Dimension(200, 100));
        Optional.ofNullable(exportIcon).ifPresent(exportCommodity::setIcon);
        exportCommodity.setHorizontalAlignment(SwingConstants.LEFT);

        final JButton incomeAndExpenses = new JButton("THU | CHI");
        incomeAndExpenses.setPreferredSize(new Dimension(200, 100));
        Optional.ofNullable(incomeAndExpensesIcon).ifPresent(incomeAndExpenses::setIcon);
        incomeAndExpenses.setHorizontalAlignment(SwingConstants.LEFT);

        final JButton customer = new JButton("KHÁCH HÀNG");
        customer.setPreferredSize(new Dimension(200, 100));
        Optional.ofNullable(customerIcon).ifPresent(customer::setIcon);
        customer.setHorizontalAlignment(SwingConstants.LEFT);

        final JButton driver = new JButton("TÀI XẾ");
        driver.setPreferredSize(new Dimension(200, 100));
        Optional.ofNullable(driverIcon).ifPresent(driver::setIcon);
        driver.setHorizontalAlignment(SwingConstants.LEFT);

        final JButton calculator = new JButton("MÁY TÍNH");
        calculator.setPreferredSize(new Dimension(200, 100));
        Optional.ofNullable(calculatorIcon).ifPresent(calculator::setIcon);
        calculator.setHorizontalAlignment(SwingConstants.LEFT);

        this.add(logo);
        this.add(importCommodity);
        this.add(exportCommodity);
        this.add(incomeAndExpenses);
        this.add(customer);
        this.add(driver);
        this.add(calculator);
    }
}
