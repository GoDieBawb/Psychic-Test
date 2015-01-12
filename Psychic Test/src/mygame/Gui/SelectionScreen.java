/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Gui;

import mygame.GameManager;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import java.util.ArrayList;

/**
 *
 * @author Bawb
 */
public class SelectionScreen extends GuiScreen {
    
    private ArrayList<SymbolButton> buttonList;
    
    public SelectionScreen(GameManager manager) {
        
        super(manager);
        createButtons();
        
    }
    
    private void createButtons() {
    
        buttonList  = new ArrayList();
        Vector2f v1 = new Vector2f();
        Vector4f v2 = new Vector4f();
        int i       = 0;
        
        while (true) {
            
            SymbolButton currentButton = new SymbolButton(manager.screen, "Button" + i, v1, v1, v2, "Textures/" + manager.getMatList().get(i) + ".png") {
            
                @Override
                public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle) {
                    
                    manager.getSelectScreen().hide();
                    manager.getSymbolScreen().show();
                    
                }
                
            };
            
            currentButton.setValue(manager.getMatList().get(i));
            buttonList.add(currentButton);
            manager.screen.addElement(currentButton);
            currentButton.hide();
            
            currentButton.setDimensions(manager.screen.getWidth()/5, manager.screen.getHeight()/2);
            
            if (i < 5) {
                currentButton.setPosition(0 + currentButton.getWidth()*i, manager.screen.getHeight()/2); 
            }
            
            else {  
                currentButton.setPosition(0 + currentButton.getWidth()*(i-5), 0);  
            }
            
            i++;
            if (i>=10)
            break;
            
        }
        
    }
    
    @Override
    public void hide() {
        
        for (int i = 0; i < buttonList.size(); i++) {
        
            buttonList.get(i).hide();
            
        }
        
    }
    
    @Override
    public void show() {
        
        for (int i = 0; i < buttonList.size(); i++) {
        
            buttonList.get(i).show();
            
        }
        
    }
    
}
