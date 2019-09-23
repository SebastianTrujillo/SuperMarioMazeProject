/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author juan sebastian
 */
public class Juego extends MIDlet
{

    private Display pantalla;
    
    public void startApp()
    {
        pantalla = Display.getDisplay(this);
        pantalla.setCurrent(new Laberinto());
    }
    
    public void pauseApp()
    {
        
    }
    
    public void destroyApp(boolean unconditional)
    {
        
    }
}
