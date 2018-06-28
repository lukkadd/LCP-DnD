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
public class Armor extends Equipment{
    private int idArmor;
    private String armor_type;
    private int base_AC_bonus; // if 11 base_AC_bonus = 1 etc. (for shields is a flat amout like +2)
    private int modifier;// 0-(nothing),1-(DEX bonus),2-(DEX bonus- max 2);
    private int strength_requirement;
    private boolean stealth_disadvantage;

    public Armor(String armor_type, int base_AC_bonus, int modifier, int strength_requirement, boolean stealth_disadvantage, boolean isEquiped, String name, int cost, String weight) {
        super(isEquiped, name, cost, weight);
        this.armor_type = armor_type;
        this.base_AC_bonus = base_AC_bonus;
        this.modifier = modifier;
        this.strength_requirement = strength_requirement;
        this.stealth_disadvantage = stealth_disadvantage;
    }

    public int getIdArmor() {
        return idArmor;
    }

    public void setIdArmor(int idArmor) {
        this.idArmor = idArmor;
    }

    public String getArmor_type() {
        return armor_type;
    }

    public void setArmor_type(String armor_type) {
        this.armor_type = armor_type;
    }

    public int getBase_AC_bonus() {
        return base_AC_bonus;
    }

    public void setBase_AC_bonus(int base_AC_bonus) {
        this.base_AC_bonus = base_AC_bonus;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public int getStrength_requirement() {
        return strength_requirement;
    }

    public void setStrength_requirement(int strength_requirement) {
        this.strength_requirement = strength_requirement;
    }

    public boolean isStealth_disadvantage() {
        return stealth_disadvantage;
    }

    public void setStealth_disadvantage(boolean stealth_disadvantage) {
        this.stealth_disadvantage = stealth_disadvantage;
    }
    
}
