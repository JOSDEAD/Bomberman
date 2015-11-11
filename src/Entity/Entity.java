/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import bomberman.graphics.Screen;
import java.util.Random;
import level.Level;

/**
 *
 * @author jomi_
 */
public abstract class Entity {
    public int x;
    public int y;
    private boolean deleted=false;
    protected Level level;
    protected Random random = new Random();
    
    public void update(){
    
    }
    
    public void render(Screen screen){
    
    }
    
    public void remove(){
        deleted=true;
    }
    
    public boolean getDeleted(){
        return deleted;
    }
}
