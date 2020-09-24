package me.mlhmz.sqlApplication.Frontend;

import me.mlhmz.sqlApplication.objects.Users;
import me.mlhmz.sqlApplication.sqlBackend.sqlUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class createUser {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panel;
    private JButton nutzerErstellenButton;
    private JTextField textField4;
    public static JFrame frame = new JFrame();


    public createUser() {
        nutzerErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // NULL = the null in SQL so the Auto Increment works.
                Users user = new Users(
                        -1, // Placeholder so Java dont gets "confused"
                        textField1.getText(), // Gets the Name
                        textField2.getText(), // Gets the Address
                        textField3.getText(), // Gets the Number
                        textField4.getText());  // Gets the Email
                sqlUsers.insertSQL(user.firmenname, user.adresse, user.telefonnummer, user.firmenemail);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            }

        });
    }

    public static void start() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new createUser().panel);
        frame.pack();
        frame.setVisible(true);
    }


}
