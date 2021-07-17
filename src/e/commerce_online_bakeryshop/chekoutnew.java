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

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class chekoutnew implements Serializable {

    private String name;
    private String adress;
    //private ArrayList<Products> ProductforShipping;
    private ArrayList<Cartj> cartarr=new ArrayList<>();
    private PhoneNumber phone;
    private ValidEmail email;

    public chekoutnew() {
    }

    public chekoutnew(String name, String adress, ArrayList<Cartj> cart,PhoneNumber phone, ValidEmail email) {
        this.name = name;
        this.adress = adress;
        
        this.phone = phone;
        this.email = email;
        for(Cartj c:cart){
        cartarr.add(c);
        }

    }

    public String getName() {
        return name;
    }

    public ArrayList<Cartj> getCartarr() {
        return cartarr;
    }
    
    
    

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getPhone() {
        return phone.getPhone();
    }
    

    public double Bill() {
        double bill = 0;
        for (Cartj c:cartarr) {
           bill=bill+(c.getPrduct().CalCost()*c.getQuantity());
        }
        return bill;
    }




public static void writeObjectToFile(chekoutnew s) {
//Code for writing data to file
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<chekoutnew> orders = chekoutnew.readAllData();

// Append new object into existing list
            orders.add(s);

            outputStream = new ObjectOutputStream(new FileOutputStream("checkout.ser"));

// Write all objects (old and new one) into the file
            for (int i = 0; i < orders.size(); i++) {
                outputStream.writeObject(orders.get(i));
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

    public static ArrayList<chekoutnew> readAllData() {
//  ArrayList initialized with size 0
        ArrayList<chekoutnew> orders = new ArrayList<>(0);
// Input stream
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("checkout.ser"));
// End Of File flag
            boolean EOF = false;
// Keep reading file until file ends

            while (!EOF) {
                try {
// read object and type cast into CarDetails object

                    chekoutnew myObj = (chekoutnew) inputStream.readObject();
// add object into ArrayList
                    orders.add(myObj);
//System.out.println("Read: " + myObj.getName());
                } catch (ClassNotFoundException e) {
//System.out.println("Class not found");
                } catch (EOFException end) {
// EOFException is raised when file ends
// set End Of File flag to true so that loop exits
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
//System.out.println("Cannot find file");
        } catch (IOException e) {
//System.out.println("IO Exception while opening stream");
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
        return orders;
    }
    
    
    
}