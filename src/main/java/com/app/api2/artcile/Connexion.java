/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.api2.artcile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class Connexion {
    
    public boolean getConnexion (boolean conx){
   Connection con = null;
   PreparedStatement pst;
   ResultSet rs;
    User u =new User();
     try{
        String url = "jdbc:mysql://localhost:3306/mydata";
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection(url,"root","Zoubaida@3othmeni");
        String sql = "Select * from login";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        if(u.getId().equals(rs.getString(1))&&u.getMdp().equals(rs.getString(2))){
           System.out.println("connexion établie");
           u.setNom(rs.getString(3));
           u.setPrenom(rs.getString(4));
           u.setEmail(rs.getString(5));
           u.setProducteur(rs.getBoolean(6));
           u.setMagasinier(rs.getBoolean(7));
           u.setNettoyeur(rs.getBoolean(8));
           u.setControleur(rs.getBoolean(9));
           u.setAdmin(rs.getBoolean(10));
    conx=true;
        }
        else{
            System.out.println("connexion échouée");
        }
    }catch(Exception exp)
       {System.out.println(exp);   
       }
    return conx; 
    
}
    
    
}
