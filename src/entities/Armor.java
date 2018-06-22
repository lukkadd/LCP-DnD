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
public class Armor extends Equipment{
    String armor_type;
    int base_AC_bonus; // if 11 base_AC_bonus = 1 etc. (for shields is a flat amout like +2)
    int modifier;// 0-(nothing),1-(DEX bonus),2-(DEX bonus- max 2);
    int strength_requirement;
    boolean stealth_disadvantage;
}
