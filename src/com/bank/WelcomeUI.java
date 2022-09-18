package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WelcomeUI extends JFrame {
    //Declaration of objects
    JLabel iconImage, welcomeLabel;
    private JButton addNewCustomer, findCustomerDetails, dataOfAllCustomer, makeTransaction,
             transactionHistory, bankDetails, logoutButton;

    //constructor
    WelcomeUI() {
        setTitle("SNAPBANK");
        Image icon= Toolkit.getDefaultToolkit().getImage("Images\\icon1.jpg");
        setIconImage(icon);
        setContentPane(new JLabel(new ImageIcon("Images\\HomeImage.jpg")));

        //Objects
        //Image
        iconImage=new JLabel(new ImageIcon("Images\\icon1.jpg"));
        iconImage.setBounds(20,25,120,80);

        //Welcome
        welcomeLabel=new JLabel("<html><font color='red'>Welcome to </font><font color='gray'>Snap</font><font color='1E90FF'>Bank</font></html>");
        welcomeLabel.setFont(new Font("Times New Roman",Font.BOLD,64));
        welcomeLabel.setBounds(155,25,635,80);

        //LOGOUT BUTTON
        logoutButton=new JButton("Log Out");
        logoutButton.setBackground(Color.orange);
        logoutButton.setBounds(690,5,90,25);
        logoutButton.addActionListener(new ActionListener() {       //Action
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();
            }
        });

        //ADD NEW CUSTOMER BUTTON
        addNewCustomer=new JButton("Add New Customer");
        addNewCustomer.setBackground(Color.cyan);
        addNewCustomer.setBounds(300,150,200,30);
        addNewCustomer.addActionListener(new ActionListener() {     //Action
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddCustomer();
            }
        });

        //FIND CUSTOMER BUTTON
        findCustomerDetails=new JButton("Find or Edit Customer Details");
        findCustomerDetails.setBackground(Color.cyan);
        findCustomerDetails.setBounds(300,200,200,30);
        findCustomerDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog enterACDialog=new JDialog(new JFrame("SNAPBANK"),"Find Customer");
                enterACDialog.setIconImage(icon);
                enterACDialog.setLayout(new FlowLayout());
                JLabel acLabel=new JLabel("Enter A/C Number");
                JTextField acField=new JTextField(10);
                JButton findButton=new JButton("Find");
                findButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        new ConnectionClass().findCustomerInDb(Integer.parseInt(acField.getText()));
                        enterACDialog.dispose();
                        dispose();
                    }
                });

                enterACDialog.add(acLabel);
                enterACDialog.add(acField);
                enterACDialog.add(findButton);

                enterACDialog.setVisible(true);
                enterACDialog.setBounds(575,310,250,100);
            }
        });

        //DATA OF ALL CUSTOMERS
        dataOfAllCustomer=new JButton("Data of All Customers");
        dataOfAllCustomer.setBackground(Color.cyan);
        dataOfAllCustomer.setBounds(300,250,200,30);
        dataOfAllCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConnectionClass().getCustomerDb();
            }
        });

        //MAKE TRANSACTION BUTTON
        makeTransaction=new JButton("Make Transaction");
        makeTransaction.setBackground(Color.cyan);
        makeTransaction.setBounds(300,300,200,30);
        makeTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TransactionUI().show();
            }
        });

        //TRANSACTION HISTORY BUTTON
        transactionHistory=new JButton("Transaction History");
        transactionHistory.setBackground(Color.cyan);
        transactionHistory.setBounds(300,350,200,30);
        transactionHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog enterACDialog=new JDialog(new JFrame("SNAPBANK"),"Find Customer");
                enterACDialog.setIconImage(icon);
                enterACDialog.setLayout(new FlowLayout());
                JLabel acLabel=new JLabel("Enter A/C Number");
                JTextField acField=new JTextField(10);
                JButton findButton=new JButton("Find");
                findButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        new ConnectionClass().customerTransactionsDetails(Integer.parseInt(acField.getText()));
                        enterACDialog.dispose();
                    }
                });

                enterACDialog.add(acLabel);
                enterACDialog.add(acField);
                enterACDialog.add(findButton);

                enterACDialog.setVisible(true);
                enterACDialog.setBounds(575,310,250,100);
            }
        });

        bankDetails=new JButton("Bank Details");
        bankDetails.setBackground(Color.cyan);
        bankDetails.setBounds(300,400,200,30);
        bankDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConnectionClass().bankDetailsMethod();
            }
        });

        add(iconImage);
        add(welcomeLabel);
        add(logoutButton);
        add(addNewCustomer);
        add(findCustomerDetails);
        add(dataOfAllCustomer);
        add(makeTransaction);
        add(transactionHistory);
        add(bankDetails);

        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300,100,800,550);
    }
}
