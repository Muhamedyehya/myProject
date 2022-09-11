package FirstProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JFrame implements ActionListener{
    private JButton createNewInvoiceButton;


    public Buttons(){
        setLayout(new FlowLayout());
        createNewInvoiceButton=new JButton("create New Invoice");
        add(createNewInvoiceButton);

        createNewInvoiceButton.addActionListener(this);


    }




    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
