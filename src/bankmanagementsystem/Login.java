package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){

        setTitle("ATM");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardno=new JLabel("Card No :");
        cardno.setBounds(120,150,250,30);
        cardno.setFont(new Font("Railway",Font.BOLD,28));
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("Pin :");
        pin.setBounds(120,200,250,30);
        pin.setFont(new Font("Railway",Font.BOLD,28));
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,200,230,30);
        add(pinTextField);

        login=new JButton("LOGIN");
        login.setBounds(300,280,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(430,280,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,330,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);   
        setLocation(350,200);

    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (e.getSource()==login) {
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query= "select * from login where cardnumber='"+cardnumber+"'and pin ='"+pinnumber+"'";
            try{
                ResultSet resultSet=conn.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Details!!!  Try Again");
                }
            }catch (Exception e1){
                System.out.println(e1);
            }


        }else if (e.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
}