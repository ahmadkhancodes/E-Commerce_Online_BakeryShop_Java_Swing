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
public class NormalCakes extends Cake implements Serializable {

    private int Weight;

    public NormalCakes() {
    }

    public NormalCakes(int WeightAvailable, String name, String id, double price, String category, boolean featured,int q) throws InvalidCakeSizeException, InvalidPriceException, InvalidQuantityException {
        super(name, id, price, category, featured,q);
         if (Weight <= 0 && Weight <= 30) {
            this.Weight = Weight;

        } else {
            throw new InvalidCakeSizeException();
        }
    }

    public void Display() {
        System.out.println("*************************");

        System.out.println(name);
        System.out.println("Product ID : " + id);
        System.out.println("Price Per Pound : " + price);
        System.out.println("Catogery : " + category);

        System.out.println("*************************");

    }

    public void setWeight(int Weight) throws InvalidCakeSizeException {
        if (Weight > 0 && Weight <= 30) {
            this.Weight = Weight;

        } else {
            throw new InvalidCakeSizeException();
        }
    }

    public int getWeight() {
        return Weight;
    }

    public double CalCost() {
        double amount = 0;
        if (Weight <= 30) {
            amount = price * Weight;
            return amount;
        } else {
            amount = 0;
            return amount;
        }
    }

    public int WeightAvailable() {
        return Weight;
    }

    public void setWeightAvailable(int MaximumWeightAvailable) {
        this.Weight = MaximumWeightAvailable;
    }

}
