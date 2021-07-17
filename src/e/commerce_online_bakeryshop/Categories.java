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
import java.util.ArrayList;
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

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class Categories extends JFrame {

    ArrayList<Products> list = Products.readAllData();
    JTextField[] displaytext = new JTextField[list.size()];
    Font f = new Font("Serif", Font.BOLD, 70);
    Font f1 = new Font("Serif", Font.BOLD, 20);

    JPanel[] p = new JPanel[15];
    JButton[] b = new JButton[15];
    JTextField t1, t2, t3;
    JLabel l1, l2, l3;
    JScrollPane sc;
    ImageIcon image = new ImageIcon("C:\\Users\\Muhammad Ahmad Khan\\Documents\\NetBeansProjects\\E-Commerce_Online_BakeryShop\\src\\e\\commerce_online_bakeryshop\\image.jpg");

    public Categories() throws HeadlessException {

        super("Product Categories");
        setLayout(new BorderLayout());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        //setLocation(180,50);
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
        p[3].setLayout(new FlowLayout());
        b[0].setText("Add to Cart");
        b[1].setText("Add to Wishlist");
        b[9].setText("Back");
        t1 = new JTextField(20);
        t2 = new JTextField(20);

        p[2].add(t1);
        p[2].add(b[0]);
        p[3].add(t2);
        p[3].add(b[1]);
        p[3].add(b[9]);

        p[1].add(p[2]);
        p[1].add(p[3]);
        p[0].add(p[1], BorderLayout.SOUTH);

        p[4].setLayout(new BorderLayout());

        p[0].add(p[4], BorderLayout.NORTH);

        p[5].setLayout(new FlowLayout());
        p[6].setLayout(new FlowLayout());

        p[4].add(p[5], BorderLayout.SOUTH);
        p[4].add(p[6], BorderLayout.CENTER);

        b[2].setText("Pizza");
        p[5].add(b[2]);
        b[3].setText("Biscuits");
        p[5].add(b[3]);
        b[4].setText("Sandwitch");
        p[5].add(b[4]);
        b[5].setText("Normal Cakes");
        p[5].add(b[5]);
        b[6].setText("CupCakes");
        p[5].add(b[6]);
        b[7].setText("Featured");
        p[5].add(b[7]);
        t3 = new JTextField(20);
        b[12].setText("Search Product");
        //b[8].setText("CheckOut");
        p[5].add(t3);

        p[5].add(b[12]);

        l1 = new JLabel("Categories");
        l1.setForeground(java.awt.Color.pink);

        f.isTransformed();
        //l1.setBackground(java.awt.Color.RED);
        l1.setFont(f);
        p[6].add(l1);

        p[7].setLayout(new BorderLayout());

        p[8].setLayout(new GridLayout(50, 1));
        sc = new JScrollPane(p[8], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        for (int i = 0; i < list.size(); i++) {
            displaytext[i] = new JTextField();
            displaytext[i].setEditable(false);
            displaytext[i].setBackground(java.awt.Color.LIGHT_GRAY);
            displaytext[i].setFont(f1);
            displaytext[i].setText("Name : " + list.get(i).getName() + " \tID : " + list.get(i).getId() + " \tQuantity : " + list.get(i).getQuantity() + " \t Price : " + list.get(i).getPrice());
            p[8].add(displaytext[i]);
        }
        p[7].add(sc);

        p[0].add(p[7], BorderLayout.CENTER);

    }

    public Categories(String cat) throws HeadlessException {

        super("Product Categories");
        setLayout(new BorderLayout());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        //setLocation(180,50);
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
        p[3].setLayout(new FlowLayout());
        b[0].setText("Add to Cart");
        b[1].setText("Add to Wishlist");
        b[9].setText("Back");
        t1 = new JTextField(20);
        t2 = new JTextField(20);

        p[2].add(t1);
        p[2].add(b[0]);
        p[3].add(t2);
        p[3].add(b[1]);
        p[3].add(b[9]);

        p[1].add(p[2]);
        p[1].add(p[3]);
        p[0].add(p[1], BorderLayout.SOUTH);

        p[4].setLayout(new BorderLayout());

        p[0].add(p[4], BorderLayout.NORTH);

        p[5].setLayout(new FlowLayout());
        p[6].setLayout(new FlowLayout());

        p[4].add(p[5], BorderLayout.SOUTH);
        p[4].add(p[6], BorderLayout.CENTER);

        b[2].setText("Pizza");
        p[5].add(b[2]);
        b[3].setText("Biscuits");
        p[5].add(b[3]);
        b[4].setText("Sandwitch");
        p[5].add(b[4]);
        b[5].setText("NormalCakes");
        p[5].add(b[5]);
        b[6].setText("CupCakes");
        p[5].add(b[6]);
        b[7].setText("Featured");
        p[5].add(b[7]);
        t3 = new JTextField(20);
        b[12].setText("Search Product");
        //b[8].setText("CheckOut");
        p[5].add(t3);

        p[5].add(b[12]);

        l1 = new JLabel("Categories");
        l1.setForeground(java.awt.Color.pink);

        f.isTransformed();
        //l1.setBackground(java.awt.Color.RED);
        l1.setFont(f);
        p[6].add(l1);

        p[7].setLayout(new BorderLayout());

        p[8].setLayout(new GridLayout(50, 1));
        sc = new JScrollPane(p[8], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        for (int i = 0; i < list.size(); i++) {
            if (cat.equalsIgnoreCase("")) {
                if (Products.readAllData().get(i).isFeatured()) {

                displaytext[i] = new JTextField();
                displaytext[i].setEditable(false);
                displaytext[i].setBackground(java.awt.Color.LIGHT_GRAY);
                displaytext[i].setFont(f1);
                displaytext[i].setText("Name : " + list.get(i).getName() + " \tID : " + list.get(i).getId() + " \tQuantity : " + list.get(i).getQuantity() + " \t Price : " + list.get(i).getPrice());
                p[8].add(displaytext[i]);
            }}
            
            if (Products.readAllData().get(i).getCategory().equalsIgnoreCase(cat)) {

                displaytext[i] = new JTextField();
                displaytext[i].setEditable(false);
                displaytext[i].setBackground(java.awt.Color.LIGHT_GRAY);
                displaytext[i].setFont(f1);
                displaytext[i].setText("Name : " + list.get(i).getName() + " \tID : " + list.get(i).getId() + " \tQuantity : " + list.get(i).getQuantity() + " \t Price : " + list.get(i).getPrice());
                p[8].add(displaytext[i]);
            }
        }
        p[7].add(sc);

        p[0].add(p[7], BorderLayout.CENTER);

    }

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Add to Cart")) {


                if (operations.islistContainID(t1.getText(), Products.readAllData())) {
                    try {

                        if (operations.isclistContainID(t1.getText(), Cartj.readAllData())) {
                            JOptionPane.showMessageDialog(new JFrame(), "Item already in cart");
                            t1.setText("");

                        } else {
                            ArrayList<Products> p5 = Products.readAllData();
                            int con = 0;
                            for (Products p1 : p5) {
                                if (t1.getText().equals(p1.getId())) {
                                    if (p1.getQuantity() <= 0) {

                                        JOptionPane.showMessageDialog(new JFrame(), "Item is Out of Stock");
                                        break;

                                    }

                                    if (p1.getClass().toString().contains("Pizza")) {
                                        Pizza pz = (Pizza) p1;
                                        String size = JOptionPane.showInputDialog(new JFrame(), "Enter Pizza Size\nS | M | L");
                                        try {
                                            pz.setSize(size);
                                        } catch (InvalidPizzaSizeException ex) {
                                            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                                            break;
                                        }

                                    }
                                    if (p1.getClass().toString().contains("NormalCakes")) {
                                        NormalCakes nc = (NormalCakes) p1;
                                        String pou = JOptionPane.showInputDialog(new JFrame(), "Enter Weight in Pounds");
                                        int pounds = Integer.parseInt(pou);
                                        try {
                                            nc.setWeight(pounds);
                                        } catch (InvalidCakeSizeException ex) {
                                            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                                            break;
                                        }

                                    }
                                    String q = JOptionPane.showInputDialog(new JFrame(), "Enter Quantity");
                                    int quantity = Integer.parseInt(q);
                                    operations.isQuantityAvailable(quantity, t1.getText(), p5);
                                    Cartj.writeObjectToFile(new Cartj(p1, quantity));
                                    operations.updateQuantity(t1.getText(), quantity, p5);
                                    JOptionPane.showMessageDialog(new JFrame(), p1.name + " Added in cart");

                                    break;
                                }

                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
                        t1.setText("");

                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Id");
                    t1.setText("");
                }
            }
            if (ae.getActionCommand().equalsIgnoreCase("Add to Wishlist")) {

                if (operations.islistContainID(t2.getText(), Products.readAllData())) {
                    try {

                        if (operations.isclistContainID(t2.getText(), Cartj.readAllData())) {
                            JOptionPane.showMessageDialog(new JFrame(), "Item already in cart");
                            t2.setText("");

                        } else {
                            ArrayList<Products> p5 = Products.readAllData();
                            int con = 0;
                            for (Products p1 : p5) {
                                if (t2.getText().equals(p1.getId())) {
                                    if (p1.getClass().toString().contains("Pizza")) {
                                        Pizza pz = (Pizza) p1;
                                        String size = JOptionPane.showInputDialog(new JFrame(), "Enter Pizza Size\nS | M | L");
                                        try {
                                            pz.setSize(size);
                                        } catch (InvalidPizzaSizeException ex) {
                                            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                                            break;
                                        }

                                    }
                                    if (p1.getClass().toString().contains("NormalCakes")) {
                                        NormalCakes nc = (NormalCakes) p1;
                                        String pou = JOptionPane.showInputDialog(new JFrame(), "Enter Weight in Pounds");
                                        int pounds = Integer.parseInt(pou);
                                        try {
                                            nc.setWeight(pounds);
                                        } catch (InvalidCakeSizeException ex) {
                                            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                                            break;
                                        }

                                    }

                                    operations.writeObjectToWishlistFile(p1);

                                    JOptionPane.showMessageDialog(new JFrame(), p1.name + " Added in Wishlist");

                                    break;
                                } else {
                                    con++;
                                }

                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
                        t2.setText("");

                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Id");
                    t2.setText("");
                }

            }
            if (ae.getActionCommand().equalsIgnoreCase("Back")) {
                dispose();
                E_Commerce_Main_Runner e = new E_Commerce_Main_Runner();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Pizza")) {
                dispose();
                Categories e = new Categories("Pizza");
                e.setResizable(false);
                e.setResizable(true);
            }
            if (ae.getActionCommand().equalsIgnoreCase("Biscuits")) {
                 dispose();
                Categories e = new Categories("Biscuits");
                e.setResizable(false);
                e.setResizable(true);
            }
            if (ae.getActionCommand().equalsIgnoreCase("Sandwitch")) {
                 dispose();
                Categories e = new Categories("Sandwich");
                e.setResizable(false);
                e.setResizable(true);
            }
            if (ae.getActionCommand().equalsIgnoreCase("NormalCakes")) {
                 dispose();
                Categories e = new Categories("NormalCakes");
                e.setResizable(false);
                e.setResizable(true);
            }
            if (ae.getActionCommand().equalsIgnoreCase("CupCakes")) {
                 dispose();
                Categories e = new Categories("CupCakes");
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Featured")) {
                 dispose();
                Categories e = new Categories("");
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Search Product")) {
                   Search e = new Search(t3.getText());
                e.setResizable(false);
                e.setResizable(true);

            }

        }
    }

    public static void main(String[] args) {
        Categories e = new Categories();
        e.setResizable(false);
        e.setResizable(true);
    }

    public void Display() {

    }
}
