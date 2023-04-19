/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.rajohnson.tpbanquerajohnson.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.rajohnson.tpbanquerajohnson.ejb.GestionnaireCompte;
import mg.itu.rajohnson.tpbanquerajohnson.entities.CompteBancaire;
import mg.itu.rajohnson.tpbanquerajohnson.entities.OperationBancaire;

/**
 *
 * @author LENOVO
 */
@Named(value = "historiqueOperation")
@ViewScoped
public class HistoriqueOperation implements Serializable {

    @EJB
    private GestionnaireCompte gestionnaireCompte;
    private Long id;
    private CompteBancaire compte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Creates a new instance of HistoriqueOperation
     */
    public HistoriqueOperation() {
    }

    public void loadOperations() {
        compte = gestionnaireCompte.getCompte(id);
    }

    public List<OperationBancaire> getOperations() {
        return compte.getOperations();
    }

}
