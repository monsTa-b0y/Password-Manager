import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Search implements ActionListener {
    JFrame frame = new JFrame();
    JButton b1 = new JButton("Search");
    JButton b2 = new JButton("Exit");
    JButton b3 = new JButton("Back");
    JLabel l1 = new JLabel("Website Name:");
    JLabel l2 = new JLabel("Linked Email:");
    JLabel l3 = new JLabel("Password:");
    JLabel l4 = new JLabel("Username:");
    JTextField t1 = new JTextField(50);
    JTextField t2 = new JTextField(50);
    JTextField t3 = new JTextField(50);
    JTextField t4 = new JTextField(50);
    Search(){
        frame.setSize(700,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        t1.setBounds(300,100,200,40);
        t2.setBounds(300,160,200,40);
        t3.setBounds(300,390,200,40);
        t4.setBounds(300,220,200,40);
        t3.setEditable(false);
        l1.setBounds(100,100,150,40);
        l2.setBounds(100,160,150,40);
        l3.setBounds(100,390,150,40);
        l4.setBounds(100,220,150,40);
        b1.setBounds(100,290,150,40);
        b2.setBounds(300,290,150,40);
        b3.setBounds(50,50,70,30);
        frame.add(b1);frame.add(b2);frame.add(b3);frame.add(t1);frame.add(t2);frame.add(t3);frame.add(t4);frame.add(l1);frame.add(l2);frame.add(l3);frame.add(l4);
        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
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
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:<local host number (default:3306)>/<your local database name>", "root", "<your root password>");
                if(c!=null)
                    System.out.println("Connection established");
                else    
                    System.out.println("Connected failed");
                Statement s = c.createStatement();
                String str = "select* from data where website= '"+(website)+"' and email = '"+(email)+"';";
                ResultSet rs = s.executeQuery(str);
                while(rs.next()){
                    String pass =  rs.getString("password");
                    t3.setText(pass);
                }
            }
            if(e.getSource()==b2){
                System.exit(0);
            }
            if(e.getSource()==b3){
                frame.dispose();
                menu m = new menu();
            }
        }
        catch(Exception en){}
    }
}
