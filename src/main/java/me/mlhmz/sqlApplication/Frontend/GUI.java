package me.mlhmz.sqlApplication.Frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.sqlBackend.sqlOrders;

public class GUI {
    private JButton kundenverwaltungButton;
    private JButton bestellungSendenButton;
    private JTable table1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JPanel panel;
    private JTextField textField1;
    private JButton löschenButton;
    public UIManager ui;

    public GUI() {

        /* The Items of the ComboBoxes are Objects,
        so the ListRenderer will get the second Array Entry of the Array (which is the Name)
        and will Display it as the Item so the Program can pick the ID's later.. */
        comboBox1.setRenderer(new ListRenderer());
        comboBox2.setRenderer(new ListRenderer());
        comboBox3.setRenderer(new ListRenderer());

        for (int i = 0; Database.departmentList.size() > i; i++) {
            // Creates a Object and puts it into the ComboBox
            int id = Database.departmentList.get(i).getId();
            String name = Database.departmentList.get(i).getAbteilungsName();
            Object[] item = new Object[] {id, name};
            comboBox1.addItem(item);


        }

        // Same Things happening here as by comboBox1
        for (int i = 0; Database.productList.size() > i; i++) {
            int id = Database.productList.get(i).getId();
            String name = Database.productList.get(i).getProduktname();
            Object[] item = new Object[] {id, name};
            comboBox2.addItem(item);
        }

        for (int i = 0; Database.userList.size() > i; i++) {
            int id = Database.userList.get(i).getId();
            String name = Database.userList.get(i).getFirmenname();
            Object[] item = new Object[] {id, name};
            comboBox3.addItem(item);
        }




        bestellungSendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Array-Hint 0 = int Id, 1 = String Name

                // Abteilung
                Object[] export1 = (Object[]) comboBox1.getSelectedItem();

                // Produkt
                Object[] export2 = (Object[]) comboBox2.getSelectedItem();

                // Firma
                Object[] export3 = (Object[]) comboBox3.getSelectedItem();

                // Deadline
                String deadline = textField1.getText();

                // Auftragsdatum
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String zeit = dtf.format(now);

                sqlOrders.insert((int) export2[0], (int) export3[0], (int) export1[0], zeit, deadline);
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
