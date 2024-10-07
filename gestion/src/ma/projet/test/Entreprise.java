/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;



import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.service.DeveloppeurService;
import ma.projet.service.ManagerService;

public class Entreprise {
    public static void main(String[] args) {
   DeveloppeurService es = new DeveloppeurService();
 
   es.create( new  Developpeur(1,"HADI",12000));
   es.create(new Developpeur(2,"SAFI",10000));
    //creation du troisieme developpeur
   es.create(new Developpeur(3,"Rami",9000));
       
  ManagerService ms = new ManagerService();
  //creation du manager
   ms.create(new Manager(1,"naciri",15000));
    //creation du directeur
    ms.create(new Manager(2,"ALAOUI",20000));
           
   Developpeur deve1 =es.getById(1);
   Developpeur deve2 =es.getById(2); 
   Developpeur deve3 =es.getById(3); 
   
   
   Manager manager = ms.getById(1);
  manager.ajouterPersonne(deve1);
  // manager.ajouterPersonne(deve2);
  Manager directeur=ms.getById(2);
   directeur.ajouterPersonne(deve3);
   directeur.ajouterPersonne(manager);
   System.out.println("le directeur:"+directeur.getNom()+" salaire"+directeur.getSalaire());
    System.out.println("le manager:"+manager.getNom()+" salaire"+manager.getSalaire());
    System.out.println("le developpeur:"+deve1.getNom()+" salaire"+deve1.getSalaire());
    System.out.println("le developpeur:"+deve2.getNom()+" salaire"+deve2.getSalaire()); 
     System.out.println("le developpeur:"+deve3.getNom()+" salaire"+deve3.getSalaire());
  
        }   
    }
    

   
   
   
   
   
   
   
   
   
   
  
   
    
      
        
  
       

