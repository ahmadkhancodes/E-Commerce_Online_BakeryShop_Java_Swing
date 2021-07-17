/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import javax.swing.JFrame;
import javax.swing.JFrame;
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
import java.awt.ScrollPane;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class Term extends JFrame {
        Font f, f1, f2;
    JPanel p1;
    JLabel imagelabel, l1, l2, l3;
    JTextField t1;
    JButton b1;
    ImageIcon image = new ImageIcon("cupcake.jpg");

    public Term() throws HeadlessException {

        super("Term & Condition");
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        //setLocation(180, 50);
        setVisible(true);
        //fonts
        f = new Font("Comic Sans MS", Font.BOLD, 45);
        f1 = new Font("Comic Sans MS", Font.BOLD, 15);
        f2 = new Font("Comic Sans MS", Font.BOLD, 20);
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
        l1 = new JLabel("Term & Condition");

        l1.setFont(f);
        l1.setForeground(java.awt.Color.WHITE);
        l1.setBounds(400, 50, 400, 150);
        p1.add(l1);

        //text
         t1 = new JTextField("                                       All Right Reserved");
        t1.setBounds(150, 200, 900, 400);
        t1.setEditable(false);
        t1.setFont(f2);
        t1.setForeground(java.awt.Color.white);
        t1.setBackground(new Color(0, 0, 0,150));
        p1.add(t1);
        
    //BackButton

        b1 = new JButton("Back");
        b1.setForeground(java.awt.Color.white);
        b1.setBackground(new java.awt.Color(139, 69, 19));
        b1.setFont(f1);
        b1.setBounds(10, 10, 100, 40);
        p1.add(b1);
    //actionlistener
    
    action act=new action();
    b1.addActionListener(act);
    
    
    }
    

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Back")) {
                dispose();
                E_Commerce_Main_Runner e=new E_Commerce_Main_Runner();
                
            }}}

    public static void main(String[] args) {
        Term c = new Term();
        c.setResizable(false);
        c.setResizable(true);
    }

}
