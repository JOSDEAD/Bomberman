/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.mob;

import bomberman.Keyboard;

/**
 *
 * @author jomi_
 */
public class Player extends Mob {
   
    private Keyboard input;
    
    public Player(Keyboard input){
        this.input=input;
    }
    
    public Player(int x,int y,Keyboard input){
        this.x=x;
        this.y=y;
        this.input=input;
        
    }
    
    @Override
    public void update(){
        if(input.up)
            y--;
        if(input.down)
            y++;
        if(input.left)
            x--;
        if(input.right)
            x++;
        
    }
    
    public void render(){
    }
}
