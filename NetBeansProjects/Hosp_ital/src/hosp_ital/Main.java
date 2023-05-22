package hosp_ital;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Main {

    public static void main(String[] args) {
        
        Paciente paciente1 = new Paciente();
        
        paciente1.Ingresar(); //Llamamos al metodo ingresar rellenar los datos del paciente
        paciente1.Calcular(); //Llamamos al etodo calcular para ver el monto a pagar
        JOptionPane.showMessageDialog(null,paciente1.Mostrar()); //Usamor un JOptionPane para mostrar los datos gnerados
        System.exit(0); //Exit para finalizar la actividad
    }
    
}
