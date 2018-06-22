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
class SubRace {
    private String name;
    private Race parentRace;
    private List<RaceTrait> subTraits;
    private List<String> additionalLanguages;
}
