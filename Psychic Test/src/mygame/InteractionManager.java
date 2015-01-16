/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.input.InputManager;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.MouseButtonTrigger;

/**
 *
 * @author Bawb
 */
public class InteractionManager extends AbstractAppState implements ActionListener {
    
    public SimpleApplication   app;
    public AppStateManager     stateManager;
    public InputManager        inputManager;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        
        super.initialize(stateManager, app);
        this.app          = (SimpleApplication) app;
        this.stateManager = this.app.getStateManager();
        this.inputManager = this.app.getInputManager();
        this.inputManager.setCursorVisible(true);
        this.inputManager.setSimulateMouse(true);
        setUpKeys();
        
    }
    
    private void setUpKeys() {
        
        inputManager.addMapping("Click", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        inputManager.addListener(this, "Click");
        
    }
    
    @Override
    public void onAction(String binding, boolean isPressed, float tpf) {   
        
    }
    
}
