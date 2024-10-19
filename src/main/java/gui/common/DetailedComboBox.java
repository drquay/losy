package gui.common;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.metal.MetalComboBoxUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DetailedComboBox extends JComboBox {

    public enum Alignment {LEFT, RIGHT}

    private List<List> tableData;
    private String[] columnNames;
    private int[] columnWidths;
    private int displayColumn;
    private Alignment popupAlignment = Alignment.LEFT;

    public DetailedComboBox(String[] colNames, int[] colWidths, int displayColumnIndex) {
        super();
        this.columnNames = colNames;
        this.columnWidths = colWidths;
        this.displayColumn = displayColumnIndex;

        setUI(new TableComboBoxUI());
        setEditable(false);
    }

    public void setPopupAlignment(Alignment alignment) {
        popupAlignment = alignment;
    }

    public void setTableData(List<List> tableData) {
        this.tableData = (tableData == null ? new ArrayList<>() : tableData);

        // even though the incoming data is for the table, we must also
        // populate the combobox's data, so first clear the previous list.
        removeAllItems();

        // then load the combobox with data from the appropriate column
        Iterator iter = this.tableData.iterator();
        while (iter.hasNext()) {
            List rowData = (List) iter.next();
            addItem(rowData.get(displayColumn));
        }
    }

    public List getSelectedRow() {
        return tableData.get(getSelectedIndex());
    }

    private class TableComboBoxUI extends MetalComboBoxUI {
        protected ComboPopup createPopup() {
            return new TableComboPopup(comboBox, this);
        }

        public JList getList() {
            return listBox;
        }
    }

    private class TableComboPopup extends BasicComboPopup implements ListSelectionListener, ItemListener {
        private final JTable table;

        private JList list = new JList();
        private TableComboBoxUI comboBoxUI;
        private PopupTableModel tableModel;
        private ListSelectionListener selectionListener;
        private ItemListener itemListener;
        private JScrollPane scroll;

        /**
         * Construct a popup component that's a table
         */
        public TableComboPopup(JComboBox combo, TableComboBoxUI ui) {
            super(combo);
            this.comboBoxUI = ui;

            tableModel = new PopupTableModel();
            table = new JTable(tableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getTableHeader().setReorderingAllowed(false);

            TableColumnModel tableColumnModel = table.getColumnModel();
            tableColumnModel.setColumnSelectionAllowed(false);

            for (int index = 0; index < table.getColumnCount(); index++) {
                TableColumn tableColumn = tableColumnModel.getColumn(index);
                tableColumn.setPreferredWidth(columnWidths[index]);
            }

            scroll = new JScrollPane(table);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            ListSelectionModel selectionModel = table.getSelectionModel();
            selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            selectionModel.addListSelectionListener(this);
            combo.addItemListener(this);

            table.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent event) {
                    Point p = event.getPoint();
                    int row = table.rowAtPoint(p);

                    comboBox.setSelectedIndex(row);
                    hide();
                }
            });

            table.setBackground(UIManager.getColor("ComboBox.listBackground"));
            table.setForeground(UIManager.getColor("ComboBox.listForeground"));
        }

        /**
         * This method is overridden from BasicComboPopup
         */
        @SuppressWarnings("deprecation")
        public void show() {
            if (isEnabled()) {
                super.removeAll();

                int scrollWidth = table.getPreferredSize().width +
                        ((Integer) UIManager.get("ScrollBar.width")).intValue() + 1;
                int scrollHeight = comboBoxUI.getList().
                        getPreferredScrollableViewportSize().height;
                scroll.setPreferredSize(new Dimension(scrollWidth, scrollHeight));

                super.add(scroll);

                ListSelectionModel selectionModel = table.getSelectionModel();
                selectionModel.removeListSelectionListener(this);
                selectRow();
                selectionModel.addListSelectionListener(this);

                int scrollX = 0;
                int scrollY = comboBox.getBounds().height;

                if (popupAlignment == Alignment.RIGHT) {
                    scrollX = comboBox.getBounds().width - scrollWidth;
                }

                show(comboBox, scrollX, scrollY);
            }
        }

        /**
         * Implemention of ListSelectionListener
         */
        public void valueChanged(ListSelectionEvent event) {
            comboBox.setSelectedIndex(table.getSelectedRow());
        }

        /**
         * Implemention of ItemListener
         */
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() != ItemEvent.DESELECTED) {
                ListSelectionModel selectionModel = table.getSelectionModel();
                selectionModel.removeListSelectionListener(this);
                selectRow();
                selectionModel.addListSelectionListener(this);
            }
        }

        /**
         * Sync up the selected row of the table with the selected row of the combo.
         */
        private void selectRow() {
            int index = comboBox.getSelectedIndex();

            if (index != -1) {
                table.setRowSelectionInterval(index, index);
                table.scrollRectToVisible(table.getCellRect(index, 0, true));
            }
        }
    }

    /**
     * A model for the popup table's data
     */
    private class PopupTableModel extends AbstractTableModel {
        /**
         * Return the # of columns in the drop-down table
         */
        public int getColumnCount() {
            return columnNames.length;
        }

        /**
         * Return the # of rows in the drop-down table
         */
        public int getRowCount() {
            return tableData == null ? 0 : tableData.size();
        }

        /**
         * Determine the value for a given cell
         */
        public Object getValueAt(int row, int col) {
            if (tableData == null || tableData.size() == 0) {
                return "";
            }

            return tableData.get(row).get(col);
        }

        /**
         * All cells in the drop-down table are uneditable
         */
        public boolean isCellEditable(int row, int col) {
            return false;
        }

        /**
         * Pull the column names out of the tableInfo object for the header
         */
        public String getColumnName(int column) {
            String columnName = null;

            if (column >= 0 && column < columnNames.length) {
                columnName = columnNames[column].toString();
            }

            return (columnName == null) ? super.getColumnName(column) : columnName;
        }
    }
}
