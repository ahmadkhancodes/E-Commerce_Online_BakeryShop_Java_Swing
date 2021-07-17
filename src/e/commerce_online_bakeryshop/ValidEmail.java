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
class ValidEmail implements Serializable{
    private String email;

    public ValidEmail(String email)throws InvalidEmailException {
    if(email.contains("@") && email.endsWith(".com")){
        this.email = email;
    }
    else
        throw new InvalidEmailException();
    
}

    public void setEmail(String email)throws InvalidEmailException {
       if(email.contains("@") && email.endsWith(".com")){
        this.email = email;
    }
    else
        throw new InvalidEmailException();
    }

    public String getEmail() {
        return email;
    }
    


}
