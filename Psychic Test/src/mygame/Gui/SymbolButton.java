/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Gui;

import com.jme3.math.Vector2f;
import tonegod.gui.controls.buttons.ButtonAdapter;
import tonegod.gui.core.Screen;

/**
 *
 * @author Bawb
 */
public class SymbolButton extends ButtonAdapter {
    
    private String value;
    
    public SymbolButton(Screen screen, String name, Vector2f size) {
        super(screen, name, size);
    }
    
    public void setValue(String value){
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
}
