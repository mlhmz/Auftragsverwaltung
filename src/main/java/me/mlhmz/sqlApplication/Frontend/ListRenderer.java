package me.mlhmz.sqlApplication.Frontend;

import javax.swing.*;
import java.awt.*;

public class ListRenderer extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Object[] item = (Object[])value;
        setText((String)item[1]);

        return this;
    }
}
