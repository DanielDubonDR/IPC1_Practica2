
package GUI;

import Controladores.Archivos;
import Controladores.Datos;
import Controladores.Label;
import Controladores.ManejadordeArchivos;
import Hilos.*;
import static Principal.Principal.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Daniel Dubón
 */
public class Ordenamiento extends JFrame{
    
    JPanel pane=new JPanel();
    private JPanel pane1=new JPanel();
    private Color celeste=new Color(0, 102, 204);
    private Color menta=new Color(26, 177, 136);
    private Color azul=new Color(36, 49, 60);
    private Color azulp=new Color(67, 81, 89);
    private Color rosa=new Color(202, 41, 91);
    ManejadordeArchivos archivos=new ManejadordeArchivos();
    public ChartPanel panel;
    public Label p=new Label(452,95,80,15);
    public Label t=new Label(462,70,118,15);
    public Label ord=new Label(80,95,130,15);
    public Label ve=new Label(95,70,80,15);
    private Datos[] datos, datos2;
    private int contador;
    public JLabel tt =new JLabel();
    public boolean leyend=true;
    public Ordenamiento(Datos[] datos, int contador)
    {
        Opciones s=new Opciones(Ordenamiento.this);
        s.setVisible(a);
        setSize(900, 730);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Proceso de Ordenamiento");
        setLocationRelativeTo(null);
        setResizable(false);
        setDatos(datos);
        setContador(contador);
        activo1=true;
        activo=true;
        agregarPanel();
        agregarBotones();
        agregarTextos();
        agregarCheck();
        grafica();
        cerrar();
    }
    
    private void setDatos(Datos[] datos)
    {
        this.datos=datos;
        this.datos2=datos.clone();
    }
    
    private void setContador(int contador)
    {
        this.contador=contador;
    }
    
    public void agregarPanel()
    {
        pane.setLayout(null);
        pane.setBackground(Color.white);
        getContentPane().add(pane);
        pane1.setLayout(null);
        pane1.setBounds(0, 0, 900, 130);
        pane1.setBackground(azul);
        pane.add(pane1);
    }
    
    public void agregarBotones()
    {
        JButton a=new JButton();
        a.setBounds(750, 74, 100, 35);
        a.setText("INICIAR");
        a.setBorderPainted(false);
        a.setFocusPainted(false);
        a.setFont(new Font("Arial", Font.BOLD, 13));
        a.setBackground(azulp);
        a.setForeground(Color.white);
        pane1.add(a);
        
       a.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                pane.removeAll();
//              pane.repaint();
//              grafica2();
                a.setText("Actualizar");
                if(type==0 && alt==0)
                {
                   BubleA a=new BubleA(Ordenamiento.this,datos,contador); 
                   a.start();
                }
                else if(type==1 && alt==0)
                {
                    BubleD a=new BubleD(Ordenamiento.this,datos,contador); 
                    a.start();
                }
                else if(type==0 && alt==1)
                {
                    ShellsortA a=new ShellsortA(Ordenamiento.this,datos,contador); 
                    a.start();
                }
                else if(type==1 && alt==1)
                {
                    ShellsortD a=new ShellsortD(Ordenamiento.this,datos,contador);
                    a.start();
                }
                else if(type==0 && alt==2)
                {
                    QuicksortA a=new QuicksortA(Ordenamiento.this,datos,contador);
                    a.start();
                }
                else if(type==1 && alt==2)
                {
                    QuicksortD a=new QuicksortD(Ordenamiento.this,datos,contador);
                    a.start();
                }
//                ShellsortD a=new ShellsortD(Ordenamiento.this,datos,contador);
//                QuicksortA a=new QuicksortA(Ordenamiento.this,datos,contador);
                
                
                panel.removeAll();
                panel.repaint();
                grafica();
                
            }
        });
    }
    
    public void agregarTextos()
    {
        
        tt.setText("Bubble Sort");
        tt.setForeground(menta);
        tt.setBounds(350, 15, 400, 40);
        tt.setFont(new Font("Arial", Font.BOLD, 28));
        pane1.add(tt);
        
        Label velocidad=new Label("Velocidad:",15,70,80,15);
        pane1.add(velocidad);
        
        Label orden=new Label("Orden:",15,95,80,15);
        pane1.add(orden);
        
        Label tiempo=new Label("Tiempo:",400,70,80,15);
        pane1.add(tiempo);
        
        Label pasos=new Label("Pasos:",400,95,80,15);
        pane1.add(pasos);
        
        p.setText("0");
        pane1.add(p);
        
        t.setText("00:00:00");
        pane1.add(t);
        
        ve.setText("Media");
        ord.setText("Ascendente");
        pane1.add(ve);
        pane1.add(ord);
    }
    boolean a=true;
    public void grafica()
    {
        String color = "";
 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0; i<(contador-1);i++)
        {
            dataset.addValue(datos[i].getCantidades(),datos[i].getCategoria(), color);
        }
 
        JFreeChart barChart = ChartFactory.createBarChart3D(titulo, encabezados[0], encabezados[1], dataset,PlotOrientation.VERTICAL, leyend,true,false);
        if(a)
        {
        panel = new ChartPanel(barChart);
        crearImagen(barChart,"Graph1.png");
        a=false;
        }
        else {panel.setChart(barChart);}
        
        if(fin)
        {
            crearImagen(barChart,"Graph2.png");
            fin=false;
            Archivos reporte=new Archivos(tt.getText(),ve.getText(),ord.getText(),t.getText(),p.getText(),datos,datos2,contador);
            reporte.unir();
        }
        
        panel.setBounds(10, 160, 860, 500);
        pane.add(panel);
    }

    public void cerrar()
    {
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent a){
                activo=false;
                activo1=false;
                MenuPrincipal abrir=new MenuPrincipal();
                abrir.setVisible(true);
            }
        });
    }
    
    public void agregarCheck()
    {
        JCheckBox leyenda=new JCheckBox();
        leyenda.setText("Ocultar leyenda");
        leyenda.setBounds(730, 660, 150, 30);
        leyenda.setBackground(Color.white);
        pane.add(leyenda);
        
        leyenda.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(leyenda.isSelected())
                {
                    panel.removeAll();
                    panel.revalidate();
                    leyend=false;
                    grafica();
                    panel.repaint();
                }
                else
                {
                    panel.removeAll();
                    panel.revalidate();
                    leyend=true;
                    grafica();
                    panel.repaint();
                }
            }
        });
    }
    
    public void crearImagen(JFreeChart a, String title)
    {
        ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
        File archivo=new File(title);
        try {
            ChartUtilities.saveChartAsPNG(archivo, a, 1000, 700);
        } catch (IOException ex) {
            Logger.getLogger(Ordenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
