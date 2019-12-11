package m4.Team2;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableButtonRenderer extends JButton implements TableCellRenderer {

    public TableButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(
        JTable table,
        Object value,
        boolean isSelected,
        boolean isFocused,
        int row,
        int col) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setFocusPainted(false);
        return this;
    }

}

