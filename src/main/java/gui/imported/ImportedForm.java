package gui.imported;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utils.Constance.COMMODITY_TYPES;
import static utils.Constance.DATETIME_FORMAT;
import static utils.Constance.IMPORTED_ALLOWANCE_LABEL;
import static utils.Constance.IMPORTED_COMMODITY_PANEL;
import static utils.Constance.IMPORTED_COMMODITY_TYPE_LABEL;
import static utils.Constance.IMPORTED_CUSTOMER_LABEL;
import static utils.Constance.IMPORTED_CUSTOMER_PLACEHOLDER;
import static utils.Constance.IMPORTED_DATETIME_LABEL;
import static utils.Constance.IMPORTED_DRIVER_LABEL;
import static utils.Constance.IMPORTED_DRIVER_PLACEHOLDER;
import static utils.Constance.IMPORTED_NET_WEIGHT_LABEL;
import static utils.Constance.IMPORTED_NOTE_LABEL;
import static utils.Constance.IMPORTED_PAYMENT_INFO_LABEL;
import static utils.Constance.IMPORTED_PAYMENT_LABEL;
import static utils.Constance.IMPORTED_PAYMENT_PANEL;
import static utils.Constance.IMPORTED_PRICE_LABEL;
import static utils.Constance.IMPORTED_TYPE_OF_PAYMENT;
import static utils.Constance.IMPORTED_WEIGHT_LABEL;
import static utils.Constance.IMPORTED_WEIGHT_PLACEHOLDER;
import static utils.Constance.PAYMENT_TYPES;

public class ImportedForm extends JPanel {

    public ImportedForm() {
        super();
        this.setLayout(new GridLayout(1, 2, 10, 10));
        initComponents();
    }

    private void initComponents() {
        add(personInfo());
        add(paymentInfo());
    }

    private JPanel personInfo() {
        final JPanel panel = commonPanel(IMPORTED_COMMODITY_PANEL);

        final JLabel datetimeLbl = new JLabel(IMPORTED_DATETIME_LABEL);
        final JTextField datetimeTf = new JTextField(10);
        datetimeTf.setEnabled(false);
        datetimeTf.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATETIME_FORMAT)));

        final JLabel commodityTypeLbl = new JLabel(IMPORTED_COMMODITY_TYPE_LABEL);
        final JComboBox<String> commodityTypeCbx = new JComboBox<>(COMMODITY_TYPES);
        commodityTypeCbx.setSelectedIndex(0);

        final JLabel customerLbl = new JLabel(IMPORTED_CUSTOMER_LABEL);
        final JTextField customerTf = new JTextField(10);
        customerTf.setText(IMPORTED_CUSTOMER_PLACEHOLDER);

        final JLabel driverLbl = new JLabel(IMPORTED_DRIVER_LABEL);
        final JTextField driverTf = new JTextField(10);
        driverTf.setText(IMPORTED_DRIVER_PLACEHOLDER);

        final JLabel weightLbl = new JLabel(IMPORTED_WEIGHT_LABEL);
        final JTextField weightTf = new JTextField(10);
        weightTf.setText(IMPORTED_WEIGHT_PLACEHOLDER);

        final JLabel allowanceLbl = new JLabel(IMPORTED_ALLOWANCE_LABEL);
        final JTextField allowanceTf = new JTextField(10);
        allowanceTf.setText(IMPORTED_WEIGHT_PLACEHOLDER);

        panel.add(datetimeLbl);
        panel.add(datetimeTf);
        panel.add(commodityTypeLbl);
        panel.add(commodityTypeCbx);
        panel.add(customerLbl);
        panel.add(customerTf);
        panel.add(driverLbl);
        panel.add(driverTf);
        panel.add(weightLbl);
        panel.add(weightTf);
        panel.add(allowanceLbl);
        panel.add(allowanceTf);

        return panel;
    }

    private JPanel paymentInfo() {
        final JPanel panel = commonPanel(IMPORTED_PAYMENT_PANEL);

        final JLabel netWeightLbl = new JLabel(IMPORTED_NET_WEIGHT_LABEL);
        final JTextField netWeightTf = new JTextField(10);
        netWeightTf.setText(IMPORTED_WEIGHT_PLACEHOLDER);
        netWeightTf.setEnabled(false);

        final JLabel priceLbl = new JLabel(IMPORTED_PRICE_LABEL);
        final JTextField priceTf = new JTextField(10);

        final JLabel paymentLbl = new JLabel(IMPORTED_PAYMENT_LABEL);
        final JTextField paymentTf = new JTextField(10);

        final JLabel typePaymentLbl = new JLabel(IMPORTED_TYPE_OF_PAYMENT);
        final JComboBox<String> typePaymentCbx = new JComboBox<>(PAYMENT_TYPES);
        typePaymentCbx.setSelectedIndex(0);

        final JLabel noteLbl = new JLabel(IMPORTED_NOTE_LABEL);
        final JTextField noteTa = new JTextField(10);

        final JLabel paymentInfoLbl = new JLabel(IMPORTED_PAYMENT_INFO_LABEL);
        final JTextField paymentInfoTa = new JTextField(10);

        panel.add(netWeightLbl);
        panel.add(netWeightTf);
        panel.add(priceLbl);
        panel.add(priceTf);
        panel.add(paymentLbl);
        panel.add(paymentTf);
        panel.add(typePaymentLbl);
        panel.add(typePaymentCbx);
        panel.add(paymentInfoLbl);
        panel.add(paymentInfoTa);
        panel.add(noteLbl);
        panel.add(noteTa);

        return panel;
    }

    private JPanel commonPanel(String title) {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        final Border lineBorder = new LineBorder(Color.CYAN, 2, true);
        final TitledBorder titledBorder = new TitledBorder(lineBorder, title);
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(titledBorder);
        return panel;
    }
}
