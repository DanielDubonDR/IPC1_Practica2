
package Controladores;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;

/**
 *
 * @author Daniel Dubón
 */
public class Label extends JLabel{
    Color rosa=new Color(202, 41, 91);
    public Label(int x, int y, int w, int h)
    {
        this.setBounds(x, y, w, h);
        this.setForeground(Color.white);
        this.setHorizontalAlignment(LEFT);
        this.setFont(new Font("Verdana", Font.PLAIN, 13));
    }
    
    public Label(String txt,int x, int y, int w, int h)
    {
        this.setText(txt);
        this.setBounds(x, y, w, h);
        this.setForeground(rosa);
        this.setHorizontalAlignment(LEFT);
        this.setFont(new Font("Verdana", Font.BOLD, 13));
    }
    
    public Label(String txt,int x, int y, int w, int h, boolean a)
    {
        this.setText(txt);
        this.setBounds(x, y, w, h);
        this.setForeground(Color.black);
        this.setHorizontalAlignment(LEFT);
        this.setFont(new Font("Verdana", Font.PLAIN, 13));
    }
}
