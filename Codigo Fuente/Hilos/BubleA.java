
package Hilos;

import Controladores.Datos;
import GUI.Ordenamiento;
import static Principal.Principal.activo;
import static Principal.Principal.activo1;
import static Principal.Principal.vel;
import static Principal.Principal.fin;

/**
 *
 * @author Daniel Dubón
 */
public class BubleA extends Thread{
    
    private Ordenamiento clse;
    private Datos[] datos;
    private int contador;
    
    public BubleA(Ordenamiento clse,Datos[] datos, int contador)
    {
        this.clse=clse;
        this.datos=datos;
        this.contador=contador;
    }
    
    @Override
    public void run()
    {
        int pasos=0;
        int aux=0;
        Datos intercambio;
        Tiempo cronometro=new Tiempo(clse.t);
        cronometro.start();
        
        for(int i=0; i<(contador-2);i++)
        {
            for(int j=0; j<(contador-2); j++)
            {
               if(datos[j].getCantidades()>datos[j+1].getCantidades())
               {
                   intercambio=datos[j];
                   datos[j]=datos[j+1];
                   datos[j+1]=intercambio;
                   if(!activo1){break;}
                   try {Thread.sleep(vel);} catch (InterruptedException ex) {}
                   clse.panel.removeAll();clse.revalidate();clse.panel.repaint();pasos++;clse.grafica();
                   clse.p.setText(String.valueOf(pasos));
                   aux++;
               }
            }
            if(!activo1){break;}
        }
        activo=false;
        fin=true;
        clse.panel.removeAll();clse.panel.repaint();clse.grafica();
    }
    
}
