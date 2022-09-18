package com.bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class TransactionUI extends JFrame {
    JLabel bankLabel, dateLabel;
    JPanel panelOfDeposit,panelOfWithdraw, panelOfTransfer, tempPanel;
    JButton depositButton, withdrawButton, transferButton, instructionButton, logoutButton, backButton;
    TransactionUI() {
        setTitle("SNAPBANK");
        Image icon=Toolkit.getDefaultToolkit().getImage("Images\\icon1.jpg");
        setIconImage(icon);
        setContentPane(new JLabel(new ImageIcon("Images\\HomeImage.jpg")));

        bankLabel=new JLabel("<htmL><font color='gray'>Snap</font><font color='1E90FF'>Bank</font></html>");
        bankLabel.setFont(new Font("Times New Roman",Font.BOLD,64));
        bankLabel.setBounds(360,25,286,80);

        LocalDate date=LocalDate.now();
        String str=date.toString();
        dateLabel=new JLabel(str);
        dateLabel.setBounds(70,100,80,20);

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

        depositButton=new JButton("Deposit");
        depositButton.setBackground(Color.cyan);
        depositButton.setBounds(40,150,120,30);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(tempPanel);
                remove(panelOfWithdraw);
                remove(panelOfTransfer);
                add(panelOfDeposit);
                setBounds(300,100,799,550);
                setBounds(300,100,800,550);
            }
        });

        withdrawButton=new JButton("Withdraw");
        withdrawButton.setBounds(40,215,120,30);
        withdrawButton.setBackground(Color.cyan);
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(tempPanel);
                remove(panelOfDeposit);
                remove(panelOfTransfer);
                add(panelOfWithdraw);
                setBounds(300,100,799,550);
                setBounds(300,100,800,550);
            }
        });

        transferButton=new JButton("Transfer");
        transferButton.setBounds(40,280,120,30);
        transferButton.setBackground(Color.cyan);
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(tempPanel);
                remove(panelOfDeposit);
                remove(panelOfWithdraw);
                add(panelOfTransfer);
                setBounds(300,100,799,549);
                setBounds(300,100,800,550);
            }
        });

        instructionButton=new JButton("Instructions");
        instructionButton.setBounds(40,345,120,30);
        instructionButton.setBackground(Color.cyan);
        instructionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                remove(panelOfDeposit);
                remove(panelOfWithdraw);
                remove(panelOfTransfer);
                add(tempPanel);
                setBounds(300,100,799,549);
                setBounds(300,100,800,550);
            }
        });
        // Deposit Panel
        panelOfDeposit=new JPanel();
            JLabel depositLabel=new JLabel("Deposit Funds");
            depositLabel.setFont(new Font("Times New Roman",Font.BOLD,27));
            depositLabel.setForeground(Color.red);
            depositLabel.setBounds(210,120,200,30);

            JLabel acNoLabel=new JLabel("Enter A/C No : ");
            acNoLabel.setBounds(145,180,90,20);

            JLabel amountLabel=new JLabel("Enter Amount : ");
            amountLabel.setBounds(145,220,90,20);

            JLabel msgLabel=new JLabel("Message : ");
            msgLabel.setBounds(145,260,90,20);

            JTextField acField=new JTextField(7);
            acField.setBounds(250,180,200,20);

            JTextField amountField=new JTextField(12);
            amountField.setBounds(250,220,200,20);

            JTextField msgField=new JTextField();
            msgField.setBounds(250,260,200,20);

            JButton proceedDeposit=new JButton("Deposit");
            proceedDeposit.setBackground(Color.red);
            proceedDeposit.setBounds(220,310,160,30);
            proceedDeposit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ConnectionClass().depositMethod(Double.parseDouble(amountField.getText()),
                            Integer.parseInt(acField.getText()), dateLabel.getText(), msgField.getText());
                }
            });

            panelOfDeposit.add(depositLabel);
            panelOfDeposit.add(acNoLabel);
            panelOfDeposit.add(amountLabel);
            panelOfDeposit.add(msgLabel);
            panelOfDeposit.add(acField);
            panelOfDeposit.add(amountField);
            panelOfDeposit.add(msgField);
            panelOfDeposit.add(proceedDeposit);

        panelOfDeposit.setLayout(null);
        panelOfDeposit.setBounds(200,0,600,550);

        // Withdraw Panel
        panelOfWithdraw=new JPanel();
            JLabel withdrawLabel=new JLabel("Withdraw Funds");
            withdrawLabel.setFont(new Font("Times New Roman",Font.BOLD,27));
            withdrawLabel.setForeground(Color.red);
            withdrawLabel.setBounds(205,120,200,30);

            JLabel acNoLabelW=new JLabel("Enter A/C No : ");
            acNoLabelW.setBounds(145,180,90,20);

            JLabel amountLabelW=new JLabel("Enter Amount : ");
            amountLabelW.setBounds(145,220,90,20);

            JLabel msgLabelW=new JLabel("Message : ");
            msgLabelW.setBounds(145,260,90,20);

            JTextField acFieldW=new JTextField(7);
            acFieldW.setBounds(250,180,200,20);

            JTextField amountFieldW=new JTextField(12);
            amountFieldW.setBounds(250,220,200,20);

            JTextField msgFieldW=new JTextField();
            msgFieldW.setBounds(250,260,200,20);

            JButton proceedWithdraw=new JButton("Withdraw");
            proceedWithdraw.setBackground(Color.red);
            proceedWithdraw.setBounds(220,310,160,30);
            proceedWithdraw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ConnectionClass().withdrawMethod(Double.parseDouble(amountFieldW.getText()),
                            Integer.parseInt(acFieldW.getText()), dateLabel.getText(), msgFieldW.getText());
                }
            });

            panelOfWithdraw.add(withdrawLabel);
            panelOfWithdraw.add(acNoLabelW);
            panelOfWithdraw.add(amountLabelW);
            panelOfWithdraw.add(msgLabelW);
            panelOfWithdraw.add(acFieldW);
            panelOfWithdraw.add(amountFieldW);
            panelOfWithdraw.add(msgFieldW);
            panelOfWithdraw.add(proceedWithdraw);
        panelOfWithdraw.setLayout(null);
        panelOfWithdraw.setBounds(200,0,600,550);

        // Transfer Panel
        panelOfTransfer=new JPanel();
            JLabel transferLabel=new JLabel("Transfer Funds");
            transferLabel.setFont(new Font("Times New Roman",Font.BOLD,27));
            transferLabel.setForeground(Color.red);
            transferLabel.setBounds(210,120,200,30);

            JLabel fromAcNoLabel=new JLabel("FROM A/C No : ");
            fromAcNoLabel.setBounds(145,180,90,20);

            JLabel toAcNoLabel=new JLabel("To A/C No : ");
            toAcNoLabel.setBounds(145,220,90,20);

            JLabel amountLabelT=new JLabel("Enter Amount : ");
            amountLabelT.setBounds(145,260,90,20);

            JLabel msgLabelT=new JLabel("Message : ");
            msgLabelT.setBounds(145,300,90,20);

            JTextField fromAcField=new JTextField(7);
            fromAcField.setBounds(250,180,200,20);

            JTextField toAcField=new JTextField(7);
            toAcField.setBounds(250,220,200,20);

            JTextField amountFieldT=new JTextField(12);
            amountFieldT.setBounds(250,260,200,20);

            JTextField msgFieldT=new JTextField();
            msgFieldT.setBounds(250,300,200,20);

            JButton proceedTransfer=new JButton("Transfer");
            proceedTransfer.setBackground(Color.red);
            proceedTransfer.setBounds(220,350,160,30);
            proceedTransfer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ConnectionClass().transferMethod(Double.parseDouble(amountFieldT.getText()),
                            Integer.parseInt(fromAcField.getText()),
                            Integer.parseInt(toAcField.getText()),dateLabel.getText(), msgFieldT.getText());
                }
            });

            panelOfTransfer.add(transferLabel);
            panelOfTransfer.add(fromAcNoLabel);
            panelOfTransfer.add(toAcNoLabel);
            panelOfTransfer.add(amountLabelT);
            panelOfTransfer.add(msgLabelT);
            panelOfTransfer.add(fromAcField);
            panelOfTransfer.add(toAcField);
            panelOfTransfer.add(amountFieldT);
            panelOfTransfer.add(msgFieldT);
            panelOfTransfer.add(proceedTransfer);

        panelOfTransfer.setLayout(null);
        panelOfTransfer.setBounds(200,0,600,550);

        // Temporary Panel
        tempPanel=new JPanel();
        String instr="<html><h2>Instructions</h2><br>" +
                "* Enter details carefully.<br>" +
                "* Please check entered details before making any transaction.<br>" +
                "* Message should not exceed 40 characters.<html>";
        JLabel textOfInstr=new JLabel(instr);
        textOfInstr.setBounds(140,200,500,140);
        tempPanel.add(textOfInstr);
        tempPanel.setLayout(null);
        tempPanel.setBounds(200,0,600,550);

        add(bankLabel);
        add(dateLabel);
        add(tempPanel);
        add(backButton);
        add(logoutButton);
        add(withdrawButton);
        add(depositButton);
        add(transferButton);
        add(instructionButton);

        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300,100,800,550);
    }
}
