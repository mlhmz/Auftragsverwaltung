package me.mlhmz.sqlApplication.sqlBackend;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testDatabase {
    public void connect() {
        String url = "jdbc:mysql://localhost:3306/auftragsverwaltung";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zur Datenbank hergestellt werden! Bitte kontaktieren sie einen Entwickler.");
        }
    }
}
