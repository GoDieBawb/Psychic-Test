/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import mygame.Gui.GuiScreen;
import mygame.Gui.SelectionScreen;
import mygame.Gui.StartScreen;
import mygame.Gui.StatsScreen;
import mygame.Gui.SymbolScreen;
import tonegod.gui.core.Screen;

/**
 *
 * @author Bawb
 */
public class GameManager extends AbstractAppState {
    
    private GuiScreen     startScreen;
    private GuiScreen     selectScreen;
    private GuiScreen     statsScreen;
    private GuiScreen     symbolScreen;
    private SymbolManager symbolManager;
    public  Screen        screen;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {

        screen = new Screen(app, "tonegod/gui/style/atlasdef/style_map.gui.xml");
        screen.setUseTextureAtlas(true,"tonegod/gui/style/atlasdef/atlas.png");
        ( (SimpleApplication) app).getGuiNode().addControl(screen);
        createStartScreen();
        createSelectionScreen();
        createSymbolScreen();
        createStatsScreen();
        createSymbolManager();

    }
    
    private void createStartScreen() {
        startScreen = new StartScreen(this);
    }
    
    private void createSelectionScreen() {
        selectScreen =  new SelectionScreen(this);
    }
    
    private void createSymbolScreen() {
        symbolScreen =  new SymbolScreen(this);
    }
    
    private void createStatsScreen() {
        statsScreen = new StatsScreen(this);
    }
    
    private void createSymbolManager() {
        symbolManager = new SymbolManager();
    }
    
    public GuiScreen getStartScreen() {
        return startScreen;
    }
    
    public GuiScreen getSelectScreen() {
        return selectScreen;
    }
    
    public GuiScreen getStatsScreen() {
        return statsScreen;
    }
    
    public GuiScreen getSymbolScreen() {
        return symbolScreen;
    }
    
    public SymbolManager getSymbolManager() {
        return symbolManager;
    }
    
}
