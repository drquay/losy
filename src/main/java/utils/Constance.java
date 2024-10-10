package utils;

import java.awt.*;

public interface Constance {

    String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
    String[] COMMODITY_TYPES = {"BẮP", "CÀ PHÊ", "TIÊU", "ĐIỀU"};
    String[] PAYMENT_TYPES = {"TIỀN MẶT", "CHUYỂN KHOẢN"};

    String IMPORTED_DATETIME_LABEL = "Ngày giờ nhập hàng";
    String IMPORTED_COMMODITY_TYPE_LABEL = "Loại hàng";
    String IMPORTED_CUSTOMER_LABEL = "Khách hàng";
    String IMPORTED_CUSTOMER_PLACEHOLDER = "Nhập tên khách hàng";
    String IMPORTED_DRIVER_LABEL = "Tài xế";
    String IMPORTED_DRIVER_PLACEHOLDER = "Nhập tên tài xế";
    String IMPORTED_WEIGHT_LABEL = "Trọng lượng hàng (kg)";
    String IMPORTED_PRICE_LABEL = "Đơn giá (vnd/kg)";
    String IMPORTED_ALLOWANCE_LABEL = "Trừ bì";
    String IMPORTED_NET_WEIGHT_LABEL = "Trọng lượng đã trừ bì (kg)";
    String IMPORTED_PAYMENT_LABEL = "Thành tiền (vnd)";
    String IMPORTED_TYPE_OF_PAYMENT = "Thanh toán bằng";
    String IMPORTED_PAYMENT_COMPLETED_STATUS_LABEL = "Thanh toán đủ";
    String IMPORTED_PAYMENT_INFO_LABEL = "Thông tin thanh toán";
    String IMPORTED_PAYMENT_NOT_COMPLETED_STATUS_LABEL = "Thiếu";
    String IMPORTED_PAYMENT_HAFT_COMPLETED_STATUS_LABEL = "Thanh một phần";
    String IMPORTED_NOTE_LABEL = "Ghi chú";
    String IMPORTED_WEIGHT_PLACEHOLDER = "0";

    String IMPORTED_COMMODITY_PANEL = "thông tin hàng hoá";
    String IMPORTED_PAYMENT_PANEL = "thông tin thanh toán";

    String REPORT_BUTTON_LABEL = "BÁO CÁO";
    String DRIVER_BUTTON_LABEL = "TÀI XẾ";
    String IMPORTED_BUTTON_LABEL = "NHẬP HÀNG";
    String EXPORTED_BUTTON_LABEL = "XUẤT HÀNG";
    String CUSTOMER_BUTTON_LABEL = "KHÁCH HÀNG";
    String CALCULATOR_BUTTON_LABEL = "MÁY TÍNH";
    String INCOME_EXPENSE_BUTTON_LABEL = "THU | CHI";

    String APPLICATION_TITLE = "LOSY - ỨNG DỤNG QUẢN LÝ LÒ SẤY";
    String LOGO_PATH = "/images/logo.svg";
    String IMPORT_ICON_PATH = "/images/import.svg";
    String EXPORT_ICON_PATH = "/images/export.svg";
    String INCOME_EXPENSE_ICON_PATH = "/images/money.svg";
    String CALCULATOR_ICON_PATH = "/images/calculator.svg";
    String CUSTOMER_ICON_PATH = "/images/customer.svg";
    String DRIVER_ICON_PATH = "/images/driver.svg";
    String REPORT_ICON_PATH = "/images/report.svg";

    Color sideMenuPanelBackground = new Color(37, 150, 190);
    Font applicationFont = new Font("Arial", Font.PLAIN, 16);
}
