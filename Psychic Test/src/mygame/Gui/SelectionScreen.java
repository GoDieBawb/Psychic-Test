/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Gui;

import mygame.GameManager;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.math.Vector2f;
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
    
        buttonList = new ArrayList();
        int i = 0;
        
        while (true) {
            
            SymbolButton currentButton = new SymbolButton(manager.screen, "Button" + i, new Vector2f(12f,12f)) {
            
                @Override
                public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle) {
                    
                    manager.getSelectScreen().hide();
                    manager.getSymbolScreen().show();
                    
                }
                
            };
            
            currentButton.setValue(assignValue(i));
            currentButton.setText(String.valueOf(i+1));
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
    
    private String assignValue(int i) {
    
        String value = "";
        
        switch(i+1) {
        
            case 1:
                value = "1";
                break;
            case 2:
                value = "2";
                break;
            case 3:
                value = "3";
                break;
            case 4:
                value = "4";
                break;
            case 5:
                value = "5";
                break;
            case 6:
                value = "circle";
                break;
            case 7:
                value = "square";
                break;
            case 8:
                value = "start";
                break;
            case 9:
                value = "triangle";
                break;
            case 10:
                value = "heart";
                break;
        
        }
       
        return value;
        
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
