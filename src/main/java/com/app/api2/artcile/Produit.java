/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.api2.artcile;

/**
 *
 * @author user
 */
public class Produit {
        private int Ref;
	    private String Designation;
	    private String Emplacement;
	    private int Production;
	    private boolean Nettoyage;
	    private boolean Controle;
	    private boolean Stockage;
	    private boolean Blocage;

    Produit(int ref, String designation, String emplacement, boolean nettoyage, boolean controle, boolean stockage, boolean blocage) {
       super();
    }

    

    public Produit(){
super();
	  }

   	        public int getRef() {
			return Ref;
		}
		public void setRef(int ref) {
			Ref = ref;
		}
		public String getDesignation() {
			return Designation;
		}
		public void setDesignation(String designation) {
			Designation = designation;
		}
		public String getEmplacement() {
			return Emplacement;
		}
		public void setEmplacement(String emplacement) {
			Emplacement = emplacement;
		}
		public int getProduction() {
			return Production;
		}
		public void setProduction(int production) {
			Production = production;
		}
		public boolean isNettoyage() {
			return Nettoyage;
		}
		public void setNettoyage(boolean nettoyage) {
			Nettoyage = nettoyage;
		}
		public boolean isControle() {
			return Controle;
		}
		public void setControle(boolean controle) {
			Controle = controle;
		}
		public boolean isStockage() {
			return Stockage;
		}
		public void setStockage(boolean stockage) {
			Stockage = stockage;
		}
		public boolean isBlocage() {
			return Blocage;
		}
		public void setBlocage(boolean blocage) {
			Blocage = blocage;
		}
		public Produit(int ref, String designation, String emplacement, int production, boolean nettoyage,
				boolean controle, boolean stockage, boolean blocage) {
			super();
			Ref = ref;
			Designation = designation;
			Emplacement = emplacement;
			Production = production;
			Nettoyage = nettoyage;
			Controle = controle;
			Stockage = stockage;
			Blocage = blocage;
		}
    
}
