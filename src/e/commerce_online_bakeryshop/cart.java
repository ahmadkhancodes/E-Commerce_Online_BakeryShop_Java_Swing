/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeCellEditor;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class cart extends JFrame {

    ArrayList<Cartj> list = Cartj.readAllData();
    JTextField[] displaytext = new JTextField[list.size()];
    JPanel[] p = new JPanel[12];
    JButton[] b = new JButton[5];
    //JTextField t1, t2;
    JLabel l1, l2;
    JScrollPane sc;
    ImageIcon image = new ImageIcon("C:\\Users\\Muhammad Ahmad Khan\\Documents\\NetBeansProjects\\E-Commerce_Online_BakeryShop\\src\\e\\commerce_online_bakeryshop\\image.jpg");
    JTextField t;

    public cart() throws HeadlessException {

        super("Cart");
        setLayout(new BorderLayout());
        //setLocation(180, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        setVisible(true);
        action act = new action();
        for (int i = 0; i < p.length; i++) {
            p[i] = new JPanel();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = new JButton();
            b[i].addActionListener(act);
        }

        p[0].setLayout(new BorderLayout());

        //p[0].setBackground(java.awt.Color.pink);
        add(p[0], BorderLayout.CENTER);

        p[1].setLayout(new FlowLayout());
        p[2].setLayout(new FlowLayout());

        b[0].setText("Proceed to CheckOut");
        b[1].setText("Remove Product");
        b[2].setText("Clear Cart");
        b[3].setText("Back");
        t = new JTextField(20);
        p[2].add(b[0]);
        p[2].add(t);
        p[2].add(b[1]);
        p[2].add(b[2]);
        p[2].add(b[3]);

        p[1].add(p[2]);

        p[0].add(p[1], BorderLayout.SOUTH);

        p[4].setLayout(new BorderLayout());
        p[0].add(p[4], BorderLayout.NORTH);

        p[6].setLayout(new FlowLayout());

        p[4].add(p[6], BorderLayout.CENTER);

        l1 = new JLabel("CART");
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
            displaytext[i].setBackground(java.awt.Color.LIGHT_GRAY);
            displaytext[i].setFont(f1);
            displaytext[i].setText("Name : " + list.get(i).getPrduct().getName() + " \tID : " + list.get(i).getPrduct().getId() + " \t Price : " + list.get(i).getPrduct().CalCost() + " \t Quantity : " + list.get(i).getQuantity());
            p[8].add(displaytext[i]);
        }
        p[7].add(sc);

        p[0].add(p[7], BorderLayout.CENTER);

    }

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Proceed to CheckOut")) {
                if(!Cartj.readAllData().isEmpty()){
                dispose();
                cheackout c = new cheackout();
                c.setResizable(false);
                c.setResizable(true);}
                else{
                JOptionPane.showMessageDialog(new JFrame(), "Your Cart is Empty! Can't Proceed to Checkout");
                
                }
            }
            if (ae.getActionCommand().equalsIgnoreCase("Remove Product")) {

                try {
                    if (operations.isclistContainID(t.getText(), Cartj.readAllData())) {
                        String name = "";

                        name = Cartj.deletecartproduct(t.getText(), Cartj.readAllData());

                        JOptionPane.showMessageDialog(new JFrame(), name + " Deleted");
                        t.setText("");

                    } else {

                        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID");
                        t.setText("");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(new JFrame(), e.getMessage());

                }

            }
            if (ae.getActionCommand().equalsIgnoreCase("Clear Cart")) {
                try {
                    for(Cartj c: Cartj.readAllData()){
                    Products.increaseQuan(c.getPrduct(), c.getQuantity());
                    }
                    Cartj.flushallData();
                    JOptionPane.showMessageDialog(new JFrame(), "Cart Cleared");
                    dispose();
                    cart c = new cart();
                    c.setResizable(false);
                    c.setResizable(true);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
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
        cart e = new cart();
        e.setResizable(false);
        e.setResizable(true);
    }

}
