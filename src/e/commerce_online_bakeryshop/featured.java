/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class featured extends JFrame {

    Font f, f1, f2, f3;
    JPanel p1;
    JLabel imagelabel, l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    JButton b7, b8;
    ImageIcon image = new ImageIcon("pizza.jpg");

    public featured() throws HeadlessException {

        super("Mark Product as Featured");
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        //setLocation(180, 50);
        setVisible(true);
        //fonts
        f = new Font("Comic Sans MS", Font.BOLD, 45);
        f1 = new Font("Comic Sans MS", Font.BOLD, 15);
        f2 = new Font("Comic Sans MS", Font.BOLD, 20);
        f3 = new Font("Comic Sans MS", Font.BOLD, 35);
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
        l1 = new JLabel("Make Featured");

        l1.setFont(f);
        l1.setForeground(java.awt.Color.WHITE);
        l1.setBounds(430, 50, 350, 150);
        p1.add(l1);

        //otherLabels
        l2 = new JLabel("Enter Product ID");
        l2.setBounds(320, 200, 200, 50);
        l2.setFont(f2);
        l2.setForeground(java.awt.Color.white);
        p1.add(l2);

//textfields
        t1 = new JTextField();
        t1.setBounds(530, 210, 300, 35);
        t1.setFont(f2);
        t1.setForeground(java.awt.Color.DARK_GRAY);
        t1.setBackground(java.awt.Color.WHITE);
        p1.add(t1);

//savebutton;
        b7 = new JButton("Mark");
        b7.setForeground(java.awt.Color.white);
        b7.setBackground(new java.awt.Color(205, 133, 63));
        b7.setFont(f3);
        b7.setBounds(450, 300, 350, 50);
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
                AdminDash e = new AdminDash();
                e.setResizable(false);
                e.setResizable(true);
            }
            if (ae.getActionCommand().equalsIgnoreCase("Mark")) {
                if (operations.islistContainID(t1.getText(), Products.readAllData())) {
                    try {
                        ArrayList<Products> p = Products.readAllData();
                        String name = operations.MakeProductFeaturedAgainstID(t1.getText(), p);
                        try {
                            Products.flushallData();
                        } catch (IOException ex) {
                            Logger.getLogger(featured.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (Products p1 : p) {
                            Products.writeObjectToFile(p1);
                        }
                        JOptionPane.showMessageDialog(new JFrame(), name + " has made Featured");

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());

                    }
                }
            else {

                JOptionPane.showMessageDialog(new JFrame(), "Invalid Id");

            }}
        }
    }

    public static void main(String[] args) {
        featured c = new featured();
        c.setResizable(false);
        c.setResizable(true);
    }

}
