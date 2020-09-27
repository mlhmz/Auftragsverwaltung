package me.mlhmz.sqlApplication.Frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Orders;
import me.mlhmz.sqlApplication.sqlBackend.sqlOrders;

public class GUI {
    private JButton kundenverwaltungButton;
    private JButton bestellungSendenButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JPanel panel;
    private JTextField textField1;
    private JButton löschenButton;
    private JSpinner spinner1;
    private JTable table1;
    private JButton aktualisierenButton;
    public UIManager ui;

    public GUI() {
        DefaultTableModel model = new DefaultTableModel();
        String columns[] = {"Auftrags ID", "Firmenname", "Firmentelefonnummer", "Firmenadresse", "Firmenemail", "Produkt", "Menge", "Beauftragte Abteilung", "Abteilungsleiter",
        "Abteilungstelefonnummer", "Auftragsdatum", "Deadline"};
        for (String column : columns) {
            model.addColumn(column);
        }

        for (Orders order : Database.orderList) {
            Object data[] = {String.valueOf(order.getAuftragsid()), order.getFirmenname(), order.getFirmentelefonnummer(), order.getFirmenadresse(), order.getFirmenemail(), order.getProdukt(),
            String.valueOf(order.getMenge()), order.getAbteilungsname(), order.getAbteilungsleiter(), order.getAbteilungstelefonnummer(), order.getAuftragsdatum(), order.getDeadline()};
            model.addRow(data);
        }


        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table1.setModel(model);


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
                if(spinner1.getValue().equals(0)) {
                    JOptionPane.showMessageDialog(null, "Sie haben keine Menge angegeben!");
                    return;
                }

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

                // Menge
                int menge = (int) spinner1.getValue();

                sqlOrders.insert((int) export2[0], (int) export3[0], (int) export1[0], zeit, deadline, menge);
                aktualisierenButton.getAction();
            }
        });

        kundenverwaltungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userManagment.start();
            }
        });
        löschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sqlOrders.delete(Integer.parseInt((String) table1.getValueAt(table1.getSelectedRow(), 0)));
            }
        });
        aktualisierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database.orderList.clear();
                sqlOrders.connect();
                DefaultTableModel model1 = new DefaultTableModel();
                String columns[] = {"Auftrags ID", "Firmenname", "Firmentelefonnummer", "Firmenadresse", "Firmenemail", "Produkt", "Menge", "Beauftragte Abteilung", "Abteilungsleiter",
                        "Abteilungstelefonnummer", "Auftragsdatum", "Deadline"};
                for (String column : columns) {
                    model1.addColumn(column);
                }

                for (Orders order : Database.orderList) {
                    Object data[] = {String.valueOf(order.getAuftragsid()), order.getFirmenname(), order.getFirmentelefonnummer(), order.getFirmenadresse(), order.getFirmenemail(), order.getProdukt(),
                            String.valueOf(order.getMenge()), order.getAbteilungsname(), order.getAbteilungsleiter(), order.getAbteilungstelefonnummer(), order.getAuftragsdatum(), order.getDeadline()};
                    model1.addRow(data);
                }


                table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table1.setModel(model1);

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
