/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.Label;
import Controladores.ManejadordeArchivos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static Principal.Principal.*;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Daniel Dubón
 */
public class Opciones extends JFrame{
    JPanel pane=new JPanel();
    private JPanel pane1=new JPanel();
    private Color celeste=new Color(0, 102, 204);
    private Color menta=new Color(26, 177, 136);
    private Color azul=new Color(36, 49, 60);
    private Color azulp=new Color(67, 81, 89);
    private Color rosa=new Color(202, 41, 91);
    ManejadordeArchivos archivos=new ManejadordeArchivos();
    private Ordenamiento frame;
    
    private JRadioButton bt1=new JRadioButton("Ascendente",true);
    private JRadioButton bt2=new JRadioButton("Descendente",false);
    private JRadioButton bt3=new JRadioButton("Baja",false);
    private JRadioButton bt4=new JRadioButton("Media",true);
    private JRadioButton bt5=new JRadioButton("Alta",false);
    private JRadioButton bt6=new JRadioButton("Bubble Sort",true);
    private JRadioButton bt7=new JRadioButton("Shellsort",false);
    private JRadioButton bt8=new JRadioButton("Quicksort",false);
    
    public Opciones(Ordenamiento frame)
    {
        this.frame=frame;
        setSize(490, 430);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Opciones de Ordenamiento");
        setLocationRelativeTo(null);
        setResizable(false);
        agregarPanel();
        agregarBotones();
        agregarTextos();
        agregarRadios();
        iniciar();
        cerrar();
    }
    
    public void agregarPanel()
    {
        pane.setLayout(null);
        pane.setBackground(Color.white);
        getContentPane().add(pane);
        pane1.setLayout(null);
        pane1.setBounds(0, 0, 600, 90);
        pane1.setBackground(azul);
        pane.add(pane1);
    }
    
    public void agregarBotones()
    {
        JButton a=new JButton();
        a.setBounds(80, 340, 150, 35);
        a.setText("ACEPTAR");
        a.setBorderPainted(false);
        a.setFocusPainted(false);
        a.setFont(new Font("Arial", Font.BOLD, 13));
        a.setBackground(azulp);
        a.setForeground(Color.white);
        pane.add(a);
        
        JButton b=new JButton();
        b.setBounds(250, 340, 150, 35);
        b.setText("CANCELAR");
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 13));
        b.setBackground(azulp);
        b.setForeground(Color.white);
        pane.add(b);
        
       a.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //System.out.println(type+" "+vel+" "+alt);
                frame.setVisible(true);
                Opciones.this.dispose();
            }
        });
       
       b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MenuPrincipal s=new MenuPrincipal();
                s.setVisible(true);
                Opciones.this.dispose();
            }
        });
      
    }
    
    public void agregarTextos()
    {
        JLabel tt =new JLabel();
        tt.setText("Opciones de Ordenamiento");
        tt.setForeground(menta);
        tt.setBounds(60, 25, 400, 40);
        tt.setFont(new Font("Arial", Font.BOLD, 28));
        pane1.add(tt);
        
        Label velocidad=new Label("Tipo de Ordenamiento",15,110,160,15);
        pane.add(velocidad);
        
        Label orden=new Label("Velocidad de Ordenamiento",15,190,210,20);
        pane.add(orden);
        
        Label tiempo=new Label("Algoritmo de ordenamiento",265,190,200,20);
        pane.add(tiempo);
    }
    public void agregarRadios()
    {
        ButtonGroup tipo = new ButtonGroup();
        ButtonGroup velocidad = new ButtonGroup();
        ButtonGroup algoritmo = new ButtonGroup();
        
        
        bt1.setBackground(Color.white);
        bt1.setFocusPainted(false);
        bt1.setBounds(60, 140, 200, 30);
        pane.add(bt1);
        
        bt2.setBackground(Color.white);
        bt2.setFocusPainted(false);
        bt2.setBounds(290, 140, 200, 30);  
        pane.add(bt2);
        tipo.add(bt1);
        tipo.add(bt2);
        
        bt3.setBackground(Color.white);
        bt3.setFocusPainted(false);
        bt3.setBounds(20, 220, 100, 30);
        pane.add(bt3);
        
        bt4.setBackground(Color.white);
        bt4.setFocusPainted(false);
        bt4.setBounds(20, 250, 100, 30);  
        pane.add(bt4);
        
        bt5.setBackground(Color.white);
        bt5.setFocusPainted(false);
        bt5.setBounds(20, 280, 100, 30);  
        pane.add(bt5);
        velocidad.add(bt3);
        velocidad.add(bt4);
        velocidad.add(bt5);
        
        
        
        bt6.setBackground(Color.white);
        bt6.setFocusPainted(false);
        bt6.setBounds(270, 220, 100, 30);
        pane.add(bt6);
        
        bt7.setBackground(Color.white);
        bt7.setFocusPainted(false);
        bt7.setBounds(270, 250, 100, 30);  
        pane.add(bt7);
        
        bt8.setBackground(Color.white);
        bt8.setFocusPainted(false);
        bt8.setBounds(270, 280, 100, 30);  
        pane.add(bt8);
        algoritmo.add(bt6);
        algoritmo.add(bt7);
        algoritmo.add(bt8);
        
        EventoRadio evento = new EventoRadio();
        bt1.addActionListener(evento);
        bt2.addActionListener(evento);
        bt3.addActionListener(evento);
        bt4.addActionListener(evento);
        bt5.addActionListener(evento);
        bt6.addActionListener(evento);
        bt7.addActionListener(evento);
        bt8.addActionListener(evento);
    }
    public void cerrar()
    {
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent a){
                MenuPrincipal s=new MenuPrincipal();
                s.setVisible(true);
            }
        });
    }
    
    private class EventoRadio implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == bt1) 
            {
               type=0;
               frame.ord.setText("Ascendente");
            }
            else if (e.getSource()==bt2)
            {
                type=1;
                frame.ord.setText("Descendente");
            }
            else if (e.getSource()==bt3)
            {
                if(c<40)
                {
                    vel=600;
                    if(c<20)
                    {
                        vel=1000;
                    }
                }
                else if(c>150)
                {
                    vel=180;
                }
                else vel=500;
                 frame.ve.setText("Baja");
            }
            else if (e.getSource()==bt4)
            {
                if(c<40)
                {
                    vel=250;
                }
                else if(c>120)
                {
                    vel=90;
                }
                else vel=120;
                 frame.ve.setText("Media");
            }
            else if (e.getSource()==bt5)
            {
                if(c<40)
                {
                    vel=80;
                }
                else if(c>150)
                {
                    vel=10;
                }
                else vel=15;
                 frame.ve.setText("Alta");
            }
            else if (e.getSource()==bt6)
            {
                 alt=0;
                 frame.tt.setText("Bubble Sort");
            }
            else if (e.getSource()==bt7)
            {
                 alt=1;
                 frame.tt.setText("Shellsort");
            }
            else if (e.getSource()==bt8)
            {
                 alt=2;
                 frame.tt.setText("Quicksort");
            }
            
        }

    }
    
    public void iniciar()
    {
        if (c < 40) {
            vel = 250;
        } else if (c > 120) {
            vel = 90;
        } else {
            vel = 120;
        }
        type=0;
        alt=0;
    }
}
