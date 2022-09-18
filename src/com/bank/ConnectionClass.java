package com.bank;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConnectionClass {
    Connection con1,con2,con3,con4,con5,con6,con7, con8, con9, con10;
    JFrame frame1,frame2;
    JTable table1, table2;
    public void addCustomerInDb(String a, String b,String c, String d, String e, String f, double g, String h) {
        String acN;
        try{
            con1=DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers","root","");
            Statement stmt1= con1.createStatement();
            int result1=stmt1.executeUpdate("INSERT INTO customer_details " +
                    "(First_name, Last_name, DOB, Father_name, Mobile_no, Address, Balance, Ac_open_date)"
                    +" VALUES ("+
                    "'"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"',"+g+",'"+h+"');");

            Statement stmt2=con1.createStatement();
            ResultSet result2=stmt2.executeQuery("SELECT Account_no FROM customer_details WHERE Mobile_no='"+e+"' AND DOB='"+c+"';");
            result2.absolute(1);
            acN=result2.getString("Account_no");
            JOptionPane.showMessageDialog(new JFrame(),"Account created successfully.\nAccount No. is "+acN);

            Statement stmt3=con1.createStatement();
            int result3=stmt3.executeUpdate("CREATE TABLE `"+acN+"` (Date date, Message varchar(60),Credit double, Debit double, Balance double);");

            Statement stmt4=con1.createStatement();
            int result4=stmt4.executeUpdate("INSERT INTO `"+acN+"` VALUES ('"+h+"','Amount deposited on a/c opening',"+g+","+0.00+","+g+");");
        } catch(Exception exp1) {
            System.out.println(exp1);
        }
    }
    public void getCustomerDb() {
        frame1 = new JFrame("SNAPBANK");

        Image icon=Toolkit.getDefaultToolkit().getImage("Images\\icon1.jpg");
        frame1.setIconImage(icon);

        JLabel bankLabel=new JLabel("<htmL><font color='gray'>Snap</font><font color='1E90FF'>Bank</font></html>");
        bankLabel.setFont(new Font("Times New Roman",Font.BOLD,68));
        bankLabel.setBounds(370,25,300,80);

        JLabel dataLabel=new JLabel("Data of Customers");
        dataLabel.setBounds(450,115,120,20);

        DefaultTableModel model1=new DefaultTableModel();
        String[] columns={"A/C Number","First Name","Last Name","DOB","Father's Name","Mobile No.","Address","Balance","Open(A/C) date"};
        model1.setColumnIdentifiers(columns);
        table1=new JTable();
        table1.setModel(model1);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table1);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(0,150,1020,320);
        int ac;
        String fname,lname,dob,father,mobile,address,openDate;
        double balance;
        try{
            con2=DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers","root","");
            Statement stmt=con2.createStatement();
            ResultSet set=stmt.executeQuery("Select * from customer_details");


            while(set.next()) {
                ac=set.getInt(1);
                fname=set.getString(2);
                lname=set.getString(3);
                dob=set.getString(4);
                father=set.getString(5);
                mobile=set.getString(6);
                address=set.getString(7);
                balance=set.getDouble(8);
                openDate=set.getString(9);
                model1.addRow(new Object[] {ac,fname,lname,dob,father,mobile,address,balance,openDate});
            }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"Something went wrong",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }

        frame1.add(bankLabel);
        frame1.add(dataLabel);
        frame1.add(scroll);

        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setBounds(200,100,1040, 500);
    }

    public void findCustomerInDb(int acNo) {
        String fname, lname, dob, father, mobile, address, openDate;
        double balance;
        try {
            con3 = DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers", "root", "");
            Statement stmt1=con3.createStatement();
            ResultSet set= stmt1.executeQuery("SELECT * FROM customer_details WHERE Account_no="+acNo+";");
            if(set.next()) {
                fname=set.getString(2);
                lname=set.getString(3);
                dob=set.getString(4);
                father=set.getString(5);
                mobile=set.getString(6);
                address=set.getString(7);
                balance=set.getDouble(8);
                openDate=set.getString(9);
                new CustomerDetails(acNo,fname,lname,dob,father,mobile,address,balance,openDate);
            } else {
                JOptionPane.showMessageDialog(new JFrame(),"No record found and Enter valid A/C number",
                        "Error",JOptionPane.ERROR_MESSAGE);
                new WelcomeUI().show();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(),"No record found and Enter valid A/C number",
                    "Error",JOptionPane.ERROR_MESSAGE);
            new WelcomeUI().show();
        }
    }

    public void updateCustomerMethod(int acNo, String fname, String lname, String dob, String father, String mobile, String address) {
        try {
            con4=DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers", "root", "");
            Statement stmt1=con4.createStatement();
            int result1=stmt1.executeUpdate("UPDATE customer_details SET First_name='"+fname+"', Last_name='"+lname+"', DOB='"+
                    dob+"', Father_name='"+father+"', Mobile_no='"+mobile+"', Address='"+address+"' WHERE Account_no="+acNo+";");
            JOptionPane.showMessageDialog(new JFrame(),"Account updated successfully");
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(new JFrame(),"Please enter valid details");
        }
    }

    public void depositMethod(double amount, int acNo, String date, String msg) {
        try {
            String acString=String.valueOf(acNo);
            con5=DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers","root","");
            Statement stmt1=con5.createStatement();
            int result1=stmt1.executeUpdate("UPDATE customer_details SET Balance=Balance+"+amount+" WHERE " +
                    "Account_no="+acNo+";");

            Statement stmt2=con5.createStatement();
            ResultSet result2=stmt2.executeQuery("SELECT Balance FROM customer_details WHERE Account_no="+acNo+";");
            result2.absolute(1);
            double bal=result2.getDouble("Balance");

            Statement stmt3=con5.createStatement();
            int result3=stmt3.executeUpdate("INSERT INTO `"+acString+"` VALUES ( '"+date+"', '"+msg+"', "+amount+", "+0+", "+bal+" );");
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"Rs. "+amount+
                    " has been credited successfully in" + "A/C No. "+acNo);
        } catch(Exception exp) {
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"Details do not match, Try again",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void withdrawMethod(double amount, int acNo, String date, String msg) {
        try {
            con6=DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers","root","");
            Statement stmt1=con6.createStatement();
            ResultSet resul1=stmt1.executeQuery("SELECT Balance FROM customer_details WHERE Account_no="+acNo+";");
            resul1.absolute(1);
            double bal=resul1.getDouble("Balance");

            if(bal < amount) {
                JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"A/C no "+acNo+" does not has "+amount+" funds to withdraw"
                    ,"Not enough funds",JOptionPane.ERROR_MESSAGE);
            } else {
                Statement stmt2=con6.createStatement();
                int result2=stmt2.executeUpdate("UPDATE customer_details SET Balance=Balance-"+amount+" WHERE " +
                        "Account_no="+acNo+";");

                bal=bal-amount;
                String acString=String.valueOf(acNo);
                Statement stmt3=con6.createStatement();
                int result3=stmt3.executeUpdate("INSERT INTO `"+acString+"` VALUES ( '"+date+"', '"+msg+"', "+0+", "+amount+", "+bal+" );");
                JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"Rs. "+amount+
                        " has been debited successfully from A/C no "+ acNo);
            }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"Invalid details, Try again",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void transferMethod(double amount, int fromAcNo, int toAcNo, String date, String msg) {
        String msg1="Transferred to A/C "+toAcNo+" : "+msg;
        String msg2="Received from A/C "+fromAcNo+" : "+msg;
        try{
            con7=DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers","root","");
            Statement stmt1=con7.createStatement();
            ResultSet result1=stmt1.executeQuery("SELECT Balance FROM customer_details WHERE Account_no="+fromAcNo+";");
            result1.absolute(1);
            double bal=result1.getDouble("Balance");
             if(bal < amount) {
                 JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"A/C no "+fromAcNo+" does not has "+amount+" funds to withdraw"
                         ,"Not enough funds",JOptionPane.ERROR_MESSAGE);
             } else {
                 withdrawMethod(amount,fromAcNo,date,msg1);
                 depositMethod(amount,toAcNo,date,msg2);
                 JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"Rs. "+amount+" has been transferred" +
                         " successfully from A/C "+fromAcNo+" to A/C "+toAcNo);
             }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"Details do not match, Try again",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void customerTransactionsDetails(int acNo) {
        String acString=String.valueOf(acNo);

        frame2 = new JFrame("SNAPBANK");

        Image icon=Toolkit.getDefaultToolkit().getImage("Images\\icon1.jpg");
        frame2.setIconImage(icon);

        JLabel bankLabel=new JLabel("<htmL><font color='gray'>Snap</font><font color='1E90FF'>Bank</font></html>");
        bankLabel.setFont(new Font("Times New Roman",Font.BOLD,68));
        bankLabel.setBounds(150,25,300,80);

        JLabel dataLabel=new JLabel("Transaction Details of A/C "+acNo);
        dataLabel.setBounds(200,115,200,20);

        DefaultTableModel model1=new DefaultTableModel();
        String[] columns={"Date","Narration","Credit","Debit","Balance"};
        model1.setColumnIdentifiers(columns);
        table2=new JTable();
        table2.setModel(model1);
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table2.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table2);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(0,150,600,320);
        String date, msg;
        double credit, debit, balanceJ;
        try{
            con8=DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers","root","");
            Statement stmt=con8.createStatement();
            ResultSet resultSet=stmt.executeQuery("Select * from `"+acString+"`;");

            while(resultSet.next()) {
                date=resultSet.getString(1);
                msg=resultSet.getString(2);
                credit=resultSet.getDouble(3);
                debit=resultSet.getDouble(4);
                balanceJ=resultSet.getDouble(5);
                model1.addRow(new Object[] {date,msg,credit,debit,balanceJ});
            }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"Invalid A/C no",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }

        frame2.add(bankLabel);
        frame2.add(dataLabel);
        frame2.add(scroll);

        frame2.setLayout(null);
        frame2.setVisible(true);
        frame2.setBounds(300,120,600, 500);
    }

    public void bankDetailsMethod() {
        try {
            con9=DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers","root","");
            Statement stmt1=con9.createStatement();
            ResultSet result1=stmt1.executeQuery("SELECT COUNT(Account_no) FROM customer_details;");
            result1.absolute(1);
            int count=result1.getInt(1);

            Statement stmt2=con9.createStatement();
            ResultSet result2=stmt2.executeQuery("SELECT SUM(Balance) FROM customer_details;");
            result2.absolute(1);
            int sum=result2.getInt(1);
            String detail="<html><h2>Bank Details</h2>The bank has total <b>"+count+"</b> customers.<br>The total balance of bank is <b>Rs. "+sum+"</b>.</html>";
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),detail);
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"Something went wrong, Try again",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removeCustomerMethod(int acNo) {
        try {
            con10=DriverManager.getConnection("jdbc:mysql://localhost/snapbank_customers","root","");
            Statement stmt1=con10.createStatement();
            int result1=stmt1.executeUpdate("DELETE FROM customer_details WHERE Account_no="+acNo+";");

            Statement stmt2=con10.createStatement();
            int result2=stmt2.executeUpdate("DROP TABLE `"+acNo+"`;");
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"A/C no."+acNo+"\n"+
                    "Account deleted successfully");
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(new JFrame("SNAPBANK"),"A/C does not exits, Please enter valid A/C no",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
