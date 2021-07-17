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
public class InvalidProductIDException extends Exception  {

        public InvalidProductIDException() {
            super("You have Entered Invalid Product ID");
        }
   
}
