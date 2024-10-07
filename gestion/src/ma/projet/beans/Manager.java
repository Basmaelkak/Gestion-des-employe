/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class Manager extends Personne {
    private List<Personne> personnesEncharge;

    public Manager( int id, String nom, double salaire) {
        super(id, nom, salaire);
        this.personnesEncharge = new ArrayList<>() ;
    }

    public Manager(List<Personne> personnesEncharge, int id, String nom) {
        super(id, nom);
        this.personnesEncharge = personnesEncharge;
    }
    
    

    
    public List<Personne> getPersonnesEncharge() {
        return personnesEncharge;
    }

    public void setPersonnesEncharge(List<Personne> personnesEncharge) {
        this.personnesEncharge = personnesEncharge;
    }
    public void ajouterPersonne(Personne pers){
        personnesEncharge.add(pers);
    }
 
    
    
}
