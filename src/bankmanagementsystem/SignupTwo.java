package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.lang.*;


public class SignupTwo extends JFrame implements ActionListener {

    JButton next;
    JComboBox religion,catagory,income,education,occupation;
    JTextField panTextField,aadharTextField;
    JRadioButton sYes,sNo,exYes,exNo;
    String formNo;
    SignupTwo(String formno){

        setLayout(null);
        this.formNo=formno;

        setTitle("New Account Application Form - Page 2");

        JLabel additionaldetails=new JLabel("Page 2 : Additional Details");
        additionaldetails.setFont(new Font("Railway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);

        JLabel religionname=new JLabel("Religion : ");
        religionname.setFont(new Font("Railway",Font.BOLD,18));
        religionname.setBounds(100,140,100,30);
        add(religionname);

        String varRel[]={"Hindu","Muslim","Cristian","Sikh","Other"};
        religion=new JComboBox(varRel);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel categorys=new JLabel("Category : ");
        categorys.setFont(new Font("Railway",Font.BOLD,18));
        categorys.setBounds(100,190,200,30);
        add(categorys);

        String varcatagory[]={"Open","SC","ST","Other"};
        catagory=new JComboBox(varcatagory);
        catagory.setBackground(Color.white);
        catagory.setBounds(300,190,400,30);
        add(catagory);

        JLabel incomes=new JLabel("Income : ");
        incomes.setFont(new Font("Railway",Font.BOLD,18));
        incomes.setBounds(100,240,200,30);
        add(incomes);

        String varincome[]={"Null","<1.5Lpa","<2.5Lpa","<5Lpa","upto 10Lpa"};
        income=new JComboBox(varincome);
        income.setBackground(Color.white);
        income.setBounds(300,240,400,30);
        add(income);

        JLabel educational=new JLabel("Educational : ");
        educational.setFont(new Font("Railway",Font.BOLD,18));
        educational.setBounds(100,290,200,30);
        add(educational);

        String vareducation[]={"No Education","10th Pass","12th Pass","Bachlors","Masters","PHD"};
        education=new JComboBox(vareducation);
        education.setBackground(Color.white);
        education.setBounds(300,290,400,30);
        add(education);

        JLabel occu=new JLabel("Occupation : ");
        occu.setFont(new Font("Railway",Font.BOLD,18));
        occu.setBounds(100,340,200,30);
        add(occu);

        String varoccupation[]={"Job","Self-Employed","Bussiness","Student","Retired","Other"};
        occupation=new JComboBox(varoccupation);
        occupation.setBackground(Color.white);
        occupation.setBounds(300,340,400,30);
        add(occupation);

        JLabel panno=new JLabel("PAN NO : ");
        panno.setFont(new Font("Railway",Font.BOLD,18));
        panno.setBounds(100,390,200,30);
        add(panno);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Railway",Font.BOLD,22));
        panTextField.setBounds(300,390,400,30);
        add(panTextField);

        JLabel aadharno=new JLabel("AADHAR NO : ");
        aadharno.setFont(new Font("Railway",Font.BOLD,18));
        aadharno.setBounds(100,440,200,30);
        add(aadharno);

        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Railway",Font.BOLD,22));
        aadharTextField.setBounds(300,440,400,30);
        add(aadharTextField);

        JLabel seniorcitizen=new JLabel("Senior Citizen : ");
        seniorcitizen.setFont(new Font("Railway",Font.BOLD,18));
        seniorcitizen.setBounds(100,490,200,30);
        add(seniorcitizen);

        sYes=new JRadioButton("Yes");
        sYes.setBounds(300,490,100,30);
        sYes.setBackground(Color.white);
        add(sYes);

        sNo=new JRadioButton("No");
        sNo.setBounds(450,490,100,30);
        sNo.setBackground(Color.white);
        add(sNo);

        ButtonGroup seniorCiti=new ButtonGroup();
        seniorCiti.add(sYes);
        seniorCiti.add(sNo);

        JLabel existingacc=new JLabel("Existing Account : ");
        existingacc.setFont(new Font("Railway",Font.BOLD,18));
        existingacc.setBounds(100,540,200,30);
        add(existingacc);

        exYes=new JRadioButton("Yes");
        exYes.setBounds(300,540,100,30);
        exYes.setBackground(Color.white);
        add(exYes);

        exNo=new JRadioButton("No");
        exNo.setBounds(450,540,100,30);
        exNo.setBackground(Color.white);
        add(exNo);

        ButtonGroup existingAccc=new ButtonGroup();
        existingAccc.add(exYes);
        existingAccc.add(exNo);

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
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno=""+formNo;
        String rel=religion.getSelectedItem().toString();
        String cata=catagory.getSelectedItem().toString();
        String incom=income.getSelectedItem().toString();
        String edu=education.getSelectedItem().toString();
        String occ=occupation.getSelectedItem().toString();
        String pan=panTextField.getText();
        String addt=aadharTextField.getText();
        String seni=null;
        String exis=null;


        if (sYes.isSelected()){
            seni="Yes";
        } else if (sNo.isSelected()) {
            seni="No";
        }

        if (exYes.isSelected()){
            exis="Yes";
        } else if (exNo.isSelected()) {
            exis="No";
        }

        try{
                Conn conn = new Conn();
                String query="insert into signuptwo values('"+formNo+"','"+rel+"','"+cata+"','"+incom+"','"+edu+"','"+occ+"','"+pan+"','"+addt+"','"+seni+"','"+exis+"')";
                conn.statement.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception e1){
            System.out.println(e1);
        }
    }
}
