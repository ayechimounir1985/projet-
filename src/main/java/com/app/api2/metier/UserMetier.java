/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.api2.metier;

import com.app.api2.artcile.User;
import com.app.api2.artcile.UserDAO;
import java.util.List;

/**
 *
 * @author user
 */
public class UserMetier{

     private final UserDAO udao= new UserDAO();
        public List<User> getUser(){
        return udao.getUser();
        }
       
        public void ajouterUser(User u){
         udao.ajouterUser(u);
        }
        public void supprimerUser(String id){
         udao.supprimerUser(id);
        }
        public void modifierUser(User u){
          udao.modifierUser(u);
        }
        public void getUserbyid(String id){
            udao.getUserbyid(id);
        }
        public int checkUsertype(int c){
            return udao.checkUsertype(c);
        }
        
        
}
