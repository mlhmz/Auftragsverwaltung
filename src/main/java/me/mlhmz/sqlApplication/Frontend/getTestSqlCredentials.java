package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Credentials;
import me.mlhmz.sqlApplication.sqlBackend.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class getTestSqlCredentials {
    private JTextField dburl;
    private JTextField dbname;
    private JTextField username;
    private JPasswordField password;
    private JButton bestätigenButton;
    private JPanel panel;
    public UIManager ui;

    public getTestSqlCredentials() {
        bestätigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Initialize internal Databases
                testDatabase testDB = new testDatabase();
                sqlUsers sqlUsers = new sqlUsers();
                sqlDepartment sqlDepartment = new sqlDepartment();
                sqlProducts sqlProducts = new sqlProducts();

                String url = dburl.getText();
                String name = dbname.getText();
                String dbusername = username.getText();
                String dbpassword = "";
                for (int i = 0; password.getPassword().length > i; i++) {
                    dbpassword += password.getPassword()[i];
                }
                Credentials testcreds = new Credentials(url, name, dbusername, dbpassword);
                Database.credentialList.add(testcreds);
                // Tests the Database and sends a Message if there's no connection established
                testDB.connect();

                // Connects to the User Database
                sqlOrders.connect();
                sqlUsers.connectSQL();
                sqlDepartment.connectSQL();
                sqlProducts.connectSQL();
                GUI gui = new GUI();
                gui.start();
            }
        });
    }

    public void start() {
        JFrame frame = new JFrame("Datenbank Zugangsdaten für den Testmodus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSystemUI();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(50,50,300, 300);
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
