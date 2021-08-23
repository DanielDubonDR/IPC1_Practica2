
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
public class QuicksortD extends Thread{
    private Ordenamiento clse;
    private Datos[] datos;
    private int contador;
    private int pasos=0;
    
    public QuicksortD(Ordenamiento clse,Datos[] datos, int contador)
    {
        this.clse=clse;
        this.datos=datos;
        this.contador=contador;
    }
    
    @Override
    public void run()
    {
        Tiempo cronometro=new Tiempo(clse.t);
        cronometro.start();
        quick(datos,0,contador-2);
        activo=false;
        fin=true;
        clse.panel.removeAll();clse.panel.repaint();clse.grafica();
    }
    
    public void quick(Datos[] arreglo, int primero, int ultimo) //algoritmo de ordenamiento quickSort como funcion recursiva
     {
         int i, j; 
         double pivote;
         Datos aux;
         i=primero;
         j=ultimo;
         pivote=arreglo[(primero+ultimo)/2].getCantidades(); //obtengo mi pivote
         do
         {
             while(arreglo[i].getCantidades()>pivote) //este ciclo me sirve para incrementar mi contador
             {
                 i++;
             }
             while(arreglo[j].getCantidades()<pivote) //este ciclo me sirve para decrementar mi contador
             {
                 j--;
             }
             if(i<=j) //aca es donde hago el intercambio de valores que se ajustan a mi condicion y ajusto mis contadores
             {
                 aux=arreglo[j];
                 arreglo[j]=arreglo[i];
                 arreglo[i]=aux;
                 try {Thread.sleep(vel);} catch (InterruptedException ex) {}
                clse.panel.removeAll();clse.panel.repaint();clse.grafica();
                pasos++;
                clse.p.setText(String.valueOf(pasos));
                 
                 i++;
                 j--;
             }
         }
         while(i<=j && activo1);
         //como mi funcion es recursiva tengo que estar mandando los valores obtenidos segun mi condicion y asi encontrar los pivotes
         if(activo)
         {
            if(primero<j)
            {
                quick(arreglo, primero,j);
            }
            if(i<ultimo)
            {
                quick(arreglo, i, ultimo);
            }
         }
     }
}
