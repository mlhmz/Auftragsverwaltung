package me.mlhmz.sqlApplication.Frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dataManagment {
    private JButton createUserBtn;
    private JButton manageUser;
    private JPanel panel;
    private JButton abteilungErstellenButton;
    private JButton abteilungVerwaltenButton;
    private JButton produktErstellenButton;
    private JButton produktVerwaltenButton;

    public dataManagment() {
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
        abteilungErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDepartment.start();
            }
        });
        produktErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProduct.start();
            }
        });
        abteilungVerwaltenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageDepartment.start();
            }
        });
        produktVerwaltenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageProducts.start();
            }
        });
    }

    public static void start() {
        JFrame frame = new JFrame("Datenverwaltung");
        frame.setBounds(50,50,300,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new dataManagment().panel);
        frame.pack();
        frame.setVisible(true);

    }
}


