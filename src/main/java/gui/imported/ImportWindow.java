package gui.imported;

import javax.swing.*;
import java.awt.*;

public class ImportWindow extends JPanel {

    private ImportedTable table;
    private ImportedForm form;

    public ImportWindow() {
        super();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        table = new ImportedTable();
        form = new ImportedForm();

        this.add(form, BorderLayout.NORTH);
        this.add(table, BorderLayout.SOUTH);
    }
}
