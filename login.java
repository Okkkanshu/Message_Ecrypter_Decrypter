import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class SignUp extends JFrame{
    JTextField t1,t2;
    JLabel l1;
    JButton b1;
    SignUp(){
        setLayout(null);

          l1 = new JLabel("Sign-Up");
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(190,10,300,30);

        t1= new JTextField(60);
        t2= new JPasswordField(60);
        b1 = new JButton("Submit");

        t1.setBounds(150, 60,180,30);
        t2.setBounds(150, 100,180,30);
        b1.setBounds(200,140,80,30);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                FileWriter fw = new FileWriter("login.txt",true);
                fw.write(t1.getText()+"\t"+t2.getText()+"\n");
                fw.close();
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"Registration Completed!");
                dispose();
                }catch(Exception e){}
            }
        });

        add(t1);
        add(t2);
        add(b1);
        add(l1);

    }
}

class Login extends JFrame{
    JTextField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3,l4;
    Login(){
        setLayout( null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1 = new JLabel("Sign-In");
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(190,10,300,30);

        l3 = new JLabel("Username:");
        l3.setFont(new Font("Times New Roman",Font.BOLD,15));
        l3.setForeground(Color.BLACK);
        l3.setBounds(75,60,300,30);

        l4 = new JLabel("Password:");
        l4.setFont(new Font("Times New Roman",Font.BOLD,15));
        l4.setForeground(Color.BLACK);
        l4.setBounds(75,100,300,30);


        t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        b1 = new JButton("SignIn");
        b2 = new JButton("SignUp");

        t1.setBounds(150, 60,180,30);
        t2.setBounds(150, 100,180,30);
        b1.setBounds(150,140,80,30);
        b2.setBounds(250,140,80,30);

        l2 = new JLabel("");     
        l2.setBounds(150,180,500,30);


        add(t1);
        add(t2);
        add(b1);
        add(b2);
        add(l1);
        add(l2);
        add(l3);
        add(l4);

        b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                boolean matched = false;
                String uname = t1.getText().toString();
                String pwd = t2.getText().toString();

                try{
                FileReader fr = new FileReader("login.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null){
                    if(line.equals(uname+"\t"+pwd)){
                        matched = true;
                        break;
                    }
                }
                fr.close();
                }catch(Exception e){}

                    if(matched){
                        dispose();
                          ed g = new ed();
                        g.setBounds(400,200,600,500);
                        g.setVisible(true);
                    }
                    else{
                        l2.setText("Invalid Username Or Password!");
                    }
                }
        });

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                SignUp s = new SignUp();
                s.setVisible(true);
                s.setBounds(200,200,500,300);
            }
        });


    }
}

class LoginPage{
    public static void main(String[] args){
        Login l = new Login();
        l.setBounds(400,200,500,300);

        l.setVisible(true);
    }
}
