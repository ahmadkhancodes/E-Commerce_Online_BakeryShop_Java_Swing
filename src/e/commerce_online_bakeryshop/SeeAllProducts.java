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
import static java.lang.Math.ceil;
import java.nio.channels.SeekableByteChannel;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class SeeAllProducts extends JFrame {

    ArrayList<Products> list = Products.readAllData();
    JTextField[] displaytext = new JTextField[list.size()];
    JPanel[] p = new JPanel[12];
   
    JLabel l1, l2;
    //JScrollPane sc;
    ImageIcon image = new ImageIcon("C:\\Users\\Muhammad Ahmad Khan\\Documents\\NetBeansProjects\\E-Commerce_Online_BakeryShop\\src\\e\\commerce_online_bakeryshop\\image.jpg");

    public SeeAllProducts() throws HeadlessException {

        super("See All Products");
        setLayout(new BorderLayout());
        //setLocation(180, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        setVisible(true);
    

        for (int i = 0; i < p.length; i++) {
            p[i] = new JPanel();
        }
        

        p[0].setLayout(new BorderLayout());
        //p[0].setBackground(java.awt.Color.pink);
        add(p[0], BorderLayout.CENTER);

//        p[1].setLayout(new FlowLayout());
//        p[2].setLayout(new FlowLayout());
//        p[3].setLayout(new FlowLayout());
//        b[0].setText("Add to Cart");
//        b[1].setText("Add to Wishlist");
//        b[2].setText("Back");
//        t1 = new JTextField(20);
//        t2 = new JTextField(20);
//
//        p[2].add(t1);
//        p[2].add(b[0]);
//        p[3].add(t2);
//        p[3].add(b[1]);
//        p[3].add(b[2]);
//
//        p[1].add(p[2]);
//        p[1].add(p[3]);
//        p[0].add(p[1], BorderLayout.SOUTH);

        p[4].setLayout(new BorderLayout());
        p[0].add(p[4], BorderLayout.NORTH);

        p[6].setLayout(new FlowLayout());

        p[4].add(p[6], BorderLayout.CENTER);

        l1 = new JLabel("Active Products");
        l1.setForeground(java.awt.Color.red);

        Font f = new Font("Serif", Font.BOLD, 70);
        Font f1 = new Font("Serif", Font.BOLD, 20);

        //l1.setBackground(java.awt.Color.RED);
        l1.setFont(f);
        p[6].add(l1);

        p[7].setLayout(new BorderLayout());


        p[8].setLayout(new GridLayout(50, 1));
        JScrollPane sc = new JScrollPane(p[8], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        for (int i = 0; i < list.size(); i++) {
            displaytext[i] = new JTextField();
            displaytext[i].setEditable(false);
            displaytext[i].setBackground(Color.LIGHT_GRAY);
            displaytext[i].setFont(f1);
            displaytext[i].setText((i+1)+" Name : " + list.get(i).getName() + " \tID : " + list.get(i).getId() + " \tQuantity : " + list.get(i).getQuantity() + " \t Price : " + list.get(i).getPrice());
            p[8].add(displaytext[i]); 
        }
        p[7].add(sc);

        p[0].add(p[7], BorderLayout.CENTER);

    }

   
    public static void main(String[] args) {
        SeeAllProducts e = new SeeAllProducts();
        e.setResizable(false);
        e.setResizable(true);
    }
}
