/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import java.io.Serializable;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class Pizza extends Products  implements Serializable{
    private String size;
    public Pizza() {
    }

    public Pizza(String size,String name, String id, double price, String category, boolean featured,int q) throws InvalidPriceException,InvalidPizzaSizeException, InvalidQuantityException {
        super(name, id, price, category, featured,q);
        if(size.equalsIgnoreCase("s") || size.equalsIgnoreCase("M")  || size.equalsIgnoreCase("L")){
    this.size=size;}
        else
        {
        throw new InvalidPizzaSizeException();
        }
    }
    

    @Override
    public void Display() {
        System.out.println("*************************");
        System.out.println(name);
        System.out.println("Small :" + price);
        System.out.println("Medium :" + (price+250));
        System.out.println("Large :" + (price + 400));
        System.out.println("Product ID : " + id);
        System.out.println("Catogery : " + category);
        System.out.println("*************************");

    }

    public void setSize(String size) throws InvalidPizzaSizeException {
   if(size.equalsIgnoreCase("s") || size.equalsIgnoreCase("M")  || size.equalsIgnoreCase("L")){
    this.size=size;}
        else
        {
        throw new InvalidPizzaSizeException();
        }
    }

    public String getSize() {
        return size;
    }
    

    public double CalCost() {
        double amount=0;
        if (size.equalsIgnoreCase("S")) {
            amount=price;
            return amount;
        }
        if (size.equalsIgnoreCase("M")) {
            amount= price + 250;
            return amount;
        }
        if (size.equalsIgnoreCase("L")) {
            amount= price + 400;
            return amount;
        } else {
            System.out.println("Invalid Size");
        }
        return 0;

    }

    
}
