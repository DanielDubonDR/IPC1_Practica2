
package Hilos;

import Controladores.Datos;
import GUI.Ordenamiento;
import static Principal.Principal.activo;
import static Principal.Principal.activo1;
import static Principal.Principal.fin;
import static Principal.Principal.vel;

/**
 *
 * @author Daniel Dubón
 */
public class ShellsortA extends Thread{
    private Ordenamiento clse;
    private Datos[] datos;
    private int contador;
    
    public ShellsortA(Ordenamiento clse,Datos[] datos, int contador)
    {
        this.clse=clse;
        this.datos=datos;
        this.contador=contador;
    }
    
    @Override
    public void run()
    {
        int pasos=0;
        Datos intercambio;
        Tiempo cronometro=new Tiempo(clse.t);
        cronometro.start();
        
         int salto=0, temp=0, i=0; //declaro mis variales que utilizare para el algoritmo
         boolean cambio;
         for(salto=(contador-1)/2;salto!=0;salto/=2)//creo un ciclo que recorrera por partes de mi vector
         {
             cambio=true;
             while(cambio) //hago otro ciclo para hacer mis comparaciones
             {
                 cambio=false;
                 for(i=salto; i<(contador-1); i++)//recorro mi vecor en una parte concreta
                 {
                     if(datos[i-salto].getCantidades()>datos[i].getCantidades())//hago la conparacion de los valores de mi vector en la parte escogida
                     {
                         //hago los cambios de valores de mi vector
                         intercambio=datos[i];
                         datos[i]=datos[i-salto];
                         datos[i-salto]=intercambio;
                         cambio=true;
                         if(!activo1){break;}
                         try {Thread.sleep(vel);} catch (InterruptedException ex) {}
                         clse.panel.removeAll();clse.panel.repaint();clse.grafica();
                         pasos++;
                         clse.p.setText(String.valueOf(pasos));
                         
                     }
                 }
                 if(!activo1){cambio=false;}
             }if(!activo1){break;}
             
         }
        activo=false;
        fin=true;
        clse.panel.removeAll();clse.panel.repaint();clse.grafica();
    }
}                 