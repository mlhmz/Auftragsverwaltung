package me.mlhmz.sqlApplication.sqlBackend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlOrders {


    public static void insert(int produktid, int kundenid, int abteilungsid, String auftragsdatum, String deadline) {
        String url = "jdbc:mysql://localhost:3306/auftragsverwaltung";
        String user = "root";
        String password = "";

        try (Connection con = DriverManager.getConnection(url,user,password)) {
            // Creates new Statements
            Statement s = con.createStatement();

            // Inserts the Data into the SQL Table with a SQL Statement
            s.executeUpdate("INSERT INTO `auftraege` (`produktid`, `kundenid`, `abteilungsid`, `auftragsid`, `auftragsdatum`, `deadline`) VALUES ('" + produktid + "', '" + kundenid + "', '" + abteilungsid + "', NULL, '" + auftragsdatum + "', '" + deadline + "')");

            // Debug Message so the User know the Insert was successful.
            System.out.println("[MySQL] Das Einfügen der Daten war soweit erfolgreich!");

            // Close the Connection
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Es ist ein Fehler aufgetreten bei dem Einsetzen der Auftrags-Werte.");
        }
    }
}
