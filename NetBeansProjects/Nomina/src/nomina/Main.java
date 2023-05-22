package nomina;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Main {

    public static void main(String[] args) {
        Nominas nomi = new Nominas();
        nomi.Leer();
        JOptionPane.showMessageDialog(null, nomi.Mayor());
        System.exit(0);
    }
    
}
