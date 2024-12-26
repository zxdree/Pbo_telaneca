package dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pboTelAneca.FrameDashboardAdmin;
import pboTelAneca.FrameTransaksiAdmin;



public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String label;
    private boolean clicked;
    private JTable currentTable;
    private int currentRow;
    private String type;
//    private List<Integer> idTransaksiList;



    public ButtonEditor(JCheckBox checkBox, String type) {
        super(checkBox);
        this.type = type;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }



    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "Details" : value.toString();
        button.setText(label);
        clicked = true;
        currentTable = table;
        currentRow = row;
        return button;
    }

   @Override
    public Object getCellEditorValue() {
        if (clicked) {
            int id = (int) currentTable.getValueAt(currentRow, 0); 
            if ("transaksi".equals(type)) {
                System.out.println("Button dari transaksi: " + id);
                FrameTransaksiAdmin detail = (FrameTransaksiAdmin) SwingUtilities.getWindowAncestor(currentTable);
                detail.openTransaksiDetails(id);
            } else if ("penjual".equals(type)) {
                System.out.println("Button dari penjual: " + id);
                FrameDashboardAdmin dashboard = (FrameDashboardAdmin) SwingUtilities.getWindowAncestor(currentTable);
                dashboard.openUserDetails(id);
            }
        }
        clicked = false;
        return label;
    }
    
}
