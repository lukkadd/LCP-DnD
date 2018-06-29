/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author lukka
 */
public class Equipment extends Item{
    private boolean isEquiped;

    public Equipment(boolean isEquiped, String name, int cost, String weight) {
        super(name, cost, weight);
        this.isEquiped = isEquiped;
    }

    public boolean isIsEquiped() {
        return isEquiped;
    }

    public void setIsEquiped(boolean isEquiped) {
        this.isEquiped = isEquiped;
    }
    
}
