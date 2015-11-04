/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level;

import bomberman.graphics.Screen;
import elements.Tile;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jomi_
 */
public class Level {
    protected int width;
    protected int height;
    protected int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles= new int[height*width];
        generateLevel();
    }
    
    public Level(String path){
        loadLevel(path);
    }
    
    protected void generateLevel() {
        for(int y=0;y<height;y++){
         for(int x=0;x<width;x++){
             if(x==0||y==0||x==width-1||y==height-1)
               tiles[x+y*width]=1;
             if(x%2==0 && y%2==0 ){
                 if(x!=0 || y!=0 || x!=width-1 || y!=width-1)
                    tiles[x+y*width]=1;}
            }
       }
       ArrayList<Integer> array= new ArrayList<>();
       for(int y=0;y<height;y++){
         for(int x=0;x<width;x++){
             
                 if(tiles[x+y*width]==0)
                     array.add(x+y*width);
            }
       }
       Random a= new Random();
       for(int count=0;count<35;count++){
           int index=a.nextInt(array.size());
           int x=array.get(index); 
           tiles[x]=2;
           array.remove(index);
       
       }
            
    }
        
    

    private void loadLevel(String path) {
        
    }
   
    
   public void update(){
   //to update ia mobs
   } 
   
   private void time(){
   }
   
   public void render(int xScroll,int yScroll,Screen screen){
       int x0= xScroll/26;
       int x1=(screen.width)/26;
       int y0=yScroll/26;
       int y1= (screen.height)/26;
       for(int y=y0;y<y1;y++){
           for(int x=x0;x<x1;x++){
               getTile(x,y).render(x, y, screen);
            }
       }
   }
   public Tile getTile(int x, int y){
        if(tiles[x+y*width]==0)
            return Tile.emptySpace;
         if(tiles[x+y*width]==2){
            return Tile.block1;}
        return Tile.block;
        
   }
    
}
