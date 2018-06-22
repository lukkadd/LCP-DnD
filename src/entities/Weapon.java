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
public class Weapon extends Equipment{
    String weapon_type;
    boolean heavy; // if not is light
    boolean loading;
    int min_range;
    int max_range; //in the interface set a reach boolean that sets it to 5
    String special_condition;
    boolean thrown;
    boolean two_handed;//disable this option if versatile
    boolean ammunition;
    boolean finesse;
    Attack normal_attack;
    Attack two_handed_attack;
}
