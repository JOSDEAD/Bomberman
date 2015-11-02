/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author jomi_
 */
public class SpriteSheet {
    private String path;
    public final int size;
    public int[] pixels;

    public SpriteSheet(String path, int size) {
        this.path = path;
        this.size = size;
        pixels = new int [size*size];
    }
    
    public void loadImage(){
        try{
        BufferedImage image= ImageIO.read(SpriteSheet.class.getResource(path));
        int w = image.getWidth();
        int h= image.getHeight();
        image.getRGB(0, 0,w,h,pixels,0,w);
        }
        catch(IOException e){
        }
    }
    
}
