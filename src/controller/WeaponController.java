/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import entities.Weapon;
import db.Connect;

/**
 *
 * @author Marjorie
 */
public class WeaponController {
    
    public WeaponController() {
        
    }
    
    public int insert(Weapon w) {
        
        try {
            Connect conexao = new Connect();
            
            String strSql = "insert into Weapon (itemName, cost, weight, isEquiped, ";
            strSql = strSql + "weaponType, heavy, loading, minRange, maxRange, ";
            strSql = strSql + "thrown, twoHanded, ammunition, finesse, normalAttack, twoHandedAttack) values ";
            strSql = strSql + "('" + w.getName() + "'," + w.getCost() + ",'" + w.getWeight() + "',";
            strSql = strSql + w.isIsEquiped() + ",'" + w.getWeapon_type()+ "'," + w.isHeavy() + ",";
            strSql = strSql + w.isLoading() + "," + w.getMin_range() + "," + w.getMax_range() + ",";
            strSql = strSql + w.isThrown() + "," + w.isTwo_handed() + ",";
            strSql = strSql + w.isAmmunition() + "," + w.isFinesse() + ",'" + w.getNormal_attack() + "','";
            strSql = strSql + w.getTwo_handed_attack();
            strSql = strSql + "');";
            
            Connection conn = conexao.conectaBD();
            
            if (conn != null) {
                Statement stmt = (Statement)conn.createStatement();
                stmt.execute(strSql);
                conexao.desconectaBD(conn);
            }
            
            return 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public int remove(Weapon w) {
        int retorno = 1;
        
        try {
            Connect conexao = new Connect();
            String strSql = "delete from Weapon where idWeapon = " + w.getIdWeapon();
            
            Connection conn = conexao.conectaBD();
            
            if (conn != null) {
                Statement stmt = (Statement)conn.createStatement();
                stmt.execute(strSql);
                conexao.desconectaBD(conn);
            }
            
            return retorno;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public ResultSet getWeaponList() {
        ResultSet rs = null;
        
        try {
            Connect conexao = new Connect();
            
            String strSql = "select * from Weapon";
            
            Connection conn = conexao.conectaBD();
            
            if (conn != null) {
                Statement stmt = (Statement)conn.createStatement();
                rs = stmt.executeQuery(strSql);
                conexao.desconectaBD(conn);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return rs;
    }
    
}
