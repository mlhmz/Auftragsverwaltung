package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.sqlBackend.sqlUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manageUsers {
    private JComboBox comboBox1;
    private JButton changeInformationBtn;
    private JButton deleteCustomer;
    private JPanel panel;


    public manageUsers() {
        Database database = new Database();
        comboBox1.setRenderer(new ListRenderer());
        for (int i = 0; Database.userList.size() > i; i++) {
            int id = Database.userList.get(i).getId();
            String name = Database.userList.get(i).getFirmenname();
            Object[] item = new Object[] {id, name};
            comboBox1.addItem(item);
        }

        changeInformationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] export = (Object[]) comboBox1.getSelectedItem();

                changeUserInformation.setId((int) export[0]);
                changeUserInformation.start();
            }
        });
        deleteCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] export = (Object[]) comboBox1.getSelectedItem();

                sqlUsers.delete((int) export[0]);
            }
        });
    }

    public static void start() {
       JFrame frame = new JFrame("Benutzer verwalten");
       frame.setBounds(50,50,400,50);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.add(new manageUsers().panel);
       frame.pack();
       frame.setVisible(true);
    }
}
