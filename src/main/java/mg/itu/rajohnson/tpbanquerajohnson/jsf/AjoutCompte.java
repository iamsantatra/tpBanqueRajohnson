/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.rajohnson.tpbanquerajohnson.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.PositiveOrZero;
import mg.itu.rajohnson.tpbanquerajohnson.ejb.GestionnaireCompte;
import mg.itu.rajohnson.tpbanquerajohnson.entities.CompteBancaire;
import mg.itu.rajohnson.tpbanquerajohnson.util.Util;

/**
 *
 * @author LENOVO
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    private String nom;
    @PositiveOrZero
    private int solde;

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String action() {
        CompteBancaire nouveauCompte = new CompteBancaire(nom, solde);
        gestionnaireCompte.creerCompte(nouveauCompte);
        Util.addFlashInfoMessage("Compte de " + nom + " ajouté");
        return "ajoutCompte?faces-redirect=true";
    }
}
