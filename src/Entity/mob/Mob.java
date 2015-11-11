/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.mob;

import Entity.Entity;
import elements.Element;

/**
 *
 * @author jomi_
 */
public abstract class Mob extends Entity {
    protected Element element;
    protected int direction=0;
    protected boolean moving=false;
    
    public void move(int xa,int ya){
        if(xa>0)
            direction=1;
        if(xa<0)
            direction=3;
        if(ya>0)
            direction=2;
        if(ya<0)
            direction=0;
        
        if(!collision()){
           x+=xa;
           y+=ya;
        }
    }
    
    @Override
    public void update(){
    
    }
    
    private boolean collision(){
        return false;
    }
}
