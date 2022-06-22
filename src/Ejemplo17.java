import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Ejemplo17 extends JFrame implements ItemListener{

    public final String DESCARGA_DIRECTA = "Descarga directa";
    public final String AFILIADO = "Afiliado";
    public final String COMERCIO = "Comercio";

    String select = "";

    JPanel primeraTarjeta;
    JPanel segundaTarjeta;
    JPanel terceraTarjeta;

    CardLayout tarjetas;
    JPanel panelTarjetas;
    JComboBox comboBox;

    public Ejemplo17() {

        //Centro el JFrame en la pantalla
        setLocationRelativeTo(null);

        //Inicializo un border layout para el JFrame
        setLayout(new BorderLayout());

        //Creo un panel para el botón superior con fondo rojo
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.RED);

        //Añado un botón para intercambiar tarjetas y le añado el action listener
        JButton cambiarTarjeta = new JButton("Cambiar tipo de cliente");
        cambiarTarjeta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent event){
                tarjetas.next(panelTarjetas);
            }
        });

        //Añado el botón al panel de pestañas
        //panelSuperior.add(cambiarTarjeta);

        //Añado el panel de pestañas a la parte superior del JFrame
        add(panelSuperior,BorderLayout.NORTH);

        //Inicializo el layout y el panel para las tarjetas
        tarjetas = new CardLayout();
        panelTarjetas = new JPanel();
        panelTarjetas.setLayout(tarjetas);

        //comboBox
        comboBox = new JComboBox();
        comboBox.addItem("Seleccione");
        comboBox.addItem(DESCARGA_DIRECTA);
        comboBox.addItem(AFILIADO);
        comboBox.addItem(COMERCIO);
        comboBox.addItemListener(this);
        panelSuperior.add(comboBox);


        //Inicializo 2 tarjetas, cada una es un JPanel con un color de fondo
        /*primeraTarjeta = new JPanel();
        segundaTarjeta = new JPanel();
        terceraTarjeta = new JPanel();
        primeraTarjeta.setBackground(Color.GREEN);
        segundaTarjeta.setBackground(Color.BLUE);
        terceraTarjeta.setBackground(Color.MAGENTA);

        //Añado botones a las dos tarjetas
        nuevoBoton(primeraTarjeta, "Manzanas");
        nuevoBoton(primeraTarjeta, "Naranjas");
        nuevoBoton(primeraTarjeta, "Plátanos");
        nuevoBoton(segundaTarjeta, "Lechugas");
        nuevoBoton(segundaTarjeta, "Tomates");
        nuevoBoton(segundaTarjeta, "Cebollas");

        //Añado las dos tarjetas al panel de tarjetas
        panelTarjetas.add(primeraTarjeta, "Frutas");
        panelTarjetas.add(segundaTarjeta, "Verduras");
        panelTarjetas.add(terceraTarjeta, "holi"); */

        //Muestro la primera
        tarjetas.show(panelTarjetas, "Frutas");

        //Añado el panel de tarjetas a la parte central del border layout
        add(panelTarjetas,BorderLayout.CENTER);

        //Configurar y mostrar JFrame
        initPantalla();
    }

    public void itemStateChanged(ItemEvent e){
        
        select = comboBox.getSelectedItem().toString();
        primeraTarjeta = new JPanel();
        segundaTarjeta = new JPanel();
        terceraTarjeta = new JPanel();

        if (e.getSource().equals(comboBox)) {

            if (select.equals(DESCARGA_DIRECTA)) {
                primeraTarjeta.setBackground(Color.GREEN);
                JLabel text = new JLabel("Bienvenido en green", SwingConstants.CENTER);
                primeraTarjeta.add(text);
                panelTarjetas.add(primeraTarjeta);
                tarjetas.next(panelTarjetas);               
            } 
            
            if (select.equals(AFILIADO)) {
                segundaTarjeta.setBackground(Color.BLUE);
                JLabel text = new JLabel("Bienvenido en azul", SwingConstants.CENTER);
                segundaTarjeta.add(text);
                panelTarjetas.add(segundaTarjeta);
                tarjetas.next(panelTarjetas);               
            }
        
            if (select.equals(COMERCIO)) {
                terceraTarjeta.setBackground(Color.MAGENTA);
                JLabel text = new JLabel("Bienvenido en magenta", SwingConstants.CENTER);
                terceraTarjeta.add(text);
                panelTarjetas.add(terceraTarjeta);
                tarjetas.next(panelTarjetas);                
            }

        }
    }

    private void initPantalla() {

        setTitle("Ejemplo 17"); //Título del JFrame
        setSize(400,300); //Dimensiones del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    //Nuevo botón
    private void nuevoBoton(JPanel panel, String titulo){

        JButton boton = new JButton(titulo);
        panel.add(boton);

    }

    public static void main(String[] args) {
        new Ejemplo17();
    }
}