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
public class StartScreen extends GuiScreen {
    
    private ButtonAdapter startButton;
    private ButtonAdapter statsButton;      
    
    public StartScreen(GameManager manager) {
        super(manager);
        createStartButton();
        createStatsButton();
    }
    
    private void createStartButton() {
        
        startButton = new ButtonAdapter(manager.screen, "Start Button", new Vector2f(120,120)) {
        
            @Override
            public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle) {
            
                manager.getStartScreen().hide();
                manager.getSelectScreen().show();
                
            }
            
        };
        
        startButton.setDimensions(manager.screen.getWidth()/3, manager.screen.getHeight()/5);
        startButton.setPosition(manager.screen.getWidth()/2 - startButton.getWidth()/2, manager.screen.getHeight()/2 - startButton.getHeight() * 2);
        manager.screen.addElement(startButton);
        startButton.setText("Start");
        
    }
    
    private void createStatsButton() {

        statsButton = new ButtonAdapter(manager.screen, "Stats Button", new Vector2f(12,12)) {

            @Override
            public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle) {
            
                manager.getStartScreen().hide();
                manager.getStatsScreen().show();
                
            }
        
        };
        
        statsButton.setDimensions(manager.screen.getWidth()/3, manager.screen.getHeight()/5);
        statsButton.setPosition(manager.screen.getWidth()/2 - statsButton.getWidth()/2, manager.screen.getHeight()/2);
        manager.screen.addElement(statsButton);
        statsButton.setText("Stats");
    
    }
    
    @Override
    public void show() {
        
        super.show();
        startButton.show();
        statsButton.show();
        
    }
    
    @Override
    public void hide() {
        
        startButton.hide();
        statsButton.hide();
        
    }
       
}
