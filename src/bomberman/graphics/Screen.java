/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.graphics;

import elements.Element;
import elements.Tile;
import java.util.Random;

/**
 *
 * @author jomi_
 */
public class Screen {
    public int width;
    public int  height;
    public int[] pixels;
    public int MAP_SIZE=15;
    
    public int[] titles= new int[MAP_SIZE*MAP_SIZE];
    private Random random = new Random();
    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels= new int[width*height];
        for(int i =0; i <MAP_SIZE*MAP_SIZE;i++){
            titles[i]= random.nextInt(0xffffff);
        }
    }
    public void clear(){
        for(int i=0;i<pixels.length;i++){
            pixels[i]=0;
        }
    }

    public void renderTile(int xp,int yp,Tile tile){
        for(int y = 0; y < tile.element.SIZE; y++) {
			int ya = y + yp;
			for(int x = 0; x < tile.element.SIZE; x++) {
				int xa = x + xp;
				if(xa < -tile.element.SIZE || xa >= width || ya < 0 || ya >= height) break; 
				if(xa < 0) xa = 0;
				int col = tile.element.pixels[x + y * tile.element.SIZE];
				pixels[xa + ya * width] = col;
			}
		}
    
    }
}
