/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import entity.Access;
import db.Connect;

/**
 *
 * @author Marjorie
 */
public class AccessController {
    
    public AccessController() {
        
    }
    
    public int insert(Access a) {
        int retorno = 1;
        
        try {
            Connect conexao = new Connect();
            
            String strSql = "insert into Access (username, passkey) values ";
            strSql =  strSql + "(" + a.getUsername() + "," + a.getPasskey() + "');";
            
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
    
    public int remove(Access a) {
        int retorno = 1;
        
        try {
            Connect conexao = new Connect();
            String strSql = "delete from Access where idAccess = " + a.getIdAccess();
            
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
    
    public ResultSet getAccessesList() {
        ResultSet rs = null;
        
        try {
            Connect conexao = new Connect();
            
            String strSql = "select * from Access";
            
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
    
    public Access getByLogin(String login) {
        ResultSet rs = null;
        Access access = null;
        
        try {
            Connect conexao = new Connect();
            
            String strSql = "select * from Access where username = '" + login + "';";
            
            Connection conn = conexao.conectaBD();
            
            if (conn != null) {
                Statement stmt = (Statement)conn.createStatement();
                rs = stmt.executeQuery(strSql);
                if (rs != null && rs.next()) {
                    access = new Access(rs.getString("username"), 
                            rs.getString("passkey"), rs.getInt("permission"));
                }
            }
            
            conexao.desconectaBD(conn);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return access;
    }
}
