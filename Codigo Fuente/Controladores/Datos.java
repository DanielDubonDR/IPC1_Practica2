
package Controladores;

/**
 *
 * @author Daniel Dubón
 */
public class Datos {
    
    private double cantidades;
    private String categoria;

    public Datos(String categoria, double cantidades)
    {
        setCantidades(cantidades);
        setCategoria(categoria);
    }
    
    public double getCantidades() {
        return cantidades;
    }

    public void setCantidades(double cantidades) {
        this.cantidades = cantidades;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "cantidades=" + cantidades + ", categoria=" + categoria;
    }
    
}
