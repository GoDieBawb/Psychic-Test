/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Gui;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import java.util.Random;
import mygame.GameManager;
import tonegod.gui.core.Element;

/**
 *
 * @author Bawb
 */
public abstract class GuiScreen {
    
    public GameManager manager;
    public Element     panelOne;
    public Element     panelTwo;
    
    public GuiScreen(GameManager manager) {
        this.manager = manager;
    }
    
    public void show(){
        manager.setBackground();
    };
    
    public abstract void hide();
    
}
