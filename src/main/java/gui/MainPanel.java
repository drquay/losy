package gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] columnNames = {"Số thứ tự", "Ngày giờ", "Tên khách hàng", "Tài xế", "Loại hàng", "Số lượng", "Đơn giá", "Trừ bì", "Thành tiền", "Thanh Toán", "In Phiếu"};
        Object[][] data = {
                {"01","01-01-2024 17:00", "John Doe", "Tài 1", "Bắp", "30 Tấn", "4000 vnđ", "150 kg", "119.400.000 vnđ", "Đã thanh toán đủ", "Yes"},
                {"02","01-01-2024 16:00", "Liam Doe", "Tài 2", "Bắp", "30 Tấn", "4000 vnđ", "150 kg", "119.400.000 vnđ", "Thiếu", "Yes"},
                {"03","01-01-2024 08:00", "Mỡ", "Tài 3", "Bắp", "30 Tấn", "4000 vnđ", "150 kg", "119.400.000 vnđ", "Đã thanh toán 10.000.000 vnđ", "Yes"},
                {"03","01-01-2024 08:00", "Mỡ", "Tài 4", "Bắp", "30 Tấn", "4000 vnđ", "150 kg", "119.400.000 vnđ", "Đã thanh toán 20.000.000 vnđ", "Yes"}
        };

        final JTable table = new JTable(data, columnNames);
        final JScrollPane tableScrollPane = new JScrollPane(table);

        this.add(tableScrollPane, BorderLayout.CENTER);
    }
}
