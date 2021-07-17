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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public abstract class Products implements Serializable {

    protected int quantity;
    protected String name;
    protected String id;
    protected double price;
    protected String category;
    protected boolean featured;

    public Products() {
        name = "none";
        id = "none";
        price = 0;
        category = "none";
        featured = false;
    }

    public boolean isFeatured() {
        return featured;
    }
    

    public Products(String name, String id, double pric, String category, boolean featured, int q) throws InvalidPriceException, InvalidQuantityException {
        if (q > 0) {
            this.quantity = q;
        } else {
            throw new InvalidQuantityException();
        }
        this.name = name;
        this.id = id;
        if (pric < 50) {
            throw new InvalidPriceException();
        } else {
            this.price = pric;
        }
        this.category = category;
        this.featured = featured;
    }

    public abstract void Display();

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
    
    

    public void setQuantity(int quantity) {
        if (quantity <= getQuantity() && quantity > 0) {
            if (quantity - getQuantity() != 0) {
                  this.quantity = getQuantity()-quantity;
            

            }
            else{
                this.quantity=0;
                //Products.delete(idd, Products.readAllData());
            }
            
           
          }
        
        
        
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double CalCost();

    public static void writeObjectToFile(Products s) {
//Code for writing data to file
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<Products> ProductList = readAllData();

// Append new object into existing list
            ProductList.add(s);

            outputStream = new ObjectOutputStream(new FileOutputStream("Products.ser"));

// Write all objects (old and new one) into the file
            for (int i = 0; i < ProductList.size(); i++) {
                outputStream.writeObject(ProductList.get(i));
            }

        } catch (IOException exp) {

        } finally {
// cleanup code which closes output stream if its object was created
            try {
                if (outputStream != null) {
                    outputStream.close();
                    // flag of success

                }

            } catch (IOException exp) {

            }
        }

    }
    public static void increaseQuan(Products p,int q){
    p.setQuantity(q+p.getQuantity());
    Products temp=p;
    Products.delete(p.getId(), Products.readAllData());
    Products.writeObjectToFile(temp);
    }

    public static ArrayList<Products> readAllData() {
//  ArrayList initialized with size 0
        ArrayList<Products> ProductList = new ArrayList<>(0);
// Input stream
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Products.ser"));
// End Of File flag
            boolean EOF = false;
// Keep reading file until file ends

            while (!EOF) {
                try {
// read object and type cast into CarDetails object

                    Products myObj = (Products) inputStream.readObject();
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
        }    finally { // cleanup code to close stream if it was opened
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

    public static String delete(String n, ArrayList<Products> list) {
        String name = "";
        for (Products w : list) {
            if (n.equalsIgnoreCase(w.getId())) {
                list.remove(w);
                name = w.name;
                break;
            }
        }
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects

// Append new object into existing list
            outputStream = new ObjectOutputStream(new FileOutputStream("Products.ser"));

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
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Products.ser"));
            outputStream.flush();

        } catch (FileNotFoundException ex) {

        }

    }

}
