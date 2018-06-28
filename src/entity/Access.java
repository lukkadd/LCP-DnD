/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author Marjorie
 */
public class Access {
    private int idAccess;
    private String username;
    private String passkey;
    private int permission;
    
    public Access(String username, String passkey, int permission) {
        this.username = username;
        this.passkey = passkey;
        this.permission = permission;
    }
    
    public Access() {}

    public int getIdAccess() {
        return idAccess;
    }

    public void setIdAccess(int idAccess) {
        this.idAccess = idAccess;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasskey() {
        return passkey;
    }

    public void setPasskey(String passkey) {
        this.passkey = passkey;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
    
}
