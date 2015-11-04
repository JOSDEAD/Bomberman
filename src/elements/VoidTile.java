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
class VoidTile extends Tile {

    public VoidTile(Element voidSprite) {
        super(voidSprite);
    }
    
    @Override
    public void render(int x,int y,Screen screen){
        screen.renderTile(x*26, y*26, this);
        
    }
    
}
