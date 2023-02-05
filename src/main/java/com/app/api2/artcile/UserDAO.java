/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.api2.artcile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class UserDAO {
   Connection con = null;
   PreparedStatement pst= null;
   ResultSet rs= null;
    public UserDAO(){
    super(); 
    }
public List<User> getUser(){
    
         List<User> liste = new ArrayList<>();
         try{
         pst = con.prepareStatement("select * from login ");
         rs = pst.executeQuery();
         while(rs.next()){
            User u = new User();
            u.setId(rs.getString("id"));
            u.setMdp(rs.getString("mdp"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setProducteur(rs.getBoolean("producteur"));
            u.setMagasinier(rs.getBoolean("magasinier"));
            u.setNettoyeur(rs.getBoolean("nettoyeur"));
            u.setControleur(rs.getBoolean("controleur"));
            u.setAdmin(rs.getBoolean("admin"));
            liste.add(u);
                          }
         }catch(Exception exp){
             System.out.println(exp);
         }
         return liste;
          
   
     }
    public void ajouterUser(User u){
            Object userScroll=null;
            String sql = "insert into login(id, mdp,nom, prenom, email, producteur, magasinier, nettoyeur, controleur, admin)"+" Values (?,?,?,?,?,?,?,?,?,?)";
            try {
            pst=con.prepareStatement(sql);
            pst.setString(1,u.getId());
            pst.setString(2, u.getMdp());
            pst.setString(3,u.getNom());
            pst.setString(4, u.getPrenom());
            pst.setString(5, u.getEmail());
            if(userScroll.equals("Producteur")){
            pst.setBoolean(6,u.isProducteur());                  }
            else if(userScroll.equals("Magasinier")){
            pst.setBoolean(7,u.isMagasinier());                    }
            else if(userScroll.equals("Nettoyeur")){
            pst.setBoolean(8, u.isNettoyeur());                   }
            else if(userScroll.equals("Controleur")){
            pst.setBoolean(9, u.isControleur());                   }
            else{
            pst.setBoolean(10, u.isAdmin());   }
            pst.executeQuery();
   } catch (Exception exp) {
            System.out.println(exp);
        }  
       getUser();
   }
    
     public void supprimerUser(String id){
      
      String sql = "Delete from login where id=?";
      User u;
      u = new User();
      try{ 
      pst = con.prepareStatement(sql);
      pst.setString(1,u.getId());
      pst.executeQuery();
        }
        catch (Exception exp) {
            System.out.println(exp);
                }  
       getUser();
    }
     
     public void modifierUser(User u){
         
      String sql = "Update login set mdp, nom, prenom, email, producteur, magasinier, nettoyeur, controleur, admin"+"VALUES (?,?,?,?,?,?,?,?,?)"+" where id=?";
      Object userScroll=null;
        try {
            pst=con.prepareStatement(sql);
             pst.setString(1,u.getId());
            pst.setString(2, u.getMdp());
            pst.setString(3, u.getNom());
            pst.setString(4, u.getPrenom());
            pst.setString(5, u.getEmail());
            if(userScroll.equals("producteur")){
            pst.setBoolean(6,u.isProducteur());                  }
            else if(userScroll.equals("magasinier")){
            pst.setBoolean(7,u.isMagasinier());                    }
            else if(userScroll.equals("nettoyeur")){
            pst.setBoolean(8, u.isNettoyeur());                   }
            else if(userScroll.equals("controleur")){
            pst.setBoolean(9, u.isControleur());                   }
            else{
            pst.setBoolean(10, u.isAdmin());   }
            pst.executeQuery();
           
             } 
        catch (Exception exp) {
            System.out.println(exp);
        }
      getUser();
    }
     
     public void getUserbyid(String id){
       
         String sql = "select * from login where id= ?";
         try{
              pst = con.prepareStatement(sql);
             rs = pst.executeQuery();   
         while(rs.next()){
             User u = new User();
              pst.setString(1,u.getId());
            u.setMdp(rs.getString("mdp"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setProducteur(rs.getBoolean("producteur"));
            u.setMagasinier(rs.getBoolean("magasinier"));
            u.setNettoyeur(rs.getBoolean("nettoyeur"));
            u.setControleur(rs.getBoolean("controleur"));
            u.setAdmin(rs.getBoolean("admin"));
             
        
         }
         }catch(Exception exp){
             System.out.println(exp);
         }
     getUser();    
}
         public int checkUsertype(int c){
        String sql = "select * from login where id=?";
try{

    pst = con.prepareStatement(sql);
    User u = new User();
    pst.setString(1,u.getId());
    rs = pst.executeQuery(sql);
    while(rs.next()){
    if(rs.getBoolean(6)==true){
        c=1;
        
    } 
    else if(rs.getBoolean(7)==true){
        c=2;
    }
     else if(rs.getBoolean(8)==true){
        c=3;
    }
     else if(rs.getBoolean(9)==true){
        c=4;
    }
     else{
         c=5;
     }
        
    }
    con.close();
   }catch(Exception exp)
        {System.out.println(exp);
        }
return c;
}
   
    
} 

