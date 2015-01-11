/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Gui;

import mygame.GameManager;

/**
 *
 * @author Bawb
 */
public abstract class GuiScreen {
    
    public GameManager manager;
    
    public GuiScreen(GameManager manager) {
        this.manager = manager;
    }
    
    public abstract void show();
    
    public abstract void hide();
    
}
