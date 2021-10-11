import javax.swing.*;
import  java.awt.event.*;
public class menu implements ActionListener {
    JFrame frame  = new JFrame();
    JLabel l1 = new JLabel("Options:");
    JButton b1 = new JButton("Add");
    JButton b2 = new JButton("Search");
    JButton b3 = new JButton("Delete");
    JButton b4 = new JButton("Exit");
   
    menu(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(l1);frame.add(b1);frame.add(b2);frame.add(b3);frame.add(b4);
        l1.setBounds(20,20,150,40);
        b1.setBounds(20,90,150,40);
        b2.setBounds(20,160,150,40);
        b3.setBounds(20,230,150,40);
        b4.setBounds(20,300,150,40);
        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            frame.dispose();
            Add a = new Add();
        }
        if(e.getSource()==b2){
            frame.dispose();
            Search s = new Search();
        }
        if(e.getSource()==b3){
            frame.dispose();
            delete d = new delete();
        }
        if(e.getSource()==b4){
            System.exit(0);
        }
        
    }
    
}
