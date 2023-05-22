package listaedades;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/* @author VGSG */

public class Main {
static Personas p[] = new Personas[10];
static double prom=0,suma=0;
static int min=0,max=0,conta=0;
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            int opc = Integer.parseInt(JOptionPane.showInputDialog("1.- Nuevo Registro\n2.- Salir"));
            if(opc == 1){
                conta++;
                p[i] = new Personas();
                p[i].setNombre(JOptionPane.showInputDialog("Ingresa el nombre"));
                p[i].setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad de la persona")));
            }else{
                break;
            }
        }
        max = 0;
        min = 0;
        for(int j=0;j<conta-1;j++){
           if(p[j+1].getEdad()<p[j].getEdad()){
               min = j+1;
           }else{
               max = j+1;
           }
            //System.out.println(p[j].getEdad());
        }
        for(int i=0;i<conta;i++){
            suma+=(double)p[i].getEdad();
        }

        DecimalFormat df = new DecimalFormat("#.00");
        
        prom=suma/conta;
        String txt = " -------------- Resultados -------------- \n";
        txt += "Menor edad: "+p[min].getEdad()+" años\n";
        txt += "Nombre: "+p[min].getNombre()+"\n";
        txt += "Mayor edad: "+p[max].getEdad()+" años\n";
        txt += "Nombre: "+p[max].getNombre()+"\n";
        txt += "Promedio de edades: "+df.format(prom)+" años\n";
        txt += "-----------------------------------------------";
        JOptionPane.showMessageDialog(null, txt);
    }

}

class Personas{
    String nombre;
    int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}