/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import static javafx.scene.input.KeyCode.S;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class Cartj implements Serializable {

    private Products prduct;
    private int quantity;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Cartj(Products prduct, int quantity) {
        this.prduct = prduct;
        this.quantity = quantity;
    }

    public Products getPrduct() {
        return prduct;
    }

    public Cartj() {
    }

    public static void writeObjectToFile(Cartj s) {
//Code for writing data to file
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<Cartj> ProductList = readAllData();

// Append new object into existing list
            ProductList.add(s);

            outputStream = new ObjectOutputStream(new FileOutputStream("Cart.ser"));

// Write all objects (old and new one) into the file
            for (int i = 0; i < ProductList.size(); i++) {
                outputStream.writeObject(ProductList.get(i));
            }

        } catch (IOException exp) {
            System.out.println("IO Exception while opening file");
        } finally {
// cleanup code which closes output stream if its object was created
            try {
                if (outputStream != null) {
                    outputStream.close();
                    // flag of success

                }

            } catch (IOException exp) {
                System.out.println("IO Exception while closing file");
            }
        }

    }

    public static ArrayList<Cartj> readAllData() {
//  ArrayList initialized with size 0
        ArrayList<Cartj> ProductList = new ArrayList<>(0);
// Input stream
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Cart.ser"));
// End Of File flag
            boolean EOF = false;
// Keep reading file until file ends

            while (!EOF) {
                try {
// read object and type cast into CarDetails object

                    Cartj myObj = (Cartj) inputStream.readObject();
// add object into ArrayList
                    ProductList.add(myObj);
//System.out.println("Read: " + myObj.getName());
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found");
                } catch (EOFException end) {
// EOFException is raised when file ends
// set End Of File flag to true so that loop exits
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file");
        } catch (IOException e) {
            System.out.println("IO Exception while opening stream");
//e.printStackTrace();
        } finally { // cleanup code to close stream if it was opened
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
// TODO Auto-generated catch block
                System.out.println("IO Exception while closing file");
            }
        }
// returns ArrayList
        return ProductList;
    }

    public static String deletecartproduct(String n, ArrayList<Cartj> list) {
        String name = "";
        for (Cartj w : list) {
            if (n.equalsIgnoreCase(w.getPrduct().getId())) {

                Products.increaseQuan(w.getPrduct(), w.getQuantity());

                list.remove(w);
                name = w.getPrduct().name;
                break;
            }
        }
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects

// Append new object into existing list
            outputStream = new ObjectOutputStream(new FileOutputStream("Cart.ser"));

// Write all objects (old and new one) into the file
            for (int i = 0; i < list.size(); i++) {
                outputStream.writeObject(list.get(i));
            }

        } catch (IOException exp) {
            System.out.println("IO Exception while opening file");
        } finally {
// cleanup code which closes output stream if its object was created
            try {
                if (outputStream != null) {
                    outputStream.close();
                    // flag of success

                }

            } catch (IOException exp) {
                System.out.println("IO Exception while closing file");
            }
        }
        return name;

    }

    public static void flushallData() throws IOException {

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Cart.ser"));
            outputStream.flush();

        } catch (FileNotFoundException ex) {

        }

    }
}
