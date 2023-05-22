package boleta;

import javax.swing.JOptionPane;

/*VGSG*/

public class Main {

    public static void main(String[] args) {
        
        Boleta bol=new Boleta();
        bol.leerdatos();
        bol.calcular();
        JOptionPane.showMessageDialog(null,bol.mostrar());
        System.exit(0);
        
    }
    
}
