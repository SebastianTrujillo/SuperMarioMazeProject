/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juan sebastian
 */
public class Mapeo
{
    private static int i = 0; //Indice i de la matriz del mapeo
    private static int j = 0; //Indice j de la matriz del mapeo
    public static char subArreglo[]; //Arreglo obtenido del submapa
    public static String submapa; //Un elemento del mapa
    
    //Mapa del laberinto--------------------------------------------------------
    private static String mapa[][] = 
    {
        {"1110"},//Posicion antes de entrar al laberinto.
        {"1100","0110","1100","0110","1100","0110","1100","0100","0101","0110"},
        {"1010","1010","1011","1001","0011","1001","0011","1010","1101","0010"},
        {"1010","1001","0100","0110","1100","0110","1100","0001","0110","1010"},
        {"1001","0111","1010","1001","0011","1010","1010","1110","1010","1011"},
        {"1101","0100","0011","1110","1101","0001","0011","1010","1001","0110"},
        {"1100","0001","0110","1001","0100","0100","0110","1000","0110","1010"},
        {"1010","1100","0001","0110","1011","1010","1001","0010","1001","0011"},
        {"1010","1001","0111","1010","1100","0000","0110","1001","0101","0111"},
        {"1000","0111","1100","0011","1010","1011","1001","0110","1100","0110"},
        {"1011","1101","0011","1101","0001","0101","0111","1001","0011","1010"}
    };
    //Mapa del laberinto--------------------------------------------------------
        
    public Mapeo()
    {
        
    }
         
    public static String[][] getMapa()
    {
        return (mapa);
    }
    public static void incrementarI()
    {
        i++;
    }
    public static void incrementarJ()
    {
        j++;
    }
    public static void decrementarI()
    {
        i--;
    }
    public static void decremetarJ()
    {
        j--;
    }
    public static int getI()
    {
        return (i);
    }
    public static int getJ()
    {
        return (j);
    }
}
