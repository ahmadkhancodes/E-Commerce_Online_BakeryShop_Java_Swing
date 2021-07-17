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
public class AddQuantity extends JFrame {

    Font f, f1, f2, f3;
    JPanel p1;
    JLabel imagelabel, l1, l2, l3, l4, l5;
    JTextField t1;
    JButton b7, b8;
    ImageIcon image = new ImageIcon("choco.jpg");

    public AddQuantity() throws HeadlessException {

        super("Add to Cart");
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
        l1 = new JLabel("Add to Cart");

        l1.setFont(f);
        l1.setForeground(java.awt.Color.WHITE);
        l1.setBounds(430, 50, 350, 150);
        p1.add(l1);

        //otherLabels
        l2 = new JLabel("Enter Quantity");
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
        b7 = new JButton("Add");
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
        b8.addActionListener(act);

    }
    
    public int getQuantity(){
        return Integer.parseInt(t1.getText());
        
        }

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Back")) {
                dispose();
                E_Commerce_Main_Runner e = new E_Commerce_Main_Runner();
                e.setResizable(false);
                e.setResizable(true);
            }
            if (ae.getActionCommand().equalsIgnoreCase("Add")) {
                dispose();
                JOptionPane.showMessageDialog(new JPanel(), "Qunatity set to "+t1.getText());

            }
        }
    }

    public static void main(String[] args) {
        AddQuantity c = new AddQuantity();
        c.setResizable(false);
        c.setResizable(true);
    }

}
