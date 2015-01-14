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
import tonegod.gui.core.Element;

/**
 *
 * @author Bawb
 */
public class SymbolScreen extends GuiScreen {
    
    private ButtonAdapter finishButton;
    private Element       chosenElement;
    private Element       actualElement;
    private Element       booleanElement;
    
    public SymbolScreen(GameManager manager) {
        
        super(manager);
        createFinishButton();
        createActualElement("Circle");
        createChosenElement("Circle");
        createBooleanElement(false);
        actualElement.hide();
        chosenElement.hide();
        booleanElement.hide();
        
    }
    
    private void createFinishButton(){
    
        Vector2f v1 = new Vector2f();
        Vector4f v2 = new Vector4f();
        
        finishButton = new ButtonAdapter(manager.screen, "Finish Button", v1, v1, v2, "Textures/FinishButton.png") {
        
            @Override
            public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggle) {
            
                manager.getSymbolScreen().hide();
                manager.getStartScreen().show();
                
            }
            
        };
        
        finishButton.setDimensions(manager.screen.getWidth()/3, manager.screen.getHeight()/5);
        manager.screen.addElement(finishButton);
        finishButton.setPosition(manager.screen.getWidth()/2 - finishButton.getWidth()/2, manager.screen.getHeight()/5);
        finishButton.hide();
        
    }
    
    public void judge(String choice) {
    
        removeElements();
        
        manager.getSymbolManager().generateSymbol();
        
        String actual = manager.getSymbolManager().getSymbol().getValue();
        
        createActualElement(actual);
        createChosenElement(choice);
        
        createBooleanElement(actual.equals(choice));
        
    }
    
    private void createActualElement(String actual) {
    
        Vector2f v1 = new Vector2f();
        Vector4f v2 = new Vector4f();
        
        actualElement = new Element(manager.screen, "Actual Element", v1, v1, v2, "Textures/" + actual + ".png");
        manager.screen.addElement(actualElement);
        actualElement.setDimensions(manager.screen.getWidth()/4, manager.screen.getWidth()/4);
        actualElement.setPosition((manager.screen.getWidth()/2 - actualElement.getWidth()/2) + actualElement.getWidth()*1.25f, manager.screen.getHeight()/2f);
        actualElement.setZOrder(1);
        
    }
    
    private void createChosenElement(String choice) {
        
        Vector2f v1 = new Vector2f();
        Vector4f v2 = new Vector4f();
        
        chosenElement = new Element(manager.screen, "Chosen Element", v1, v1, v2, "Textures/" + choice + ".png");
        manager.screen.addElement(chosenElement);
        chosenElement.setDimensions(manager.screen.getWidth()/4, manager.screen.getWidth()/4);
        chosenElement.setPosition((manager.screen.getWidth()/2 - chosenElement.getWidth()/2) - chosenElement.getWidth()*1.25f, manager.screen.getHeight()/2f);
        chosenElement.setZOrder(1);
        
    }
    
    private void createBooleanElement(boolean outcome) {
    
        String imagePath;
        
        if (outcome)
        imagePath = "RightImage";
        else
        imagePath = "WrongImage";
        
        Vector2f v1 = new Vector2f();
        Vector4f v2 = new Vector4f();
        
        booleanElement = new Element(manager.screen, "Boolean Element", v1, v1, v2, "Textures/" + imagePath + ".png");
        manager.screen.addElement(booleanElement);
        booleanElement.setDimensions(manager.screen.getWidth()/3, manager.screen.getWidth()/6f);
        booleanElement.setPosition(manager.screen.getWidth()/2 - booleanElement.getWidth()/2, manager.screen.getHeight() - booleanElement.getHeight()*1.25f);
        booleanElement.setZOrder(1);
        
    }
    
    private void removeElements() {
    
        try {
        
        manager.screen.removeElement(manager.screen.getElementById("Actual Element"));
        manager.screen.removeElement(manager.screen.getElementById("Chosen Element"));
        manager.screen.removeElement(manager.screen.getElementById("Boolean Element"));
        
        }
        
        catch (Exception e) {
        
        }
    
    }
    
    @Override
    public void hide() {
        
        finishButton.hide();
        actualElement.hide();
        chosenElement.hide();
        booleanElement.hide();
        
    }
    
    @Override
    public void show() {
        
        super.show();
        finishButton.show();
        actualElement.setZOrder(1);
        chosenElement.setZOrder(1);
        finishButton.setZOrder(1);
        booleanElement.setZOrder(1);
        
    }
    
}
