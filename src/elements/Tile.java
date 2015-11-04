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
public class Tile {
    public int x;
    public Element element;

    
    public static Tile emptySpace= new EmptySpace(Element.emptySpace);
    public static Tile voidTile= new VoidTile(Element.voidTile);
    public static Tile block= new VoidTile(Element.block);
    public static Tile block1= new VoidTile(Element.block1);
    
    public Tile(Element element) {
        this.element = element;
    }
    
    public void render(int x,int y,Screen screen){
    
    }
    public boolean solid(){
        return false;
    }
            
}
