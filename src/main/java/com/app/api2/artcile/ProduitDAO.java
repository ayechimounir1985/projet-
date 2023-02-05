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
public class ProduitDAO {
    Connection con = null;
   PreparedStatement pst= null;
   ResultSet rs= null;
  
         public ProduitDAO(){
           super();
            }
     public List<Produit> getProduit(){
         String sql = "select * from cadre left join status on cadre.ref = status.ref";
         List<Produit> list = new ArrayList<>();
         try{
         pst = con.prepareStatement(sql);
         rs = pst.executeQuery();
        
         while(rs.next()){
             Produit p = new Produit();
                p.setRef(rs.getInt("ref"));
                p.setDesignation(rs.getString("designation"));
                p.setEmplacement(rs.getString("emplacement"));
                p.setProduction(rs.getInt("prod"));
                p.setNettoyage(rs.getBoolean("nett"));
                p.setControle(rs.getBoolean("cont"));
                p.setStockage(rs.getBoolean("stock"));
                p.setBlocage(rs.getBoolean("blok"));
                list.add(p);
         }
         }catch(Exception exp){
             System.out.println(exp);
         }
        
         
         return list; 
     }
     public void chercherProduit(int ref){
          String sql = "select * from cadre left join status on cadre.ref = status.ref where ref=?";
          try{
         pst = con.prepareStatement(sql);
         rs = pst.executeQuery();
        
         while(rs.next()){
             Produit p = new Produit();
                p.setRef(rs.getInt("ref"));
                p.setDesignation(rs.getString("designation"));
                p.setEmplacement(rs.getString("emplacement"));
                p.setProduction(rs.getInt("prod"));
                p.setNettoyage(rs.getBoolean("nett"));
                p.setControle(rs.getBoolean("cont"));
                p.setStockage(rs.getBoolean("stock"));
                p.setBlocage(rs.getBoolean("blok"));
         }
         }catch(Exception exp){
             System.out.println(exp);
         }
     }
      public void ajouterProduit(Produit p){
      
       String sql = "insert into cadre(ref, designation,emplacement)"+" Values (?,?,?)";
               try {
            pst=con.prepareStatement(sql);
            pst.setInt(1, p.getRef());
            pst.setString(2, p.getDesignation());
            pst.setString(3, p.getEmplacement());
            pst.executeQuery();
                           } catch (Exception exp) {
            System.out.println(exp);
        }
   Object StatusScroll=null;
        try{
         pst = con.prepareStatement("insert into status where ref=?");
            if(StatusScroll=="production"){
                pst.setInt(2, p.getProduction());                     }
            else if(StatusScroll=="nettoyage"){
            pst.setBoolean(3, p.isNettoyage());                  }
            else if(StatusScroll=="controle"){
            pst.setBoolean(4, p.isControle());                     }
            else if(StatusScroll=="stockage"){
            pst.setBoolean(5, p.isStockage());               }
            else{
            pst.setBoolean(6, p.isBlocage());  }
        pst.executeQuery();
        con.close();
        } catch (Exception exp) {
         System.out.println(exp);
        }
       getProduit();
    
    }
      public void modifierProduit(Produit p){
      
       String sql = "Update cadre set designation, emplacement"+"VALUES (?,?)"+" where ref=?";
        try{  
           
            pst =con.prepareStatement(sql);
            pst.setString(2,p.getDesignation());
            pst.setString(3, p.getEmplacement());
            pst.executeUpdate();
            con.close();
        }catch (Exception exp) {
            System.out.println(exp);
        }
        Object Status=null;
        try{  
        if (Status.equals("production")){
        pst =con.prepareStatement("Update status set prod=1 "+" where ref=?");
        }
        else if (Status.equals("nettoyage")){
        pst =con.prepareStatement("Update status set nett=true "+" where ref=?");
        }
        else if (Status.equals("controle")){
        pst =con.prepareStatement("Update status set cont=true "+" where ref=?");
        }
        else if (Status.equals("stockage")){
         pst =con.prepareStatement("Update status set stok=true "+" where ref=?");
        }
        else{
         pst =con.prepareStatement("Update status set blok=true "+" where ref=?");
        }
        con.close();}
      catch (Exception exp) {
            System.out.println(exp);
        }  
        getProduit();
 
    }
       public void supprimerProduit(int ref){
      String sql = "Delete from cadre where ref=?";  
      Produit p = new Produit();
        try{ 
      pst = con.prepareStatement(sql);
            pst.setInt(1,p.getRef() );
            pst.executeQuery();
        }
        catch (Exception exp) {
            System.out.println(exp);
                }          
    getProduit();
  
      
    }
      public void validProduitstat(Produit p){
        
        String sql = "select * from status where ref";
try{
    pst = con.prepareStatement(sql);
    pst.setInt(1,p.getRef());
    rs = pst.executeQuery(sql);
    while(rs.next()){
                 if(rs.getInt(2)!=0){
                 pst =con.prepareStatement("Update status set prod= 0, nett=true, cont=false, stok= false, blok= false"+" where ref");
        }
        else if (rs.getBoolean(3)==true){
        pst =con.prepareStatement("Update status set prod= 0, nett=false, cont=true, stok= false, blok= false"+" where ref");
        }
        else if(rs.getBoolean(4)==true){
       pst =con.prepareStatement("Update status set prod= 0, nett=false, cont=false, stok= true, blok= false"+" where ref");
       pst =con.prepareStatement("Update cadre set emplacement= ?"+" where ref");
       pst.setString(2, p.getEmplacement());
                    }
        else if(rs.getBoolean(5)==true){
       pst =con.prepareStatement("Update status set prod= 1, nett=false, cont=false, stok= false, blok= false"+" where ref");
        pst=con.prepareStatement("Update cadre set emplacement = "+"where ref");
        comptage();
        }
        else{
        System.out.println("Veuillez contacter l'administration");
        }
        
    pst.executeUpdate();
    con.close();
    }
   }catch(Exception exp)
        {System.out.println(exp);
        }
       
    }
      public void annulProduitstat(Produit p){
        
      String sql = "select * from status where ref";
try{
     pst = con.prepareStatement(sql);
    pst.setInt(1,p.getRef());
    rs = pst.executeQuery(sql);
    while(rs.next()){
        if(rs.getInt(2)!=0){
         pst =con.prepareStatement("Update status set prod= 0, nett=false, cont=false, stok= true, blok= false"+" where ref");
       pst =con.prepareStatement("Update cadre set emplacement= ?"+" where ref");
       pst.setString(2, p.getEmplacement());
        }
       else if(rs.getBoolean(3)==true){
       pst =con.prepareStatement("Update status set prod= 1, nett=false, cont=false, stok= false, blok= false"+" where ref");
       comptage(); 
       }
               if(rs.getBoolean(4)==true){
             pst =con.prepareStatement("Update status set prod= 0, nett=true, cont=false, stok= false, blok= false"+" where ref");   
        }
        else if(rs.getBoolean(5)==true){
                pst =con.prepareStatement("Update status set prod= 0, nett=false, cont=true, stok= false, blok= false"+" where ref");    
               }
        else{
        System.out.println("Veuillez contacter l'administration");
        }
        pst.executeUpdate();
    con.close();
    }
   }catch(Exception exp)
        {System.out.println(exp);
        }
   
    }
       public void comptage(){
           Produit p= new Produit();
     int i = 1;
   String sql= "select * from status where ref=?";
       try{
        pst = con.prepareStatement(sql);
        pst.setInt(1,p.getRef());
  rs = pst.executeQuery();
  p.setProduction(i);
  i= rs.getInt(2);
  while(rs.next()){
  if (i!=0 && i<390){
     pst =con.prepareStatement("Update status set prod=i+1"+" where ref=?");
        i++;
  }   
  else if (i>=390&& i<400){
     pst =con.prepareStatement("Update status set prod=i+1"+" where ref=?");    
      i++;
  }
  else {
  bloquer();   
  i++;      
        }
  }
  pst.executeUpdate();
  con.close();
        }catch (Exception exp) 
           {System.out.println(exp);
        }
        
    }
    public void bloquer(){
        Produit p= new Produit();
        String sql= "Update status set blok=true"+" where ref=?";
                try{
        pst.setInt(1,p.getRef());
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        System.out.println("B");
    }catch (Exception exp) 
           {System.out.println(exp);
}
    }
     
}
