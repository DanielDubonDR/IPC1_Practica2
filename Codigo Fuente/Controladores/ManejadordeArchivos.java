
package Controladores;

import static Principal.Principal.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Daniel Dubón
 */
public class ManejadordeArchivos {
    
    private File path;
    private FileReader entrada;
    private boolean abierto;
    private int cont=0;
    private int contador=0;
    private Datos[] datos;
    
    public void abrir()
    {
        JFileChooser choose=new JFileChooser();
        choose.setCurrentDirectory(new java.io.File("."));
        choose.setDialogTitle("Cargar Archivo");
        FileNameExtensionFilter filtro=new FileNameExtensionFilter(".csv","csv");
        choose.addChoosableFileFilter(filtro);
        choose.setAcceptAllFileFilterUsed(true);
        
        if(choose.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            System.out.println("se abrio archivo");
            path =choose.getSelectedFile();
            System.out.println(path);
            abierto=true;
        }
        else
        {
            System.out.println("NO se abrio archivo");
            abierto=false;
        }
    }
    
    public void cargarEncabezados() throws IOException//este metodo me extrae lo que contiene el archivo de texto
    {
        try 
        {
             entrada=new FileReader(path);
             String linea;
             BufferedReader lector =new BufferedReader(entrada);//creo un buffer que me lee por lineas
             while((linea=lector.readLine())!=null)
             {
                 String cadena[];
                 cadena=linea.split(",");
                 if(cont==0)
                 {
                     encabezados[0]=cadena[0];
                     encabezados[1]=cadena[1];
                 }
                 cont++;
             }
        } 
        catch (FileNotFoundException ex) {System.out.print("Error al abrir el archivo");}
        catch (IOException e){System.out.println("Error");}
        finally
        {
            entrada.close();//simpre cierro mi buffer para evitar problemas
        }
    }
    
    public void cargarDatos() throws IOException//este metodo me extrae lo que contiene el archivo de texto
    {
        datos=new Datos[cont-1];
        try 
        {
             entrada=new FileReader(path);
             String linea;
             BufferedReader lector =new BufferedReader(entrada);//creo un buffer que me lee por lineas
             while((linea=lector.readLine())!=null)
             {
                 String cadena[];
                 cadena=linea.split(",");
                 if(contador>0)
                 {
                     Datos aux=new Datos(cadena[0],Double.valueOf(cadena[1]));
                     datos[contador-1]=aux;
                 }
                 contador++;
             }
             System.out.println(datos[0]);
             System.out.println(datos[1]);
             System.out.println(datos[2]);
        } 
        catch (FileNotFoundException ex) {System.out.print("Error al abrir el archivo");}
        catch (IOException e){System.out.println("Error");}
        finally
        {
            entrada.close();//simpre cierro mi buffer para evitar problemas
        }
    }
    
    public boolean getAbierto()
    {
        return abierto;
    }
    
    public void cargarEncabezados(String patt) throws IOException//este metodo me extrae lo que contiene el archivo de texto
    {
        try 
        {
            entrada=new FileReader(patt);
            String linea;
            BufferedReader lector =new BufferedReader(entrada);//creo un buffer que me lee por lineas
            while((linea=lector.readLine())!=null)
            {
                 String cadena[];
                 cadena=linea.split(",");
                 if(cont==0)
                 {
                     encabezados[0]=cadena[0];
                     encabezados[1]=cadena[1];
                 }
                 cont++;
             }
             System.out.println(cont+" "+encabezados[0]+" "+encabezados[1]);
        } 
        catch (FileNotFoundException ex) {System.out.print("Error al abrir el archivo");}
        catch (IOException e){System.out.println("Error");}
        finally
        {
            entrada.close();//simpre cierro mi buffer para evitar problemas
        }
        
    }
    
    public void cargarDatos(String patt) throws IOException//este metodo me extrae lo que contiene el archivo de texto
    {
        datos=new Datos[cont-1];
        try 
        {
             entrada=new FileReader(patt);
             String linea;
             BufferedReader lector =new BufferedReader(entrada);//creo un buffer que me lee por lineas
             while((linea=lector.readLine())!=null)
             {
                 String cadena[];
                 cadena=linea.split(",");
                 if(contador>0)
                 {
                     Datos aux=new Datos(cadena[0],Double.valueOf(cadena[1]));
                     datos[contador-1]=aux;
                 }
                 contador++;
             }
             System.out.println(datos[0]);
             System.out.println(datos[1]);
             System.out.println(datos[2]);
        } 
        catch (FileNotFoundException ex) {System.out.print("Error al abrir el archivo");}
        catch (IOException e){System.out.println("Error");}
        finally
        {
            entrada.close();//simpre cierro mi buffer para evitar problemas
        }
    }
     
    public String getPath()
    {
        return path.toString();
    }
    
    public Datos[] getDatos()
    {
        return datos;
    }
    
    public int getContador()
    {
        return contador;
    }
}
