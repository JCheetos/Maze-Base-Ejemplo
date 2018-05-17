package javaapplication7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventosTeclado extends JFrame implements KeyListener {

    JTextArea informacion;
    JTextField texto;
    JPanel principal;
    String linea, cadena, codigotecla;

    public EventosTeclado() {
        super("Eventos del Teclado");
        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());
        linea = System.getProperty("line.separator");
        texto = new JTextField(20);
        informacion = new JTextArea(18, 40);
        informacion.setEditable(false);
        texto.addKeyListener(this);
        principal = new JPanel();
        principal.add(texto);
        JScrollPane visualizacion = new JScrollPane(informacion);
        contenedor.add(principal, BorderLayout.NORTH);
        contenedor.add(visualizacion, BorderLayout.CENTER);
        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char tecla = e.getKeyChar();
        int codigo = e.getKeyCode();
        if (Character.isISOControl(tecla)) {
            cadena = "Tecla pulsada = (caracter de control no imprimible)";
        } else {
            cadena = "Tecla pulsada = " + tecla + "'";
        }
        codigotecla = "Codigo Tecla = " + codigo + "(" + KeyEvent.getKeyText(codigo) + ")";
        informacion.append("EVENTO KEYTYPED: " + linea + " " + cadena + linea + " " + codigotecla + linea);
    }

    public static void main(String args[]) {
        EventosTeclado ventana = new EventosTeclado();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        informacion.setText("");
        char tecla = e.getKeyChar();
        int codigo = e.getKeyCode();
        if (Character.isISOControl(tecla)) {
            cadena = "Tecla pulsada = (caracter de control no imprimible)";
        } else {
            cadena = "Tecla pulsada = " + tecla + "'";
        }
        codigotecla = "Codigo Tecla = " + codigo + "(" + KeyEvent.getKeyText(codigo) + ")";
        informacion.append("EVENTO KEYPRESSED: " + linea + " " + cadena + linea + " " + codigotecla + linea);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char tecla = e.getKeyChar();
        int codigo = e.getKeyCode();
        if (Character.isISOControl(tecla)) {
            cadena = "Tecla pulsada = (caracter de control no imprimible)";
        } else {
            cadena = "Tecla pulsada = " + tecla + "'";
        }
        codigotecla = "Codigo Tecla = " + codigo + "(" + KeyEvent.getKeyText(codigo) + ")";
        informacion.append("EVENTO KEYRELEASED: " + linea + " " + cadena + linea + " " + codigotecla + linea);
        texto.setText("");
    }
}
