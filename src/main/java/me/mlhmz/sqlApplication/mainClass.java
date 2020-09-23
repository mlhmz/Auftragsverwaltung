package me.mlhmz.sqlApplication;

import me.mlhmz.sqlApplication.sqlBackend.*;

public class mainClass {
    public static void main(String[] args) {
        getSqlUsers sqlUsers = new getSqlUsers();
        getSqlDepartment sqlDepartment = new getSqlDepartment();
        sqlUsers.connectSQL();
        sqlDepartment.connectSQL();
        GUI gui = new GUI();
        gui.start();


    }
}
