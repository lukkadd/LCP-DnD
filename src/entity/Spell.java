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
public class Spell {
    String name;
    String desc;
    String higher_level;
    String page;
    int range;
    String components;
    boolean ritual;
    String duration;
    boolean concentration;
    String casting_time;
    int level;
    String school;
    List<Class> classes;
    List<SubClass> subclasses;
}
