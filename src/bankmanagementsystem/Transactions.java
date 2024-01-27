package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastcash,ministatment,pinchange,balanceenqu,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon( ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatment=new JButton("E-Statement");
        ministatment.setBounds(355,450,150,30);
        ministatment.addActionListener(this);
        image.add(ministatment);

        pinchange=new JButton("PIN change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenqu=new JButton("Balance Enquiry");
        balanceenqu.setBounds(355,485,150,30);
        balanceenqu.addActionListener(this);
        image.add(balanceenqu);

        exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==deposit ){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (e.getSource()==withdraw) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (e.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (e.getSource()==ministatment) {
            new MiniStatement(pinnumber).setVisible(true);
        } else if (e.getSource()==pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (e.getSource()==balanceenqu) {
            setVisible(false);
            new BalanceEnqu(pinnumber).setVisible(true);
        } else if (e.getSource()==exit) {
            System.exit(0);
        }

    }
}
