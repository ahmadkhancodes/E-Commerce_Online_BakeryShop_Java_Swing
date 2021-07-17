/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class E_Commerce_Main_Runner extends JFrame {

    Font f, f1, f2, f3, f4, f5, f7;
    JPanel p1, p2, p3, p4, p5;
    JLabel imagelabel, l1, fb, insta;
    JLabel[] inner = new JLabel[18];
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    ImageIcon image = new ImageIcon("choco.jpg");
    ImageIcon facebook = new ImageIcon("fb.png");
    ImageIcon instagram = new ImageIcon("insta.png");

    public E_Commerce_Main_Runner() throws HeadlessException {

        super("Home");
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        //setLocation(180, 50);
        setVisible(true);
        //fonts
        f = new Font("Comic Sans MS", Font.BOLD, 50);
        f1 = new Font("Comic Sans MS", Font.BOLD, 15);
        f2 = new Font("Comic Sans MS", Font.BOLD, 17);
        f3 = new Font("Comic Sans MS", Font.BOLD, 35);
        f4 = new Font("Comic Sans MS", Font.BOLD, 35);
        f7 = new Font("Serif", Font.BOLD, 30);

        f5 = new Font("Serif", Font.BOLD, 42);
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

        p1.setBounds(38, 20, 1300, 700);
        imagelabel.add(p1);

        //header
        l1 = new JLabel("Made With Love");

        l1.setFont(f);
        l1.setForeground(java.awt.Color.WHITE);
        l1.setBounds(440, -30, 500, 200);
        p1.add(l1);

        //buttons
        b1 = new JButton("Home");
        b1.setForeground(java.awt.Color.white);
        b1.setBackground(new java.awt.Color(205, 133, 63));
        b1.setFont(f1);
        b1.setBounds(40, 120, 120, 40);
        p1.add(b1);

        b2 = new JButton("Shop Now");
        b2.setForeground(java.awt.Color.white);
        b2.setBackground(new java.awt.Color(205, 133, 63));
        b2.setFont(f1);
        b2.setBounds(180, 120, 120, 40);
        p1.add(b2);

        b3 = new JButton("Product Categories");
        b3.setForeground(java.awt.Color.white);
        b3.setBackground(new java.awt.Color(205, 133, 63));
        b3.setFont(f1);
        b3.setBounds(320, 120, 180, 40);
        p1.add(b3);

        b4 = new JButton("Best Deals");
        b4.setForeground(java.awt.Color.white);
        b4.setBackground(new java.awt.Color(205, 133, 63));
        b4.setFont(f1);
        b4.setBounds(520, 120, 120, 40);
        p1.add(b4);

        b5 = new JButton("Wishlist");
        b5.setForeground(java.awt.Color.white);
        b5.setBackground(new java.awt.Color(205, 133, 63));
        b5.setFont(f1);
        b5.setBounds(660, 120, 120, 40);
        p1.add(b5);

        b6 = new JButton("Cart");
        b6.setForeground(java.awt.Color.white);
        b6.setBackground(new java.awt.Color(205, 133, 63));
        b6.setFont(f1);
        b6.setBounds(800, 120, 120, 40);
        p1.add(b6);

        b7 = new JButton("Contact Us");
        b7.setForeground(java.awt.Color.white);
        b7.setBackground(new java.awt.Color(205, 133, 63));
        b7.setFont(f1);
        b7.setBounds(940, 120, 120, 40);
        p1.add(b7);

        b8 = new JButton("Term&Condition");
        b8.setForeground(java.awt.Color.white);
        b8.setBackground(new java.awt.Color(205, 133, 63));
        b8.setFont(f1);
        b8.setBounds(1080, 120, 180, 40);
        p1.add(b8);

        b9 = new JButton("Admin Login Here");
        b9.setForeground(java.awt.Color.white);
        b9.setBackground(new java.awt.Color(205, 133, 63));
        b9.setFont(f1);
        b9.setBounds(20, 10, 200, 40);
        p1.add(b9);

        b10 = new JButton("Search");
        b10.setForeground(java.awt.Color.white);
        b10.setBackground(new java.awt.Color(205, 133, 63));
        b10.setFont(f1);
        b10.setBounds(1160, 10, 120, 40);
        p1.add(b10);

        //textfields
        t1 = new JTextField();
        t1.setBounds(940, 18, 200, 30);
        t1.setFont(f2);
        t1.setForeground(java.awt.Color.DARK_GRAY);
        t1.setBackground(java.awt.Color.WHITE);
        p1.add(t1);

        //featuredPanel
        p2 = new JPanel();
        p2 = new JPanel(null);

        p2.setBackground(new java.awt.Color(0, 0, 0, 100));

        p2.setBounds(138, 190, 1100, 450);

        imagelabel.add(p2);

        //innerPanels
        p3 = new JPanel();
        p3 = new JPanel(null);

        p3.setBackground(new java.awt.Color(0, 0, 0, 100));

        p3.setBounds(15, 130, 350, 300);
        p2.add(p3);

        //Inner labels
        for (int i = 0; i < inner.length; i++) {
            inner[i] = new JLabel();
        }

        inner[0].setText("ONLINE BAKERY SHOP");
        inner[0].setBounds(300, 10, 500, 50);
        inner[0].setFont(f5);
        inner[0].setForeground(new Color(238, 197, 145));

        p2.add(inner[0]);

        inner[1].setText("Adress");
        inner[1].setBounds(115, 75, 250, 30);
        inner[1].setFont(f4);
        inner[1].setForeground(Color.white);
        p2.add(inner[1]);

        inner[2].setText("Sector A,Block 6,Colony Islamabad");
        inner[2].setBounds(35, 60, 350, 30);
        inner[2].setFont(f2);
        inner[2].setForeground(Color.white);
        p3.add(inner[2]);

        inner[3].setText("Phone : +923116015387");
        inner[3].setBounds(35, 90, 350, 30);
        inner[3].setFont(f2);
        inner[3].setForeground(Color.white);
        p3.add(inner[3]);

        inner[4].setText("Store Timings :");
        inner[4].setBounds(35, 120, 350, 30);
        inner[4].setFont(f2);
        inner[4].setForeground(Color.white);
        p3.add(inner[4]);

        inner[5].setText("11:00 AM to 12:00 PM");
        inner[5].setBounds(70, 150, 350, 30);
        inner[5].setFont(f2);
        inner[5].setForeground(Color.white);
        p3.add(inner[5]);

        inner[14].setText("Website : ebakery.com.pk");
        inner[14].setBounds(35, 180, 350, 30);
        inner[14].setFont(f2);
        inner[14].setForeground(Color.white);
        p3.add(inner[14]);

        //2nd Panel
        p4 = new JPanel();
        p4 = new JPanel(null);

        p4.setBackground(new java.awt.Color(0, 0, 0, 100));

        p4.setBounds(400, 130, 680, 300);
        p2.add(p4);

        //Inner labels
        inner[7].setText("Our Mission to");
        inner[7].setBounds(600, 75, 350, 30);
        inner[7].setFont(f4);
        inner[7].setForeground(Color.white);
        p2.add(inner[7]);

        inner[8].setText("#Create bakery which makes the best quality baked goods.fresh daily!");
        inner[8].setBounds(10, 20, 600, 30);
        inner[8].setFont(f2);
        inner[8].setForeground(Color.white);
        p4.add(inner[8]);

        inner[9].setText("#Motivate the brightest and most talented people in the industry.");
        inner[9].setBounds(10, 50, 600, 30);
        inner[9].setFont(f2);
        inner[9].setForeground(Color.white);
        p4.add(inner[9]);

        inner[10].setText("#Create an atmosphere where employees can learn, grow, and innovate.");
        inner[10].setBounds(10, 80, 600, 30);
        inner[10].setFont(f2);
        inner[10].setForeground(Color.white);
        p4.add(inner[10]);

        inner[11].setText("#To create an inviting warm atmosphere for our clients and customers");
        inner[11].setBounds(10, 110, 600, 30);
        inner[11].setFont(f2);
        inner[11].setForeground(Color.white);
        p4.add(inner[11]);

        inner[12].setText("to be able to purchase their baked goods.");
        inner[12].setBounds(10, 140, 600, 30);
        inner[12].setFont(f2);
        inner[12].setForeground(Color.white);
        p4.add(inner[12]);

        inner[13].setText("#Innovating in the baking industry to make everything from scratch.");
        inner[13].setBounds(10, 170, 600, 30);
        inner[13].setFont(f2);
        inner[13].setForeground(Color.white);
        p4.add(inner[13]);

        //SocialIcons
        Image fbb = facebook.getImage();
        Image tempp = fbb.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        facebook = new ImageIcon(tempp);
        fb = new JLabel("", facebook, JLabel.CENTER);
        fb.setBounds(700, 650, 50, 30);
        imagelabel.add(fb);

        Image instaa = instagram.getImage();
        Image temppp = instaa.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        instagram = new ImageIcon(temppp);
        insta = new JLabel("", instagram, JLabel.CENTER);
        insta.setBounds(750, 650, 50, 30);
        imagelabel.add(insta);

        inner[15].setText("Follow us on ");
        inner[15].setBounds(520, 645, 200, 30);
        inner[15].setFont(f7);
        inner[15].setForeground(Color.white);
        imagelabel.add(inner[15]);

//actionlistener
        action act = new action();
        b1.addActionListener(act);
        b2.addActionListener(act);
        b2.addActionListener(act);
        b3.addActionListener(act);
        b4.addActionListener(act);
        b5.addActionListener(act);
        b6.addActionListener(act);
        b7.addActionListener(act);
        b8.addActionListener(act);
        b9.addActionListener(act);
        b10.addActionListener(act);

    }

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Home")) {
                dispose();
                E_Commerce_Main_Runner e = new E_Commerce_Main_Runner();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Shop Now")) {
                dispose();
                Shop e = new Shop();

                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Product Categories")) {
                dispose();
                Categories e = new Categories();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Best Deals")) {
                dispose();
                BestDeal e = new BestDeal();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Wishlist")) {
                dispose();
                Wishlist e = new Wishlist();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Cart")) {
                dispose();
                cart e = new cart();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Contact Us")) {
                dispose();
                ContactUs e = new ContactUs();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Term&Condition")) {
                dispose();
                Term e = new Term();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Admin Login Here")) {
                dispose();
                Adminlogin e = new Adminlogin();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Search")) {
                Search e = new Search(t1.getText());
                e.setResizable(false);
                e.setResizable(true);

            }

        }

    }

    public static void main(String[] args) {
        E_Commerce_Main_Runner e = new E_Commerce_Main_Runner();
        e.setResizable(false);
        e.setResizable(true);
    }

}
