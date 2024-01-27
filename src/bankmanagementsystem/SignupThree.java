package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formNo;

    SignupThree(String formno){

        this.formNo=formno;

        setLayout(null);
        JLabel l1=new JLabel("Page 3 :Account Details");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Railway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,250,20);
        add(r1);

        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,250,250,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,250,250,20);
        add(r4);

        ButtonGroup accountType=new ButtonGroup();
        accountType.add(r1);
        accountType.add(r2);
        accountType.add(r3);
        accountType.add(r4);

        JLabel card=new JLabel("Card No :");
        card.setFont(new Font("Railway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number=new JLabel("xxxx-xxxx-xxxx-4215");
        number.setFont(new Font("Railway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel carddetail=new JLabel("This is your card No.");
        carddetail.setFont(new Font("Railway",Font.BOLD,12));
        carddetail.setBounds(330,330,300,30);
        add(carddetail);

        JLabel pin=new JLabel("Pin : ");
        pin.setFont(new Font("Railway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pinno=new JLabel("xxxx");
        pinno.setFont(new Font("Railway",Font.BOLD,22));
        pinno.setBounds(330,370,300,30);
        add(pinno);

        JLabel pindetail=new JLabel("This is your pin");
        pindetail.setFont(new Font("Railway",Font.BOLD,12));
        pindetail.setBounds(330,400,300,30);
        add(pindetail);


        JLabel services=new JLabel("Services Required :");
        services.setFont(new Font("Railway",Font.BOLD,22));
        services.setBounds(100,450,300,30);
        add(services);

        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Railway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Railway",Font.BOLD,16));
        c2.setBounds(330,500,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Railway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4=new JCheckBox("Email and SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Railway",Font.BOLD,16));
        c4.setBounds(330,550,200,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Railway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Railway",Font.BOLD,16));
        c6.setBounds(330,600,200,30);
        add(c6);

        c7=new JCheckBox("Hereby declare that the above details are correct to the best of knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Railway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);


        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Railway",Font.BOLD,14));
        submit.addActionListener(this);
        submit.setBounds(220,720,100,30);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Railway",Font.BOLD,14));
        cancel.addActionListener(this);
        cancel.setBounds(420,720,100,30);
        add(cancel);

        getContentPane().setBackground(Color.white);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==submit){
            String acctype=null;
            if (r1.isSelected()){
                acctype="Saving Account";
            } else if (r2.isSelected()) {
                acctype="Current Account";
            }else if (r3.isSelected()) {
                acctype="Fixed Deposit Account";
            }else if (r4.isSelected()) {
                acctype="Recurring Deposit Account";
            }

            Random random=new Random();
            String cardno=""+ Math.abs(random.nextLong()%90000000L+5040936000000000L);
            String pinno=""+ Math.abs(random.nextLong()%9000L+1000L);

            String facility ="";
            if(c1.isSelected()){
                facility=facility+" Atm Card";
            }else if (c2.isSelected()) {
                facility=facility+" Internet Banking";
            }else if (c3.isSelected()) {
                facility=facility+" Mobile Banking";
            }else if (c4.isSelected()) {
                facility=facility+" Email and SMS Alerts";
            }else if (c5.isSelected()) {
                facility=facility+" Cheque Book";
            }else if (c6.isSelected()) {
                facility=facility+" E-Statement";
            }

            try{
                if(acctype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                } else {
                    Conn conn = new Conn();
                    String query="insert into signupthree values('"+formNo+"','"+acctype+"','"+cardno+"','"+pinno+"','"+facility+"')";
                    String query1="insert into login values('"+formNo+"','"+cardno+"','"+pinno+"')";
                    conn.statement.executeUpdate(query);
                    conn.statement.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Card No."+cardno+"\n Pin : "+pinno);
                    setVisible(false);
                    new Deposit(pinno).setVisible(true);
                }
            }catch(Exception e1){
                System.out.println(e1);
            }

        } else if (e.getSource()==cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
