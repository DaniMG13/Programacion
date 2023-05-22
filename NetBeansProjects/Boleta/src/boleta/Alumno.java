package boleta;

import javax.swing.JOptionPane;

/*VGSG*/

public class Alumno {
    String nombre, nroCtrl;
    byte semestre;

    void leerDatos(){
        nombre = JOptionPane.showInputDialog("Teclea nombre del Alumno");
        nroCtrl = JOptionPane.showInputDialog("Teclea Número de Control del Alumno\n"+nombre);
        semestre = Byte.parseByte(JOptionPane.showInputDialog("Teclea semestre del Alumno\n"+nombre));
    }

    String mostrar(){
        String aux;
        aux="Número de Control: "+nroCtrl+"\nNombre: "+nombre+"\nSemestre:"+semestre;
        return (aux);
    }
}

