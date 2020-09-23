package me.mlhmz.sqlApplication.Frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import me.mlhmz.sqlApplication.Database;

public class GUI {
    private JButton kundenverwaltungButton;
    private JButton bestellungSendenButton;
    private JTable table1;
    public JComboBox comboBox1;
    public JComboBox comboBox2;
    public JComboBox comboBox3;
    private JPanel panel;
    public UIManager ui;

    public GUI() {
        comboBox1.addItem("-");
        comboBox2.addItem("-");
        comboBox3.addItem("-");

        for (int i = 0; Database.departmentList.size() > i; i++) {
            comboBox1.addItem(Database.departmentList.get(i).getAbteilungsName());
        }

        for (int i = 0; Database.productList.size() > i; i++) {
            comboBox2.addItem(Database.productList.get(i).getProduktname());
        }

        for (int i = 0; Database.userList.size() > i; i++) {
            comboBox3.addItem(Database.userList.get(i).getFirmenname());
        }


        bestellungSendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        kundenverwaltungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userManagment.start();
            }
        });
    }

    public void start() {
        JFrame frame = new JFrame("Auftragsverwaltung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSystemUI();
        frame.add(new GUI().panel);
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(50,50,500,400);
    }

    public void setSystemUI() {
        try {
            ui.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
