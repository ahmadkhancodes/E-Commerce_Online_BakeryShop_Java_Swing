/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

/**
 *
 * @author Muhammad Ahmad Khan
 */
public class IDAlreadyExist extends Exception {

    public IDAlreadyExist() {
    super("This ID Already Exist, Please Enter another ID");
    }
    
}
