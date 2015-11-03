/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.graphics;

import elements.Element;
import java.util.Random;

/**
 *
 * @author jomi_
 */
public class Screen {
    private int width,height;
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
    public void render(){
        
        for(int y=0;y<height;y++){
            if(y<0 ||y>=height)break;
            for(int x=0;x<width;x++){
                if(x<0||x>=width)break;
                int tileIndex=(int) ((x>>4)+(y>>4))*64;
                pixels[x + y * width] = Element.emptySpace.pixels[(x%20)+(y%20)*Element.emptySpace.SIZE];
            }
        }
    }
    
}
