package nomina;

import javax.swing.JOptionPane;

/* @author VGSG */ 

public class Empleado {
    String nombre;
    byte sueldo;
    double total;
    int hrs;

    void LeerDatos(){
        nombre = JOptionPane.showInputDialog("Ingresa el nombre del trabajador:");
        sueldo = Byte.parseByte(JOptionPane.showInputDialog("Ingresa el sueldo por hora: "));
        hrs = Integer.parseInt(JOptionPane.showInputDialog("Ingresa las horas trabajadas: "));
    }

    void Calcular(){
        if(hrs<=40){
            total = hrs*sueldo;
        }else{  
            if(hrs<=50){
                total = 40*sueldo+(hrs-40)*1.5*sueldo;
            }else{
                total = 40*sueldo+10*1.5*sueldo+(hrs-50)*2*sueldo;
            }
        }
    }

    String Mostrar(){
        return "Empleado: "+nombre+"\nSueldo base por hora: "+sueldo+"\nHoras trabajadas: "+hrs+"\nSueldo total: "+total;
    }
}