package gui.common;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailedComboBoxDemo implements Runnable {

    private DetailedComboBox combo;
    private JTextField name;
    private JTextField capital;

    public DetailedComboBoxDemo() {
    }

    @Override
    public void run() {
        java.util.List<List> tableData = new ArrayList<List>();
        tableData.add(new ArrayList(Arrays.asList("MD", "Maryland", "Annapolis")));
        tableData.add(new ArrayList(Arrays.asList("NH", "New Hampshire", "Concord")));
        tableData.add(new ArrayList(Arrays.asList("NJ", "New Jersey", "Trenton")));
        tableData.add(new ArrayList(Arrays.asList("NM", "New Mexico", "Santa Fe")));
        tableData.add(new ArrayList(Arrays.asList("ND", "North Dakota", "Bismark")));

        String[] columns = new String[]{"State", "Name", "Capital"};
        int[] widths = new int[]{50, 100, 100};

        combo = new DetailedComboBox(columns, widths, 0);
        combo.setTableData(tableData);
        combo.setSelectedIndex(-1);
        combo.setPopupAlignment(DetailedComboBox.Alignment.LEFT);
        combo.addActionListener(e -> showDetails());

        name = new JTextField(10);
        capital = new JTextField(10);
        name.setEditable(false);
        capital.setEditable(false);

        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 1, 1);
        p.add(new JLabel("State"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        p.add(combo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        p.add(new JLabel("Name"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        p.add(name, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        p.add(new JLabel("Capital"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        p.add(capital, gbc);

        JFrame frame = new JFrame("DetailedComboBox Demo");
        frame.getContentPane().add(new JScrollPane(p), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showDetails() {
        List rowData = combo.getSelectedRow();
        name.setText(rowData.get(1).toString());
        capital.setText(rowData.get(2).toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new DetailedComboBoxDemo());
    }
}
