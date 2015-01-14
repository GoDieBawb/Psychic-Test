/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Gui;

import com.jme3.app.state.AppStateManager;
import com.jme3.font.BitmapFont;
import mygame.GameManager;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import mygame.StatsManager;
import tonegod.gui.controls.buttons.ButtonAdapter;
import tonegod.gui.controls.text.LabelElement;
import tonegod.gui.core.Element;

/**
 *
 * @author Bawb
 */
public class StatsScreen extends GuiScreen {
    
    private ButtonAdapter    backButton;
    private StatsManager     statsManager;
    private AppStateManager  stateManager;
    private Element          display;
    private int              total;
    private int              wrongCount;
    private int              rightCount;
    
    public StatsScreen(GameManager manager) {
    
        super(manager);
        stateManager = manager.app.getStateManager();
        statsManager = new StatsManager(stateManager);
        createBackButton();
        createDisplay();
        
    }
    
    private void getStats(){
    
        statsManager.loadInfo(stateManager);
        total      = statsManager.getTotal();
        rightCount = statsManager.getRightCount();
        wrongCount = statsManager.getWrongCount();
        
    }
    
    private void displayStats() {
    
        getStats();
        display.setFontSize(50f);
        display.setText("Total: " + total + System.getProperty("line.separator") + " Right Count: " + rightCount + System.getProperty("line.separator") + " Wrong Count: " + wrongCount);
        display.setTextAlign(BitmapFont.Align.Center);
        display.show();
        display.setZOrder(1);
        
    }
    
    private void createDisplay() {
        
        Vector2f v1     = new Vector2f();
        Vector4f v2     = new Vector4f();
        BitmapFont font = stateManager.getApplication().getAssetManager().loadFont("Interface/Fonts/CrackedJohnnie.fnt");
        display         = new Element(manager.screen, "Stats Display", v1, v1, v2, "Textures/paper.jpg");
        //display.setFont(font);
        manager.screen.addElement(display);
        display.setDimensions(manager.screen.getWidth()/2, manager.screen.getHeight()/2); 
        display.setPosition(manager.screen.getWidth()/2 - display.getWidth()/2, manager.screen.getHeight()/2 -  display.getWidth()/10);
        display.hide();
        
    }
    
    private void createBackButton() {
    
        Vector2f v1 = new Vector2f();
        Vector4f v2 = new Vector4f();
        
        backButton = new ButtonAdapter(manager.screen, "Back Button", v1, v1, v2, "Textures/BackButton.png") {
        
            @Override
            public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle){
            
                manager.getStatsScreen().hide();
                manager.getStartScreen().show();
                
            }
        
        };
        
        backButton.setDimensions(manager.screen.getWidth()/3, manager.screen.getHeight()/5);
        manager.screen.addElement(backButton);
        backButton.setPosition(manager.screen.getWidth()/2 -  backButton.getWidth()/2, manager.screen.getHeight()/5);
        backButton.hide();
        
    }
    
    public StatsManager getStatsManager() {
        return statsManager;
    }
    
    @Override
    public void hide() {
        backButton.hide();
        display.hide();
    }
    
    @Override
    public void show() {
        
        super.show();
        backButton.show();
        backButton.setZOrder(1);
        displayStats();
        
    }
    
}
