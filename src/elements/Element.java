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
    public final int SIZE;
    private int x;
    private int y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Element emptySpace= new Element(26,1,0,SpriteSheet.tiles);
    public static Element block= new Element(26,0,0,SpriteSheet.tiles);
    public static Element block1= new Element(26,3,0,SpriteSheet.tiles);
    public static Element voidTile = new Element(26,0);
    
    public Element(int SIZE, int x, int y, SpriteSheet sheet) {
        this.SIZE = SIZE;
        this.x = x*SIZE;
        pixels= new int[SIZE*SIZE];
        this.y = y*SIZE;
        this.sheet = sheet;
        load();
    }
    public Element(int SIZE, int color) {
        this.SIZE = SIZE;
        pixels= new int[SIZE*SIZE];
        setColor(color);
    }

    private void load() {
        for(int y1=0; y1<SIZE;y1++){
            for(int x1=0; x1<SIZE;x1++){
                pixels[x1+y1*SIZE]= sheet.pixels[(x1+this.x)+(y1+this.y)*(sheet.size)];
            }
        }
    }

    private void setColor(int color) {
        for(int i=0; i<SIZE*SIZE;i++){
            pixels[i]=color;
        }
    }
    

}
