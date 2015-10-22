/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.graphics;

/**
 *
 * @author jomi_
 */
public class Screen {
    private int width,height;
    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels= new int[width*height];
    }
    
}
