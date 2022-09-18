package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    // Declaring objects
    JPanel topPanel;
    JLabel bankNameLabel, userIdLabel, passLabel;
    private JTextField userIdField;
    private JPasswordField passField;
    JButton loginButton;

    // Initializing objects in constructor
    LoginPage() {
        setTitle("SNAPBANK");
        Image icon=Toolkit.getDefaultToolkit().getImage("Images\\icon1.jpg");
        setIconImage(icon);
        setContentPane(new JLabel(new ImageIcon("Images\\HomeImage.jpg")));

        // Top Panel
        topPanel=new JPanel();
        topPanel.setBackground(Color.RED);
        topPanel.setBounds(0,0,800,100);

        // Bank Name
        bankNameLabel=new JLabel("SNAPBANK");
        bankNameLabel.setBounds(200,0,400,100);
        bankNameLabel.setFont(new Font("Times New Roman",Font.BOLD,70));
        bankNameLabel.setForeground(Color.WHITE);
        topPanel.add(bankNameLabel);

        // UserId label
        userIdLabel=new JLabel("User ID");
        userIdLabel.setBounds(300,180,100,20);

        // UserId field
        userIdField=new JTextField(15);
        userIdField.setBounds(300,200,200,20);

        // Pass label
        passLabel=new JLabel("Password");
        passLabel.setBounds(300,240,100,20);

        // Pass field
        passField=new JPasswordField(15);
        passField.setBounds(300,260,200,20);

        // Login button
        loginButton=new JButton("Log In");
        loginButton.setBounds(300,310,200,30);
        loginButton.setBackground(Color.CYAN);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((userIdField.getText()).equals("ideal")) {
                    if ((passField.getText()).equals("pass")) {
                        dispose();
                        new WelcomeUI().show();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Password isn't correct", "Log In",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid User ID", "Log In",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adding objects to frame
        add(topPanel);
        add(userIdLabel);
        add(userIdField);
        add(passLabel);
        add(passField);
        add(loginButton);

        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300,100,800,550);
    }
}
