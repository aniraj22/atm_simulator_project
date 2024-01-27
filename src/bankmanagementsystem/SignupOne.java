package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame implements ActionListener {

    long random;
    JButton next;
    JTextField nametextfield,fathertextfield,emailtextfield,addresstextfield,citytextfield,statetextfield,pintextfield;
    JDateChooser datechooser;
    JRadioButton male,female,other,married,unmarried,others;
    SignupOne(){

        setLayout(null);
        Random ran =new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno=new JLabel("Application For No."+random);
        formno.setFont(new Font("Railway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetail=new JLabel("Page 1 : Personal Details");
        personalDetail.setFont(new Font("Railway",Font.BOLD,22));
        personalDetail.setBounds(290,80,400,30);
        add(personalDetail);

        JLabel name=new JLabel("Name : ");
        name.setFont(new Font("Railway",Font.BOLD,18));
        name.setBounds(100,140,100,30);
        add(name);

        nametextfield=new JTextField();
        nametextfield.setFont(new Font("Railway",Font.BOLD,22));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);

        JLabel fname=new JLabel("Father's Name : ");
        fname.setFont(new Font("Railway",Font.BOLD,18));
        fname.setBounds(100,190,200,30);
        add(fname);

        fathertextfield=new JTextField();
        fathertextfield.setFont(new Font("Railway",Font.BOLD,22));
        fathertextfield.setBounds(300,190,400,30);
        add(fathertextfield);

        JLabel dob=new JLabel("Date of Birth : ");
        dob.setFont(new Font("Railway",Font.BOLD,18));
        dob.setBounds(100,240,200,30);
        add(dob);

        datechooser=new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        add(datechooser);

        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Railway",Font.BOLD,18));
        gender.setBounds(100,290,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.white);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.white);
        add(female);

        other=new JRadioButton("Others");
        other.setBounds(600,290,100,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);

        JLabel email=new JLabel("Email : ");
        email.setFont(new Font("Railway",Font.BOLD,18));
        email.setBounds(100,340,200,30);
        add(email);

        emailtextfield=new JTextField();
        emailtextfield.setFont(new Font("Railway",Font.BOLD,22));
        emailtextfield.setBounds(300,340,400,30);
        add(emailtextfield);

        JLabel material=new JLabel("Material status : ");
        material.setFont(new Font("Railway",Font.BOLD,18));
        material.setBounds(100,390,200,30);
        add(material);

        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);

        unmarried=new JRadioButton("Un-Married");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        others=new JRadioButton("Others");
        others.setBounds(600,390,100,30);
        others.setBackground(Color.white);
        add(others);

        ButtonGroup materialgroup=new ButtonGroup();
        materialgroup.add(married);
        materialgroup.add(unmarried);
        materialgroup.add(others);

        JLabel address=new JLabel("Address : ");
        address.setFont(new Font("Railway",Font.BOLD,18));
        address.setBounds(100,440,200,30);
        add(address);

        addresstextfield=new JTextField();
        addresstextfield.setFont(new Font("Railway",Font.BOLD,22));
        addresstextfield.setBounds(300,440,400,30);
        add(addresstextfield);

        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Railway",Font.BOLD,18));
        city.setBounds(100,490,200,30);
        add(city);

        citytextfield=new JTextField();
        citytextfield.setFont(new Font("Railway",Font.BOLD,22));
        citytextfield.setBounds(300,490,400,30);
        add(citytextfield);

        JLabel state=new JLabel("State : ");
        state.setFont(new Font("Railway",Font.BOLD,18));
        state.setBounds(100,540,200,30);
        add(state);

        statetextfield=new JTextField();
        statetextfield.setFont(new Font("Railway",Font.BOLD,22));
        statetextfield.setBounds(300,540,400,30);
        add(statetextfield);

        JLabel pincode=new JLabel("Pin Code : ");
        pincode.setFont(new Font("Railway",Font.BOLD,18));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pintextfield=new JTextField();
        pintextfield.setFont(new Font("Railway",Font.BOLD,22));
        pintextfield.setBounds(300,590,400,30);
        add(pintextfield);

        next=new JButton("NEXT");
        next.setBounds(600,660,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }


    public static void main(String[] args) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=""+ random;
        String name=nametextfield.getText();
        String fname=fathertextfield.getText();
        String dob=datechooser.getDateEditor().getDateFormatString();
        String gender=null;
        String material=null;
        String email=emailtextfield.getText();
        String address=addresstextfield.getText();
        String city=citytextfield.getText();
        String state=statetextfield.getText();
        String pin=pintextfield.getText();

        if (male.isSelected()){
            gender="Male";
        } else if (female.isSelected()) {
            gender="Female";
        }else {
            gender="Other";
        }

        if (married.isSelected()){
            material="Married";
        } else if (unmarried.isSelected()) {
            material="Unmarried";
        }else {
            material="Other";
        }

        try{
            if (name.equals("")){

                JOptionPane.showMessageDialog(null,"Please fill Name");
            }else{
                Conn conn = new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+material+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                conn.statement.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch(Exception e1){
            System.out.println(e1);
        }
    }
}
