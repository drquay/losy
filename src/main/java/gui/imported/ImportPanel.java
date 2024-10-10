package gui.imported;

import javax.swing.*;
import java.awt.*;

public class ImportPanel extends JPanel {

    public ImportPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final String[] columnNames = {"Ngày giờ", "Tên khách hàng", "Tài xế", "Loại hàng", "Số lượng", "Đơn giá", "Trừ bì", "Thành tiền", "Thanh Toán", "Ghi chú", "In Phiếu"};
        final Object[][] data = {
                {"01-01-2024 17:00", "John Doe", "Tài 1", "Bắp", "30 Tấn", "4000 vnđ", "150 kg", "119.400.000 vnđ", "Đã thanh toán đủ", "333", "Yes"},
                {"01-01-2024 16:00", "Liam Doe", "Tài 2", "Bắp", "30 Tấn", "4000 vnđ", "150 kg", "119.400.000 vnđ", "Thiếu", "123", "Yes"},
                {"01-01-2024 08:00", "Mỡ", "Tài 3", "Bắp", "30 Tấn", "4000 vnđ", "150 kg", "119.400.000 vnđ", "Đã thanh toán 10.000.000 vnđ", "22", "Yes"},
                {"01-01-2024 08:00", "Mỡ", "Tài 4", "Bắp", "30 Tấn", "4000 vnđ", "150 kg", "119.400.000 vnđ", "Đã thanh toán 20.000.000 vnđ", "11", "Yes"}
        };

        final JTable table = new JTable(data, columnNames);
        final JScrollPane tableScrollPane = new JScrollPane(table);

        this.add(tableScrollPane, BorderLayout.CENTER);
    }
}
