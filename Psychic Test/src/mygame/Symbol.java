/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.util.Random;

/**
 *
 * @author Bawb
 */
public class Symbol {

    private String type;
    private String value;
    
    public Symbol(){
    
        setType();
        setValue();
    
    }
    
    private void setType(){
        
        int chance = randInt(1,100);

        if (chance < 51) {
          
            type = "shape";
            
        }
        
        else {
        
            type = "number";
            
        }
        
    }
    
    private void setValue() {
        
        int chance = randInt(1,5);
        
        if (type.equals("shape")) {
        
            switch (chance) {
            
                case 1:
                    value = "circle";
                    break;
                case 2:
                    value = "square";
                    break;
                case 3:
                    value = "star";
                    break;
                case 4:
                    value = "triangle";
                    break;
                case 5:
                    value = "heart";
                    break;
                
            }

        }
        
        else {
            
            value = Integer.toString(chance); 
        }
    
    }
    
    private int randInt(int min, int max) {

        Random rand   = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    
    }
    
    public String getType() {
        return type;
    }
    
    public String getValue() {
        return value;
    }
    
    
}
