/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import bomberman.graphics.Screen;

/**
 *
 * @author jomi_
 */
public class block extends Tile{

    public block(Element element) {
        super(element);
    }
    @Override
    public void render(int x,int y,Screen screen){
        screen.renderTile(x*20, y*20, this);
        
    }
    @Override
    public boolean solid(){
        return true;
    }
}
