package hospital;

import javax.swing.JOptionPane;

/*VGSG*/
public class Main {

    public static void main(String[] args) {
        
        Paciente pac = new Paciente();
        
        pac.Ingresar();
        pac.Calcular();
        JOptionPane.showMessageDialog(null, pac.Motrar());
        System.exit(0);
    }
    
}
