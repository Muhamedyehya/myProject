package FirstProject;

//import frame1.MyFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SalesGen extends JFrame implements ActionListener  {
    public static Object AddRowToJTable;
    private JButton createNewInvoiceButton;
    private JButton deleteInvoiceButton;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField invoiceNumber;
    private JTextField date;
    private JTextField customerName;
    private JTextField invoiceTotal;
//    public DefaultTableModel model=new DefaultTableModel(1,5);
//    private JTable table2=new JTable(model);;
    public   JTable table2;
    public   JTable table1;
    public JPanel myPanel;
    private JLabel labelNumber;
    private JLabel labelDate;
    private JLabel labelName;
    private JLabel labelTotal;
    private JLabel items;

    //MenuBar Items
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem loadMenuItem;
    //opening new panel
//    JMenuBar mb;
//    JMenuItem openItem;
//    private JTextArea ta;
//    String clipText =new String("");
    private JMenuItem saveMenuItem;

    //invoiceItems
//    public int number=0;
//    public String itemName;
//    public double price;
//    public int count;
//    public double itemTotal=0;

    //testing table2
//    public String[] InvoiceLines={"No.","Item Name","Item Price","Count","Item Total"};
//    public DefaultTableModel model=new DefaultTableModel(InvoiceLines,4);
//    public JTable table2=new JTable(model);




    public SalesGen(){
        setContentPane(myPanel);
        createTable();

        setTitle("SIG");
        setSize(1000,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Testing buttons
  //      Buttons but1=new Buttons();
 //       but1.addActionListener(this);
//        but1.setActionCommand("N");


        //Buttons
        //New Invoice
//        createNewInvoiceButton=new JButton("Create New Invoice");
//        add(createNewInvoiceButton);
//        createNewInvoiceButton.addActionListener(this);
//        createNewInvoiceButton.setActionCommand("N");

        //creating menu items
        menuBar=new JMenuBar();
        loadMenuItem =new JMenuItem("Load");
        loadMenuItem.addActionListener(this);
        loadMenuItem.setActionCommand("O");   //to use in actionListener
        saveMenuItem=new JMenuItem("Save");
       saveMenuItem.addActionListener(this);
        saveMenuItem.setActionCommand("S");
        //adding items to file
        fileMenu=new JMenu("File");
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        //new panel for open
//        mb=new JMenuBar();
//        fileMenu=new JMenu("File");
//        openItem=new JMenuItem("open");
//        setJMenuBar(mb);
//        mb.add(fileMenu);
//        fileMenu.add(openItem);
//
//        ta=new JTextArea();
//        add(new JScrollPane(ta));

        //adding menu to frame
        setJMenuBar(menuBar);




        createNewInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntryClass entry=new EntryClass();



            }
        });
        deleteInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table2.getModel();
                model.removeRow(1);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //calling object of items
                InvoiceItems items=new InvoiceItems("Mu","mobile", 7000, 2);

//                DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
//                model1.addRow(new Object[]{null,null,null});
//                addingRow(new Object[]{null,null,null,null});
                //Adding new row with no values
                DefaultTableModel model = (DefaultTableModel) table2.getModel();
                model.addRow(new Object[]{null,null,null,null});

            }
        });
    }//end of constructor

    public static void main(String[] args) {

        SalesGen pro=new SalesGen();

        pro.setVisible(true);

    }

    public void createTable(){
        InvoiceItems items=new InvoiceItems("M","mobile", 7000, 2);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        Object[][] data ={};
        table1.setModel(new DefaultTableModel(
                data,
                new String[]{"No.","Date","Customer","Total"}));

        //table2 testing another method


        //table2
        Object[][] data2 ={
                {items.number,"mobile",items.price,items.count,items.itemTotal},
                {items.number,"mouse",items.price,items.count,items.itemTotal}
        };
        table2.setModel(new DefaultTableModel(
                data2,
                new String[]{"No.","Item Name","Item Price","Count","Item Total"}));
    }//end of createTable





    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "O":
                openFile();
                break;
            case "S":
                saveContent();
                break;
            case "N":

 //               InvoiceItems invo=new InvoiceItems(String customerName,String itemName,double price,int count);




        }

    }
    NotePad notepad =new NotePad("Opening");
    private void openFile(){
        JFileChooser fc =new JFileChooser();
        int result =fc.showOpenDialog(this);
        if(result==JFileChooser.APPROVE_OPTION){
            String path= fc.getSelectedFile().getPath();
            FileInputStream fis =null;
            try {
                fis = new FileInputStream(path);
                int size = fis.available();
                byte[] b = new byte[size];
                fis.read(b);
                notepad.ta.setText(new String(b));
            }catch(FileNotFoundException e) {
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                try{
                    fis.close();}catch(IOException e){}
            }
        }

    }
    void saveContent(){
        JFileChooser fc =new JFileChooser();
        int result=fc.showSaveDialog(this);
        if(result==JFileChooser.APPROVE_OPTION){
            String path= fc.getSelectedFile().getPath();
            FileOutputStream fos =null;
            try {
                fos = new FileOutputStream(path);

                byte[] b = notepad.ta.getText().getBytes();
                fos.write(b);
                notepad.ta.setText(new String(b));
            }catch(FileNotFoundException e) {
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                try{
                    fos.close();}catch(IOException e){}
            }
        }

    }

}
