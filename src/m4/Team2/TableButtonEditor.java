package m4.Team2;

import m4.Team3.SubmitResponse;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class TableButtonEditor extends DefaultCellEditor
{

    private JButton button;
    private String label;
    private boolean clicked;
    private int row, col;
    private JTable table;
    private List<Lead> leadList;

    public TableButtonEditor(List<Lead> leadList, JCheckBox checkBox, String label)
    {
        super(checkBox);
        this.leadList = leadList;
        this.label = label;
        this.button = new JButton();
        this.button.setOpaque(true);
        this.button.addActionListener(e -> fireEditingStopped());
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        this.col = column;

        button.setForeground(Color.black);
        button.setBackground(UIManager.getColor("Button.background"));
        button.setText(label);
        clicked = true;
        return button;
    }
    public Object getCellEditorValue() {

        if (clicked) {
            // TODO: Add page redirection logic here
            SubmitResponse window = new SubmitResponse(leadList.get(row));
//            DealerPesponsePage window = new DealerPesponsePage(leadList.get(row));
//            JOptionPane.showMessageDialog(button, "Lead Id: " + leadList.get(row).getLeadId());
        }
        clicked = false;
        return label;
    }

    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

}


