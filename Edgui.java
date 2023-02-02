import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.*;

class ed extends JFrame{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2;
    JButton b1,b2,b3;
    ed(){
        ImageIcon img = new ImageIcon("img.jpg");


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        l1 = new JLabel("Mesage Encrypter-Decrypter");
        l3 = new JLabel("Enter Message Here:");
        l4 = new JLabel("Enter Shift-Key Here:");

        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l3.setFont(new Font("Times New Roman",Font.BOLD,15));
        l4.setFont(new Font("Times New Roman",Font.BOLD,15));
        l1.setForeground(Color.BLUE);
        l3.setForeground(Color.BLACK);
        l4.setForeground(Color.BLACK);


        l1.setBounds(80,10,600,30);
        l3.setBounds(100,50,200,20);
        l4.setBounds(100,100,200,20);
        add(l1);
        add(l3);
        add(l4);

        t1 = new JTextField(70);
        t2 =  new JTextField(70);

        b1 = new JButton("Encrypt The Message");
        b2 = new JButton("Decrypt The Message");

        t1.setBounds(100,70,400,30);
        t2.setBounds(100,120,400,30);
        b1.setBounds(100,160,180,30);
        b2.setBounds(300,160,180,30);

        l2 = new JLabel("");
        l2.setFont(new Font("Times New Roman",Font.BOLD,30));
        l2.setForeground(Color.BLUE);
        l2.setBounds(50,200,550,100);

        l5 = new JLabel("");
        l5.setFont(new Font("Times New Roman",Font.BOLD,30));
        l5.setForeground(Color.RED);
        l5.setBounds(140,200,400,30);

        b3 = new JButton("Copy The Message");
        b3.setBounds(200,350,180,30);

        add(l2);
        add(l5);
        add(t1);
        add(t2);
        add(b1);
        add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = t1.getText();
                int shift = Integer.parseInt(t2.getText());
                String encryptedMessage = encrypt(message, shift);


                
                l2.setText("<html>"+encryptedMessage+"</html>");
                l5.setText("Encrypted-Message:");


                add(b3);

                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                        StringSelection strsel = new StringSelection(encryptedMessage);
                        clip.setContents(strsel,strsel);
                    }
                });
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
       
                String message = t1.getText();
                int shift = Integer.parseInt(t2.getText());
                
                String decryptedMessage = decrypt(message, shift);



                l2.setText(decryptedMessage);
                l5.setText("Decrypted-Message:");

                 add(b3);

                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                        StringSelection strselc = new StringSelection(decryptedMessage);
                        clip.setContents(strselc,strselc);
                    }
                });

            }
        });

    }
    public static String encrypt(String message, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c + shift);
                if (Character.isLowerCase(message.charAt(i)) && c > 'z' || Character.isUpperCase(message.charAt(i)) && c > 'Z') {
                    c = (char) (c - 26);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String decrypt(String message, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) (c - shift);
                if (Character.isLowerCase(message.charAt(i)) && c < 'a' || Character.isUpperCase(message.charAt(i)) && c < 'A') {
                    c = (char) (c + 26);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
class Edgui {
    public static void main(String[] args) {
        ed g = new ed();
        g.setBounds(400,200,600,500);
        g.setVisible(true);
    }


}
