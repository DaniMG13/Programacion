package bicicleta;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Main {

    public static void main(String[] args) {
        Bicicleta miBicicleta = new Bicicleta("Miguelita", "Rojo", 12, 5, 3);
        miBicicleta.Imprimir();
        Bicicleta tuBicicleta = new Bicicleta("Carmelita", "Azul", 10, 8, 4);
        tuBicicleta.Imprimir();
        Bicicleta suBicicleta = new Bicicleta("Luisito el comunicador", "Plata", 11, 6, 8);
        suBicicleta.Imprimir();
        Bicicleta nuestraBicicleta = new Bicicleta("Auron el playas", "Morado", 15, 5, 7);
        nuestraBicicleta.Imprimir();
        JOptionPane.showMessageDialog(null, "Numero de bicicletas creadas: "+miBicicleta.GetInstancias());
        
    }

}
