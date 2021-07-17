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
public class Sandwich extends Products  implements Serializable{

    public Sandwich() {

    }

    public Sandwich(String name, String id, double price, String category, boolean featured,int q) throws InvalidPriceException, InvalidQuantityException {
        super(name, id, price, category, featured,q);
    }

    @Override
    public void Display() {
        System.out.println("*************************");
        System.out.println(name);
        System.out.println("Product ID : " + id);
        System.out.println("Price  : " + price);
        System.out.println("Catogery : " + category);
        System.out.println("*************************");

    }

    public double CalCost() {
        double amount = 0;
        amount = price;
        return amount;
    }
}
