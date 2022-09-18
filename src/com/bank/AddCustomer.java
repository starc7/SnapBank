package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class AddCustomer extends JFrame {
    JLabel bankLabel, dateLabel;
    JLabel firstNameLabel, lastNameLabel, dobLabel, fatherNameLabel, mobileNoLabel, addressLabel, openingAmountLabel;
    private JTextField firstName, lastName, dob, fatherName, mobileNo, address, openingAmount;
    private JButton submitDetails, logoutButton, backButton;

    //Constructor for initializing object
    AddCustomer() {
        setTitle("SNAPBANK");
        Image icon = Toolkit.getDefaultToolkit().getImage("Images\\icon1.jpg");
        setIconImage(icon);
        setContentPane(new JLabel(new ImageIcon("Images\\HomeImage.jpg")));

        //Labels
        LocalDate d = LocalDate.now();
        dateLabel = new JLabel(d.toString());
        dateLabel.setBounds(360, 10, 80, 20);

        bankLabel = new JLabel("<htmL><font color='gray'>Snap</font><font color='1E90FF'>Bank</font></html>");
        bankLabel.setFont(new Font("Times New Roman", Font.BOLD, 64));
        bankLabel.setBounds(257, 25, 286, 80);

        firstNameLabel = new JLabel("First name :");
        firstNameLabel.setBounds(190, 150, 150, 20);

        lastNameLabel = new JLabel("Last name :");
        lastNameLabel.setBounds(190, 180, 150, 20);

        dobLabel = new JLabel("Date of Birth :");
        dobLabel.setBounds(190, 210, 150, 20);

        fatherNameLabel = new JLabel("Father's name :");
        fatherNameLabel.setBounds(190, 240, 150, 20);

        mobileNoLabel = new JLabel("Mobile No. :");
        mobileNoLabel.setBounds(190, 270, 150, 20);

        addressLabel = new JLabel("Address :");
        addressLabel.setBounds(190, 300, 150, 20);

        openingAmountLabel = new JLabel("Opening amount :");
        openingAmountLabel.setBounds(190, 330, 150, 20);

        //Fields
        firstName = new JTextField(20);
        firstName.setBounds(360, 150, 250, 20);

        lastName = new JTextField(20);
        lastName.setBounds(360, 180, 250, 20);

        dob = new JTextField(20);
        dob.setBounds(360, 210, 250, 20);

        fatherName = new JTextField(20);
        fatherName.setBounds(360, 240, 250, 20);

        mobileNo = new JTextField(20);
        mobileNo.setBounds(360, 270, 250, 20);

        address = new JTextField(20);
        address.setBounds(360, 300, 250, 20);

        openingAmount = new JTextField(20);
        openingAmount.setBounds(360, 330, 250, 20);

        //Buttons
        backButton = new JButton("Back");
        backButton.setBackground(Color.orange);
        backButton.setBounds(10, 5, 90, 25);
        backButton.addActionListener(new ActionListener() {   //Action
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new WelcomeUI().show();
            }
        });

        logoutButton = new JButton("Log Out");
        logoutButton.setBackground(Color.orange);
        logoutButton.setBounds(690, 5, 90, 25);
        logoutButton.addActionListener(new ActionListener() {  //Action
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage().show();
            }
        });

        submitDetails = new JButton("Submit");
        submitDetails.setBackground(Color.cyan);
        submitDetails.setBounds(340, 370, 120, 40);
        submitDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String a = firstName.getText(), b = lastName.getText(), c = dob.getText();
                String d = fatherName.getText(), e = mobileNo.getText(), f = address.getText();
                double g = Double.parseDouble(openingAmount.getText());
                String h = dateLabel.getText();

                new ConnectionClass().addCustomerInDb(a, b, c, d, e, f, g, h);
            }
        });

        //Add objects
        //Add Labels
        add(dateLabel);
        add(bankLabel);
        add(firstNameLabel);
        add(lastNameLabel);
        add(dobLabel);
        add(fatherNameLabel);
        add(mobileNoLabel);
        add(addressLabel);
        add(openingAmountLabel);
        //Add Fields
        add(firstName);
        add(lastName);
        add(dob);
        add(fatherName);
        add(mobileNo);
        add(address);
        add(openingAmount);
        //Add Buttons
        add(backButton);
        add(logoutButton);
        add(submitDetails);

        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300, 100, 800, 550);
    }
}
