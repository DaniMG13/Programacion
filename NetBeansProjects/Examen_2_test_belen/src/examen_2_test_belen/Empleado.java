package examen_2_test_belen;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/* @author VGSG */
public class Empleado {
    String Nombre;
    String RFC;
    double sueldob;
    int aumento;
    double aumentoS;
    double sueldot;
    
    void Ingresar(){
        Nombre = JOptionPane.showInputDialog(null,"Ingresa el nombre del empleado");
        RFC = JOptionPane.showInputDialog(null,"Ingresa el RFC de "+Nombre);
        sueldob = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa el sueldo de "+Nombre));
    }
    
    void Calcular(){
        if(sueldob<=2000){
            aumento = 8;
        }
        if(sueldob>2000 && sueldob<2500){
            aumento = 7;
        }
        if(sueldob>=2500 && sueldob<=3000){
            aumento = 6;
        }
        if(sueldob>=3000 && sueldob<3500){
            aumento = 5;
        }
        if(sueldob>=3500){
            aumento = 4;
        }
        
        aumentoS = sueldob*((double)aumento/100);
        sueldot = sueldob+aumentoS;
    }
    
    String Mostrar(){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(1);
        return "Empresa VGSG\n--------------------\nEmpleado: "+Nombre+"\nRFC: "+RFC+"\nSueldo base: "+sueldob+"\nAumento: "+aumento+"%\nAumento de sueldo: "+df.format(aumentoS)+"\nSueldo total: "+sueldot;
    }
}
