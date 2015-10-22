/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.graphics.Screen;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

/**
 *
 * @author jomi_
 */
public class Bomberman extends Canvas implements Runnable {


    public static int width=300;
    public static int height=width/16*9;
    public static int scale=3;
    
    private Thread thread;
    private final Screen screen;
    private boolean running=false;
    private final JFrame frame;
    private final BufferedImage image= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    
    public Bomberman(){
        Dimension size= new Dimension(width*scale,height*scale);
        setPreferredSize(size);
        screen= new Screen(width,height);
        frame= new JFrame();
    }
    
    public synchronized void start() {
       running=true;
       thread= new Thread(this,"Display");
       thread.start();
    }
    
    public synchronized void stop(){
        running=false;
        try{
        thread.join();
        }catch(InterruptedException e){
        }
    }

    @Override
    public void run() {
        while(running){
            //Run the logic of the game
            update();
            //Run the graphics of the game
            render();
        }
    }
    public static void main(String[] args){
        //create the window
        Bomberman bomberman= new Bomberman();
        bomberman.frame.setResizable(false);
        bomberman.frame.setTitle("Bomberman");
        bomberman.frame.add(bomberman);
        bomberman.frame.pack();
        bomberman.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bomberman.frame.setLocationRelativeTo(null);
        bomberman.frame.setVisible(true);
        bomberman.start();
    }

    public void render() {
        BufferStrategy bs= getBufferStrategy();
        //creat buffer when is empty
        if(bs==null){
            createBufferStrategy(3);
            return;
        }
        
        Graphics g= bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width*scale, height*scale);
        //clean the screen
        g.dispose();
        
        //showw the next buffer screen
        bs.show();
    }
    public void update(){
    
    }
}
