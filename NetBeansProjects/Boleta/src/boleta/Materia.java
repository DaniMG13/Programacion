package boleta;

import javax.swing.JOptionPane;

/*VGSG*/

public class Materia {
    String nomMateria, claveMat;
    byte creditos;

    void leerDatos(){
        nomMateria=JOptionPane.showInputDialog("Teclea nombre de la Materia");
        claveMat=JOptionPane.showInputDialog("Teclea clave de la Materia\n"+nomMateria);
        creditos=Byte.parseByte(JOptionPane.showInputDialog("Teclea créditos de la Materia\n"+nomMateria));
    }

    String mostrar(){
        String aux;
        aux="\nClave de la Materia: "+claveMat+"\nNombre de la materia:"+nomMateria+"\nCreditos: "+creditos;
        return (aux);
    }
}