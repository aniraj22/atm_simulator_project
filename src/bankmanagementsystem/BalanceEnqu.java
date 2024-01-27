package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnqu extends JFrame implements ActionListener {

    String pinnumber;
    JButton back;

    BalanceEnqu(String pinnumber) {

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
        int balance=0;
        try {
            ResultSet rs=conn.statement.executeQuery( "select * from bank where pin='" + pinnumber + "'");
            while (rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e1) {
            System.out.println(e1);
        }

        JLabel text=new JLabel("Your Current Balance is "+balance);
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BalanceEnqu("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}