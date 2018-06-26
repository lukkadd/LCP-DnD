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
public class Weapon extends Equipment{
    private int idWeapon;
    private String weapon_type;
    private boolean heavy; // if not is light
    private boolean loading;
    private int min_range;
    private int max_range; //in the interface set a reach boolean that sets it to 5
    private String special_condition;
    private boolean thrown;
    private boolean two_handed;//disable this option if versatile
    private boolean ammunition;
    private boolean finesse;
    private String normal_attack;
    private String two_handed_attack; //can be null

    public Weapon(String weapon_type, boolean heavy, boolean loading, int min_range, int max_range, String special_condition, boolean thrown, boolean two_handed, boolean ammunition, boolean finesse, String normal_attack, String two_handed_attack, boolean isEquiped, String name, int cost, String weight) {
        super(isEquiped, name, cost, weight);
        this.weapon_type = weapon_type;
        this.heavy = heavy;
        this.loading = loading;
        this.min_range = min_range;
        this.max_range = max_range;
        this.special_condition = special_condition;
        this.thrown = thrown;
        this.two_handed = two_handed;
        this.ammunition = ammunition;
        this.finesse = finesse;
        this.normal_attack = normal_attack;
        this.two_handed_attack = two_handed_attack;
    }
    
}
