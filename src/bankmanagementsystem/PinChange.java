package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JTextField pin,pin1;
    JButton change, cancel;
    String pinnumber;

    PinChange(String pinnn){
        this.pinnumber=pinnn;
        setLayout(null);

        ImageIcon i1=new ImageIcon( ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        JLabel pintext=new JLabel("New PIN");
        pintext.setBounds(165,320,180,25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);

        pin = new JTextField();
        pin.setFont(new Font("Railway", Font.BOLD, 22));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel pintext1=new JLabel("Re-Enter new PIN");
        pintext1.setBounds(165,360,180,25);
        pintext1.setForeground(Color.white);
        pintext1.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext1);

        pin1 = new JTextField();
        pin1.setFont(new Font("Railway", Font.BOLD, 22));
        pin1.setBounds(330, 360, 180, 25);
        image.add(pin1);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        cancel = new JButton("Cancel");
        cancel.setBounds(355, 520, 150, 30);
        cancel.addActionListener(this);
        image.add(cancel);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PinChange("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==change) {
            try {
                String npin = pin.getText();
                String rpin = pin1.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN deon mot match");
                    return;
                }

                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }

                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                Conn conn=new Conn();
                String query1="update bank set pin='"+rpin+"'where pin='"+pinnumber+"'";
                String query2="update login set pin='"+rpin+"'where pin='"+pinnumber+"'";
                String query3="update signupthree set pinno='"+rpin+"'where pinno='"+pinnumber+"'";
                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                conn.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed Sucessfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e1) {
                System.out.println(e1);
            }
        }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
}
