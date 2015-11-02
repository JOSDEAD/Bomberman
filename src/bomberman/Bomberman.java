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


    public static int width=375;
    public static int height=width;
    public static int scale=2;
    
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
        
        long Time= System.nanoTime();
        long timer=System.currentTimeMillis();
        double nanoSecond= 1000000000.0 / 60.0;
        double delta=0;
        int frames=0;
        int updates=0;
        while(running){
            long now= System.nanoTime();
            delta+= (now - Time)/nanoSecond;
            Time=now;
            
            //Just Update  60 times in a second
            while(delta>=1){
                //Run the logic of the game
                update();
                updates++;
                delta--;
            }
            //Run the graphics of the game
            render(); 
            frames++;
            if(System.currentTimeMillis() - timer>1000){
                timer+=1000;
                frame.setTitle("Bomberman  | "+updates+"ups | "+frames+ "fps");
                frames=0;
                updates=0;
            }
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
        screen.clear();
        screen.render();
        
        for(int i=0;i<pixels.length;i++){
            pixels[i]=screen.pixels[i];
        }
        
        Graphics g= bs.getDrawGraphics();

        //clean the screen
        g.drawImage(image, 0, 0, getWidth(),getHeight(),null);
        g.dispose();
        
        //showw the next buffer screen
        bs.show();
    }
    public void update(){
    
    }
}
