import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class Add extends JFrame implements ActionListener  {
    JFrame frame = new JFrame();
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3,b4;
    Add(){
        frame.setSize(700,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        b1 = new JButton ("Insert");
        b2 = new JButton ("Clear");
        b3 = new JButton ("Exit");
        b4 = new JButton ("Back");
        l4 = new JLabel ("Username");
        l1 = new JLabel ("Website:");
        l2 = new JLabel ("Email:");
        l3 = new JLabel ("Password:");
        t1 = new JTextField(50);
        t2 = new JTextField(50);
        t3 = new JTextField(50);
        t4 = new JTextField(50);
        b1.setBounds(70,400,150,40);
        b2.setBounds(270,400,150,40);
        b3.setBounds(480,400,150,40);
        b4.setBounds(50,50,70,30);
        l1.setBounds(100,100,150,40);
        l2.setBounds(100,160,150,40);
        l3.setBounds(100,220,150,40);
        l4.setBounds(100,280,150,40);
        t1.setBounds(300,100,150,40);
        t2.setBounds(300,160,150,40);
        t3.setBounds(300,220,150,40);
        t4.setBounds(300,280,150,40);
        frame.add(l1); frame.add(l2);frame.add(l3);frame.add(t1);frame.add(t2);frame.add(t3);frame.add(b1);frame.add(b2);frame.add(b3);frame.add(b4);frame.add(t4);frame.add(l4);
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
     public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==b1){
                String website = t1.getText();
                String email = t2.getText();
                String password = t3.getText();
                String username = t4.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/passwordmanager", "root", "leaveme@10ne");
                if(c!=null)
                    System.out.println("Connection established");
                else
                    System.out.println("Connection failed");
                Statement s = c.createStatement();
                String i1 = "insert into data values('"+(website)+"','"+(email)+"','"+(password)+"','"+(username)+"')";
                int n1 = s.executeUpdate(i1);
                JOptionPane.showMessageDialog(null,"Data inserted successfully!");
            }
            if(e.getSource()==b2){
                t1.setText(" ");
                t2.setText(" ");
                t3.setText(" ");
                t4.setText(" ");
            }
            if(e.getSource()==b3){
                System.exit(0);
            }
            if(e.getSource()==b4){
                frame.dispose();
                menu m = new menu();
            }
        }catch(Exception ee){}
    }

}