
package Hilos;

import Controladores.Label;
import static Principal.Principal.activo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Dubón
 */
public class Tiempo extends Thread{
    
    Label cronometro;
    
    public Tiempo(Label cronometro)
    {
        this.cronometro=cronometro;
    }
    
    @Override
    public void run()
    {
        int mm=0, s=0, m=0;
        while(activo)
        {
            try {Thread.sleep(10);} catch (InterruptedException ex) {}
            mm++;
            if(mm==100)
            {
                mm=0;
                s++;
            }
            if(s>9)
            {
                if(s==60)
                {
                    s=0;
                    m++;
                }
                if(m>9)
                {
                    cronometro.setText(String.valueOf(m)+":"+String.valueOf(s)+":"+String.valueOf(mm));
                }
                else
                {
                    cronometro.setText("0"+String.valueOf(m)+":"+String.valueOf(s)+":"+String.valueOf(mm));
                }
            }
            else if(m>9)
            {
                cronometro.setText(String.valueOf(m)+":0"+String.valueOf(s)+":"+String.valueOf(mm));
            }
            else
            {
                cronometro.setText("0"+String.valueOf(m)+":0"+String.valueOf(s)+":"+String.valueOf(mm));
            }
        }
    }
}
