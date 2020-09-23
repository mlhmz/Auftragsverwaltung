package me.mlhmz.sqlApplication.sqlBackend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Users;

import java.sql.*;
import java.util.ArrayList;

public class getSqlUsers {
    public ArrayList<Users> connectSQL() {

        String url = "jdbc:mysql://localhost:3306/auftragsverwaltung";
        String user = "root";
        String password = "";

        // Initialize Database
        Database database = new Database();

        // Connect to MySQL
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("[MySQL] Es wurde eine Verbindung mit der SQL Datenbank hergestellt für die Benutzer-Tabelle!");

            // Get Data from Query
            String query = "SELECT * FROM benutzer ORDER BY id ASC";

            // Create new Statement
            Statement stmt = con.createStatement();

            // Get Result with Statement
            ResultSet rs = stmt.executeQuery(query);

            // Save Amount of Columns in a int
            int columns = rs.getMetaData().getColumnCount();



            // Store all Userdata's into an ArrayList
            while (rs.next()) {
                Users users = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                database.userList.add(users);
            }


            // Close SQL Connection
            rs.close();
            stmt.close();
        // If theres an Error, catch and report it.
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Ein Datenbank Technischer Fehler ist aufgetreten bei der Benutzertabelle.");
        }

        // Return the Userdata to the List
        return Database.userList;
    }
}


