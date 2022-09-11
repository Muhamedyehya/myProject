package FirstProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import FirstProject.SalesGen;

public class EntryClass implements ActionListener {

    JFrame f=new JFrame();
    JLabel l;
    JLabel label1;
    JTextField userText1;
    JLabel label2;
    JTextField userText2;
    JLabel label3;
    JTextField userText3;
    JButton btn1;
    JButton btn2;
    SalesGen salesgen=new SalesGen();

    EntryClass(){
        l=new JLabel("Invoice Data");
        l.setBounds(0,0,200,2000);
        l.setFont(new Font(null, Font.PLAIN,20));
        f.add(l);
        f.setLayout(new FlowLayout());

        //username
        label1=new JLabel("Customer Name");
        label1.setBounds(500,500,100,0);
        f.add(label1);
        userText1=new JTextField(20);
        userText1.setBounds(800,800,965,0);
        f.add(userText1);

        //username
        label2=new JLabel("Date");
//        label2.setBounds(500,500,100,0);
        f.add(label2);
        userText2=new JTextField(20);
//        userText2.setBounds(800,800,965,0);
        f.add(userText2);

        //username
        label3=new JLabel("Invoice Number");
        label3.setBounds(500,500,100,0);
        f.add(label3);
        userText3=new JTextField(20);
        userText3.setBounds(800,800,965,0);
        f.add(userText3);

        //buttons
        btn1=new JButton("ok");
        btn2=new JButton("Cancel");
        f.add(btn1);
        btn1.addActionListener(this);
        f.add(btn2);

        f.setSize(400,400);
        f.setVisible(true);
    }//end of constructor

    public void addingRow(Object[] dataRow){
        DefaultTableModel model1 = (DefaultTableModel) salesgen.table1.getModel();
        model1.addRow(dataRow);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
        //taking name
        String customerName = userText1.getText();
        //Taking date
        String date=userText2.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date1=null;
        date1= dateFormat.parse(date);
        //taking invoice number
        int invoiceNumber= Integer.parseInt(userText3.getText());

        //filling table if info is right
        if(customerName !="" &&  date1 !=null && invoiceNumber>0){
           addingRow(new Object[]{"invoiceNumber", "date", "customerName","0"});

        }
        //error message if info is null or incorrect
        else{JOptionPane.showMessageDialog(null,"Please write all data CORRECTLY","Dialog",JOptionPane.ERROR_MESSAGE);}
        }catch(Exception d){JOptionPane.showMessageDialog(null,d.toString(),"Dialog",JOptionPane.ERROR_MESSAGE);}
    }


}
