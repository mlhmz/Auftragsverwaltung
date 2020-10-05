package me.mlhmz.sqlApplication.sqlBackend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Credentials;

import java.sql.*;

public class tableCreator {
    public static void start() {
        Credentials credentials = Database.credentialList.get(0);
        String url = credentials.getUrl() + "/" + "auftraege";
        String name = credentials.getUsername();
        String password = credentials.getPassword();
        try (Connection con = DriverManager.getConnection(url, name, password)) {
            String abteilungen = "CREATE TABLE IF NOT EXISTS `abteilungen` (" +
                    "abteilungsid int(15) NOT NULL auto_increment," +
                    "abteilungsname varchar(50)," +
                    "abteilungsnummer varchar(50)," +
                    "abteilungsleiter varchar(50)," +
                    "CONSTRAINT abteilung_pk PRIMARY KEY (abteilungsid)" +
                    ")";

            String auftraege = "CREATE TABLE IF NOT EXISTS `auftraege` (" +
                    "produktid int(50)," +
                    "kundenid int(50)," +
                    "abteilungsid int(50)," +
                    "auftragsid int(50) NOT NULL auto_increment," +
                    "auftragsdatum varchar(50)," +
                    "deadline varchar(15)," +
                    "menge int(4)," +
                    "CONSTRAINT auftrags_pk PRIMARY KEY (auftragsid)" +
                    ")";

            String benutzer = "CREATE TABLE IF NOT EXISTS `benutzer` (" +
                    "id int(15) NOT NULL auto_increment," +
                    "firmenname varchar(50)," +
                    "adresse varchar(50)," +
                    "telefonnummer varchar(50)," +
                    "firmenemail varchar(50)," +
                    "CONSTRAINT benutzer_pk PRIMARY KEY (id)" +
                    ")";

            String produkte = "CREATE TABLE IF NOT EXISTS `produkte` (" +
                    "id int(15) NOT NULL auto_increment," +
                    "produktname varchar(50)," +
                    "CONSTRAINT produkt_pk PRIMARY KEY (id)" +
                    ")";

            Statement stmt = con.createStatement();

            stmt.executeUpdate(abteilungen);
            stmt.executeUpdate(auftraege);
            stmt.executeUpdate(benutzer);
            stmt.executeUpdate(produkte);

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("[MySQL] Ein Fehler ist bei der Erstellung von den Tabellen aufgetreten.");
        }


    }
}
