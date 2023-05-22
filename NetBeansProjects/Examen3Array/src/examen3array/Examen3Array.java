package examen3array;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Examen3Array {
static int index = 0;
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de jugadores"));
        
        Jugador jugs[] = new Jugador[n];
        
        String salida = "Total de Jugadores: "+n+"\n";
        
        for(int i = 0;i<jugs.length;i++){
            jugs[i] = new Jugador();
            jugs[i].Ingresar();
            jugs[i].Promedio();
            
            salida += "\nNombre: "+jugs[i].nombre+"\nTiros a canasta realizados: "+jugs[i].tr+"\nCanastas anotadas: "+jugs[i].ca;
            salida += "\nAsistencias realizadas: "+jugs[i].ar+"\nPromedio de canastas anotadas: "+jugs[i].pca+"\n";
            
        }
        
        double mayor = 0;
        
        for(int i = 0;i<jugs.length;i++){
            if(mayor<jugs[i].pca){
                mayor = jugs[i].pca;
                index = i;
            }
        }
        
        String salida2 = "Jugador con mayor promedio\nNombre: "+jugs[index].nombre+"\nTiros a canasta realizados: "+jugs[index].tr+"\nCanastas anotadas: "+jugs[index].ca;
        salida2 += "\nAsistencias realizadas: "+jugs[index].ar+"\nPromedio de canastas anotadas: "+jugs[index].pca;
       
        JOptionPane.showMessageDialog(null, salida);
        JOptionPane.showMessageDialog(null, salida2);
    }
    
}
