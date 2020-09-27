package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.sqlBackend.sqlProducts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createProduct {
    private JTextField textField1;
    private JButton produktErstellenButton;
    private JPanel panel;

    public createProduct() {
        produktErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sqlProducts.insertSQL(textField1.getText());
            }
        });
    }

    public static void start() {
        JFrame frame = new JFrame("Produkt erstellen");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new createProduct().panel);
        frame.pack();
        frame.setVisible(true);
    }
}
