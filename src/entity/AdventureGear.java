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
public class AdventureGear extends Item {
    //equipment packs count as a single item
    //to-do: containers and vehicles
    private String description;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdventureGear(String description, String gear_type, String name, int cost, String weight) {
        super(name, cost, weight);
        this.description = description;
        this.gear_type = gear_type;
    }
    
    public AdventureGear(String description, String gear_type, String name, int cost, String weight,int id) {
        super(name, cost, weight);
        this.description = description;
        this.gear_type = gear_type;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGear_type() {
        return gear_type;
    }

    public void setGear_type(String gear_type) {
        this.gear_type = gear_type;
    }
    private String gear_type; //set to general if it does not have a specific one
    
}
