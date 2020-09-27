package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.sqlBackend.sqlDepartment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manageDepartment {
    private JComboBox comboBox1;
    private JButton deleteButton;
    private JButton informationenÄndernButton;
    private JPanel panel;


    public manageDepartment() {
        Database database = new Database();
        comboBox1.setRenderer(new ListRenderer());
        for (int i = 0; Database.departmentList.size() > i; i++) {
            int id = Database.departmentList.get(i).getId();
            String name = Database.departmentList.get(i).getAbteilungsName();
            Object[] item = new Object[] {id, name};
            comboBox1.addItem(item);
        }

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object export[] = (Object[]) comboBox1.getSelectedItem();

                sqlDepartment.delete((int) export[0]);
            }
        });
        informationenÄndernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object export[] = (Object[]) comboBox1.getSelectedItem();

                changeDepartmentInformation.setId((int) export[0]);
                changeDepartmentInformation.start();

            }
        });
    }

    public static void start() {
        JFrame frame = new JFrame("Abteilungsverwaltung");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new manageDepartment().panel);
        frame.pack();
        frame.setVisible(true);
    }
}
