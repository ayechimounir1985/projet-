/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.api2.metier;

import com.app.api2.artcile.Produit;
import com.app.api2.artcile.ProduitDAO;
import java.util.List;

/**
 *
 * @author user
 */
public class ProduitMetier {
    private final ProduitDAO pdao= new ProduitDAO();
    public List<Produit> getProduit(){
        return pdao.getProduit();
    }
    public void ajouterProduit(Produit p){
         pdao.ajouterProduit(p);
    }
    public void modifierProduit(Produit p){
         pdao.modifierProduit(p);
    }
    public void supprimerProduit(int ref){
         pdao.supprimerProduit(ref);
    }
    public void validProduitstat(Produit p){
         pdao.validProduitstat(p);
    }
    public void annulProduitstat(Produit p){
        pdao.annulProduitstat(p);
    }
    public void comptage(){
         pdao.comptage();
    }
    public void chercherProduit(int ref){
         pdao.chercherProduit(ref);
    }
}
