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
import tonegod.gui.core.Element;

/**
 *
 * @author Bawb
 */
public class SelectionScreen extends GuiScreen {
    
    private ArrayList<SymbolButton> buttonList;
    private Element                 predictElement;
    
    public SelectionScreen(GameManager manager) {
        
        super(manager);
        createButtons();
        createPredictElement();
        
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
                    ((SymbolScreen) manager.getSymbolScreen()).judge(((SymbolButton) this).getValue());
                    
                }
                
            };
            
            currentButton.setValue(manager.getMatList().get(i));
            buttonList.add(currentButton);
            manager.screen.addElement(currentButton);
            currentButton.hide();
            
            currentButton.setDimensions(manager.screen.getWidth()/5, manager.screen.getWidth()/5);
            
            if (i < 5) {
                currentButton.setPosition(0 + currentButton.getWidth()*i, manager.screen.getWidth()/5); 
            }
            
            else {  
                currentButton.setPosition(0 + currentButton.getWidth()*(i-5), 0);  
            }
            
            i++;
            if (i>=10)
            break;
            
        }
        
    }
    
    private void createPredictElement() {
        
        Vector2f v1 = new Vector2f();
        Vector4f v2 = new Vector4f();
        
        predictElement = new Element(manager.screen, "Predict Element", v1, v1, v2, "Textures/PredictImage.png");
        predictElement.setDimensions(manager.screen.getWidth()/3, manager.screen.getHeight() - manager.screen.getWidth()/2.5f);
        predictElement.setPosition(manager.screen.getWidth()/2 - predictElement.getWidth()/2, 0);
        manager.screen.addElement(predictElement);
        predictElement.hide();
        
    }
    
    @Override
    public void hide() {
        
        for (int i = 0; i < buttonList.size(); i++) {
        
            buttonList.get(i).hide();
            
        }
        
        predictElement.hide();
        
    }
    
    @Override
    public void show() {
        
        super.show();
        
        for (int i = 0; i < buttonList.size(); i++) {
        
            buttonList.get(i).show();
            buttonList.get(i).setZOrder(1);
            
        }
        
        predictElement.show();
        predictElement.setZOrder(1);
        
    }
    
}
