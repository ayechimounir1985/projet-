/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.api2.artcile;

/**
 *
 * @author user
 */
public class User {
      private String id;
	    private String mdp;
	    private String nom;
	    private String prenom;
	    private String email;
	    private boolean producteur;
	    private boolean magasinier;
	    private boolean nettoyeur;
	    private boolean controleur;
	    private boolean admin;

    User() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    
	    public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMdp() {
			return mdp;
		}
		public void setMdp(String mdp) {
			this.mdp = mdp;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public boolean isProducteur() {
			return producteur;
		}
		public void setProducteur(boolean producteur) {
			this.producteur= producteur;
		}
		public boolean isMagasinier() {
			return magasinier;
		}
		public void setMagasinier(boolean magasinier) {
			this.magasinier = magasinier;
		}
		public boolean isNettoyeur() {
			return nettoyeur;
		}
		public void setNettoyeur(boolean nettoyeur) {
			this.nettoyeur = nettoyeur;
		}
		public boolean isControleur() {
			return controleur;
		}
		public void setControleur(boolean controleur) {
			this.controleur = controleur;
		}
		public boolean isAdmin() {
			return admin;
		}
		public void setAdmin(boolean admin) {
			this.admin = admin;
		}
		public User(String id, String mdp, String nom, String prenom, String email, boolean producteur, boolean magasinier,
				boolean nettoyeur, boolean controleur, boolean admin) {
			super();
			this.id = id;
			this.mdp = mdp;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.producteur= producteur;
			this.magasinier = magasinier;
			this.nettoyeur = nettoyeur;
			this.controleur = controleur;
			this.admin = admin;
		}
	
    
}
