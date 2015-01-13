/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Gui;

import mygame.GameManager;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import tonegod.gui.controls.buttons.ButtonAdapter;

/**
 *
 * @author Bawb
 */
public class StartScreen extends GuiScreen {
    
    private ButtonAdapter startButton;
    private ButtonAdapter statsButton;      
    
    public StartScreen(GameManager manager) {
        super(manager);
        createStartButton();
        createStatsButton();
    }
    
    private void createStartButton() {
        
        Vector2f v1 = new Vector2f();
        Vector4f v2 = new Vector4f();
        
        startButton = new ButtonAdapter(manager.screen, "Start Button", v1, v1, v2, "Textures/StartButton.png") {
        
            @Override
            public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle) {
            
                manager.getStartScreen().hide();
                manager.getSelectScreen().show();
                
            }
            
        };
        
        startButton.setDimensions(manager.screen.getWidth()/3, manager.screen.getHeight()/5);
        startButton.setPosition(manager.screen.getWidth()/2 - startButton.getWidth()/2, manager.screen.getHeight()/2 - startButton.getHeight() * 2);
        manager.screen.addElement(startButton);
        startButton.setZOrder(1);
        
    }
    
    private void createStatsButton() {

        Vector2f v1 = new Vector2f();
        Vector4f v2 = new Vector4f();
        
        statsButton = new ButtonAdapter(manager.screen, "Stats Button", v1, v1, v2, "Textures/StatsButton.png") {

            @Override
            public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle) {
            
                manager.getStartScreen().hide();
                manager.getStatsScreen().show();
                
            }
        
        };
        
        statsButton.setDimensions(manager.screen.getWidth()/3, manager.screen.getHeight()/5);
        statsButton.setPosition(manager.screen.getWidth()/2 - statsButton.getWidth()/2, manager.screen.getHeight()/2);
        manager.screen.addElement(statsButton);
        statsButton.setZOrder(1);
    
    }
    
    @Override
    public void show() {
        
        super.show();
        startButton.show();
        statsButton.show();
        startButton.setZOrder(1);
        statsButton.setZOrder(1);
        
    }
    
    @Override
    public void hide() {
        
        startButton.hide();
        statsButton.hide();
        
    }
       
}
