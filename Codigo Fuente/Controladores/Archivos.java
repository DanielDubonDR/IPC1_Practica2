
package Controladores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static Principal.Principal.*;
import java.awt.Desktop;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Dubón
 */
public class Archivos {
    
    private StringBuilder codigo =new StringBuilder();
    private String algorimto, velocidad, orden, tiempo, pasos;
    private Datos[] datos, datos2;
    int cont;
    
    public Archivos(String algoritmo, String velocidad, String orden, String tiempo, String pasos, Datos[] datos,Datos[] datos2, int cont)
    {
        this.algorimto=algoritmo;
        this.velocidad=velocidad;
        this.orden=orden;
        this.tiempo=tiempo;
        this.pasos=pasos;
        this.datos=datos;
        this.cont=cont;
        this.datos2=datos2;
    }
    
    public void crearArchivo(String contenido){//este metodo me crea archivos planos
        
        File archivo = new File("Reporte.html");
        
        try {
            FileWriter escritor = new FileWriter(archivo);//declaro mi variable que va a leer los datos
            escritor.write(contenido);
            escritor.close();
        } 
        catch (IOException ex) {
            
            ex.printStackTrace();
            
        } 
    }
    
    public void header()
    {
        codigo.append("<!DOCTYPE html>\n" +
        "<html>\n" +
        "<title>USAC Data Plotter</title>\n" +
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
        "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
        "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lobster\">\n" +
        "<style>.w3-lobster {font-family: \"Lobster\", serif;}</style>\n" +
        "<body><div class=\"w3-container w3-teal w3-center w3-margin-bottom\">\n" +
        "<h1>Daniel Reginaldo Dubón Rodríguez</h1><h3>201901772</h3></div>\n" +
        "<div class=\"w3-panel w3-light-grey w3-leftbar w3-rightbar w3-border-teal\">\n" +
        "<p><b>Algorimto: </b>"+algorimto+"</p><p><b>Velocidad:</b> "+velocidad+"</p>\n" +
        "<p><b>Orden:</b> "+orden+"</p><p><b>Tiempo:</b>"+tiempo+"</p>\n" +
        "<p><b>Pasos:</b> "+pasos+"</p></div>");
    }
    
    public void tablaMinimo()
    {
        if(type==0)
        {
            codigo.append("<div class=\"w3-container\">  \n" +
            "<table class=\"w3-table-all w3-margin-top w3-card-4 w3-hoverable\">\n" +
            "<tr class=\"w3-black\">\n" +
            "<th colspan=\"2\" style=\"width:50%;\" class=\"w3-center\">Dato Mínimo</th>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td class=\"w3-center\">"+datos[0].getCategoria()+"</td>\n" +
            "<td class=\"w3-center\">"+datos[0].getCantidades()+"</td>\n" +
            "</tr>\n" +
            "</table>\n" +
            "</div>");
        }
        else
        {
            codigo.append("<div class=\"w3-container\">  \n" +
            "<table class=\"w3-table-all w3-margin-top w3-card-4 w3-hoverable\">\n" +
            "<tr class=\"w3-black\">\n" +
            "<th colspan=\"2\" style=\"width:50%;\" class=\"w3-center\">Dato Mínimo</th>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td class=\"w3-center\">"+datos[cont-2].getCategoria()+"</td>\n" +
            "<td class=\"w3-center\">"+datos[cont-2].getCantidades()+"</td>\n" +
            "</tr>\n" +
            "</table>\n" +
            "</div>");
        }
    }
    
    public void tablaMaximo()
    {
        if(type==0)
        {
            codigo.append("<div class=\"w3-container\">  \n" +
            "<table class=\"w3-table-all w3-margin-top w3-card-4 w3-hoverable\">\n" +
            "<tr class=\"w3-pink\"><th colspan=\"2\" style=\"width:50%;\" class=\"w3-center\">Dato Máximo</th></tr>\n" +
            "          <tr>\n" +
            "            <td class=\"w3-center\">"+datos[cont-2].getCategoria()+"</td>\n" +
            "            <td class=\"w3-center\">"+datos[cont-2].getCantidades()+"</td>\n" +
            "          </tr>\n" +
            "</table></div><br><br>");
        }
        else
        {
            codigo.append("<div class=\"w3-container\">  \n" +
            "<table class=\"w3-table-all w3-margin-top w3-card-4 w3-hoverable\">\n" +
            "<tr class=\"w3-pink\"><th colspan=\"2\" style=\"width:50%;\" class=\"w3-center\">Dato Máximo</th></tr>\n" +
            "          <tr>\n" +
            "            <td class=\"w3-center\">"+datos[0].getCategoria()+"</td>\n" +
            "            <td class=\"w3-center\">"+datos[0].getCantidades()+"</td>\n" +
            "          </tr>\n" +
            "</table></div><br><br>");
        }
    }
    
    public void tablaDesordenada()
    {
        codigo.append("<div class=\"w3-container w3-center\">  \n" +
        "<div class=\"w3-container w3-lobster\"><p class=\"w3-xxxlarge\">Datos Desordenados<p></div>\n" +
        "<table class=\"w3-table-all w3-margin-top w3-card-4 w3-hoverable\">\n" +
        "<tr class=\"w3-teal\">\n" +
        "<th style=\"width:50%;\" class=\"w3-center\">Categoria</th>\n" +
        "<th style=\"width:50%;\" class=\"w3-center\">Cantidad</th>\n" +
        "</tr>\n");
        
        for(int i=0; i<cont-1; i++)
        {
            codigo.append("<tr>\n" +
            "<td class=\"w3-center\">"+datos2[i].getCategoria()+"</td>\n" +
            "<td class=\"w3-center\">"+datos2[i].getCantidades()+"</td>\n" +
            "</tr>\n");
        }       
        codigo.append("</table></div><br><br>\n" +
        "<div class=\"w3-container w3-center\">\n" +
        "<img src=\"Graph1.png\" class=\"w3-round\" alt=\"Norway\">\n" +
        "</div>");
    }
    
    public void tablaOrdenada()
    {
        codigo.append("<div class=\"w3-container w3-center\">  \n" +
        "<div class=\"w3-container w3-lobster\"><p class=\"w3-xxxlarge\">Datos Ordenados<p></div>\n" +
        "<table class=\"w3-table-all w3-margin-top w3-card-4 w3-hoverable\">\n" +
        "<tr class=\"w3-teal\">\n" +
        "<th style=\"width:50%;\" class=\"w3-center\">Categoria</th>\n" +
        "<th style=\"width:50%;\" class=\"w3-center\">Cantidad</th>\n" +
        "</tr>\n");
        
        for(int i=0; i<cont-1; i++)
        {
            codigo.append("<tr>\n" +
            "<td class=\"w3-center\">"+datos[i].getCategoria()+"</td>\n" +
            "<td class=\"w3-center\">"+datos[i].getCantidades()+"</td>\n" +
            "</tr>\n");
        }       
        codigo.append("</table></div><br><br>\n" +
        "<div class=\"w3-container w3-center\">\n" +
        "<img src=\"Graph2.png\" class=\"w3-round\" alt=\"Norway\">\n" +
        "</div>");
    }
    
    public void crearFinal()
    {
        codigo.append("<br></body></html>");
    }
    
    public void unir()
    {
        header();
        tablaMinimo();
        tablaMaximo();
        tablaDesordenada();
        tablaOrdenada();
        crearFinal();
        crearArchivo(codigo.toString());
        abrirarchivo("Reporte.html");
    }
    
    public void abrirarchivo(String archivo) {

        try {

            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo");
        }

    }
}
