/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Developpeur;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author pc
 */
public class DeveloppeurService implements IDao<Developpeur> {
     @Override
     public boolean create(Developpeur o){
        try{
            String req="insert into developpeur (id,nom,salaire,language) values(?,?,?,?)";           
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.setString(2,o.getNom());
            ps.setDouble(3, o.getSalaire());
        
            if(ps.executeUpdate()==1){
                return true;
                
            }          
        }catch(SQLException ex){
            Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    @Override
      public boolean update(Developpeur o){
        try{
            String req="update developpeur set id = ? , nom= ? ,salaire =?  where id = ?";
            PreparedStatement ps =
                    Connexion.getConnection().prepareStatement(req);
            ps.setInt(1,o.getId());
            ps.setString(2, o.getNom());
             ps.setDouble(3,o.getSalaire());
          
            
            if(ps.executeUpdate()== 1){
                return true;
                
            }   
                    
        }catch(SQLException ex){
            Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    @Override
        public boolean delete(Developpeur o){
        try{
            String req="delet from developpeur where id =?";
            PreparedStatement ps =
                    Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if(ps.executeUpdate()== 1){
                return true;
                
            }                 
        }catch(SQLException ex){
            Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    @Override
         public Developpeur getById(int id) {
             Developpeur developpeur = null;
        try{
            String req="select * from developpeur where id =?";
            PreparedStatement ps =
                    Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                developpeur = new Developpeur(rs.getInt("id"),rs.getString("nom"),rs.getDouble("salaire"));
                
                         
        }catch(SQLException ex){
            Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return developpeur;
    }
    @Override
          public List<Developpeur> getAll(){
              List<Developpeur> developpeurs = new ArrayList<>();
        try{
            String req="select * from developpeur ";
            PreparedStatement ps =
                    Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                developpeurs.add(new Developpeur(rs.getInt("id"),rs.getString("nom"),rs.getDouble("salaire")));
                
                           
        }catch(SQLException ex){
            Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return developpeurs;
    }
    
    
}
