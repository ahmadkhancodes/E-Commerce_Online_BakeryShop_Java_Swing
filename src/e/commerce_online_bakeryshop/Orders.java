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
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class Orders extends JFrame {

    ArrayList<chekoutnew> list = chekoutnew.readAllData();
    //JTextField[] displaytext = new JTextField[list.size()];
    JPanel[] p = new JPanel[12];

    JTable jt;
    JLabel l1, l2;
    //JScrollPane sc;
    //ImageIcon image = new ImageIcon("choco.jpg");

    public Orders() throws HeadlessException {

        super("See Orders");
        setLayout(new BorderLayout());
        //setLocation(180, 50);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        setVisible(true);

        for (int i = 0; i < p.length; i++) {
            p[i] = new JPanel();
        }

        p[0].setLayout(new BorderLayout());
        //p[0].setBackground(java.awt.Color.pink);
        add(p[0], BorderLayout.CENTER);

        p[4].setLayout(new BorderLayout());
        p[0].add(p[4], BorderLayout.NORTH);

        p[6].setLayout(new FlowLayout());

        p[4].add(p[6], BorderLayout.CENTER);

        l1 = new JLabel("Orders Recieved");
        l1.setForeground(java.awt.Color.red);

        Font f = new Font("Serif", Font.BOLD, 70);
        Font f1 = new Font("Serif", Font.PLAIN, 15);
        Font f2 = new Font("Serif", Font.BOLD, 25);

        //l1.setBackground(java.awt.Color.RED);
        l1.setFont(f);
        p[6].add(l1);

        p[7].setLayout(new BorderLayout());


        String[] columns = {"Customer Name ", "Phone No", "Email", "Order Details", "Bill", "Address",};
        String[][] data = new String[list.size()][9];
        for (int i = 0; i < list.size(); i++) {

            data[i][0] = list.get(i).getName();
            data[i][1] = list.get(i).getPhone();
            data[i][2] = list.get(i).getEmail();
            for (Cartj c : list.get(i).getCartarr()) {
                data[i][3] = c.getPrduct().getName() + " x " + c.getQuantity() + " = " + c.getPrduct().CalCost() * c.getQuantity();

            }

            data[i][4] = String.valueOf(list.get(i).Bill());
            data[i][5] = list.get(i).getAdress();

        }
        jt = new JTable(data, columns) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        jt.getTableHeader().setBackground(new Color(0,0,0,100));
        jt.getTableHeader().setFont(f2);
        jt.setPreferredScrollableViewportSize(new Dimension(1266, 700));
        jt.setFillsViewportHeight(false);
        jt.setFont(f1);
        for (int i = 0; i < list.size(); i++) {
            jt.setRowHeight(i, 50);
        }
        JScrollPane jps = new JScrollPane(jt);
        p[7].add(jps);

        p[0].add(p[7], BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        Orders e = new Orders();
        e.setResizable(false);
        e.setResizable(true);
    }
}
