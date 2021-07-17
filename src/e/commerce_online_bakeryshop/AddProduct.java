/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import java.awt.Color;
import java.awt.Font;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class AddProduct extends JFrame {

    Font f, f1, f2, f3, f4;
    JPanel p1;
    JLabel imagelabel, l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    ImageIcon image = new ImageIcon("choco.jpg");
    JCheckBox box, cf;

    public AddProduct() throws HeadlessException {

        super("Add Product");
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        //setLocation(180, 50);
        setVisible(true);
        //fonts
        f = new Font("Comic Sans MS", Font.BOLD, 50);
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

        p1.setBackground(new Color(0, 0, 0, 150));

        p1.setBounds(82, 50, 1200, 650);
        imagelabel.add(p1);

        //header
        l1 = new JLabel("Add Product");

        l1.setFont(f);
        l1.setForeground(Color.WHITE);
        l1.setBounds(450, -30, 300, 150);
        p1.add(l1);

        //buttons
        b1 = new JButton("Pizza");
        b1.setForeground(Color.white);
        b1.setBackground(new Color(205, 133, 63));
        b1.setFont(f1);
        b1.setBounds(160, 120, 120, 40);
        p1.add(b1);

        b2 = new JButton("Biscuits");
        b2.setForeground(Color.white);
        b2.setBackground(new Color(205, 133, 63));
        b2.setFont(f1);
        b2.setBounds(310, 120, 120, 40);
        p1.add(b2);

        b3 = new JButton("Sandwich");
        b3.setForeground(Color.white);
        b3.setBackground(new Color(205, 133, 63));
        b3.setFont(f1);
        b3.setBounds(460, 120, 120, 40);
        p1.add(b3);

        b4 = new JButton("NormalCakes");
        b4.setForeground(Color.white);
        b4.setBackground(new Color(205, 133, 63));
        b4.setFont(f1);
        b4.setBounds(610, 120, 125, 40);
        p1.add(b4);

        b5 = new JButton("CupCakes");
        b5.setForeground(Color.white);
        b5.setBackground(new Color(205, 133, 63));
        b5.setFont(f1);
        b5.setBounds(760, 120, 120, 40);
        p1.add(b5);

        b6 = new JButton("BestDeals");
        b6.setForeground(Color.white);
        b6.setBackground(new Color(205, 133, 63));
        b6.setFont(f1);
        b6.setBounds(910, 120, 120, 40);
        p1.add(b6);

        //otherLabels
        l2 = new JLabel("Enter Product Name");
        l2.setBounds(310, 200, 200, 50);
        l2.setFont(f2);
        l2.setForeground(Color.white);
        p1.add(l2);

        l3 = new JLabel("Enter Product ID");
        l3.setBounds(310, 280, 200, 50);
        l3.setFont(f2);
        l3.setForeground(Color.white);
        p1.add(l3);

        l4 = new JLabel("Product Categorey");
        l4.setBounds(310, 360, 200, 50);
        l4.setFont(f2);
        l4.setForeground(Color.white);
        p1.add(l4);

        l5 = new JLabel("Enter Product Price");
        l5.setBounds(310, 440, 200, 50);
        l5.setFont(f2);
        l5.setForeground(Color.white);
        p1.add(l5);

        l6 = new JLabel("Featured ");
        l6.setBounds(300, 505, 200, 50);
        l6.setFont(f2);
        l6.setForeground(Color.white);
        p1.add(l6);

        l7 = new JLabel("Centerly Filled ");
        l7.setEnabled(false);
        l7.setBounds(470, 505, 200, 50);
        l7.setFont(f2);
        l7.setForeground(Color.white);
        p1.add(l7);

        l8 = new JLabel("Quantity");

        l8.setBounds(670, 505, 180, 50);
        l8.setFont(f2);
        l8.setForeground(Color.white);
        p1.add(l8);

        //cheakbox
        box = new JCheckBox();
        box.setBounds(420, 510, 30, 35);
        box.setBackground(new Color(0, 0, 0, 10));
        p1.add(box);

        cf = new JCheckBox();
        cf.setEnabled(false);
        cf.setBounds(630, 510, 30, 35);
        cf.setBackground(new Color(0, 0, 0, 10));
        p1.add(cf);

//textfields
        t1 = new JTextField();
        t1.setBounds(570, 210, 300, 35);
        t1.setFont(f2);
        t1.setForeground(Color.DARK_GRAY);
        t1.setBackground(Color.WHITE);
        p1.add(t1);

        t2 = new JTextField();
        t2.setBounds(570, 290, 300, 35);
        t2.setFont(f2);
        t2.setForeground(Color.DARK_GRAY);
        t2.setBackground(Color.WHITE);
        p1.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setBounds(570, 370, 300, 35);
        t3.setFont(f2);
        t3.setForeground(Color.DARK_GRAY);
        t3.setBackground(Color.WHITE);
        p1.add(t3);

        t4 = new JTextField();
        t4.setBounds(570, 450, 300, 35);
        t4.setFont(f2);
        t4.setForeground(Color.DARK_GRAY);
        t4.setBackground(Color.WHITE);
        p1.add(t4);

        t5 = new JTextField();
        t5.setBounds(780, 505, 80, 50);
        t5.setFont(f2);
        t5.setForeground(Color.DARK_GRAY);
        t5.setBackground(Color.WHITE);
        p1.add(t5);

//savebutton;
        b7 = new JButton("Add");
        b7.setForeground(Color.white);
        b7.setBackground(new Color(205, 133, 63));
        b7.setFont(f3);
        b7.setBounds(430, 570, 400, 50);
        p1.add(b7);

//BackButton
        b8 = new JButton("Back");
        b8.setForeground(Color.white);
        b8.setBackground(new Color(139, 69, 19));
        b8.setFont(f1);
        b8.setBounds(10, 10, 100, 40);
        p1.add(b8);
//extra labels

//ActionListener
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

    }

    class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Add")) {
                if (t1.getText().isEmpty() && t2.getText().isEmpty() && t3.getText().isEmpty() && t4.getText().isEmpty() && t5.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Fields Cannot be Empty");
                } else {
                    try {
                 
               
                        String cat = t3.getText();
                        operations.isCategoryTrue(cat);
                        if (cat.equalsIgnoreCase("Pizza")) {
                            String name = t1.getText();

                            String id = t2.getText();
                            operations.idAlreadyExist(id, Products.readAllData());
                            double pri = Double.parseDouble(t4.getText());
                            int quan = Integer.parseInt(t5.getText());

                            Products.writeObjectToFile(new Pizza("s", name, id, pri, "Pizza", box.isSelected(), quan));

                            JOptionPane.showMessageDialog(new JFrame(), t1.getText() + " Added");
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            box.setSelected(false);
                            cf.setSelected(false);
                        }
                        if (cat.equalsIgnoreCase("Biscuits")) {
                            String name = t1.getText();

                            String id = t2.getText();
                            operations.idAlreadyExist(id, Products.readAllData());

                            double pri = Double.parseDouble(t4.getText());
                            int quan = Integer.parseInt(t5.getText());
                            Products.writeObjectToFile(new Biscuits(1, name, id, pri, "Biscuits", box.isSelected(), quan));

                            JOptionPane.showMessageDialog(new JFrame(), t1.getText() + " Added");
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            box.setSelected(false);
                            cf.setSelected(false);

                        }
                        if (cat.equalsIgnoreCase("BestDeals")) {
                            String name = t1.getText();

                            String id = t2.getText();
                            operations.idAlreadyExist(id, Products.readAllData());
                            double pri = Double.parseDouble(t4.getText());
                            int quan = Integer.parseInt(t5.getText());
                            Products.writeObjectToFile(new BestDeals(name, id, pri, "BestDeals", box.isSelected(), quan));

                            JOptionPane.showMessageDialog(new JFrame(), t1.getText() + " Added");
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            box.setSelected(false);
                            cf.setSelected(false);
                        }
                        if (cat.equalsIgnoreCase("CupCakes")) {
                            String name = t1.getText();

                            String id = t2.getText();
                            operations.idAlreadyExist(id, Products.readAllData());
                            double pri = Double.parseDouble(t4.getText());
                            int quan = Integer.parseInt(t5.getText());
                            Products.writeObjectToFile(new CupCakes(cf.isSelected(), name, id, pri, "CupCakes", box.isSelected(), quan));

                            JOptionPane.showMessageDialog(new JFrame(), t1.getText() + " Added");
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            box.setSelected(false);
                            cf.setSelected(false);

                        }
                        if (cat.equalsIgnoreCase("NormalCakes")) {
                            String name = t1.getText();

                            String id = t2.getText();
                            operations.idAlreadyExist(id, Products.readAllData());
                            double pri = Double.parseDouble(t4.getText());
                            int quan = Integer.parseInt(t5.getText());
                            Products.writeObjectToFile(new NormalCakes(2, name, id, pri, "NormalCakes", box.isSelected(), quan));

                            JOptionPane.showMessageDialog(new JFrame(), t1.getText() + " Added");
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            box.setSelected(false);
                            cf.setSelected(false);
                        }
                        if (cat.equalsIgnoreCase("Sandwich")) {
                            String name = t1.getText();

                            String id = t2.getText();
                            operations.idAlreadyExist(id, Products.readAllData());
                            double pri = Double.parseDouble(t4.getText());
                            int quan = Integer.parseInt(t5.getText());
                            Products.writeObjectToFile(new Sandwich(name, id, pri, "Sandwich", box.isSelected(), quan));

                            JOptionPane.showMessageDialog(new JFrame(), t1.getText() + " Added");
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                            box.setSelected(false);
                            cf.setSelected(false);

                        }
                    } catch (Exception es) {
                        JOptionPane.showMessageDialog(new JFrame(), es.getMessage());
                    }
                }

            }

            if (ae.getActionCommand().equalsIgnoreCase("Back")) {
                dispose();
                AdminDash e = new AdminDash();
                e.setResizable(false);
                e.setResizable(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Pizza")) {
                t3.setText("Pizza");
                cf.setEnabled(false);
                l7.setEnabled(false);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Biscuits")) {
                t3.setText("Biscuits");
                cf.setEnabled(false);
                l7.setEnabled(false);

            }
            if (ae.getActionCommand().equalsIgnoreCase("Sandwich")) {
                t3.setText("Sandwich");
                cf.setEnabled(false);
                l7.setEnabled(false);
            }
            if (ae.getActionCommand().equalsIgnoreCase("NormalCakes")) {
                t3.setText("NormalCakes");
                cf.setEnabled(false);
                l7.setEnabled(false);
            }
            if (ae.getActionCommand().equalsIgnoreCase("CupCakes")) {
                t3.setText("CupCakes");
                cf.setEnabled(true);
                l7.setEnabled(true);

            }
            if (ae.getActionCommand().equalsIgnoreCase("BestDeals")) {
                t3.setText("BestDeals");
                cf.setEnabled(false);
                l7.setEnabled(false);
            }

        }
    }

    public static void main(String[] args) {
        AddProduct e = new AddProduct();
        e.setResizable(false);
        e.setResizable(true);
    }

}
