/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Gui;

import mygame.GameManager;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.math.Vector2f;
import tonegod.gui.controls.buttons.ButtonAdapter;

/**
 *
 * @author Bawb
 */
public class StatsScreen extends GuiScreen {
    
    private ButtonAdapter backButton;
    
    public StatsScreen(GameManager manager) {
    
        super(manager);
        createBackButton();
        
    }
    
    private void createBackButton() {
    
        backButton = new ButtonAdapter(manager.screen, "Back Button", new Vector2f(12, 12)) {
        
            @Override
            public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle){
            
                manager.getStatsScreen().hide();
                manager.getStartScreen().show();
                
            }
        
        };
        
        backButton.setText("Back");
        manager.screen.addElement(backButton);
        backButton.hide();
        
    }
    
    @Override
    public void hide() {
        backButton.hide();
    }
    
    @Override
    public void show() {
        backButton.show();
    }
    
}
