/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.rajohnson.tpbanquerajohnson.ejb;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import mg.itu.rajohnson.tpbanquerajohnson.entities.CompteBancaire;
import mg.itu.rajohnson.tpbanquerajohnson.util.Util;

/**
 *
 * @author LENOVO
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {

    private Long idSource;
    private Long idDestination;
    private int montant;

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    /**
     * Creates a new instance of transfert
     */
    public Transfert() {
    }

    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String enregistrementTransfert() {
        boolean erreur = false;
        CompteBancaire source = gestionnaireCompte.getCompte(idSource);
        if (source == null) {
            // Message d'erreur associé au composant source ; form:source est l'id client
            // si l'id du formulaire est "form" et l'id du champ de saisie de l'id de la source est "source"
            // dans la page JSF qui lance le transfert.
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
            erreur = true;
        } else {
            if (source.getSolde() < montant) {
                Util.messageErreur("Solde insuffisant !", "Solde insuffisant !", "form:montant");
                erreur = true;
            }
        }
        CompteBancaire destination = gestionnaireCompte.getCompte(idDestination);
        if (destination == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:destination");
            erreur = true;
        }
        if (erreur) {
            return null;
        }
        gestionnaireCompte.transferer(source, destination, montant);
        Util.addFlashInfoMessage("Transfert correctement effectué ");
        return "listeComptes?faces-redirect=true";
    }

}
