package dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pboTelAneca.FrameDashboardAdmin;

public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String label;
    private boolean clicked;
    private JTable currentTable;
    private int currentRow;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
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
            // Ambil ID pengguna dari tabel (kolom pertama)
            int userId = (int) currentTable.getValueAt(currentRow, 0);
            
            FrameDashboardAdmin dashboard = (FrameDashboardAdmin) SwingUtilities.getWindowAncestor(currentTable);
            dashboard.openUserDetails(userId); 
        }
        clicked = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }
}
