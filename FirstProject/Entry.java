package FirstProject;

import javax.swing.*;

public class Entry extends JFrame {
    private JPanel newPanel;
    private JButton okButton;
    private JButton nopeButton;
    private JTextField d;
    private JTextField num;
    private JLabel labelName;
    private JTextField yyname;

    public Entry(){
        setContentPane(newPanel);
        setTitle("SIG");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
//    public JPanel getPanel() {return newPanel;}


    public void createUIComponents() {
        // TODO: place custom component creation code here

    }

    public static void main(String[] args) {
        Entry g=new Entry();

    }
}
