/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author lukka
 */
public class Class {
    String name;
    String hitDice;
    int baseHP;//add CON modifier in the system logic
    String profficiencies;
    
    List<Attribute> savingThrows;
    int skillNumber;
    List<Skill> possibleSkills;
    
    List<Feature> features;
    
    Spellcasting spellcasting;
    
    //TO-DO: equipment choices
}
