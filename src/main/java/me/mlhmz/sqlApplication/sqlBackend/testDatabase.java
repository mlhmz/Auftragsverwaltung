package me.mlhmz.sqlApplication.sqlBackend;

import me.mlhmz.sqlApplication.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testDatabase {
    public void connect() {
        String url = Database.credentialList.get(0).getUrl() + "/" + Database.credentialList.get(0).getDatabaseName();
        String user = Database.credentialList.get(0).getUsername();
        String password = Database.credentialList.get(0).getPassword();
        try (Connection con = DriverManager.getConnection(url, user, password)) {

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zur Datenbank hergestellt werden! Bitte kontaktieren sie einen Entwickler.");
            System.exit(1);
        }
    }
}
