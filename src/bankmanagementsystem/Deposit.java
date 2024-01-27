package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, cancel;
    String pinnumber;
    Deposit(String pinnumber) {

        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount for Deposit");
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Railway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        cancel = new JButton("Back");
        cancel.setBounds(355, 520, 150, 30);
        cancel.addActionListener(this);
        image.add(cancel);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter for the amount you want to deposit");
            }else {
                try {
                    Conn conn=new Conn();
                    String query="insert into bank values ('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+number+"Deposited Sucessfull");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
}
