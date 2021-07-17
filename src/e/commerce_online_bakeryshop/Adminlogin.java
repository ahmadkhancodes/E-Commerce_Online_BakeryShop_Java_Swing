/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class Adminlogin extends JFrame {

    JButton b1, b2;
    JTextField t1;
    JPasswordField t2;
    Font f, f1;
    JPanel p1;
    JLabel imagelabel, l1, l2, l3, l4, l5;
    ImageIcon image = new ImageIcon("pastry.jpg");

    public Adminlogin() throws HeadlessException {

        super("Login");
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        //setLocation(180, 50);
        setVisible(true);
        //fonts
        f = new Font("Comic Sans MS", Font.BOLD, 35);
        f1 = new Font("Comic Sans MS", Font.BOLD, 25);
        //image
        Image img = image.getImage();
        Image temp = img.getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
        image = new ImageIcon(temp);
        imagelabel = new JLabel("", image, JLabel.CENTER);
        imagelabel.setBounds(0, 0, 1366, 768);
        add(imagelabel);
        //panel
        p1 = new JPanel(null);

        p1.setBackground(new Color(0, 0, 0, 150));

        p1.setBounds(82, 50, 1200, 650);
        imagelabel.add(p1);

        //header
        l1 = new JLabel("Admin Login");

        l1.setFont(f);
        l1.setForeground(Color.WHITE);
        l1.setBounds(500, 50, 350, 170);
        p1.add(l1);

        //textfield
        t1 = new JTextField();
        t1.setBounds(540, 210, 300, 35);
        t1.setFont(f1);
        t1.setForeground(Color.DARK_GRAY);
        t1.setBackground(Color.WHITE);
        p1.add(t1);

        //passwordfield
        t2 = new JPasswordField();
        t2.setBounds(540, 270, 300, 35);
        t2.setFont(f1);
        t2.setForeground(Color.DARK_GRAY);
        t2.setBackground(Color.WHITE);
        p1.add(t2);

        //labels
        l2 = new JLabel("Username");
        l2.setBounds(320, 200, 200, 50);
        l2.setFont(f1);
        l2.setForeground(Color.white);
        p1.add(l2);

        l3 = new JLabel("Password");
        l3.setBounds(320, 260, 200, 50);
        l3.setFont(f1);
        l3.setForeground(Color.white);
        p1.add(l3);

        //back
        b2 = new JButton("Back");
        b2.setForeground(Color.white);
        b2.setBackground(new Color(139, 69, 19));
        b2.setFont(f1);
        b2.setBounds(10, 10, 100, 40);
        p1.add(b2);

        //login
        b1 = new JButton("Login");
        b1.setForeground(Color.white);
        b1.setBackground(new Color(205, 133, 63));
        b1.setFont(f1);
        b1.setBounds(450, 340, 300, 50);
        p1.add(b1);
        //actionlistner

        action act = new action();
        b1.addActionListener(act);
        b2.addActionListener(act);
    }

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Login")) {
                if (t1.getText().equals("admin") && t2.getText().equals("admin")) {
                    dispose();
                    AdminDash d = new AdminDash();
                } else {

                    JOptionPane.showMessageDialog(new JFrame(), "Wrong Details");
                }
            }

            if (ae.getActionCommand().equalsIgnoreCase("Back")) {
                dispose();
                E_Commerce_Main_Runner e = new E_Commerce_Main_Runner();
                e.setResizable(false);
                e.setResizable(true);

            }
        }
    }

    public static void main(String[] args) {
        Adminlogin a = new Adminlogin();
        a.setResizable(false);
        a.setResizable(true);

    }

}
