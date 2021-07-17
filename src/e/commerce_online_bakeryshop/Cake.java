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
public abstract class Cake extends Products  implements Serializable{

    public Cake() {
        super();
    }

    public Cake(String name, String id, double price, String category, boolean featured,int q) throws InvalidPriceException, InvalidQuantityException {
        super(name, id, price, category, featured,q);
    }

}
