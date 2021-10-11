import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class delete implements ActionListener {
    JFrame frame = new JFrame();
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;
    delete(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        b1 = new JButton ("Delete");
        b2 = new JButton ("Cancel");
        b3 = new JButton("Back");
        l1 = new JLabel ("Website:");
        l2 = new JLabel ("Email:");
        l3 = new JLabel ("Username:");
        t1 = new JTextField(50);
        t2 = new JTextField(50);
        t3 = new JTextField(50);
        l1.setBounds(100,100,150,40);
        l2.setBounds(100,160,150,40);
        l3.setBounds(100,220,150,40);
        t1.setBounds(300,100,150,40);
        t2.setBounds(300,160,150,40);
        t3.setBounds(300,220,150,40);
        b1.setBounds(70,350,150,40);
        b2.setBounds(270,350,150,40);
        b3.setBounds(50,50,70,30);
        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        frame.add(l1);frame.add(l2);frame.add(l3);frame.add(t1);frame.add(t2);frame.add(t3);frame.add(b1);frame.add(b2);frame.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       try{
           if(e.getSource()==b1){
                String website = t1.getText();
                String email = t2.getText();
                String username = t3.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:<local host port number(default:3306)>/<local database name>", "root", "<your local root password>");
                if(c!=null)
                    System.out.println("Connection established");
                else
                    System.out.println("Connection failed");
                Statement s = c.createStatement();
                String i1 = "delete from data where website = '"+(website)+"' and email = '"+(email)+"' and username = '"+(username)+"'";
                int n1 = s.executeUpdate(i1);
                JOptionPane.showMessageDialog(null,"Data deleted successfully!");
            }
            if(e.getSource()==b2){
                System.exit(0);
            }
            if(e.getSource()==b3){
                frame.dispose();
                menu m = new menu();
            }
        }
       catch(Exception ex){}
    }
          
}
