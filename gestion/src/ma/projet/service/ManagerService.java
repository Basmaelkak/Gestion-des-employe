/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Manager;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;


/**
 *
 * @author pc
 */
public class ManagerService implements IDao<Manager> {
      @Override
      public boolean create(Manager o){
        try{
            String req="insert into manager (id,nom,salaire) values(?,?,?)";
            PreparedStatement ps =
                    Connexion.getConnection().prepareStatement(req);
           ps.setInt(1, o.getId());
            ps.setString(1,o.getNom());
            ps.setDouble(2, o.getSalaire());
            if(ps.executeUpdate()== 1){
                return true;
                
            }
                    
                    
        }catch(SQLException ex){
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    @Override
      public boolean update(Manager o){
        try{
            String req="update manager set id = ? , nom= ? ,salaire =? where id = ?";
            PreparedStatement ps =
                    Connexion.getConnection().prepareStatement(req);
            ps.setInt(1,o.getId());
            ps.setString(2, o.getNom());
             ps.setDouble(3,o.getSalaire());
            
            if(ps.executeUpdate()== 1){
                return true;
                
            }   
                    
        }catch(SQLException ex){
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    @Override
        public boolean delete(Manager o){
        try{
            String req="delet from manager where id =?";
            PreparedStatement ps =
                    Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if(ps.executeUpdate()== 1){
                return true;
                
            }                 
        }catch(SQLException ex){
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
    }
    @Override
         public Manager getById(int id) {
             Manager manager = null;
        try{
            String req="select * from manager where id =?";
            PreparedStatement ps =
                    Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                manager = new Manager(rs.getInt("id"),rs.getString("nom"),rs.getDouble("salaire"));
                
                         
        }catch(SQLException ex){
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return manager;
    }
    @Override
          public List<Manager> getAll(){
              List<Manager> managers = new ArrayList<>();
        try{
            String req="select * from manager ";
            PreparedStatement ps =
                    Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                managers.add(new Manager(rs.getInt("id"),rs.getString("nom"),rs.getDouble("salaire")));
                
                           
        }catch(SQLException ex){
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,null, ex);
        }
        return managers;
    }

}