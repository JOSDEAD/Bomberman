/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import bomberman.graphics.SpriteSheet;

/**
 *
 * @author jomi_
 */
public class Element {
    private final int SIZE;
    private int x;
    private int y;
    public int[] pixels;
    private SpriteSheet sheet;

    public Element(int SIZE, int x, int y, SpriteSheet sheet) {
        this.SIZE = SIZE;
        this.x = x*SIZE;
        pixels= new int[SIZE*SIZE];
        this.y = y*SIZE;
        this.sheet = sheet;
        load();
    }

    private void load() {
        for(int y=0; y<SIZE;y++){
            for(int x=0; x<SIZE;x++){
                pixels[x+y*SIZE]= sheet.pixels[(x+this.x+y+this.y*sheet.size)];
            }
        }
    }
    

}
