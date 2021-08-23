
package Principal;


import GUI.MenuPrincipal;
import GUI.Opciones;


/**
 *
 * @author Daniel Dubón
 */
public class Principal {
    public static String titulo;
//    public static int contador=0;
//    public static Datos[] datos;
    public static String[] encabezados=new String[2];
    public static boolean activo=true, activo1=true, fin=false;
    public static int type=0, vel=250, alt=0, c=0;
    
    public static void main(String[] args)
    { 
        MenuPrincipal a=new MenuPrincipal();
//        Ordenamiento a=new Ordenamiento();
//        Opciones a=new Opciones();
        a.setVisible(true);
    }
}
