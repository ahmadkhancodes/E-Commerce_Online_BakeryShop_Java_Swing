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
        public class InvalidPizzaSizeException extends Exception {

        public InvalidPizzaSizeException() {
            super("This Pizza Size is not valid! Please Enter a valid size\n S for Small\n M for Medium\n L for Large");
        }
   
}
