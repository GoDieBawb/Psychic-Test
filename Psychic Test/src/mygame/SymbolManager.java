/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author Bawb
 */
public class SymbolManager {

    private Symbol symbol;
    
    public void generateSymbol() {
        symbol = new Symbol();
    }
    
    public Symbol getSymbol(){
        return symbol;
    } 
    
}
