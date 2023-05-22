package examen;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Examen {

    public static void main(String[] args) {
        Matrices mat = new Matrices();
        mat.Crear();
        //int[][] mat1 = mat1.Crear();
        
        mat.Llenar();
        mat.Sumar();
        mat.Mostrar();
        //mat1.Mostrar(mat1,mat2);
    }
    
}
