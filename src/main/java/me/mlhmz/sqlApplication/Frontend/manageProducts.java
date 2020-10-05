package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.sqlBackend.sqlProducts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manageProducts {
    private JComboBox comboBox1;
    private JButton löschenButton;
    private JButton informationenÄndernButton;
    private JPanel panel;

    public manageProducts() {
        Database database = new Database();
        for (int i = 0; Database.productList.size() > i; i++) {
            if (!Database.productList.isEmpty()) {
                comboBox1.setRenderer(new ListRenderer());
                int id = Database.productList.get(i).getId();
                String name = Database.productList.get(i).getProduktname();
                Object[] item = new Object[] {id, name};
                comboBox1.addItem(item);
            }

        }

        löschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] export = (Object[]) comboBox1.getSelectedItem();

                sqlProducts.delete((int) export[0]);
            }
        });
        informationenÄndernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] export = (Object[]) comboBox1.getSelectedItem();

                changeProductInformation.setId((int) export[0]);
                changeProductInformation.start();
            }
        });
    }

    public static void start() {
        JFrame frame = new JFrame("Produkte verwalten");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new manageProducts().panel);
        frame.pack();
        frame.setVisible(true);
    }
}
