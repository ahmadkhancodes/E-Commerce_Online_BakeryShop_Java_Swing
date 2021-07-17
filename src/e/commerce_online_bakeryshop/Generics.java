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
public class Generics {
    public static void main(String[] args) {
        System.out.println( Input(2, 3));
      
    }
    
      
        
        public static <T> boolean Input(T a, T b){
        if(a==b)
            return true;
        else
            return false;
        
        
        }
}
