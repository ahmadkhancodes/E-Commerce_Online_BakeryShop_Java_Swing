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
public class PhoneNumber implements Serializable {
    private String phone;

    public PhoneNumber(String phone) throws InvalidPhoneNumberException {
        if((phone.length()==11 && phone.startsWith("03")) || (phone.length()==12 && phone.startsWith("92")) || (phone.length()==13 && phone.startsWith("+92"))){
        this.phone = phone;}
    
    else
    throw new InvalidPhoneNumberException();
    
}

    public void setPhone(String phone) throws InvalidPhoneNumberException {
           if((phone.length()==11 || phone.length()==12 || phone.length()==13) && (phone.startsWith("03") || phone.startsWith("92")) || phone.startsWith("+92")){
        this.phone = phone;}
    
    else
    throw new InvalidPhoneNumberException();
    }

    public String getPhone() {
        return phone;
    }

}
