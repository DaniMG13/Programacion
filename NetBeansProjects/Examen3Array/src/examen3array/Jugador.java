package examen3array;

import javax.swing.JOptionPane;

/* @author VGSG */

public class Jugador {
    String nombre;
    int tr,ca,ar;
    double pca,bbc;
    
    void Ingresar(){
        nombre = JOptionPane.showInputDialog("Ingresa el nombre del jugador");
        tr = Integer.parseInt(JOptionPane.showInputDialog("Ingresa los tiros realizados"));
        ca = Integer.parseInt(JOptionPane.showInputDialog("Ingresa las canastas anotadas"));
        ar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa las asistencias realizadas"));
    }
    
    void Promedio(){
        bbc = ca + ar;
        pca = bbc/tr * 1000;
    }
    
}
