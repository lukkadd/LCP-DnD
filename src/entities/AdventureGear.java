/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author lukka
 */
public class AdventureGear extends Item {
    //equipment packs count as a single item
    //to-do: containers and vehicles
    private String description;
    private String gear_type; //set to general if it does not have a specific one

    public AdventureGear(String description, String gear_type, String name, int cost, String weight) {
        super(name, cost, weight);
        this.description = description;
        this.gear_type = gear_type;
    }
    
}
