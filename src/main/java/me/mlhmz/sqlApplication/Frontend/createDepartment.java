package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.sqlBackend.sqlDepartment;
import me.mlhmz.sqlApplication.sqlBackend.sqlUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createDepartment {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton abteilungErstellenButton;
    private JPanel panel;

    public createDepartment() {
        abteilungErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sqlDepartment.insertSQL(textField1.getText(), textField2.getText(), textField3.getText());
            }
        });
    }

    public static void start() {
        JFrame frame = new JFrame("Abteilung Erstellen");
        frame.add(new createDepartment().panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
