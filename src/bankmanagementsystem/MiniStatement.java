package bankmanagementsystem;

import javax.swing.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        this.pinnumber=pinnumber;
        setLayout(null);

        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        Conn conn=new Conn();
        try {
            ResultSet rs= conn.statement.executeQuery("select * from login where pin='" + pinnumber + "'");
            while (rs.next()){
            card.setText("Card Number : "+rs.getString("cardNumber"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            ResultSet rs= conn.statement.executeQuery("select * from bank where pin='" + pinnumber + "'");
            int bal=0;
            while (rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else {
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText(" BALANCE : "+bal);

        }catch (Exception e){
            System.out.println(e);
        }



        setSize(400,600);
        setLocation(300,0);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    }
