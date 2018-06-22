/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.List;

/**
 *
 * @author lukka
 */
public class Race {
    private String name;
    private int speed;
    private List<RaceTrait> traits;
    private List<RaceTrait> loreTraits;
    private List<AttributeIncrease> attBonus;
    private List<String> languages;
    
}
