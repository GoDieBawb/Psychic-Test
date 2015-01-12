/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import java.util.ArrayList;
import java.util.Random;
import mygame.Gui.GuiScreen;
import mygame.Gui.SelectionScreen;
import mygame.Gui.StartScreen;
import mygame.Gui.StatsScreen;
import mygame.Gui.SymbolScreen;
import tonegod.gui.core.Element;
import tonegod.gui.core.Screen;

/**
 *
 * @author Bawb
 */
public class GameManager extends AbstractAppState {
    
    private GuiScreen           startScreen;
    private GuiScreen           selectScreen;
    private GuiScreen           statsScreen;
    private GuiScreen           symbolScreen;
    private SymbolManager       symbolManager;
    private ArrayList<String>   matList;
    private Element             panelOne;
    private Element             panelTwo;
    public  SimpleApplication   app;
    public  Screen              screen;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {

        this.app = (SimpleApplication) app;
        createMatList();
        createScreen();
        setBackground();
        createStartScreen();
        createSelectionScreen();
        createSymbolScreen();
        createStatsScreen();
        createSymbolManager();

    }
    
    public void setBackground() {
        
        removeBackground();
        
        Vector2f v1 =  new Vector2f();
        Vector4f v2 =  new Vector4f();
        
        String  tex1 = "Textures/Backgrounds/Cards/" + randInt(0,21) + ".png";
        String  tex2 = "Textures/Backgrounds/Cards/" + randInt(0,21) + ".png";
        
        panelOne = new Element(screen,"Panel One", v1, v1, v2, tex1);
        panelTwo = new Element(screen,"Panel Two", v1, v1, v2, tex2);
        
        panelOne.setDimensions(screen.getWidth()/2, screen.getHeight());
        panelTwo.setDimensions(screen.getWidth()/2, screen.getHeight());
        
        screen.addElement(panelOne);
        screen.addElement(panelTwo);
        
        panelTwo.setPosition(screen.getWidth()/2, 0);
        
    }
    
    private void removeBackground() {
    
        try {
        
            screen.removeElement(screen.getElementById("Panel One"));
            screen.removeElement(screen.getElementById("Panel Two"));
            
        }
        
        catch (Exception e) {
        
        }
    
    }
    
    private int randInt(int min, int max) {

        Random rand   = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    
    }
    
    private void createMatList() {
        
        matList = new ArrayList();
        int i   = 1;
        
        while(true) {
        
            String matPath = "";
            
            switch(i) {
            
                case 1:
                    matPath = "One";
                    break;
                case 2:
                    matPath = "Two";
                    break;
                case 3:
                    matPath = "Three";
                    break;
                case 4:
                    matPath = "Four";
                    break;
                case 5:
                    matPath = "Five";
                    break;
                case 6:
                    matPath = "Circle";
                    break;
                case 7:
                    matPath = "Square";
                    break;
                case 8:
                    matPath = "Star";
                    break;
                case 9:
                    matPath = "Triangle";
                    break;
                case 10:
                    matPath = "Heart";
                    break;
                    
            }

            matList.add(matPath);
            
            i++;
            if (i>=11)
            break;
            
        }
        
    }
    
    private void createScreen() {
        screen = new Screen(app, "tonegod/gui/style/atlasdef/style_map.gui.xml");
        screen.setUseTextureAtlas(true,"tonegod/gui/style/atlasdef/atlas.png");
        app.getGuiNode().addControl(screen);
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
    
    public ArrayList<String>  getMatList() {
        return matList;
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
