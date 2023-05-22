package examen_2_test_belen;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Main {

    public static void main(String[] args) {
        Empleado emp = new Empleado();
        emp.Ingresar();
        emp.Calcular();
        JOptionPane.showMessageDialog(null, emp.Mostrar());
        System.exit(0);
    }
    
}
