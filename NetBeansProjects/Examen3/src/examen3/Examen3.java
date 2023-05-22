package examen3;

import javax.swing.JOptionPane;

/* @author VGSG */

public class Examen3 {
static Jugador jug;
static String nombre,salida;
static int tr,ca,ar;
static double pca,bbc,PM = 0;


    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de jugadores"));
        
        salida = "Total de Jugadores: "+n+"\n";
        
        for(int i = 0;i<n;i++){
            jug = new Jugador();
            jug.Ingresar();
            jug.Promedio();
            
            salida += "\nNombre: "+jug.nombre+"\nTiros a canasta realizados: "+jug.tr+"\nCanastas anotadas: "+jug.ca;
            salida += "\nAsistencias realizadas: "+jug.ar+"\nPromedio de canastas anotadas: "+jug.pca+"\n";
            
            if(PM<jug.pca){
                PM = jug.pca;
                nombre = jug.nombre;
                tr = jug.tr;
                ca = jug.ca;
                ar = jug.ar;
            }
            
        }
        
        salida += "\n\nJugador con mayor promedio\nNombre: "+nombre+"\nTiros a canasta realizados: "+tr+"\nCanastas anotadas: "+ca;
        salida += "\nAsistencias realizadas: "+ar+"\nPromedio de canastas anotadas: "+PM;
        
        JOptionPane.showMessageDialog(null, salida);
        
    }
    
}
