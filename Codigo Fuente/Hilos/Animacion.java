
package Hilos;

import javax.swing.JFrame;

/**
 *
 * @author Daniel Dubón
 */
public class Animacion extends Thread{
    
    JFrame frame;
    
    public Animacion(JFrame frame)
    {
        this.frame=frame;
    }
    
    @Override
    public void run()
    {
        int x=0;
        while(x<255)
        {
            frame.repaint();
            frame.setSize(frame.getWidth(), frame.getHeight()+2);
            try {
                Thread.sleep(3);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            x++;
            frame.setLocationRelativeTo(null);
        }
    }
    
}
