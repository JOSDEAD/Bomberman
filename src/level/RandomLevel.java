/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level;

import java.util.Random;

/**
 *
 * @author jomi_
 */
public class RandomLevel extends Level{

    private static Random random= new Random();
    
    public RandomLevel(int width, int height) {
        super(width, height);
    }
    
    @Override
    protected void generateLevel(){
        for(int y=0; y<height;y++){
            for(int x=0;x<width;x++){
                tiles[x+y*width]= random.nextInt(2);
            }
        }
    }
}
