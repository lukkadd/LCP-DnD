/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import entities.AdventureGear;
import db.Connect;
import java.util.ArrayList;

/**
 *
 * @author Marjorie
 */

public class AdventureGearController {
    
    public AdventureGearController() {
        
    }
    
    public int insert(AdventureGear a) {
        int retorno = 1;
        
        try {
            Connect conexao = new Connect();
            
            String strSql = "insert into AdventureGear (itemName, cost, weight, description, gearType) values ";
            strSql =  strSql + "('" + a.getName() + "','" +
                                    a.getCost()+ "','" + 
                                    a.getWeight() + "','" + 
                                    a.getDescription()+ "','" +
                                    a.getGear_type() + "');";
            
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
    
    public ArrayList getAdventureGearList() {
        ResultSet rs = null;
        ArrayList<AdventureGear> advGList = new ArrayList<AdventureGear>();
        AdventureGear advG = new AdventureGear();
        
        try {
            Connect conexao = new Connect();
            
            String strSql = "select * from AdventureGear";
            
            Connection conn = conexao.conectaBD();
            
            if (conn != null) {
                Statement stmt = (Statement)conn.createStatement();
                rs = stmt.executeQuery(strSql);
                while(rs.next()){
                    advG.setName(rs.getString("itemName"));
                    advGList.add(advG);
                }
                conexao.desconectaBD(conn);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return advGList;
    }
    
    
}
