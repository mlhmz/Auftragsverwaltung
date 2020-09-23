package me.mlhmz.sqlApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manageUsers {
    private JComboBox comboBox1;
    private JButton changeInformation;
    private JButton deleteCustomer;
    private JPanel panel;


    public manageUsers() {
        Database database = new Database();
        comboBox1.addItem("-");
        for (int i = 0; Database.userList.size() > i; i++) {
            comboBox1.addItem(database.userList.get(i).getFirmenname());
        }
        changeInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
