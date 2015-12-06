/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author SofySmo
 */

import java.awt.Image;

public class Person {
    String Name;
    String Surname;
    String Email;
    String Password;
    Image Avatar;
    
    public void  setName(String name){Name=name;}
    public void  setSurname(String surname){Surname=surname;}
    public void  setEmail(String email){ Email=email;}
    public void setPassword(String password){Password=password;}
    public void setAvatar(Image avatar){Avatar=avatar;}
    
    public String getName(){return Name;}
    public String getSurname(){return Surname;}
    public String getEmail(){return Email;}
    public String getPassword(){return Password;}
    public Image getAvatar(){return Avatar;}
}
