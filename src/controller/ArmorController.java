/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import entities.Armor;
import db.Connect;

/**
 *
 * @author Marjorie
 */
public class ArmorController {
    
    public ArmorController() {
        
    }
    
    public int insert(Armor a) {
        
        try {
            Connect conexao = new Connect();
            
            String strSql = "insert into Armor (itemName, cost, weight, isEquiped, ";
            strSql = strSql + "armorType, baseACBonus, modifier, ";
            strSql = strSql + "strengthRequirement, stealthDisadvantage) values ";
            strSql = strSql + "('" + a.getName() + "'," + a.getCost() + ",'" + a.getWeight() + "',";
            strSql = strSql + a.isIsEquiped() + ",'" + a.getArmor_type() + "'," + a.getBase_AC_bonus()+ ",";
            strSql = strSql + a.getModifier() + "," + a.getStrength_requirement() + "," + a.isStealth_disadvantage();
            strSql = strSql + ");";
            
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
    
    public int remove(Armor a) {
        int retorno = 1;
        
        try {
            Connect conexao = new Connect();
            String strSql = "delete from Armor where idArmor = " + a.getIdArmor();
            
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
        
    public int update(Armor a) {
        int retorno = 1;

        try {
            Connect conexao = new Connect();
            String strSql = "update Armor set "
                    + "itemName = " + "'" + a.getName() +"',"
                    + "cost = " + a.getCost() +","
                    + "weight = " + "'" + a.getWeight() +"',"
                    + "isEquiped = " + "" + a.isIsEquiped() + ","
                    + "armorType = " + "'" + a.getArmor_type() + "', "
                    + "baseACBonus = " + a.getBase_AC_bonus()+ ", "
                    + "modifier = " + a.getModifier() + ", "
                    + "strengthRequirement = " + a.getStrength_requirement() + ", "
                    + "stealthDisadvantage = " + a.isStealth_disadvantage()
                    + " where idArmor = " + a.getIdArmor();

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
    
    public ResultSet getArmorList() {
        ResultSet rs = null;
        
        try {
            Connect conexao = new Connect();
            
            String strSql = "select * from Armor";
            
            Connection conn = conexao.conectaBD();
            
            if (conn != null) {
                Statement stmt = (Statement)conn.createStatement();
                rs = stmt.executeQuery(strSql);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return rs;
    }
    
}
