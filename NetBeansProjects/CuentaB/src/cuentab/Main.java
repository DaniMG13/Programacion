package cuentab;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Main {
    static String n,a,t;
    static int c;
    public static void main(String[] args) {
        Bienv();
        n = JOptionPane.showInputDialog("Ingresa tu(s) nombre(s)");
        a = JOptionPane.showInputDialog("Ingresa tus apellidos");
        t = JOptionPane.showInputDialog("Ingresa tipo de cuenta\n1.- Cuenta de ahorro\n2.- Cuenta corriente");
        Cuenta c1 = new Cuenta(n, a, t);
        
        n = JOptionPane.showInputDialog("Ingresa tu(s) nombre(s)");
        a = JOptionPane.showInputDialog("Ingresa tus apellidos");
        t = JOptionPane.showInputDialog("Ingresa tipo de cuenta\n1.- Cuenta de ahorro\n2.- Cuenta corriente");
        c = Integer.parseInt(JOptionPane.showInputDialog("Ingresa numero de cuenta"));
        Cuenta c2 = new Cuenta(n, a, t);
        
        /*n = JOptionPane.showInputDialog("Ingresa tu(s) nombre(s)");
        a = JOptionPane.showInputDialog("Ingresa tus apellidos");
        t = JOptionPane.showInputDialog("Ingresa tipo de cuenta\nCuenta de ahorro\nCuenta corriente");
        c = Integer.parseInt(JOptionPane.showInputDialog("Ingresa numero de cuenta"));
        Cuenta c3 = new Cuenta(n, a, t, c);
        
        n = JOptionPane.showInputDialog("Ingresa tu(s) nombre(s)");
        a = JOptionPane.showInputDialog("Ingresa tus apellidos");
        t = JOptionPane.showInputDialog("Ingresa tipo de cuenta\nCuenta de ahorro\nCuenta corriente");
        c = Integer.parseInt(JOptionPane.showInputDialog("Ingresa numero de cuenta"));
        Cuenta c4 = new Cuenta(n, a, t, c);
        */
        
        c1.Activar();
        c1.Imprimir();
        
    }
    
    static void Bienv(){
        String m = "----- Bienvenido -----\nVamos a crear tu cuenta";
        JOptionPane.showMessageDialog(null, m);
    }
 
}
