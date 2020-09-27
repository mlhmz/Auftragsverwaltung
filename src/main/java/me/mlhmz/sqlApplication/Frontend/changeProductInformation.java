package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.sqlBackend.sqlProducts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeProductInformation {
    private JTextField textField1;
    private JButton saveChanges;
    private JPanel panel;
    public static int id = 0;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        changeProductInformation.id = id;
    }

    public changeProductInformation() {
        saveChanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sqlProducts.update(id, "produktname", textField1.getText());
            }
        });
    }

    public static void start() {
        JFrame frame = new JFrame("Produkte verwalten");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new changeProductInformation().panel);
        frame.pack();
        frame.setVisible(true);
    }
}
