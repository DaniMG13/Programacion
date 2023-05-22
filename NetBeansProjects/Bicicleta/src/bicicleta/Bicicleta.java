package bicicleta;

import javax.swing.JOptionPane;

/* @author VGSG */
public class Bicicleta {
    private static int No=0; 
    private String nombre,color;
    private int velocidadActual,platoActual,piñonActual;

    public Bicicleta(String nombre, String color, int velocidadActual, int platoActual, int piñonActual) {
        this.nombre = nombre;
        this.color = color;
        this.velocidadActual = velocidadActual;
        this.platoActual = platoActual;
        this.piñonActual = piñonActual;
        No++;
    }
    
    void acelerar(){
        velocidadActual*=2;
    }
    
    void frenar(){
        velocidadActual/=2;
    }
    
    void cambiarPlato(int plato){
        platoActual = plato;
    }
    
    void cambiarPiñon(int piñon){
        piñonActual = piñon;
    }
    
    void Imprimir(){
        String salida = "Datos de la bicicleta\nNombre: "+nombre+"\nColor: "+color+"\nVelocidad actual: "+velocidadActual+"\nPlato actual: "
                +platoActual+"\nPiñon actual: "+piñonActual;
        JOptionPane.showMessageDialog(null, salida);
    }
    
    int GetInstancias(){
        return No;
    }
    
}
