package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDetails extends JFrame{
    JLabel bankLabel, acLabel;
    JLabel firstNameLabel, lastNameLabel, dobLabel, fatherNameLabel, mobileNoLabel, addressLabel, balanceLabel, joinDateLabel;
    JLabel firstName, lastName, dobL, fatherName, mobileNo, addressL, balanceL, joinDateL;
    private JButton editButton, transactionButton, removeButton, logoutButton, backButton;

    //Constructor for initializing object
    CustomerDetails(int acNo, String fname, String lname, String dob, String father, String mobile, String address, Double balance, String openDate) {
        setTitle("SNAPBANK");
        Image icon=Toolkit.getDefaultToolkit().getImage("Images\\icon1.jpg");
        setIconImage(icon);
        setContentPane(new JLabel(new ImageIcon("Images\\HomeImage.jpg")));

        //Labels
        acLabel=new JLabel("A/C no. : "+String.valueOf(acNo));
        acLabel.setBounds(320,10,160,20);

        bankLabel=new JLabel("<htmL><font color='gray'>Snap</font><font color='1E90FF'>Bank</font></html>");
        bankLabel.setFont(new Font("Times New Roman",Font.BOLD,64));
        bankLabel.setBounds(257,25,286,80);

        firstNameLabel=new JLabel("First name :");
        firstNameLabel.setBounds(260,150,120,20);

        lastNameLabel=new JLabel("Last name :");
        lastNameLabel.setBounds(260,180,120,20);

        dobLabel=new JLabel("Date of Birth :");
        dobLabel.setBounds(260,210,120,20);

        fatherNameLabel=new JLabel("Father's name :");
        fatherNameLabel.setBounds(260, 240,120,20);

        mobileNoLabel=new JLabel("Mobile No. :");
        mobileNoLabel.setBounds(260, 270,120,20);

        addressLabel=new JLabel("Address :");
        addressLabel.setBounds(260, 300,120,20);

        balanceLabel=new JLabel("Balance :");
        balanceLabel.setBounds(260, 330,120,20);

        joinDateLabel=new JLabel("Date of joining :");
        joinDateLabel.setBounds(260,360,120,20);

        //Results
        firstName=new JLabel(fname);
        firstName.setForeground(Color.blue);
        firstName.setBounds(450,150,250,20);

        lastName=new JLabel(lname);
        lastName.setForeground(Color.blue);
        lastName.setBounds(450,180,250,20);

        dobL=new JLabel(dob);
        dobL.setForeground(Color.blue);
        dobL.setBounds(450,210,250,20);

        fatherName=new JLabel(father);
        fatherName.setForeground(Color.blue);
        fatherName.setBounds(450,240,250,20);

        mobileNo=new JLabel(mobile);
        mobileNo.setForeground(Color.blue);
        mobileNo.setBounds(450,270,250,20);

        addressL=new JLabel(address);
        addressL.setForeground(Color.blue);
        addressL.setBounds(450,300,250,20);

        balanceL=new JLabel(String.valueOf(balance));
        balanceL.setForeground(Color.blue);
        balanceL.setBounds(450,330,250,20);

        joinDateL=new JLabel(openDate);
        joinDateL.setForeground(Color.orange);
        joinDateL.setBounds(450,360,250,20);

        //Buttons
        backButton=new JButton("Back");
        backButton.setBackground(Color.orange);
        backButton.setBounds(10,5,90,25);
        backButton.addActionListener(new ActionListener() {   //Action
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new WelcomeUI().show();
            }
        });

        logoutButton=new JButton("Log Out");
        logoutButton.setBackground(Color.orange);
        logoutButton.setBounds(690,5,90,25);
        logoutButton.addActionListener(new ActionListener() {  //Action
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage().show();
            }
        });

        editButton=new JButton("Edit");
        editButton.setBackground(Color.cyan);
        editButton.setBounds(300,380,200,25);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                JFrame editFrame=new JFrame("SNAPBANK");
                Image icon=Toolkit.getDefaultToolkit().getImage("Images\\icon1.jpg");
                editFrame.setIconImage(icon);
                editFrame.setContentPane(new JLabel(new ImageIcon("Images\\HomeImage.jpg")));

                //Labels
                firstNameLabel=new JLabel("First name :");
                firstNameLabel.setBounds(190,150,150,20);

                lastNameLabel=new JLabel("Last name :");
                lastNameLabel.setBounds(190,180,150,20);

                dobLabel=new JLabel("Date of Birth :");
                dobLabel.setBounds(190,210,150,20);

                fatherNameLabel=new JLabel("Father's name :");
                fatherNameLabel.setBounds(190, 240,150,20);

                mobileNoLabel=new JLabel("Mobile No. :");
                mobileNoLabel.setBounds(190, 270,150,20);

                addressLabel=new JLabel("Address :");
                addressLabel.setBounds(190, 300,150,20);

                //Fields
                JTextField firstName=new JTextField(fname);
                firstName.setBounds(360,150,250,20);

                JTextField lastName=new JTextField(lname);
                lastName.setBounds(360,180,250,20);

                JTextField dobField=new JTextField(dob);
                dobField.setBounds(360,210,250,20);

                JTextField fatherName=new JTextField(father);
                fatherName.setBounds(360,240,250,20);

                JTextField mobileNo=new JTextField(mobile);
                mobileNo.setBounds(360,270,250,20);

                JTextField addressField=new JTextField(address);
                addressField.setBounds(360,300,250,20);

                JButton exitButton=new JButton("Exit");
                exitButton.setBackground(Color.red);
                exitButton.setBounds(300,350,80,30);
                exitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        editFrame.dispose();
                        new WelcomeUI().show();
                    }
                });

                JButton updateButton=new JButton("Update");
                updateButton.setBackground(Color.cyan);
                updateButton.setBounds(420,350,80,30);
                updateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int acInt=Integer.parseInt(acLabel.getText().substring(10));
                        new ConnectionClass().updateCustomerMethod(acInt,firstName.getText(),lastName.getText(),
                                dobField.getText(),fatherName.getText(),mobileNo.getText(),addressField.getText());
                    }
                });

                //Adding objects
                editFrame.add(acLabel);
                editFrame.add(bankLabel);
                editFrame.add(firstNameLabel);
                editFrame.add(lastNameLabel);
                editFrame.add(dobLabel);
                editFrame.add(fatherNameLabel);
                editFrame.add(mobileNoLabel);
                editFrame.add(addressLabel);

                editFrame.add(firstName);
                editFrame.add(lastName);
                editFrame.add(dobField);
                editFrame.add(fatherName);
                editFrame.add(mobileNo);
                editFrame.add(addressField);

                editFrame.add(exitButton);
                editFrame.add(updateButton);
                editFrame.add(logoutButton);

                editFrame.setResizable(false);
                editFrame.setLayout(null);
                editFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                editFrame.setVisible(true);
                editFrame.setBounds(300,100,800,450);

                dispose();
            }
        });

        transactionButton=new JButton("Transaction History");
        transactionButton.setBackground(Color.cyan);
        transactionButton.setBounds(300,410,200,25);
        transactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConnectionClass().customerTransactionsDetails(acNo);
            }
        });

        removeButton=new JButton("Remove Customer");
        removeButton.setBackground(Color.cyan);
        removeButton.setBounds(300,440,200,25);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConnectionClass().removeCustomerMethod(acNo);
            }
        });
        //Add objects
        //Add Labels
        add(acLabel);
        add(bankLabel);
        add(firstNameLabel);
        add(lastNameLabel);
        add(dobLabel);
        add(fatherNameLabel);
        add(mobileNoLabel);
        add(addressLabel);
        add(balanceLabel);
        //Add Results
        add(firstName);
        add(lastName);
        add(dobL);
        add(fatherName);
        add(mobileNo);
        add(addressL);
        add(balanceL);
        //Add Buttons
        add(backButton);
        add(logoutButton);
        add(editButton);
        add(transactionButton);
        add(removeButton);

        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300,100,800,550);
    }
}