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
    private boolean thrown;
    private boolean two_handed;//disable this option if versatile
    private boolean ammunition;
    private boolean finesse;
    private String normal_attack;
    private String two_handed_attack; //can be null

    public Weapon(String weapon_type, boolean heavy, boolean loading, int min_range, int max_range, boolean thrown, boolean two_handed, boolean ammunition, boolean finesse, String normal_attack, String two_handed_attack, boolean isEquiped, String name, int cost, String weight) {
        super(isEquiped, name, cost, weight);
        this.weapon_type = weapon_type;
        this.heavy = heavy;
        this.loading = loading;
        this.min_range = min_range;
        this.max_range = max_range;
        this.thrown = thrown;
        this.two_handed = two_handed;
        this.ammunition = ammunition;
        this.finesse = finesse;
        this.normal_attack = normal_attack;
        this.two_handed_attack = two_handed_attack;
    }

    public Weapon(int idWeapon, String weapon_type, boolean heavy, boolean loading, int min_range, int max_range, boolean thrown, boolean two_handed, boolean ammunition, boolean finesse, String normal_attack, String two_handed_attack, boolean isEquiped, String name, int cost, String weight) {
        super(isEquiped, name, cost, weight);
        this.idWeapon = idWeapon;
        this.weapon_type = weapon_type;
        this.heavy = heavy;
        this.loading = loading;
        this.min_range = min_range;
        this.max_range = max_range;
        this.thrown = thrown;
        this.two_handed = two_handed;
        this.ammunition = ammunition;
        this.finesse = finesse;
        this.normal_attack = normal_attack;
        this.two_handed_attack = two_handed_attack;
    }

    public int getIdWeapon() {
        return idWeapon;
    }

    public void setIdWeapon(int idWeapon) {
        this.idWeapon = idWeapon;
    }

    public String getWeapon_type() {
        return weapon_type;
    }

    public void setWeapon_type(String weapon_type) {
        this.weapon_type = weapon_type;
    }

    public boolean isHeavy() {
        return heavy;
    }

    public void setHeavy(boolean heavy) {
        this.heavy = heavy;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public int getMin_range() {
        return min_range;
    }

    public void setMin_range(int min_range) {
        this.min_range = min_range;
    }

    public int getMax_range() {
        return max_range;
    }

    public void setMax_range(int max_range) {
        this.max_range = max_range;
    }

    public boolean isThrown() {
        return thrown;
    }

    public void setThrown(boolean thrown) {
        this.thrown = thrown;
    }

    public boolean isTwo_handed() {
        return two_handed;
    }

    public void setTwo_handed(boolean two_handed) {
        this.two_handed = two_handed;
    }

    public boolean isAmmunition() {
        return ammunition;
    }

    public void setAmmunition(boolean ammunition) {
        this.ammunition = ammunition;
    }

    public boolean isFinesse() {
        return finesse;
    }

    public void setFinesse(boolean finesse) {
        this.finesse = finesse;
    }

    public String getNormal_attack() {
        return normal_attack;
    }

    public void setNormal_attack(String normal_attack) {
        this.normal_attack = normal_attack;
    }

    public String getTwo_handed_attack() {
        return two_handed_attack;
    }

    public void setTwo_handed_attack(String two_handed_attack) {
        this.two_handed_attack = two_handed_attack;
    }
    
}
