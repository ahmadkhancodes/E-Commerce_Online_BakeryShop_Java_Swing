/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class cheackout extends JFrame {

    Font f, f1, f2, f3, f4;
    JPanel p1;
    JLabel imagelabel, l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    ImageIcon image = new ImageIcon("color.jpg");

    public cheackout() throws HeadlessException {

        super("CheakOut");
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        //setLocation(180, 50);
        setVisible(true);
        //fonts
        f = new Font("Comic Sans MS", Font.BOLD, 40);
        f1 = new Font("Comic Sans MS", Font.BOLD, 15);
        f2 = new Font("Comic Sans MS", Font.BOLD, 20);
        f3 = new Font("Comic Sans MS", Font.BOLD, 35);
        f4 = new Font("Comic Sans MS", Font.BOLD, 35);
        //image
        Image img = image.getImage();
        Image temp = img.getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
        image = new ImageIcon(temp);
        imagelabel = new JLabel("", image, JLabel.CENTER);
        imagelabel.setBounds(0, 0, 1366, 768);
        add(imagelabel);
        //panel
        p1 = new JPanel(null);

        p1.setBackground(new java.awt.Color(0, 0, 0, 150));

        p1.setBounds(82, 50, 1200, 650);
        imagelabel.add(p1);

        //header
        l1 = new JLabel("Thanks For Shopping");

        l1.setFont(f);
        l1.setForeground(java.awt.Color.WHITE);
        l1.setBounds(430, 18, 400, 150);
        p1.add(l1);

        //otherLabels
        l2 = new JLabel("Name");
        l2.setBounds(320, 140, 200, 50);
        l2.setFont(f2);
        l2.setForeground(java.awt.Color.white);
        p1.add(l2);

        l3 = new JLabel("Email");
        l3.setBounds(320, 220, 200, 50);
        l3.setFont(f2);
        l3.setForeground(java.awt.Color.white);
        p1.add(l3);

        l4 = new JLabel("Phone No");
        l4.setBounds(320, 300, 200, 50);
        l4.setFont(f2);
        l4.setForeground(java.awt.Color.white);
        p1.add(l4);

        l5 = new JLabel("Adress");
        l5.setBounds(320, 380, 200, 50);
        l5.setFont(f2);
        l5.setForeground(java.awt.Color.white);
        p1.add(l5);

//textfields
        t1 = new JTextField();
        t1.setBounds(530, 150, 300, 35);
        t1.setFont(f2);
        t1.setForeground(java.awt.Color.DARK_GRAY);
        t1.setBackground(java.awt.Color.WHITE);
        p1.add(t1);

        t2 = new JTextField();
        t2.setBounds(530, 230, 300, 35);
        t2.setFont(f2);
        t2.setForeground(java.awt.Color.DARK_GRAY);
        t2.setBackground(java.awt.Color.WHITE);
        p1.add(t2);

        t3 = new JTextField();

        t3.setBounds(530, 310, 300, 35);
        t3.setFont(f2);
        t3.setForeground(java.awt.Color.DARK_GRAY);
        t3.setBackground(java.awt.Color.WHITE);
        p1.add(t3);

        t4 = new JTextField();

        t4.setBounds(530, 390, 300, 100);
        t4.setFont(f2);
        t4.setForeground(java.awt.Color.DARK_GRAY);
        t4.setBackground(java.awt.Color.WHITE);
        p1.add(t4);

//savebutton;
        b7 = new JButton("Place Order");
        b7.setForeground(java.awt.Color.white);
        b7.setBackground(new java.awt.Color(205, 133, 63));
        b7.setFont(f3);
        b7.setBounds(410, 550, 300, 50);
        p1.add(b7);

//BackButton
        b8 = new JButton("Back");
        b8.setForeground(java.awt.Color.white);
        b8.setBackground(new java.awt.Color(139, 69, 19));
        b8.setFont(f1);
        b8.setBounds(10, 10, 100, 40);
        p1.add(b8);
        //actionlistener

        action act = new action();
        b8.addActionListener(act);
        b7.addActionListener(act);

    }

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Back")) {
                dispose();
                E_Commerce_Main_Runner e = new E_Commerce_Main_Runner();

            }
            if (ae.getActionCommand().equalsIgnoreCase("Place Order")) {
                if (t1.getText().isEmpty() && t2.getText().isEmpty() && t3.getText().isEmpty() && t4.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Fields Cannot be Empty");
                } else {
                    try {
                        PhoneNumber phone = new PhoneNumber(t3.getText());
                        ValidEmail email = new ValidEmail(t2.getText());
                        chekoutnew c11 = new chekoutnew(t1.getText(), t4.getText(), Cartj.readAllData(), phone, email);
                        chekoutnew.writeObjectToFile(c11);

                        JOptionPane.showMessageDialog(new JFrame(), "We Have Recieved Your Order");

                        JOptionPane.showMessageDialog(new JFrame(), "Your Total Bill is : " + c11.Bill() + "Rs");
                        Cartj.flushallData();

                    } catch (InvalidEmailException | InvalidPhoneNumberException | HeadlessException | IOException e) {
                        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
                    }

                }
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                //t5.setText("");
                

            }

        }
    }

    public static void main(String[] args) {
        cheackout c = new cheackout();
        c.setResizable(false);
        c.setResizable(true);
    }

}
