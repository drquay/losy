package gui.imported;

import javax.swing.*;
import java.awt.*;

public class ImportWindow extends JPanel {

    public ImportWindow() {
        super();
        this.setLayout(new BorderLayout());
        this.add(new ImportedForm(), BorderLayout.NORTH);
        this.add(new ImportedTable(), BorderLayout.SOUTH);
    }
}
