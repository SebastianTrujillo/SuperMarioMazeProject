/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author juan sebastian
 */
public class Laberinto extends GameCanvas implements Runnable
{
    Graphics g;
    Image mario;
    Image splash;
    Image ganaste;
    Image pantalla;
    Thread hilo;
    boolean play=true;
    Sprite marioSprite;
    int x=24; //posicion inicial de mario eje x
    int y=66; //posicion inicial de mario eje y
    int tecla;
    
    public Laberinto()
    {
        super(true); 
        
        g=getGraphics();
               
        try{ 
                pantalla=Image.createImage("/pantalla.png");

                ganaste=Image.createImage("/ganaste.jpg");

                splash=Image.createImage("/splash.jpg");

                mario=Image.createImage("/mario.png");
           
           }
        catch (IOException ex) 
              {
                 ex.printStackTrace();
              }
        
        marioSprite = new Sprite(mario);
        
        hilo = new Thread(this);
        
        g.drawImage(splash, 0, 0, Graphics.TOP | Graphics.LEFT);
        
        hilo.start();
    } 
    
    public void teclaPulsada()
    {
       tecla=getKeyStates();
       
       Mapeo.submapa=Mapeo.getMapa()[Mapeo.getI()][Mapeo.getJ()];
       
       Mapeo.subArreglo=Mapeo.submapa.toCharArray();
       
       if((tecla & GameCanvas.LEFT_PRESSED)!=0)
       {
           if(Mapeo.subArreglo[0]=='0')
               x-=19;
           else return;
           Mapeo.decremetarJ();
       }
       else if((tecla & GameCanvas.DOWN_PRESSED)!=0)
       {
           if(Mapeo.subArreglo[3]=='0')
               y+=19;
           else return;
           Mapeo.incrementarI();
       }
       else if((tecla & GameCanvas.RIGHT_PRESSED)!=0)
       {
           if(Mapeo.subArreglo[2]=='0')
               x+=19;
           else return;
           Mapeo.incrementarJ();
       }
       else if((tecla & GameCanvas.UP_PRESSED)!=0)
       {
           if(Mapeo.subArreglo[1]=='0')
               y-=19;
           else return;
           Mapeo.decrementarI();
       }
       
       repaint();
    }
    
    public void dibujarLaberinto()
    {
        int x1=23;
        int y1=84;
        int anc=95;
        int alt=5;
        int l=19;
        
        g.drawImage(pantalla, 0, 0, Graphics.TOP | Graphics.LEFT);
    }
    
    public void run()
    {
        if(play)
        {
            int i=0;  
        
            while(i<5)
            {
                try{
                     hilo.sleep(1000);
                   }
                catch(InterruptedException e){}
                
                i++;
            }
             
            play=false;
        }
        
        int ancho=getWidth();
        int alto=getHeight();
        
        while(true)
        {
            if(Mapeo.getI()<11&&Mapeo.getI()>-1&&Mapeo.getJ()<10&&Mapeo.getJ()>-1)
                teclaPulsada();   
            
            marioSprite.setRefPixelPosition(x, y);
                      
            dibujarLaberinto();
            
            marioSprite.paint(g);
                        
            if(x==195&&y==275)
            {
                g.drawImage(ganaste, 0, 0, Graphics.TOP | Graphics.LEFT);
                return;
            }  
            
            try{ 
                hilo.sleep(90);
               }
            catch(InterruptedException e){}
            
            flushGraphics();
        }
    }
}
