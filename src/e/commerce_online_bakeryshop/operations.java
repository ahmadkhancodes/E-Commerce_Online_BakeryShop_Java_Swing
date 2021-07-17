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
import java.util.ArrayList;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class operations {

    public operations() {

    }

    public void Home(ArrayList<Products> p) {
        //showing all Products
        System.out.println("                        ** Products **                        ");
        for (Products p1 : p) {
            p1.Display();

        }
        //showing all featured products
        System.out.println("                        ** Featured Products **                        ");
        for (Products p2 : p) {
            if (p2.featured) {
                p2.Display();
            }
        }
    }

    public void ShopNow(ArrayList<Products> p) {
        //showing all Products
        for (Products p1 : p) {
            p1.Display();

        }
    }

    public static void DisplayProductCategories() {
        //showing all Categories
        System.out.println("Pizza");
        System.out.println("Biscuits");
        System.out.println("Sandwitch");
        System.out.println("NormalCakes");
        System.out.println("CupCakes");
        System.out.println("BestDeal");

    }

    public static void isCategoryTrue(String cat) throws InvalidProductCategoryException {
        if (cat.equalsIgnoreCase("Pizza") || cat.equalsIgnoreCase("NormalCakes") || cat.equalsIgnoreCase("Sandwich") || cat.equalsIgnoreCase("CupCakes") || cat.equalsIgnoreCase("Biscuits") || cat.equalsIgnoreCase("BestDeals")) {

        } else {
            throw new InvalidProductCategoryException();
        }

    }

    public static void idAlreadyExist(String s, ArrayList<Products> p8) throws IDAlreadyExist {
        for (Products list : p8) {
            if (list.getId().equals(s)) {
                throw new IDAlreadyExist();
               
            }
        }
    }

    public static void FilterProduct(String s, ArrayList<Products> p) {
        int con = 0;
        for (Products p1 : p) {
            if (s.equalsIgnoreCase(p1.getCategory())) {
                p1.Display();
            } else {
                con++;
            }
            if (con == p.size()) {
                System.out.println("Invalid Catogery or No Product Available in this Category");
            }
        }
    }

    public static String GetProductNameAgainstID(String id, ArrayList<Products> p) {
        int con = 0;
        String name = "";
        for (Products p1 : p) {
            if (id.equalsIgnoreCase(p1.getId())) {
                con++;
                name = p1.name;
                break;
            }
        }
        if (con > 0) {
            return name;
        } else {
            return "";
        }

    }

    public static String GetProductCategoryAgainstID(String id, ArrayList<Products> p) {
        int con = 0;
        String name = "";
        for (Products p1 : p) {
            if (id.equalsIgnoreCase(p1.getId())) {
                con++;
                name = p1.category;
                break;
            }
        }
        if (con > 0) {
            return name;
        } else {
            return "";
        }

    }

    public static boolean islistContainID(String i, ArrayList<Products> list) {
        int co = 0;
        for (Products w : list) {
            if (i.equalsIgnoreCase(w.getId())) {
                co++;
            }
        }
        if (co > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isclistContainID(String i, ArrayList<Cartj> list) {
        int co = 0;
        for (Cartj w : list) {
            if (i.equalsIgnoreCase(w.getPrduct().getId())) {
                co++;
            }
        }
        if (co > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void Wishlist(String id, ArrayList<Products> p5, ArrayList<Products> w) {

        if (islistContainID(id, w)) {
            System.out.println(GetProductNameAgainstID(id, p5) + " is Already in Wishlist");
        } else {
            int con = 0;
            for (Products p1 : p5) {
                if (id.equals(p1.getId())) {
                    w.add(p1);
                    System.out.println(" ~~~ " + p1.name + " Added to WishList ~~~ ");
                    break;
                } else {
                    con++;
                }
            }
            if (con == p5.size()) {
                System.out.println("Invalid ID");
            }
        }

    }

    public static void updateQuantity(String id, int cquan, ArrayList<Products> list) throws InvalidQuantityException, IOException {

        for (Products p1 : list) {
            if (id.equals(p1.getId())) {
                p1.setQuantity(cquan);

                break;
            }

        }
        Products.flushallData();
        for(Products pr:list){
        Products.writeObjectToFile(pr);
        }
        
        
    }

    public static void isQuantityAvailable(int q, String id, ArrayList<Products> list) throws qunatityLessException, InvalidProductIDException {
        int con = 0;

        for (Products p1 : list) {
            if (id.equalsIgnoreCase(p1.getId())) {
                con++;
                if (q <= p1.getQuantity()) {

                } else {
                    throw new qunatityLessException();
                }
                break;
            }
        }
        if (con > 0) {

        } else {
            throw new InvalidProductIDException();
        }

    }

    public static void writeObjectToWishlistFile(Products s) {
//Code for writing data to file
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<Products> ProductList = readWishlistAllData();

// Append new object into existing list
            ProductList.add(s);

            outputStream = new ObjectOutputStream(new FileOutputStream("Wishlist.ser"));

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

    public static void flushwishlistdata() throws IOException {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Wishlist.ser"));
            outputStream.flush();

        } catch (FileNotFoundException ex) {

        }

    }

    public static String deletewishlistproduct(String n, ArrayList<Products> list) {
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
            outputStream = new ObjectOutputStream(new FileOutputStream("Wishlist.ser"));

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

    public static ArrayList<Products> readWishlistAllData() {
//  ArrayList initialized with size 0
        ArrayList<Products> ProductList = new ArrayList<>(0);
// Input stream
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Wishlist.ser"));
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

    public static void Cart(int pounds, String id, String size, ArrayList<Products> p5, ArrayList<Products> c) throws InvalidCakeSizeException, InvalidPizzaSizeException, IDAlreadyExist {
        if (islistContainID(id, c)) {
            System.out.println(GetProductNameAgainstID(id, p5) + " is Already in Cart");
            idAlreadyExist(id, p5);
        } else {
            int con = 0;
            for (Products p1 : p5) {
                if (id.equals(p1.getId())) {
                    if (p1.getClass().toString().contains("Pizza")) {
                        Pizza pz = (Pizza) p1;
                        pz.setSize(size);
                        System.out.println("Your Pizza size is : " + pz.getSize());
                    }
                    if (p1.getClass().toString().contains("NormalCakes")) {
                        NormalCakes nc = (NormalCakes) p1;
                        nc.setWeight(pounds);
                        System.out.println("Your cake weight is : " + nc.getWeight() + " Pounds");
                    }
                    c.add(p1);
                    System.out.println(" ~~~ " + p1.name + " Added to Cart ~~~ ");
                    break;
                } else {
                    con++;
                }
            }
            if (con == p5.size()) {
                System.out.println("Invalid ID");
            }

        }
    }
//    public static void newCart(int quantity,int pounds, String id, String size, ArrayList<Products> p5, ArrayList<Products> c) throws InvalidCakeSizeException, InvalidPizzaSizeException, IDAlreadyExist {
//        if (islistContainID(id, c)) {
//            System.out.println(GetProductNameAgainstID(id, p5) + " is Already in Cart");
//            idAlreadyExist(id, p5);
//        } else {
//            int con = 0;
//            for (Products p1 : p5) {
//                if (id.equals(p1.getId())) {
//                    if (p1.getClass().toString().contains("Pizza")) {
//                        Pizza pz = (Pizza) p1;
//                        pz.setSize(size);
//                        System.out.println("Your Pizza size is : " + pz.getSize());
//                    }
//                    if (p1.getClass().toString().contains("NormalCakes")) {
//                        NormalCakes nc = (NormalCakes) p1;
//                        nc.setWeight(pounds);
//                        System.out.println("Your cake weight is : " + nc.getWeight() + " Pounds");
//                    }
//                    c.add(p1);
//                    System.out.println(" ~~~ " + p1.name + " Added to Cart ~~~ ");
//                    break;
//                } else {
//                    con++;
//                }
//            }
//            if (con == p5.size()) {
//                System.out.println("Invalid ID");
//            }
//
//        }
//    }

//      public Products GetProductAgainstID(String id, ArrayList<Products> p) {
//        Products copy=null;
//        boolean con=false;
//        for (Products p1 : p) {
//            if (id.equalsIgnoreCase(p1.getId())) {
//                con=true;
//                try {
//                    copy=(Products) p1.clone();
//                } catch (CloneNotSupportedException ex) {
//                    Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                break;
//            }
//        }
//        if (con) {
//            return copy;
//        } else {
//            return null;
//        }
//
//    }
    public static String RemoveProductAgainstID(String id, ArrayList<Products> p) {
        String name = "";
        for (Products p1 : p) {
            if (id.equalsIgnoreCase(p1.getId())) {
                p.remove(p1);
                name = p1.name;
                break;

            }
        }
        return name;

    }

    public static void RemoveProductFromList(String ide, ArrayList<Products> list) {
        if (islistContainID(ide, list)) {
            RemoveProductAgainstID(ide, list);
        } else {
            System.out.println("Item  Not Present");
        }
    }

    public static String MakeProductFeaturedAgainstID(String id, ArrayList<Products> p) {
        String name = "";
        for (Products p1 : p) {
            if (id.equalsIgnoreCase(p1.getId())) {
                p1.featured = true;
                name = p1.name;
                break;
            }
        }
        return name;
    }

}
