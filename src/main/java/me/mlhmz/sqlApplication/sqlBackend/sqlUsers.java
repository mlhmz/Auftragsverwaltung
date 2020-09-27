package me.mlhmz.sqlApplication.sqlBackend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Users;

import java.sql.*;
import java.util.ArrayList;

public class sqlUsers {
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
                Users users = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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

    public static void insertSQL(String firmenname, String firmenadresse, String firmennummer, String firmenemail) {
        String url = "jdbc:mysql://localhost:3306/auftragsverwaltung";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url,user,password)) {
            // Creates a new Statement
            Statement stmt = con.createStatement();

            // Inserts the Data into the SQL Table with a SQL Statement
            stmt.executeUpdate("INSERT INTO `benutzer` (`id`, `firmenname`, `adresse`, `telefonnummer`, `firmenemail`) VALUES (NULL, '" + firmenname + "', '" + firmenadresse + "', '" + firmennummer + "', '" + firmenemail + "')");

            // Debug Message so the User know the Insert was successful.
            System.out.println("[MySQL] Das Einfügen der Daten war soweit erfolgreich!");

            // Finally closes the Statement
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Es ist ein Fehler aufgetreten bei dem Einsetzen der Benutzer-Werte.");
        }

    }

    public static void delete(int id) {
        String url = "jdbc:mysql://localhost:3306/auftragsverwaltung";
        String user = "root";
        String password = "";
        try (Connection con = DriverManager.getConnection(url,user,password)) {
            String query = "DELETE from `benutzer` where id=" + id;
            Statement s = con.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Ein Fehler ist aufgetreten beim löschen von Auftragsdaten.");
        }
    }
}


