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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AdminDash extends JFrame {

    Font f, f1;
    JPanel p1;
    JLabel imagelabel, l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    ImageIcon image = new ImageIcon("cake1.jpg");

    public AdminDash() throws HeadlessException {

        super("Admin Dashboard");
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        //setLocation(180, 50);
        setVisible(true);
        //fonts
        f = new Font("Comic Sans MS", Font.BOLD, 45);
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
        l1 = new JLabel("Admin Dashboard");

        l1.setFont(f);
        l1.setForeground(Color.WHITE);
        l1.setBounds(400, -30, 400, 170);
        p1.add(l1);

        //buttons
        b1 = new JButton("Add Product");
        b1.setForeground(Color.white);
        b1.setBackground(new Color(205, 133, 63));
        b1.setFont(f1);
        b1.setBounds(400, 150, 400, 50);
        p1.add(b1);

        b2 = new JButton("Delete Product");
        b2.setForeground(Color.white);
        b2.setBackground(new Color(205, 133, 63));
        b2.setFont(f1);
        b2.setBounds(400, 210, 400, 50);
        p1.add(b2);

        b3 = new JButton("Delete All Products");
        b3.setForeground(Color.white);
        b3.setBackground(new Color(205, 133, 63));
        b3.setFont(f1);
        b3.setBounds(400, 270, 400, 50);
        p1.add(b3);

        b4 = new JButton("Mark Product as Featured");
        b4.setForeground(Color.white);
        b4.setBackground(new Color(205, 133, 63));
        b4.setFont(f1);
        b4.setBounds(400, 330, 400, 50);
        p1.add(b4);

        b5 = new JButton("See All Products");
        b5.setForeground(Color.white);
        b5.setBackground(new Color(205, 133, 63));
        b5.setFont(f1);
        b5.setBounds(400, 390, 400, 50);
        p1.add(b5);

        b6 = new JButton("View Orders");
        b6.setForeground(Color.white);
        b6.setBackground(new Color(205, 133, 63));
        b6.setFont(f1);
        b6.setBounds(400, 450, 400, 50);
        p1.add(b6);

        b7 = new JButton("Logut");
        b7.setForeground(Color.white);
        b7.setBackground(new Color(205, 133, 63));
        b7.setFont(f1);
        b7.setBounds(450, 510, 300, 50);
        p1.add(b7);
//actionlistener

        action act = new action();
        b1.addActionListener(act);
        b2.addActionListener(act);
        b3.addActionListener(act);
        b4.addActionListener(act);
        b5.addActionListener(act);
        b6.addActionListener(act);
        b7.addActionListener(act);

    }

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Add Product")) {
                dispose();
                AddProduct a = new AddProduct();
                a.setResizable(false);
                a.setResizable(true);
            }
            if (ae.getActionCommand().equalsIgnoreCase("Delete Product")) {
                dispose();
                Deletepro c = new Deletepro();
                c.setResizable(false);
                c.setResizable(true);
            }
            if (ae.getActionCommand().equalsIgnoreCase("Delete All Products")) {
                try {
                    Products.flushallData();
                    JOptionPane.showMessageDialog(new JFrame(), "Store is Empty Now");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            }
            if (ae.getActionCommand().equalsIgnoreCase("Mark Product as Featured")) {
                dispose();
                featured f = new featured();

            }
            if (ae.getActionCommand().equalsIgnoreCase("See All Products")) {
                dispose();
                SeeAllProducts e = new SeeAllProducts();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("View Orders")) {
                Orders e = new Orders();
                e.setResizable(false);
                e.setResizable(true);
            }

            if (ae.getActionCommand().equalsIgnoreCase("Logut")) {
                dispose();
                Adminlogin e = new Adminlogin();
                e.setResizable(false);
                e.setResizable(true);

            }
        }
    }

    public static void main(String[] args) {
        AdminDash a = new AdminDash();
        a.setResizable(false);
        a.setResizable(true);

    }

}
