package dani_;

import javax.swing.JOptionPane;

/* @author sergi */
public class Alumno {
    int numCtrl;
    String nombre;

    public int getNumCtrl() {
        return numCtrl;
    }

    public void setNumCtrl() {
        numCtrl=(int)(Math.random()*100+1);
        this.numCtrl = numCtrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        nombre=JOptionPane.showInputDialog("Ingrese el nombre del alumno");
        this.nombre = nombre;
    }
}
