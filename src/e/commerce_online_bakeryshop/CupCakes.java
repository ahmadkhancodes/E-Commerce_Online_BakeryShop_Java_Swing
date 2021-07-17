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
public class CupCakes extends Cake  implements Serializable{

    private boolean CentrelFilling;

    public CupCakes() {
    }

    public CupCakes(boolean CentrelFilling, String name, String id, double price, String category, boolean featured,int q) throws InvalidPriceException, InvalidQuantityException {
        super(name, id, price, category, featured,q);
        this.CentrelFilling = CentrelFilling;
    }

    public void Display() {
        System.out.println("*************************");
        System.out.println(name);
        System.out.println("Product ID : " + id);
        System.out.println("Price  : " + price);
        System.out.println("Catogery : " + category);
        System.out.println("Centrely Filled : " + CentrelFilling);
        System.out.println("*************************");

    }

    public double CalCost() {
        double amount = 0;
        if (CentrelFilling) {
            amount = price + 20;
            return amount;
        } else {
            amount = price;
            return amount;
        }
    }

}
