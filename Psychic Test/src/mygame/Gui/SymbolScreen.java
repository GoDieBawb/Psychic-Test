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
public class SymbolScreen extends GuiScreen {
    
    private ButtonAdapter finishButton;
    
    public SymbolScreen(GameManager manager) {
        
        super(manager);
        createFinishButton();
        
    }
    
    private void createFinishButton(){
    
        finishButton = new ButtonAdapter(manager.screen, "Finish Button", new Vector2f(12,12)) {
        
            @Override
            public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle) {
            
                manager.getSymbolScreen().hide();
                manager.getStartScreen().show();
                
            }
            
        };
        
        finishButton.setDimensions(manager.screen.getWidth()/3, manager.screen.getHeight()/5);
        finishButton.setText("Finish");
        manager.screen.addElement(finishButton);
        finishButton.setPosition(manager.screen.getWidth()/2 - finishButton.getWidth()/2, manager.screen.getHeight()/5);
        finishButton.hide();
        
    }
    
    @Override
    public void hide() {
        
        finishButton.hide();
        
    }
    
    @Override
    public void show() {
        
        super.show();
        finishButton.show();
        
    }
    
}
