package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Department;
import me.mlhmz.sqlApplication.sqlBackend.sqlDepartment;
import me.mlhmz.sqlApplication.sqlBackend.sqlUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeDepartmentInformation {
    private JCheckBox checkBox1;
    private JTextField textField1;
    private JCheckBox checkBox2;
    private JTextField textField2;
    private JCheckBox checkBox3;
    private JTextField textField3;
    private JButton informationenSpeichernButton;
    private JPanel panel;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        changeDepartmentInformation.id = id;
    }

    public static int id = 0;

    public changeDepartmentInformation() {
        for (Department department : Database.departmentList) {
            if (department.getId() == id) {
                textField1.setText(department.getAbteilungsName());
                textField2.setText(department.getAbteilungsNummer());
                textField3.setText(department.getAbteilungsleiter());
            }
        }

        textField1.setEnabled(false);
        textField2.setEnabled(false);
        textField3.setEnabled(false);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox1.isSelected()) {
                    textField1.setEnabled(true);
                } else {
                    textField1.setEnabled(false);
                }
                if (checkBox2.isSelected()) {
                    textField2.setEnabled(true);
                } else {
                    textField2.setEnabled(false);
                }
                if (checkBox3.isSelected()) {
                    textField3.setEnabled(true);
                } else {
                    textField3.setEnabled(false);
                }
            }
        };
        checkBox1.addActionListener(listener);
        checkBox2.addActionListener(listener);
        checkBox3.addActionListener(listener);
        informationenSpeichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox1.isSelected()) {
                    sqlDepartment.update(id, "abteilungsname", textField1.getText());
                }

                if (checkBox2.isSelected()) {
                    sqlDepartment.update(id, "abteilungsnummer", textField2.getText());
                }

                if (checkBox3.isSelected()) {
                    sqlDepartment.update(id, "abteilungsleiter", textField3.getText());
                }
            }
        });
    }

    public static void start() {
        JFrame frame = new JFrame("Informationen ändern");
        frame.add(new changeDepartmentInformation().panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
