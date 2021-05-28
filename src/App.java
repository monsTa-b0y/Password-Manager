import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class App extends JFrame implements ActionListener  {
    JFrame frame = new JFrame();
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    App(){
        frame.setSize(700,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        b1 = new JButton ("Insert");
        b2 = new JButton ("Clear");
        l4 = new JLabel ("Username");
        l1 = new JLabel ("Website");
        l2 = new JLabel ("Email");
        l3 = new JLabel ("Password");
        t1 = new JTextField(50);
        t2 = new JTextField(50);
        t3 = new JTextField(50);
        t4 = new JTextField(50);
        b1.setBounds(100,400,150,40);
        b2.setBounds(300,400,150,40);
        l1.setBounds(100,100,150,40);
        l2.setBounds(100,160,150,40);
        l3.setBounds(100,220,150,40);
        l4.setBounds(100,280,150,40);
        t1.setBounds(300,100,150,40);
        t2.setBounds(300,160,150,40);
        t3.setBounds(300,220,150,40);
        t4.setBounds(300,280,150,40);
        frame.add(l1); frame.add(l2);frame.add(l3);frame.add(t1);frame.add(t2);frame.add(t3);frame.add(b1);frame.add(b2);frame.add(t4);frame.add(l4);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    @Override
     public void actionPerformed(ActionEvent ae){
        try{
            Object obj = ae.getSource();
            if(obj==b1){
                String website = t1.getText();
                String email = t2.getText();
                String password = t3.getText();
                String username = t4.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/PasswordManager", "root", "leaveme@10ne");
                if(c!=null)
                    System.out.println("Connection established");
                else
                    System.out.println("Connection failed");
                Statement s = c.createStatement();
                String i1 = "insert into data values('"+(website)+"','"+(email)+"','"+(password)+"','"+(username)+"')";
                int n1 = s.executeUpdate(i1);
                System.out.println("Data Inserted");
            }
            if(obj==b2){
                t1.setText(" ");
                t2.setText(" ");
                t3.setText(" ");
                t4.setText(" ");
            }
        }catch(Exception e){}
    }

}