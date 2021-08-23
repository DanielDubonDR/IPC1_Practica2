/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Datos;
import Controladores.ManejadordeArchivos;
import Hilos.Animacion;
import static Principal.Principal.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Daniel Dubón
 */
public class MenuPrincipal extends JFrame{
    
    JPanel pane=new JPanel();
    JPanel pane1=new JPanel();
    Color celeste=new Color(0, 102, 204);
    Color menta=new Color(26, 177, 136);
    Color azul=new Color(36, 49, 60);
    Color azulp=new Color(67, 81, 89);
    Color rosa=new Color(202, 41, 91);
    JTextField pat=new JTextField();
    JTextField ttt=new JTextField();
    ManejadordeArchivos archivos=new ManejadordeArchivos();
    private ChartPanel panel;
    
    public MenuPrincipal()
    {
        setSize(700, 218);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("USAC Processing Data");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarPanel();
        agregarBotones();
        agregarTextos();
        agregarCheck();
        repaint();
    }
    
    public void agregarPanel()
    {
        pane.setLayout(null);
        pane.setBackground(Color.white);
        getContentPane().add(pane);
        pane1.setLayout(null);
        pane1.setBounds(0, 0, 700, 190);
        pane1.setBackground(azul);
        pane.add(pane1);
    }
    
    public void agregarBotones()
    {
        JButton a=new JButton();
        a.setBounds(100, 130, 490, 35);
        a.setText("Buscar");
        a.setBorderPainted(false);
        a.setFocusPainted(false);
        a.setFont(new Font("Arial", Font.BOLD, 13));
        a.setBackground(azulp);
        a.setForeground(Color.white);
        pane1.add(a);
        
        JButton b=new JButton();
        b.setBounds(566, 200, 95, 35);
        b.setText("INICIAR");
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 13));
        b.setBackground(menta);
        b.setForeground(Color.white);
        pane.add(b);
        
       a.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                pane.removeAll();
//              pane.repaint();
//              grafica2();
//                Animacion a=new Animacion(MenuPrincipal.this);
//                a.start();
                
                if(pat.getText().equals("") || pat.getText().equals("Ruta del archivo"))
                {
                    
                    archivos.abrir();
                    if(archivos.getAbierto())
                    {
                        try 
                        {
                            archivos.cargarEncabezados(); 
                            archivos.cargarDatos();
                            pat.setText(archivos.getPath());
                            JOptionPane.showMessageDialog(null, "Archivo cargado correctamente");
                            grafica();
                            Animacion a=new Animacion(MenuPrincipal.this);
                            a.start();
                        } 
                        catch (IOException ex) {JOptionPane.showMessageDialog(null,"Ocurrio un error al cargar los datos");}
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No se cargó ningún archivo");
                    }
                }
                else
                {
//                    ManejadordeArchivos archivos=new ManejadordeArchivos();
                    try 
                    {
                        archivos.cargarEncabezados(pat.getText());
                        archivos.cargarDatos(pat.getText());
                        JOptionPane.showMessageDialog(null, "Archivo cargado correctamente");
                        grafica();
                        Animacion a=new Animacion(MenuPrincipal.this);
                        a.start();
                    } 
                    catch (IOException ex) {JOptionPane.showMessageDialog(null,"Ocurrio un error al cargar los datos");}
                }
            }
        });
       
       b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               titulo=ttt.getText();
               Ordenamiento a=new Ordenamiento(archivos.getDatos(), archivos.getContador());
//               a.setVisible(true);
               c=archivos.getContador()-1;
               MenuPrincipal.this.dispose();
            }
        });
    }
    
    public void agregarTextos()
    {
        JLabel tt =new JLabel();
        tt.setText("USAC Processing Data");
        tt.setForeground(menta);
        tt.setBounds(200, 15, 400, 40);
        tt.setFont(new Font("Arial", Font.BOLD, 28));
        pane1.add(tt);
        
        pat.setBounds(10, 70, 668, 35);
        pat.setOpaque(false);
        pat.setForeground(Color.white);
        pat.setText("Ruta del archivo");
        pat.setHorizontalAlignment(CENTER);
        pat.setFont(new Font("Arial", Font.BOLD, 13));
        pat.setBorder(null);
        pane1.add(pat);
        
        ttt.setBounds(10, 200, 545, 35);
        ttt.setOpaque(false);
        ttt.setForeground(rosa);
        ttt.setText("Título de la gráfica");
        ttt.setHorizontalAlignment(CENTER);
        ttt.setFont(new Font("Arial", Font.BOLD, 14));
        //ttt.setBorder(null);
        pane.add(ttt);
        
        ttt.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                ttt.setText("");
                repaint();
            }
            
        });
        
    }
    
    public void paint(Graphics g){
        super.paint(g);   
        Graphics2D linea3=(Graphics2D)g;
        linea3.setStroke(new BasicStroke(2.f));
        linea3.setPaint(rosa);
        linea3.drawRect(13, 134, 664, 0);
    }
    
    public void grafica()
    {
        String color = "";
 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0; i<(archivos.getContador()-1);i++)
        {
            dataset.addValue(archivos.getDatos()[i].getCantidades(),archivos.getDatos()[i].getCategoria(), color);
        }
 
        JFreeChart barChart = ChartFactory.createBarChart3D("", encabezados[0], encabezados[1], dataset,PlotOrientation.VERTICAL, true,true,false);
        panel = new ChartPanel(barChart);
        panel.setBounds(10, 250, 660, 415);
        pane.add(panel);
    }
    
    public void grafica1()
    {
        String color = "";
 
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0; i<(archivos.getContador()-1);i++)
        {
            dataset.addValue(archivos.getDatos()[i].getCantidades(),archivos.getDatos()[i].getCategoria(), color);
        }
 
        JFreeChart barChart = ChartFactory.createBarChart3D("", encabezados[0], encabezados[1], dataset,PlotOrientation.VERTICAL, false,true,false);
        panel = new ChartPanel(barChart);
        panel.setBounds(10, 250, 660, 415);
        pane.add(panel);
    }
    
    public void agregarCheck()
    {
        JCheckBox leyenda=new JCheckBox();
        leyenda.setText("Ocultar leyenda");
        leyenda.setBounds(550, 670, 150, 30);
        leyenda.setBackground(Color.white);
        pane.add(leyenda);
        repaint();
        leyenda.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(leyenda.isSelected())
                {
                    panel.removeAll();
                    panel.revalidate();
                    grafica1();
                    panel.repaint();
                }
                else
                {
                    panel.removeAll();
                    panel.revalidate();
                    grafica();
                    panel.repaint();
                }
            }
        });
    }
}
