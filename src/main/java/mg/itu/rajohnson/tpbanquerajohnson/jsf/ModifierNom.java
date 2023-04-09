/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.rajohnson.tpbanquerajohnson.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import mg.itu.rajohnson.tpbanquerajohnson.ejb.GestionnaireCompte;
import mg.itu.rajohnson.tpbanquerajohnson.entities.CompteBancaire;

/**
 *
 * @author LENOVO
 */
@Named(value = "modifierNom")
@ViewScoped
public class ModifierNom implements Serializable {

    /**
     * Creates a new instance of ModifierNom
     */
    public ModifierNom() {
    }
    private Long id;
    private CompteBancaire compte;

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public String modifierNom() {
        gestionnaireCompte.update(compte);
        return "listeComptes?faces-redirect=true";
    }

    public void loadCompte() {
        compte = gestionnaireCompte.getCompte(id);
    }
}
