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
public class Admin {
    private String username;
    private String password;
    private final  StringBuffer actualPass=new StringBuffer("admin");
    private final StringBuffer actualuser=new StringBuffer("admin");
    private final boolean details;
    public Admin(String username, String password) {
        if(username.equals(actualuser.toString()) && password.equals(actualPass.toString())){
        this.username = username;
        this.password = password;
        this.details=true;
        }
        else{
            this.details=false;
        }
           
    }
    public void setUserNameandPassword(String username, String password){
    actualPass.replace(0, actualPass.length(), username);
    actualuser.replace(0, actualuser.length(), password);
        System.out.println("Your new UserName is : "+actualuser);
        System.out.println("Your new Password is : "+actualPass);
    }
    
   public boolean getDetails(){
   return details;
   }
 
   
   


}
