package FirstProject;

import javax.swing.*;

public class NotePad extends JFrame {
    public JTextArea ta;
    public JMenuBar mb;
    public JMenu fileMenu;
    public JMenuItem openItem;
    String clipText=new String("");

    public NotePad(String title){
        super(title);
        ta=new JTextArea();
        mb=new JMenuBar();
        fileMenu=new JMenu("File");
        openItem= new JMenuItem("open");
        setJMenuBar(mb);
        mb.add(fileMenu);
        fileMenu.add(String.valueOf(openItem));
        add(ta);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        new NotePad("notepad").setVisible(true);
    }
}