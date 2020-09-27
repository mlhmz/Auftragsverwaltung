package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.Database;
import me.mlhmz.sqlApplication.objects.Users;
import me.mlhmz.sqlApplication.sqlBackend.sqlUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeUserInformation {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton saveChanges;
    private JPanel panel;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        changeUserInformation.id = id;
    }

    public static int id = 0;

    public changeUserInformation() {
        textField1.setEnabled(false);
        textField2.setEnabled(false);
        textField3.setEnabled(false);
        textField4.setEnabled(false);
        for (Users user : Database.userList) {
            if (user.getId() == id) {
                textField1.setText(user.getFirmenname());
                textField2.setText(user.getAdresse());
                textField3.setText(user.getTelefonnummer());
                textField4.setText(user.getFirmenemail());
            }
        }



        saveChanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox1.isSelected()) {
                    sqlUsers.update(id, "firmenname", textField1.getText());
                }

                if (checkBox2.isSelected()) {
                    sqlUsers.update(id, "adresse", textField2.getText());
                }

                if (checkBox3.isSelected()) {
                    sqlUsers.update(id, "telefonnummer", textField3.getText());
                }

                if (checkBox4.isSelected()) {
                    sqlUsers.update(id, "firmenemail", textField4.getText());
                }
            }
        });


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
                if (checkBox4.isSelected()) {
                    textField4.setEnabled(true);
                } else {
                    textField4.setEnabled(false);
                }

            }
        };
        checkBox1.addActionListener(listener);
        checkBox2.addActionListener(listener);
        checkBox3.addActionListener(listener);
        checkBox4.addActionListener(listener);
    }

    public static void start() {
        JFrame frame = new JFrame("Informationen ändern");
        frame.add(new changeUserInformation().panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
