package me.mlhmz.sqlApplication.Frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userManagment {
    private JButton createUser;
    private JButton manageUser;
    private JPanel panel;

    public userManagment() {
        manageUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageUsers.start();
            }
        });
    }

    public static void start() {
        JFrame frame = new JFrame("Benutzerverwaltung");
        frame.setBounds(50,50,300,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new userManagment().panel);
        frame.pack();
        frame.setVisible(true);

    }
}


