/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.rajohnson.tpbanquerajohnson.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import mg.itu.rajohnson.tpbanquerajohnson.entities.CompteBancaire;

/**
 *
 * @author LENOVO
 */
@Startup
@Singleton
public class Init {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    @PostConstruct
    public void init() {
        if (gestionnaireCompte.nbComptes() == 0) {
            gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }
    }
}
