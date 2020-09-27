package me.mlhmz.sqlApplication.Frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userManagment {
    private JButton createUserBtn;
    private JButton manageUser;
    private JPanel panel;
    private JButton abteilungErstellenButton;
    private JButton abteilungVerwaltenButton;
    private JButton produktErstellenButton;
    private JButton produktVerwaltenButton;

    public userManagment() {
        manageUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageUsers.start();
            }
        });
        createUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUser.start();
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


