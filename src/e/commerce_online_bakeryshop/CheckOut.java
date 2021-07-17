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
public class CheckOut implements Serializable {

    private String name;
    private String adress;
    //private ArrayList<Products> ProductforShipping;
    private Products[] prolist;
    private int[] quantity;
    private PhoneNumber phone;
    private ValidEmail email;

    public CheckOut() {
    }

    public CheckOut(String name, String adress, int[] quantit, PhoneNumber phone, ValidEmail email, ArrayList<Products> ProductforShip, Products[] p) {
        this.name = name;
        this.adress = adress;
        quantity = new int[ProductforShip.size()];
        prolist = new Products[ProductforShip.size()];
        for (int i = 0; i < quantit.length; i++) {
            this.quantity[i] = quantit[i];
            this.prolist[i] = p[i];
        }
        this.phone = phone;
        this.email = email;

    }

    public String getName() {
        return name;
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

    public void Display() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Shipping Details");
        System.out.println("Name : " + name);
        System.out.println("Address : " + adress);
        System.out.println("Phone Number : " + getPhone());
        System.out.println("Email : " + getEmail());
        for (int i = 0; i < quantity.length; i++) {
            if (prolist[i].getClass().toString().contains("Pizza")) {
                Pizza pz = (Pizza) prolist[i];
                pz.getSize();
                System.out.println("Your Pizza size is : " + pz.getSize());

            }
            if (prolist[i].getClass().toString().contains("NormalCakes")) {
                NormalCakes nc = (NormalCakes) prolist[i];
                nc.getWeight();
                System.out.println("Your cake weight is : " + nc.getWeight() + " Pounds");
            }
            System.out.println(prolist[i].name + " x " + quantity[i] + " = " + (prolist[i].CalCost()) * (quantity[i]));

        }
        System.out.println("Total  : " + Bill());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public double Bill() {
        double bill = 0;
        for (int i = 0; i < quantity.length; i++) {
            bill = bill + ((prolist[i].CalCost()) * (quantity[i]));
        }
        return bill;
    }

    public void printRecipt() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int i = 0; i < quantity.length; i++) {
            System.out.println(prolist[i].name + " x " + quantity[i] + " = " + (prolist[i].CalCost()) * (quantity[i]));
        }
        System.out.println("Total  : " + Bill());
        System.out.println("We have Recieved Your Order ");
        System.out.println("Thanks for Visiting...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");

    }



public static void writeObjectToFile(CheckOut s) {
//Code for writing data to file
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<CheckOut> orders = readAllData();

// Append new object into existing list
            orders.add(s);

            outputStream = new ObjectOutputStream(new FileOutputStream("SL.ser"));

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

    public static ArrayList<CheckOut> readAllData() {
//  ArrayList initialized with size 0
        ArrayList<CheckOut> orders = new ArrayList<CheckOut>(0);
// Input stream
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("SL.ser"));
// End Of File flag
            boolean EOF = false;
// Keep reading file until file ends

            while (!EOF) {
                try {
// read object and type cast into CarDetails object

                    CheckOut myObj = (CheckOut) inputStream.readObject();
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