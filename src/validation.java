import javax.swing.*;
import java.awt.event.*;
public class validation implements ActionListener{
    private static String password = "<your main password for the application>";    
    JFrame frame = new JFrame();
    JPasswordField pass = new JPasswordField(50);
    JButton check = new JButton("Login");
    JButton exit = new JButton("Exit");
    JLabel msg = new JLabel("Enter the password:");
    JLabel res = new JLabel(" ");
    validation(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(check);frame.add(exit);frame.add(msg);frame.add(res);frame.add(pass);
        msg.setBounds(50,50,300,30);
        pass.setBounds(300,50,150,30);
        exit.setBounds(300,150,150,40);
        check.setBounds(50,150,150,40);
        pass.setEchoChar('*');
        check.setFocusable(false);
        exit.setFocusable(false);
        check.addActionListener(this);
        exit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            String pass1 = new String(pass.getPassword());
            if(pass1.equals(password)){
                frame.dispose();
                menu m = new menu();
            }
            else{
                JOptionPane.showMessageDialog(null,"Wrong Password");
                System.exit(0);
            }
        }
        else if(e.getSource()==exit){
            System.exit(0);
        }    
    }
}
